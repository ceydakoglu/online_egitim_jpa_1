package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import beans.Adres;
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
			
			//Adres bilgisi giriliyor.
			Adres adres = new Adres();
			adres.setAdres_ev("Ankara Çankaya");		
			adres.setAdres_is("Ankara Bilkent");
			adres.setEmail("uzunsoy@yandex.com");
			
			egitmen.setAdres(adres);
			adres.setEgitmen(egitmen);
			
			em.persist(egitmen);
			em.persist(adres);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
		 
	}

	
}
