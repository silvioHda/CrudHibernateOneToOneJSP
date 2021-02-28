package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Novia;
import com.mx.entidad.Novio;
import com.mx.general.Metodo;

public class NoviaDao implements Metodo{

	EntityManagerFactory enf = Persistence.createEntityManagerFactory("Relacion");
	EntityManager en = enf.createEntityManager();
	 Novio novio = null;
	 Novia novia = null;
	
	@Override
	public void guardar(Object o) {
		en.getTransaction().begin();

		 novia = (Novia)o;
		 novio = en.find(Novio.class, novia.getNovio().getId());
		 
		 try {
				en.persist(novia);
				novia.setNovio(novio);
				novio.setNovia(novia);
				
				en.getTransaction().commit();
			}catch(Exception ex) {
				System.out.println("Error agregar -> "+ex.getMessage());
				en.getTransaction().rollback();
			}
	}

	@Override
	public void eliminar(Object o) {
		// TODO Auto-generated method stub
		en.getTransaction().begin();

		 novia = (Novia)o;
		novia = en.find(Novia.class, novia.getId());
		novio = en.find(Novio.class,novia.getNovio().getId() );
		novio.setNovia(null);
		novia.setNovio(null);
		
		try {
			en.remove(novia);
			en.getTransaction().commit();
		}catch(Exception ex) {
			System.out.println("Error eliminar -> "+ex.getMessage());
			en.getTransaction().rollback();
		}
	}

	@Override
	public void editar(Object o) {
		Novia nuevaNovia = (Novia) o;
		Novia novia, exNovia;
		Novio exNovio;
		
		en.getTransaction().begin(); //iniciar transaccion
		
		try {
			novia = en.find(Novia.class, nuevaNovia.getId());
			if(novia != null) {
				
				Novio nuevoNovio = novio = en.find(Novio.class, nuevaNovia.getNovio().getId());
				if(nuevoNovio == null) {
					
					System.out.println("error al editar, no existe el novio");
					en.getTransaction().rollback();
					return;
				}
				
			
			if(novia.getNovio() != null && nuevoNovio.getNovia() != null) {
				exNovio = en.find(Novio.class, novia.getNovio().getId());
				exNovia = en.find(Novia.class, nuevoNovio.getNovia().getId());
				exNovio.setNovia(null);
				exNovia.setNovio(null);
				nuevoNovio.setNovia(novia);
				novia.setNovio(novio);
			}else if(novia.getNovio() != null && nuevoNovio.getNovia()== null) {
				exNovio = en.find(Novio.class, novia.getNovio().getId());
				exNovio.setNovia(null);
				novia.setNovio(nuevoNovio);
				nuevoNovio.setNovia(novia);
			}else if(novia.getNovio()== null && nuevoNovio.getNovia()==null) {
				novia.setNovio(nuevoNovio);
				nuevoNovio.setNovia(novia);
			}else if(novia.getNovio()==null && nuevoNovio.getNovia() != null) {
				exNovia = en.find(Novia.class, nuevoNovio.getNovia().getId());
				exNovia.setNovio(null);
				nuevoNovio.setNovia(novia);
				novia.setNovio(nuevoNovio);
			}
			novia.setApp(nuevaNovia.getApp());
			novia.setEdad(nuevaNovia.getEdad());
			novia.setEstatura(nuevaNovia.getEstatura());
			novia.setNombre(nuevaNovia.getNombre());
			novia.setPasatiempo(nuevaNovia.getPasatiempo());
			
			en.merge(novia);
			en.getTransaction().commit();
		}else {
			System.out.println("Error al editar, la novia no existe");
			en.getTransaction().rollback();
		}
			
		}catch(Exception e) {
			System.out.println("Error cambiar novia(o)->" + e.getMessage());
			en.getTransaction().rollback();
		}
	}
	
	/*@Override
	public void editar(Object o) {
		en.getTransaction().begin();

		 novia = (Novia)o;
		int id = novia.getNovio().getId();
		 novio = en.find(Novio.class, novia.getNovio().getId());
		 System.out.println(novio);
		 System.out.println(novia);
		 if (novia.getNovio().getNombre()==null) {
			 novia.setNovio(null);
			 novio.setNovia(null);
			 //novia = en.find(Novia.class, novia.getId());
			 novio = en.find(Novio.class,id);
			 novio.setNovia(null);
			 System.out.println(novia.toString());
			 System.out.println(novio.toString());
			novia.setNovio(novio);
			 novio.setNovia(novia);
		}
		 if (!(novia.getNovio().getNombre().isEmpty())) {
			 novia.setNovio(null);
			 novio.setNovia(null);
			 
			 novio = en.find(Novio.class,id);
			 Novia novia2 = en.find(Novia.class, novio.getNovia().getId());
			 novio.setNovia(null);
			 novia2.setNovio(null);
			 System.out.println(novia.toString());
			 System.out.println(novio.toString());
			novia.setNovio(novio);
			 novio.setNovia(novia);
		}
		 
		
		 try {
				en.merge(novia);
				//novia.setNovio(novio);
				//novio.setNovia(novia);
				en.getTransaction().commit();
			}catch(Exception ex) {
				System.out.println("Error editar -> "+ex.getMessage());
				en.getTransaction().rollback();
			}
		
	}
	*/

	@Override
	public Object buscar(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List mostrar() {
		// TODO Auto-generated method stub
		return en.createQuery("From Novia order by id").getResultList();

	}

}
