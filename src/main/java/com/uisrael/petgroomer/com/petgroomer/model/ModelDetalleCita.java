package com.uisrael.petgroomer.com.petgroomer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ModelDetalleCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalle_cita_id;

    @ManyToOne
    @JoinColumn(name = "cita_id", nullable = false)
    private ModelCita cita;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private ModelServicio servicio;

    private double precio;
}
