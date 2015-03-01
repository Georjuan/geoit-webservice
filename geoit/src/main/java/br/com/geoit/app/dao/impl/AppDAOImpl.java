/**
 * 
 */
package br.com.geoit.app.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.geoit.app.dao.AppDAO;
import br.com.geoit.app.dao.JdbcDAO;
import br.com.geoit.app.dao.mapper.AppSettingsMapper;
import br.com.geoit.app.model.AppSettings;

/**
 * @author "Georjuan Taylor"
 *
 */
@Repository
public class AppDAOImpl extends JdbcDAO<AppSettings> implements AppDAO {

	/**
	 * DB data source from spring context
	 * @param dataSource
	 */
	@Autowired
	public AppDAOImpl(DataSource dataSource) {
		super(AppDAOImpl.class);
		super.setDataSource(dataSource);
		
	}

	/* (non-Javadoc)
	 * @see br.com.geoit.app.dao.AppDAO#selectSettings()
	 */
	@Override
	public AppSettings selectSettings() {
		String sql = "SELECT * FROM settings WHERE valid = true;";
		
		List<AppSettings> settings = getJdbcTemplate().query(sql, new AppSettingsMapper());
		
		return settings.size() == 0 ? null : settings.get(0);
	}

}
