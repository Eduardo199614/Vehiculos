package com.Vehiculos.Vehiculos.Service.impl;

import com.Vehiculos.Vehiculos.Entity.Vehiculo;
import com.Vehiculos.Vehiculos.Repository.VehiculoRepository;
import com.Vehiculos.Vehiculos.Service.VehiculoService;
import com.Vehiculos.Vehiculos.util.PrecioResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	private final String REST_SERVICE_URL = "https://auto.jedai.workers.dev?placa=";

    private final VehiculoRepository vehiculoRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository, RestTemplate restTemplate) {
        this.vehiculoRepository = vehiculoRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Vehiculo guardarAutomovil(Vehiculo vehiculos) {
        // Guardar el automóvil en la base de datos
        Vehiculo vehiculosGuardado = vehiculoRepository.save(vehiculos);

        // Obtener el precio del servicio REST y actualizar el automóvil
        String placa = vehiculosGuardado.getPlaca();
        PrecioResponse precioResponse = obtenerPrecioDesdeRestService(placa);

        if (precioResponse != null) {
            float precio = precioResponse.getPrecio();
            vehiculosGuardado.setPrecio(precio);

            // Actualizar el automóvil con el precio
            vehiculoRepository.save(vehiculosGuardado);
        }

        return vehiculosGuardado;
    }

    @Override
    public List<Vehiculo> listarAutomoviles() {
        return vehiculoRepository.findAll();
    }

    private PrecioResponse obtenerPrecioDesdeRestService(String placa) {
        // Consumir el servicio REST para obtener el precio
        String url = REST_SERVICE_URL + placa;
        return restTemplate.getForObject(url, PrecioResponse.class);
    }
}
