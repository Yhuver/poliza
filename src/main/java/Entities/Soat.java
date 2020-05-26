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
@Table(name = "soats")
public class Soat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "soat_id")
	private Long id;
	
	@Column(name = "soat_valor")
	private Double valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clie_id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehi_id")
	private Vehiculo vehiculo;

}
