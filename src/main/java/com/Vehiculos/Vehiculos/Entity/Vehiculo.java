package com.Vehiculos.Vehiculos.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include()
    @Column(name = "id")
    private Long id;

    @Column(name = "placa")
    private String placa;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "año")
    private int año;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column(name="precio")
    private float precio;

    
}
