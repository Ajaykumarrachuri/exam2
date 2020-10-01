package com.sapient.assesment.assesment;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

	public static void main(String[] args) {
		final Logger LOGGER = LoggerFactory.getLogger(Login.class);
	      Login a = new Login();
	      a.setUsername("ajay.rachuri");
	      a.setPassword("12234");
	      
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
	    	EntityManager em = null;
	    	try {
	    	em=emf.createEntityManager();
	    	
	    	em.getTransaction().begin();
	    	em.persist(a);
	    	em.getTransaction().commit();
	    	}
	    	catch(PersistenceException e) {
				em.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			}finally {
				em.close();
			}
	    	
	    	LOGGER.info("added the user credentilas");
	    	

	}

}
