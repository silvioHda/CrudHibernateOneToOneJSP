package com.mx.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.*;
import com.mx.general.*;
public class NovioDao implements Metodo{

	EntityManagerFactory enf = Persistence.createEntityManagerFactory("Relacion");
	EntityManager en = enf.createEntityManager();
	 Novio novio = null;
	 Novia novia = null;
	
	
	@Override
	public void guardar(Object o) {
		en.getTransaction().begin();

		 novio = (Novio)o;
		 
		 try {
				en.persist(novio);
				en.getTransaction().commit();
			}catch(Exception ex) {
				System.out.println("Error agregar -> "+ex.getMessage());
				en.getTransaction().rollback();
			}
	}

	@Override
	public void eliminar(Object o) {
		en.getTransaction().begin();

		 novio = (Novio)o;
		novio = en.find(Novio.class, novio.getId());
		try {
			en.remove(novio);
			en.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Error eliminar -> "+ex.getMessage());
			en.getTransaction().rollback();
		}
	}

	@Override
	public void editar(Object o) {
		en.getTransaction().begin();

		 novio = (Novio)o;
		 
		 try {
				en.merge(novio);
				en.getTransaction().commit();
			}catch(Exception ex) {
				System.out.println("Error editar -> "+ex.getMessage());
				en.getTransaction().rollback();
			}
	}

	@Override
	public Object buscar(Object o) {
		novio=(Novio)o;
		return en.createQuery("From Novio where id = "+novio.getId()).getResultList().get(0);
	}

	@Override
	public List mostrar() {
		return en.createQuery("From Novio order by id").getResultList();
		
	}

}
