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
        empleado.setNumeroEmpleado(empleadoActualizado.getNumeroEmpleado());
        empleado.setNombreCompletoEmpleado(empleadoActualizado.getNombreCompletoEmpleado());
        empleado.setFechaNacimiento(empleadoActualizado.getFechaNacimiento());
        empleado.setNoCelular(empleadoActualizado.getNoCelular());
        empleado.setEstatus(empleadoActualizado.getEstatus());
        return empleadosRepository.save(empleado);
    }//updateEmpleado

    public void inactivarEmpleado(Long id) {
        Empleados empleado = empleadosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        empleado.setEstatus(0);
        empleadosRepository.save(empleado);
    }
    
    public Empleados deleteEmpleado(Long id) {
    	Empleados empleado = null;
		if(empleadosRepository.existsById(id)) {
				empleado = empleadosRepository.findById(id).get();
				empleadosRepository.deleteById(id);
			}//ifexist
		return empleado;
	}//class deleteUsuario
}
