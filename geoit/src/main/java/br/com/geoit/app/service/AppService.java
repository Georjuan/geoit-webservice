/**
 * 
 */
package br.com.geoit.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.geoit.app.dao.impl.AppDAOImpl;
import br.com.geoit.app.model.AppSettings;

/**
 * Service of App settings
 * @author "Georjuan Taylor"
 *
 */
@Service
public class AppService {

	@Autowired
	private AppDAOImpl appDAO;
		
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(AppService.class);
		
	/**
	 * Retrieve app settings
	 * @return App
	 * @throws Exception
	 */
	public AppSettings getAppSettings() throws Exception{
		AppSettings app = this.appDAO.selectSettings();
		
		if(app == null) throw new Exception("No app settings found.");
		
		return app;
	}
	
}
