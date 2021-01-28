package com.treino.times_hibernate.models;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Gols {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_gols;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Partidas partida;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Jogadores jogador;
	
	private Instant ti_tempo;
	
	public Gols() {}

	public Integer getId_gols() {
		return id_gols;
	}

	public void setId_gols(Integer id_gols) {
		this.id_gols = id_gols;
	}

	public Partidas getPartida() {
		return partida;
	}

	public void setPartida(Partidas partida) {
		this.partida = partida;
	}

	public Jogadores getJogadores() {
		return jogador;
	}

	public void setJogadores(Jogadores jogador) {
		this.jogador = jogador;
	}

	public Instant getTi_tempo() {
		return ti_tempo;
	}

	public void setTi_tempo(Instant ti_tempo) {
		this.ti_tempo = ti_tempo;
	}

}
