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
public class ModelProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;

    private String nombre;
    private double precio;
    private int stock;
}
