package com.uisrael.petgroomer.com.petgroomer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ModelFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long model_id;

    private LocalDateTime fecha;
    private double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ModelCliente cliente;
}
