package com.redjframeworksample.test.web.urlpathmarshaller;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.MarshallAndUnmarshaller;

@Controller("/urlpathmarshaller")
@Default
@MarshallAndUnmarshaller(marshaller=XMLJSONURLPathMarshallAndUnmarshaller.class, unmarshaller=XMLJSONURLPathMarshallAndUnmarshaller.class)
public class WebController {
	/**
	 * /index.html
	 * /index.json
	 * /index.xml
	 *
	 * @return
	 */
	public Object index(Map<String, String> map){
		if(map == null)
			map = new HashMap<String, String>();
		map.put("a", "AAAAAAAAAAAAAAAA");
		System.out.println(map);
		return map;
	}

	TestWebApplicationContainer container = TestWebApplicationContainer.getInstance(System.getProperty("contextPath"));

	@Test
	public void testIndex_html(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		container.submit("/urlpathmarshaller/index.html", request, response);

		assertEquals("/WEB-INF/jsp/urlpathmarshaller/index.jsp", response.getForwardedUrl());
	}

	@Test
	public void testIndex_json() throws UnsupportedEncodingException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		request.setMethod("POST");
		request.addHeader("JSON", "JSON");
		request.setContentType("application/json");
		request.setParameter("JSON", "[{\"b\":\"BBBBBBBBBBBBBBBBBB\"}]");
		request.setContent("[1]".getBytes());

		container.submit("/urlpathmarshaller/index.json", request, response);
		assertTrue(response.getContentAsString().startsWith("{"));
	}

	@Test
	public void testIndex_body_json() throws UnsupportedEncodingException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		request.setMethod("POST");
		request.setContentType("application/json");
		request.setContent("[{\"b\":\"BBBBBBBBBBBBBBBBBB\"}]".getBytes());

		container.submit("/urlpathmarshaller/index.json", request, response);
		assertTrue(response.getContentAsString().startsWith("{"));
	}

	@Test
	public void testIndex_xml() throws UnsupportedEncodingException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		request.setMethod("POST");
		request.setContentType("application/xml");
		request.setContent("<map><entry><string>b</string><string>BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB</string></entry></map>".getBytes());

		container.submit("/urlpathmarshaller/index.xml", request, response);
		System.out.println(response.getContentAsString());
		assertTrue(response.getContentAsString().startsWith("<"));
	}
}
