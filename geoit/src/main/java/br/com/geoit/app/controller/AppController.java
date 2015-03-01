package br.com.geoit.app.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import br.com.geoit.app.model.AppSettings;
import br.com.geoit.app.service.AppService;
import br.com.geoit.app.util.Utils;
import br.com.geoit.app.util.WebException;
import br.com.geoit.app.util.WebResponse;
import br.com.geoit.app.util.WebResponse.WEB_RESPONSE_STATUS;

/**
 * Controller of App settings
 * @author "Georjuan Taylor"
 *
 */
@RestController
@RequestMapping(value="/app")
public class AppController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	private final Logger logger = LoggerFactory.getLogger(AppController.class);

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(ModelAndView view, Locale locale){
		this.logger.info("Welcome Get It! The client IP is {} and locale is {}.", request.getRemoteAddr(), locale);		
		//View name
		view.setViewName("home");
		//View parameters
		view.addObject("company", "Geo It");
		view.addObject("message", "Hello World!");
		return view;
	}
	
	/**
	 * Get app settings to work
	 * @return App
	 */
	@RequestMapping(value="/settings", method=RequestMethod.GET)
	public WebResponse<AppSettings> getSettings(){
		this.logger.info(String.format("Request for '/app/settings' - From: %s:%d - Parameters: %s",
											request.getRemoteAddr(), request.getRemotePort(), Utils.getMapParam(this.request)));
		try {
			//Get application context
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.session.getServletContext());
			
			//Get AppService bean
			AppService appService = ctx.getBean(AppService.class);
			
			//Get settings
			AppSettings app = appService.getAppSettings(); 
			
			//Return response
			return new WebResponse<AppSettings>(app, WEB_RESPONSE_STATUS.OK);
		} catch (Exception e) {
			return new WebResponse<AppSettings>(new WebException(e, this.logger));
		}
	}
	
}