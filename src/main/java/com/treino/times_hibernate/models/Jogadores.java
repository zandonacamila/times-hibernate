package com.treino.times_hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Jogadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_jogador;
	
	private String ds_nome;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pessoas pessoa;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Times time;
	
	@OneToMany(mappedBy = "jogador")
	private List<Gols> gols = new ArrayList<Gols>();
	
	public Jogadores() {}
	
	public String getDs_nome() {
		return ds_nome;
	}
	
	public void setDs_nome(String ds_nome) {
		this.ds_nome = ds_nome;
	}

	public void addJogador(Pessoas pessoa, Times time) {
		this.pessoa = pessoa;
		this.time = time;
		time.setJogador(this);
		this.setDs_nome(pessoa.getDs_nome());
	}

	public Integer getId_jogador() {
		return id_jogador;
	}

	public void setId_jogador(Integer id_jogador) {
		this.id_jogador = id_jogador;
	}

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}

	public Times getTime() {
		return time;
	}

	public void setId_time(Times time) {
		this.time = time;
	}

	public List<Gols> getGols() {
		return gols;
	}

	public void setGols(List<Gols> gols) {
		this.gols = gols;
	}
	
}
