/**
 * 
 */
package br.com.geoit.app.dao;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * JDBC DAO base class
 * @author "Georjuan Taylor"
 *
 */
public class JdbcDAO<T extends Serializable> extends JdbcDaoSupport{
	
	/** Logger object */
	protected Logger logger;
	
	/** Create logger instance */
	protected JdbcDAO(Class<?> daoClass) {
		this.logger = LoggerFactory.getLogger(daoClass);
	}
	
}
