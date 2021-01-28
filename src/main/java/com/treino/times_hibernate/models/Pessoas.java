package com.treino.times_hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pessoa;
	
	private String ds_nome;
	private String dt_nascimento;
	
	public Pessoas() {}

	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getDs_nome() {
		return ds_nome;
	}

	public void setDs_nome(String ds_nome) {
		this.ds_nome = ds_nome;
	}

	public String getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
		
}
