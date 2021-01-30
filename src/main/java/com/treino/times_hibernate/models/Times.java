package com.treino.times_hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Times {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_time;
	
	private String ds_time;
	
	@OneToMany
	private List<Jogadores> jogadores;

	public Times() {}

	public Integer getId_time() {
		return id_time;
	}
		
	public List<Jogadores> getJogador() {
		return jogadores;
	}

	public void setJogador(Jogadores jogadores) {
		List<Jogadores> jogadores_time = new ArrayList<Jogadores>();
		jogadores_time.add(jogadores);
		this.jogadores = jogadores_time;
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
