package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_PRODUCTO")
public class ProductoEntity {
	@Id
	@Column(name = "ID_PRODUCTO")
	private Integer idProducto;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "FEC_REGISTRO")
	private LocalDate fecRegistro;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(LocalDate fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

}
