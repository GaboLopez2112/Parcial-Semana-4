package com.uisrael.petgroomer.com.petgroomer.repository;

import com.uisrael.petgroomer.com.petgroomer.model.ModelCita;
import com.uisrael.petgroomer.com.petgroomer.model.ModelDetalleCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCitaRepository extends JpaRepository<ModelDetalleCita,Integer> {
}
