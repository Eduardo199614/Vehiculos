package com.Vehiculos.Vehiculos.Service;

import java.util.List;

import com.Vehiculos.Vehiculos.Entity.Vehiculo;

public interface VehiculoService {

	Vehiculo guardarAutomovil(Vehiculo vehiculo);
    List<Vehiculo> listarAutomoviles();
}
