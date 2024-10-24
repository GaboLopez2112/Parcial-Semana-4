package com.uisrael.petgroomer.com.petgroomer.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ModelCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cita_id;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private ModelMascota mascota;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private ModelEmpleado empleado;

    @OneToMany(mappedBy = "cita", cascade = CascadeType.ALL)
    private List<ModelDetalleCita> detalles;
}
