package com.treino.times_hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.treino.times_hibernate.models.Times;

public class TimesDao {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public TimesDao() {
		
		emf = Persistence.createEntityManagerFactory("treino");
		
	}
	
	public Times buscaPorId(int id) {
		
		Times ret = new Times();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			ret = em.find(Times.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public void insere(Times time) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
	        em.persist(time);
	        em.getTransaction().commit();
	        em.close();    
	        
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void update(Times time) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(time);
			em.getTransaction().commit();
			em.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void remove(Times time) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			time = em.merge(time);
			em.remove(time);
			
			em.getTransaction().commit();
			
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Times> buscaTodos() {
		
		List<Times> times = new ArrayList<Times>();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			times = em.createQuery("select t from Times t", Times.class).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return times;
	}
	
	public Times buscaPorNome(String nome) {
	
		Times ret = new Times();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			ret = em.createQuery("select t from Times t where t.ds_nome = :nome", Times.class)
			.setParameter("nome", nome)
			.setMaxResults(1)
			.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
