package com.Vehiculos.Vehiculos.util;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PrecioResponse {

	@Id
	  private String placa;
	    private float precio;
}
