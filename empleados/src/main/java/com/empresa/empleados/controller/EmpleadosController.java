package com.empresa.empleados.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.empleados.model.Empleados;
import com.empresa.empleados.repository.service.EmpleadosService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {
	private final EmpleadosService empleadosService;

    public EmpleadosController(EmpleadosService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @GetMapping
    public List<Empleados> getAllEmpleados() {
        return empleadosService.getAllEmpleados();
    }//getAllEmpleados
    
    @GetMapping("/{id}")
    public Empleados getEmpleado(@PathVariable Long id) {
        return empleadosService.getEmpleado(id);
    }//getEmpleado

    @PostMapping
    public ResponseEntity<Empleados> addEmpleado(@RequestBody Empleados empleado) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(empleadosService.addEmpleado(empleado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }//addEmpleado
    
    @PutMapping("/{id}")
    public Empleados updateEmpleado(@PathVariable Long id, @RequestBody Empleados empleado) {
    	return empleadosService.updateEmpleado(id, empleado);
    }//updateEmpleado
    
    @PutMapping("/{id}/inactivar")
    public ResponseEntity<Void> inactivarEmpleado(@PathVariable Long id) {
        empleadosService.inactivarEmpleado(id);
        return ResponseEntity.noContent().build();
    }//putMapping
    
}//classEmpleadosController
