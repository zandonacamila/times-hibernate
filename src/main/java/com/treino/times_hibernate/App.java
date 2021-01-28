package com.treino.times_hibernate;

import com.treino.times_hibernate.dao.GolsDao;
import com.treino.times_hibernate.dao.JogadoresDao;
import com.treino.times_hibernate.dao.PartidasDao;
import com.treino.times_hibernate.dao.PessoasDao;
import com.treino.times_hibernate.dao.TimesDao;
import com.treino.times_hibernate.models.Gols;
import com.treino.times_hibernate.models.Jogadores;
import com.treino.times_hibernate.models.Partidas;
import com.treino.times_hibernate.models.Pessoas;
import com.treino.times_hibernate.models.Times;

public class App {
    public static void main( String[] args ) {

    	GolsDao golsService = new GolsDao();
        PartidasDao partidasService = new PartidasDao();
        TimesDao timesService = new TimesDao();
        PessoasDao pessoasService = new PessoasDao();
        JogadoresDao jogadoresService = new JogadoresDao();
        
    	
    	Gols gols = new Gols();
    	Gols gols2 = new Gols();
    	Gols gols3 = new Gols();
        Jogadores jogador1 = new Jogadores();
        Jogadores jogador2 = new Jogadores();
        Partidas partidas = new Partidas();
        Pessoas pessoa1 = new Pessoas();
        Pessoas pessoa2 = new Pessoas();
        Times time1 = new Times();
        Times time2 = new Times();

        pessoasService.insere(pessoa1);
        pessoasService.insere(pessoa2);
        partidasService.insere(partidas);
        timesService.insere(time1);
        timesService.insere(time2);
        jogadoresService.insere(jogador1);
        jogadoresService.insere(jogador2);
        golsService.insere(gols); 
        golsService.insere(gols2); 
        golsService.insere(gols3); 

        var timao = timesService.buscaPorId(1);
        var timinho = timesService.buscaPorId(2);
        
        var tevez = jogadoresService.buscaPorId(1);
        var ceni = jogadoresService.buscaPorId(2);
        
        var jogao = partidasService.buscaPorId(1);
        
        pessoa1.setDs_nome("Carlitos");
        pessoa2.setDs_nome("Ceni");
        
        tevez.addJogador(pessoa1, timao);
        ceni.addJogador(pessoa2, timinho);
        
        var golaco = golsService.buscaPorId(1);
        var frango = golsService.buscaPorId(2);
        var gol = golsService.buscaPorId(3);
        golaco.setJogadores(tevez);
        frango.setJogadores(tevez);
        gol.setJogadores(ceni);
                
        timao.setDs_time("COR");
        timinho.setDs_time("SPFC");
        
        jogao.addGols(golaco, golaco.getJogadores().getTime());
        jogao.addGols(frango, frango.getJogadores().getTime());
        jogao.addGols(gol, gol.getJogadores().getTime());
        jogao.setId_time1(timao);
        jogao.setId_time2(timinho);
        
        jogao.setRivais();

        golsService.update(golaco);
        golsService.update(frango);
        golsService.update(gol);
        timesService.update(timao);
        timesService.update(timinho);
        pessoasService.update(pessoa1);
        pessoasService.update(pessoa2);        
        jogadoresService.update(tevez);
        jogadoresService.update(ceni);
        partidasService.update(jogao);
        
    }
}



//for (Pessoas x : pessoasService.buscaTodos()) {
//	System.out.println(x.getId_pessoa());
//}
//
//for (Times y : timesService.buscaTodos()) {
//	System.out.println(y.getId_time());
//}
