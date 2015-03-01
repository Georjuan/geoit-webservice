package br.com.geoit.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * App data settings
 * @author "Georjuan Taylor"
 * 
 */
@Entity
@Table(name="settings")
public class AppSettings implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** Search method enum */
	public static enum APP_SEARCH_METHOD{
		BLOCKS_SEARCH, TEXT_SEARCH, TEXT_BLOCKS_SEARCH;
	}
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="settings_id_seq")
	private Integer id;
	
	@JsonIgnore
	@Column
	private boolean valid; 
	
	@Column(name="system_available")
	private boolean systemAvailable;
	
	@Column(name="min_app_version")
	private short minVersion;
	
	@Column(name="actual_app_version")
	private short actualVersion;
	
	@Column(name="request_login_access_app")
	private boolean requestLoginAccess;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="app_search_method")
	private APP_SEARCH_METHOD searchMethod;

	public AppSettings() {}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the systemAvailable
	 */
	public boolean isSystemAvailable() {
		return systemAvailable;
	}

	/**
	 * @param systemAvailable the systemAvailable to set
	 */
	public void setSystemAvailable(boolean systemAvailable) {
		this.systemAvailable = systemAvailable;
	}

	/**
	 * @return the minVersion
	 */
	public short getMinVersion() {
		return minVersion;
	}

	/**
	 * @param minVersion the minVersion to set
	 */
	public void setMinVersion(short minVersion) {
		this.minVersion = minVersion;
	}

	/**
	 * @return the actualVersion
	 */
	public short getActualVersion() {
		return actualVersion;
	}

	/**
	 * @param actualVersion the actualVersion to set
	 */
	public void setActualVersion(short actualVersion) {
		this.actualVersion = actualVersion;
	}

	/**
	 * @return the requestLoginAccess
	 */
	public boolean isRequestLoginAccess() {
		return requestLoginAccess;
	}

	/**
	 * @param requestLoginAccess the requestLoginAccess to set
	 */
	public void setRequestLoginAccess(boolean requestLoginAccess) {
		this.requestLoginAccess = requestLoginAccess;
	}

	/**
	 * @return the searchMethod
	 */
	public APP_SEARCH_METHOD getSearchMethod() {
		return searchMethod;
	}

	/**
	 * @param searchMethod the searchMethod to set
	 */
	public void setSearchMethod(APP_SEARCH_METHOD searchMethod) {
		this.searchMethod = searchMethod;
	}

}
