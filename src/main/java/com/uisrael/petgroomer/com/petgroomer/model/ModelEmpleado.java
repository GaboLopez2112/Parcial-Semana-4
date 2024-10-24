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
public class ModelEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empleado_id;
    private String cedula_passport;
    private String nombre;
    private String puesto;
}
