package com.uisrael.petgroomer.com.petgroomer.repository;

import com.uisrael.petgroomer.com.petgroomer.model.ModelCita;
import com.uisrael.petgroomer.com.petgroomer.model.ModelServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<ModelServicio,Long> {
}
