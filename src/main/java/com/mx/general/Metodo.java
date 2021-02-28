package com.mx.general;

import java.util.List;

public interface Metodo {
	public void guardar(Object o);
	public void eliminar(Object o);
	public void editar(Object o);
	public Object buscar(Object o);
	public List mostrar();
}
