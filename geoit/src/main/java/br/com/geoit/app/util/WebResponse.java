/**
 * 
 */
package br.com.geoit.app.util;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author "Georjuan Taylor"
 *
 */
public class WebResponse<T extends Serializable> {
	
	public enum WEB_RESPONSE_STATUS{ 
		OK, ERROR;
	}
	
	/** Response status */
	private WEB_RESPONSE_STATUS status;
	
	/** Response message */
	private String message;
	
	/** Response object */
	@JsonProperty("response")
	private T response;
	
	/** Response error */
	private WebException exception;
	
	//Build response
	public WebResponse(T object, WEB_RESPONSE_STATUS status, String message){
		this.response = object;
		this.status = status;
		this.message = message;
	}
	
	//Build response
	public WebResponse(WebException exception){
		this.response = null;
		this.status = WEB_RESPONSE_STATUS.ERROR;
		this.exception = exception;
	}
		
	//Build response
	public WebResponse(T object, WEB_RESPONSE_STATUS status){
		this.response = object;
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public WEB_RESPONSE_STATUS getStatus() {
		return status;
	}

	/**
	 * @return the response
	 */
	public T getResponse() {
		return response;
	}

	/**
	 * @return the exception
	 */
	public WebException getException() {
		return exception;
	}

}
