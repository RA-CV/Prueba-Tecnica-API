package com.empresa.empleados.dto;

import java.time.LocalDate;

public class EmpleadoDTO {
	
	 	private String numeroEmpleado;
	    private String nombreCompletoEmpleado;
	    private LocalDate fechaNacimiento;
	    private String noCelular;
	    
		public EmpleadoDTO(String numeroEmpleado, String nombreCompletoEmpleado, LocalDate fechaNacimiento,
				String noCelular) {
			this.numeroEmpleado = numeroEmpleado;
			this.nombreCompletoEmpleado = nombreCompletoEmpleado;
			this.fechaNacimiento = fechaNacimiento;
			this.noCelular = noCelular;
		}//constructor

		public String getNumeroEmpleado() {
			return numeroEmpleado;
		}

		public void setNumeroEmpleado(String numeroEmpleado) {
			this.numeroEmpleado = numeroEmpleado;
		}

		public String getNombreCompletoEmpleado() {
			return nombreCompletoEmpleado;
		}

		public void setNombreCompletoEmpleado(String nombreCompletoEmpleado) {
			this.nombreCompletoEmpleado = nombreCompletoEmpleado;
		}

		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getNoCelular() {
			return noCelular;
		}

		public void setNoCelular(String noCelular) {
			this.noCelular = noCelular;
		}

}//classEmpleadoDTO
