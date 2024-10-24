package com.uisrael.petgroomer.com.petgroomer.repository;

import com.uisrael.petgroomer.com.petgroomer.model.ModelCita;
import com.uisrael.petgroomer.com.petgroomer.model.ModelEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<ModelEmpleado,Integer> {
}
