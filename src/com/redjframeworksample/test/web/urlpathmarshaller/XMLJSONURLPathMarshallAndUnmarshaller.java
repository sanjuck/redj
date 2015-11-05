package com.redjframeworksample.test.web.urlpathmarshaller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redjframework.ajc.common.JSONMarshallAndUNmarshaller;
import com.redjframework.xos.Viewer;
import com.redjframework.xos.annotations.Template;
import com.thoughtworks.xstream.XStream;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLJSONURLPathMarshallAndUnmarshaller.
 *
 * @author sanjuck@gmail.com
 */
public class XMLJSONURLPathMarshallAndUnmarshaller extends JSONMarshallAndUNmarshaller {

	/* (non-Javadoc)
	 * @see com.redjframework.ajc.common.JSONMarshallAndUNmarshaller#marshall(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public Object marshall(HttpServletRequest request, HttpServletResponse response, Object rst) throws Exception {
		if(rst != null && (	rst instanceof Viewer
				|| rst.getClass().isAnnotationPresent(Template.class)))
			return rst;

		String uri = request.getRequestURI();
		if(uri.endsWith(".xml")){
			XStream xs = new XStream();
			response.setContentType("text/xml;charset=UTF-8");
			xs.toXML(rst, response.getOutputStream());
			return null;
		}

		return super.marshall(request, response, rst);
	}

	/* (non-Javadoc)
	 * @see com.redjframework.ajc.common.JSONMarshallAndUNmarshaller#unmarshall(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Class<?>[])
	 */
	public Object[] unmarshall(HttpServletRequest request, HttpServletResponse response, Class<?>[] argTypes) throws Exception {
		String contentType = request.getContentType();

		if(contentType == null)
			return null;

		if(contentType.indexOf("/xml") != -1){
			String content = getBody(request);
			XStream xs = new XStream();
			return new Object[]{ xs.fromXML(content) };
		}

		return super.unmarshall(request, response, argTypes);
	}
}
