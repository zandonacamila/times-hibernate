package com.treino.times_hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.treino.times_hibernate.models.Gols;

public class GolsDao {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public GolsDao() {
		
		emf = Persistence.createEntityManagerFactory("treino");
		
	}
	
	public Gols buscaPorId(int id) {
		
		Gols ret = new Gols();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			ret = em.find(Gols.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public void insere(Gols gol) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
	        em.persist(gol);
	        em.getTransaction().commit();
	        em.close();    
	        
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void update(Gols gol) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(gol);
			em.getTransaction().commit();
			em.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void remove(Gols gol) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			gol = em.merge(gol);
			em.remove(gol);
			
			em.getTransaction().commit();
			
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Gols> buscaTodos() {
		
		List<Gols> gols = new ArrayList<Gols>();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			gols = em.createQuery("select t from Gols t", Gols.class).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gols;
	}
	
}
