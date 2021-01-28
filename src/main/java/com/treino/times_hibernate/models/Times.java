package com.treino.times_hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Times {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_time;
	
	private String ds_time;
	
	@ManyToOne
	private Jogadores jogador;
	
	
	public Times() {}

	public Integer getId_time() {
		return id_time;
	}
		
	public Jogadores getJogador() {
		return jogador;
	}

	public void setJogador(Jogadores jogador) {
		this.jogador = jogador;
	}
	
	public void setId_time(Integer id_time) {
		this.id_time = id_time;
	}

	public String getDs_time() {
		return ds_time;
	}

	public void setDs_time(String ds_time) {
		this.ds_time = ds_time;
	}
	
}
