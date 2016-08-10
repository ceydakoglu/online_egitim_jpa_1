package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import beans.Egitmen;

public class Yonetim {

	static EntityManagerFactory emf;
	static EntityManager em;
	
	public static void main(String[] args) {
	
		emf = Persistence.createEntityManagerFactory("JPAProjesi");
		em = emf.createEntityManager();
		
		try {
		
			em.getTransaction().begin();			
			Egitmen egitmen = new Egitmen();
			egitmen.setIsim("Selçuk Uzunsoy/ BilgeAdam");
			egitmen.setTc("954876948576");
			egitmen.setTel("0495680364");
			em.persist(egitmen);			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
		 
	}

	
}
