package br.com.geoit.app.dao;

import br.com.geoit.app.model.AppSettings;

/**
 * App object DAO interface
 * @author "Georjuan Taylor"
 *
 */
public interface AppDAO {

	/**
	 * Select settings from app configuration
	 * @return {@link AppSettings}
	 */
	AppSettings selectSettings();
	
}
