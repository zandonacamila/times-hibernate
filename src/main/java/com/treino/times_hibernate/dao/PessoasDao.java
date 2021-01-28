package com.treino.times_hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.treino.times_hibernate.models.Pessoas;

public class PessoasDao {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public PessoasDao() {
		
		emf = Persistence.createEntityManagerFactory("treino");
		
	}
	
	public Pessoas buscaPorId(int id) {
		
		Pessoas ret = new Pessoas();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			ret = em.find(Pessoas.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public void insere(Pessoas pessoa) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
	        em.persist(pessoa);
	        em.getTransaction().commit();
	        em.close();    
	        
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void update(Pessoas pessoa) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.merge(pessoa);
			em.getTransaction().commit();
			em.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void remove(Pessoas pessoa) {
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			pessoa = em.merge(pessoa);
			em.remove(pessoa);
			
			em.getTransaction().commit();
			
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Pessoas> buscaTodos() {
		
		List<Pessoas> pessoas = new ArrayList<Pessoas>();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			pessoas = em.createQuery("select p from Pessoas p", Pessoas.class).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoas;
	}
	
	public Pessoas buscaPorNome(String nome) {
	
		Pessoas ret = new Pessoas();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			ret = em.createQuery("select p from Pessoas p where p.ds_nome = :nome", Pessoas.class)
			.setParameter("nome", nome)
			.setMaxResults(1)
			.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
