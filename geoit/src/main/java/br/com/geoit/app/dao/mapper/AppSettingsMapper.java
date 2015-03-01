package br.com.geoit.app.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.geoit.app.model.AppSettings;
import br.com.geoit.app.model.AppSettings.APP_SEARCH_METHOD;

public final class AppSettingsMapper implements RowMapper<AppSettings> {

	@Override
	public AppSettings mapRow(ResultSet rs, int rowNum) throws SQLException {
		AppSettings settings = new AppSettings();
		
		settings.setId(rs.getInt("id"));
		settings.setSystemAvailable(rs.getBoolean("system_available"));
		settings.setActualVersion(rs.getShort("actual_app_version"));
		settings.setMinVersion(rs.getShort("min_app_version"));
		settings.setRequestLoginAccess(rs.getBoolean("request_login_access_app"));
		settings.setSearchMethod(APP_SEARCH_METHOD.values()[rs.getInt("app_search_method")]);
		settings.setValid(rs.getBoolean("valid"));
		
		return settings;
	}

}
