package com.empresa.empleados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empleados.model.Empleados;

public interface EmpleadosRepository  extends JpaRepository<Empleados, Long> {
    List<Empleados> findByEstatus(Integer estatus);
    Optional<Empleados> findByNumeroEmpleado(String numeroEmpleado);
}