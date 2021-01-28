package com.treino.times_hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import com.treino.times_hibernate.models.Jogadores;

public class JogadoresDao {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public JogadoresDao() {
		
		emf = Persistence.createEntityManagerFactory("treino");
		
	}
	
	public Jogadores buscaPorId(int id) {
		
		Jogadores ret = new Jogadores();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			ret = em.find(Jogadores.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public void insere(Jogadores pessoa) {
		
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
	
	public void update(Jogadores pessoa) {
		
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
	
	public void remove(Jogadores pessoa) {
		
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
	
	public List<Jogadores> buscaTodos() {
		
		List<Jogadores> jogadores = new ArrayList<Jogadores>();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			jogadores = em.createQuery("select p from Jogadores p", Jogadores.class).getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogadores;
	}
	
	public Jogadores buscaPorNome(String nome) {
	
		Jogadores ret = new Jogadores();
		
		try {
			
			EntityManager em = emf.createEntityManager();
			
			ret = em.createQuery("select p from Jogadores p where p.ds_nome = :nome", Jogadores.class)
			.setParameter("nome", nome)
			.setMaxResults(1)
			.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
