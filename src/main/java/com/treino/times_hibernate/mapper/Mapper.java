package com.treino.times_hibernate.mapper;

import com.treino.times_hibernate.dao.JogadoresDao;
import com.treino.times_hibernate.dao.PartidasDao;
import com.treino.times_hibernate.dao.PessoasDao;
import com.treino.times_hibernate.dao.TimesDao;
import com.treino.times_hibernate.models.Jogadores;
import com.treino.times_hibernate.models.Partidas;
import com.treino.times_hibernate.models.Pessoas;
import com.treino.times_hibernate.models.Times;

public class Mapper {

	public Partidas montaPartida() {
		
		return new Partidas();
	}

	public void inserePartida() {

		PartidasDao partidasService = new PartidasDao();
		partidasService.insere(montaPartida());

	}

	public void montaTimes() {


	}

	public TimesDao insereTimes() {
		
		Times time = new Times();
	
		TimesDao timesService = new TimesDao();
		timesService.insere(time);
				
		return timesService;
	}

	public void montaPessoas() {


	}

	public PessoasDao inserePessoas() {
		
		Pessoas pessoa = new Pessoas();

		PessoasDao pessoasService = new PessoasDao();
		pessoasService.insere(pessoa);
			
		return pessoasService;
	}

	public void montaJogadores() {


	}

	public JogadoresDao insereJogadores() {
		
		Jogadores jogador = new Jogadores();
		

		JogadoresDao jogadoresService = new JogadoresDao();
		jogadoresService.insere(jogador);
				
		return jogadoresService;
	}


	
	
	

//	Gols gols = new Gols();
	
	
	
	

	
	
	
	

//	var timao = timesService.buscaPorId(1);
//	var timinho = timesService.buscaPorId(2);
//
//	var tevez = jogadoresService.buscaPorId(1);
//	var ceni = jogadoresService.buscaPorId(2);
//
//	var jogao = partidasService.buscaPorId(1);
//
//	pessoa1.setDs_nome("Carlitos");
//	pessoa2.setDs_nome("Ceni");
//
//	tevez.addJogador(pessoa1, timao);
//	ceni.addJogador(pessoa2, timinho);
//
//	timao.setDs_time("COR");
//	timinho.setDs_time("SPFC");
//
//	jogao.setId_time1(timao);
//	jogao.setId_time2(timinho);
//
//	jogao.setRivais();
//
//	timesService.update(timao);
//	timesService.update(timinho);
//	pessoasService.update(pessoa1);
//	pessoasService.update(pessoa2);        
//	jogadoresService.update(tevez);
//	jogadoresService.update(ceni);
//	partidasService.update(jogao);
}
