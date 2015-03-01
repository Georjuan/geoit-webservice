package br.com.geoit.app.dao;

import java.io.Serializable;


/**
 * Basic CRUD operations interface
 * @author "Georjuan Taylor"
 *
 * @param <T>
 */
public interface CRUD<T extends Serializable> {

	/** Create {@link T} object into data base */
	T create(T object) throws Exception;
	
	/** Select {@link T} object from data base */
	T select(T object) throws Exception;
	
	/** Update {@link T} object into data base */
	T update(T object) throws Exception;
	
	/** Delete {@link T} object from data base */
	T delete(T object) throws Exception;
	
}
