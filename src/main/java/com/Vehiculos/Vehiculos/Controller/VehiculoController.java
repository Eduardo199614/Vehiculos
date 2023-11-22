package com.Vehiculos.Vehiculos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vehiculos.Vehiculos.Entity.Vehiculo;
import com.Vehiculos.Vehiculos.Service.impl.VehiculoServiceImpl;

@RestController
@RequestMapping("/automovil")
public class VehiculoController {

	 @Autowired
	    private VehiculoServiceImpl vehiculoServiceimpl;



	    @Autowired
	    public VehiculoController(VehiculoServiceImpl automovilService) {
	        this.vehiculoServiceimpl = automovilService;
	    }

	    @PostMapping("/Crear")
	    public Vehiculo guardarAutomovil(@RequestBody Vehiculo vehiculos) {
	        return vehiculoServiceimpl.guardarAutomovil(vehiculos);
	    }
	    
	    @GetMapping("/listar")
	    public List<Vehiculo> listarAutomoviles() {
	        return vehiculoServiceimpl.listarAutomoviles();
	    }
}
