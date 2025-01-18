package com.empresa.empleados.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
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
    
    @GetMapping(path = "{id}") //https://localhost:8080/api/productos/1
	public Empleados getEmpleado(@PathVariable("id")Long Id) {
		return empleadosService.getEmpleado(Id);
	}//getEmpleado

    @PostMapping
    public Empleados addEmpleado(@RequestBody Empleados empleado) {
        return empleadosService.addEmpleado(empleado);
    }//addEmpleado
    
    @PutMapping("/{id}")
    public Empleados updateEmpleado(@PathVariable Long id, @RequestBody Empleados empleado) {
    	return empleadosService.updateEmpleado(id, empleado);
    }//updateEmpleado
    
    @DeleteMapping("/{id}") // Corregido
    public Empleados deleteEmpleado(@PathVariable("id") Long id) {
        return empleadosService.deleteEmpleado(id);
	}//deleteEmpleados
    
}//classEmpleadosController
