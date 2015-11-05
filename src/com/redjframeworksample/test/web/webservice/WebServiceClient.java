package com.redjframeworksample.test.web.webservice;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import com.redjframework.factory.WebserviceFactory;
import com.redjframework.xos.sample.URLPathApplicationContainer;

// TODO: Auto-generated Javadoc
/**
 * The Class WebServiceClient.
 *
 * @author sanjuck@gmail.com
 */
public class WebServiceClient {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws MalformedURLException the malformed url exception
	 */
	public static void main(String[] args) throws MalformedURLException{
		WebController webServiceSample = WebserviceFactory.newWebservice(WebController.class, new URL("http://localhost:8080"), new URLPathApplicationContainer());
		assertEquals("NAME@HOST", webServiceSample.get("NAME"));
	}
}
