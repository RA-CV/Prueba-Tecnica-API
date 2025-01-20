package com.empresa.empleados.repository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.empleados.model.Empleados;
import com.empresa.empleados.repository.EmpleadosRepository;

@Service
public class EmpleadosService {
	public final EmpleadosRepository empleadosRepository;
	
	public EmpleadosService(EmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
    }//constructor

    public List<Empleados> getAllEmpleados() {
        return empleadosRepository.findByEstatus(1);
    }//methodGetAllEmpleados
    
    public Empleados getEmpleado(Long Id) {
		return empleadosRepository.findById(Id).orElseThrow(
				()-> new IllegalArgumentException("el usuario con el id ["+ 
					Id + "] no existe")
				);
	}//methodGetEmpleado
    
    public Empleados addEmpleado(Empleados empleado) {
        Optional<Empleados> existingEmpleado = empleadosRepository.findByNumeroEmpleado(empleado.getNumeroEmpleado());
        if (existingEmpleado.isEmpty()) {
            return empleadosRepository.save(empleado);
        } else {
            throw new IllegalArgumentException("El empleado con número " + empleado.getNumeroEmpleado() + " ya existe.");
		}//if is Empty
	}//Method addEmpleados

    public Empleados updateEmpleado(Long id, Empleados empleadoActualizado) {
    	Empleados empleado = empleadosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    	
        if (!empleado.getNumeroEmpleado().equals(empleadoActualizado.getNumeroEmpleado())) {
            throw new IllegalArgumentException("El número de empleado no puede ser modificado.");
        }// Validación del número de empleado

        if (empleadoActualizado.getEstatus() != null && empleadoActualizado.getEstatus() != 0 && empleadoActualizado.getEstatus() != 1) {
            throw new IllegalArgumentException("El estatus solo puede ser 0 (inactivo) o 1 (activo).");
        }// Validación del estatus
        
        empleado.setNombreCompletoEmpleado(empleadoActualizado.getNombreCompletoEmpleado());
        empleado.setFechaNacimiento(empleadoActualizado.getFechaNacimiento());
        empleado.setNoCelular(empleadoActualizado.getNoCelular());
        empleado.setEstatus(empleadoActualizado.getEstatus());
        
        return empleadosRepository.save(empleado);
    }// Method updateEmpleado

    public void inactivarEmpleado(Long id) {
        Empleados empleado = empleadosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        empleado.setEstatus(0);
        empleadosRepository.save(empleado);
    }//Method inactivarEmpleado
    
}//classEmpleados Service
