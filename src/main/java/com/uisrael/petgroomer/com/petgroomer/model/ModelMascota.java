package com.uisrael.petgroomer.com.petgroomer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ModelMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mascota_id;

    private String nombre;
    private String raza;
    private int edad;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ModelCliente cliente;
}
