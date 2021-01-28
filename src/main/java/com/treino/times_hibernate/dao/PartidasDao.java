package com.treino.times_hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.treino.times_hibernate.models.Gols;
import com.treino.times_hibernate.models.Partidas;

public class PartidasDao {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public PartidasDao() {

		emf = Persistence.createEntityManagerFactory("treino");

	}

	public Partidas buscaPorId(int id) {

		Partidas ret = new Partidas();

		try {

			EntityManager em = emf.createEntityManager();

			ret = em.find(Partidas.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void insere(Partidas partida) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(partida);
			em.getTransaction().commit();
			em.close();    

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void update(Partidas partida) {

		try {

			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(partida);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<Partidas> buscaTodos() {

		List<Partidas> partidas = new ArrayList<Partidas>();

		try {

			EntityManager em = emf.createEntityManager();

			partidas = em.createQuery("select p from Partidas p", Partidas.class).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return partidas;
	}
	
	public List<Gols> getGolsPorPartida(Integer id_partida) {
		
		Partidas partida = buscaPorId(id_partida);
		
		return partida.getGols();
	}

}
