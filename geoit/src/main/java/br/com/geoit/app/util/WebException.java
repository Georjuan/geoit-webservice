/**
 * 
 */
package br.com.geoit.app.util;

import java.io.Serializable;

import org.slf4j.Logger;

/**
 * Exception treatment for web responses
 * @author "Georjuan Taylor"
 *
 */
public class WebException implements Serializable {

	/** Exception message */
	private String message;
	
	private static final long serialVersionUID = 1L;

	public WebException(Exception exception, final Logger logger) {
		this.message = exception.getMessage();
		logger.error(this.message);
	}

	public WebException(String message, final Logger logger) {
		this.message = message;
		logger.error(this.message);
	}
	
	private static String removeSQL(String msg){
		msg = msg.replaceAll("nested exception is ", "");
		msg = msg.replaceAll("\\[SELECT[^\\[\\]].+;?\\]", "[SELECT...]");
		msg = msg.replaceAll("\\[UPDATE[^\\[\\]].+;?\\]", "[UPDATE...]");
		msg = msg.replaceAll("\\[INSERT[^\\[\\]].+;?\\]", "[INSERT...]");
		msg = msg.replaceAll("\\[DELETE[^\\[\\]].+;?\\]", "[DELETE...]");
		return msg;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		message = WebException.removeSQL(message);
		return message;
	}
}
