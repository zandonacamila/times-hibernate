package com.treino.times_hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Partidas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_partida;
	
	private String rivais;
	
	@OneToOne
	private Times id_time1;
	
	@OneToOne
	private Times id_time2;
	
	@OneToMany
	private List<Gols> gols = new ArrayList<Gols>();
	
	public Partidas() {}

	public String getRivais() {
		return rivais;
	}

	public void setRivais() {
		this.rivais = this.getId_time1().getDs_time() + " x " + this.getId_time2().getDs_time();
	}

	public void addGols(Gols gols, Times time) {
		
		this.gols.add(gols);
		gols.setPartida(gols.getPartida());
		gols.setJogadores(gols.getJogadores());
		gols.setTi_tempo(gols.getTi_tempo());
		
	}

	public Integer getId_partida() {
		return id_partida;
	}

	public void setId_partida(Integer id_partida) {
		this.id_partida = id_partida;
	}

	public Times getId_time1() {
		return id_time1;
	}

	public void setId_time1(Times id_time1) {
		this.id_time1 = id_time1;
	}

	public Times getId_time2() {
		return id_time2;
	}

	public void setId_time2(Times id_time2) {
		this.id_time2 = id_time2;
	}

	public List<Gols> getGols() {
		return gols;
	}

	public void setGols(List<Gols> gols) {
		this.gols = gols;
	}
		
}
