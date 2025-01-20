package com.empresa.empleados.model;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Empleados {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable = false)
	    @Size(min = 6, max = 6, message = "El número de empleado debe tener 6 caracteres.")
	    private String numeroEmpleado;
	    @Column(nullable = false)
	    @Size(min = 6, max = 100, message = "El nombre completo debe tener entre 6 y 100 caracteres.")
	    private String nombreCompletoEmpleado;
	    @Column(nullable = false)
	    @NotNull(message = "La fecha de nacimiento es obligatoria.")
	    private LocalDate fechaNacimiento;
	    @Column(nullable = false)
	    @Pattern(regexp = "\\d{10}", message = "El número de celular debe tener exactamente 10 dígitos.")
	    private String noCelular;
	    @Column(nullable = false)
	    @NotNull(message = "El estatus no puede ser nulo.")
	    @Pattern(regexp = "0|1", message = "El estatus debe ser 0 (inactivo) o 1 (activo).")
	    private Integer estatus;
	    
	 // Constructores
		public Empleados(String numeroEmpleado, String nombreCompletoEmpleado, LocalDate fechaNacimiento,
				String noCelular, Integer estatus) {
			this.numeroEmpleado = numeroEmpleado;
			this.nombreCompletoEmpleado = nombreCompletoEmpleado;
			this.fechaNacimiento = fechaNacimiento;
			this.noCelular = noCelular;
			this.estatus = estatus;
		}//constructor
	    

		public Empleados() {}//constructor vacio para id

		// Getters y Setters
		public Long getId() {
			return id;
		}//getId


		public void setId(Long id) {
			this.id = id;
		}//setId


		public String getNumeroEmpleado() {
			return numeroEmpleado;
		}//getNumeroEmpleado


		public void setNumeroEmpleado(String numeroEmpleado) {
			if (numeroEmpleado == null || numeroEmpleado.length() != 6) {
	            throw new IllegalArgumentException("El número de empleado debe tener exactamente 6 caracteres.");
	        }
			this.numeroEmpleado = numeroEmpleado;
		}//setNumeroEmpleado


		public String getNombreCompletoEmpleado() {
			return nombreCompletoEmpleado;
		}//getNombreCompletoEspleado


		public void setNombreCompletoEmpleado(String nombreCompletoEmpleado) {
			 if (nombreCompletoEmpleado == null || nombreCompletoEmpleado.trim().length() < 6) {
		            throw new IllegalArgumentException("El nombre completo debe tener al menos 6 caracteres.");
		        }
		        if (nombreCompletoEmpleado.length() > 100) {
		            throw new IllegalArgumentException("El nombre completo no puede exceder los 100 caracteres.");
		        }
			this.nombreCompletoEmpleado = nombreCompletoEmpleado.trim();
		}//setNombreCompletoEspleado


		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}//getFechaNacimiento


		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			 if (fechaNacimiento == null) {
		            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
		        }
		        if (Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18) {
		            throw new IllegalArgumentException("El empleado debe ser mayor de 18 años.");
		        }
			this.fechaNacimiento = fechaNacimiento;
		}//setFechaNacimiento


		public String getNoCelular() {
			return noCelular;
		}//getNoCelular


		public void setNoCelular(String noCelular) {
			 if (noCelular == null || noCelular.length() != 10 || !noCelular.matches("\\d+")) {
		            throw new IllegalArgumentException("El número de celular debe tener exactamente 10 dígitos numéricos.");
		        }
			this.noCelular = noCelular;
		}//setNoCelular


		public Integer getEstatus() {
			return estatus;
		}//getEstatus


		public void setEstatus(Integer estatus) {
	        if (estatus == null || (estatus != 0 && estatus != 1)) {
	            throw new IllegalArgumentException("El estatus debe ser 1 (activo) o 0 (inactivo).");
	        }
			this.estatus = estatus;
		}//setEstatus

		//toString
		@Override
		public String toString() {
			return "Empleados [id=" + id + ", numeroEmpleado=" + numeroEmpleado + ", nombreCompletoEmpleado="
					+ nombreCompletoEmpleado + ", noCelular=" + noCelular + ", estatus=" + estatus + "]";
		}//toString
	    
}//class Empleados

