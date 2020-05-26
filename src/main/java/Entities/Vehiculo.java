package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehi_id")
	private Long id;
	
	@Column(name = "vehi_modelo")
	private String modelo;
	
	@Column(name = "vehi_marca")
	private String marca;
	
	@Column(name = "vehi_anio")
	private Long anio;
	
	@Column(name = "vehi_placa")
	private String placa;
	
	@Column(name = "vehi_seril")
	private String serial;
	
	@Column(name = "vehi_valor")
	private Double valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clie_id")
	private Cliente cliente;

}
