package br.com.geoit.app.util;

import javax.servlet.http.HttpServletRequest;

public abstract class Utils {
	
	/** Format received parameters in request to String map format */
	public static String getMapParam(HttpServletRequest request){
		if(request.getParameterMap().size() == 0) return "{}";
		String values = "";
		for(Object key : request.getParameterMap().keySet()) values += String.format("%s=[%s], ", key.toString(), request.getParameter(key.toString()));
		return "{" + values.substring(0, values.length()-2) + "}";
	}

}
