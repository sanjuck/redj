package com.redjframeworksample.test.web.helloworld;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.annotations.Autoassign;
import com.redjframework.conf.Configuration;
import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.RequestMapping;
import com.redjframework.xos.annotations.RequestParam;
import com.redjframework.xos.viewer.Forward;

// TODO: Auto-generated Javadoc
/**
 * The Class WebController.
 *
 * @author sanjuck@gmail.com
 */
@Controller("/helloworld")
@Default
public class WebController {
	static{
		System.setProperty("mode", "commercial");
	}

	@Autoassign("conf") Map<String, String> conf;

	/**
	 * http://localhost:8080/helloworld/index.
	 *
	 * @return the string
	 */
	public String index(){
		System.out.println(conf);
		return "helloworld";
	}

	/**
	 * http://localhost:8080/helloworld/forward.
	 *
	 * @return the forward
	 */
	public Forward forward(){
		return new Forward().data("data", "helloworld");
	}

	/**
	 * http://localhost:8080/helloworld/mapping/aaaaaaaaaaaaaa?name=sanjuck.
	 *
	 * @param value the value
	 * @param name the name
	 * @return the forward
	 */
	@RequestMapping(path="/helloworld/mapping/*")
	public Forward mapping(@RequestParam(mappingIndex=1) String value, @RequestParam("name") String name){
		System.out.println("value >> " + value);
		System.out.println("name >> " + name);
		return null;
	}

	/** The container. */
	TestWebApplicationContainer container = TestWebApplicationContainer.getInstance(System.getProperty("contextPath"));

	/**
	 * Test index.
	 */
	@Test
	public void testIndex(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		WebController a = container.create(WebController.class, request, response);
		System.out.println(a.index());
	}

	/**
	 * Test index2.
	 *
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	@Test
	public void testIndex2() throws UnsupportedEncodingException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		container.submit("/helloworld/index", request, response);

		System.out.println(response.getContentAsString());
	}

	/**
	 * Testmapping.
	 *
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	@Test
	public void testmapping() throws UnsupportedEncodingException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		request.setParameter("name", "sanjuck");
		container.submit("/helloworld/mapping/1234567890", request, response);

		System.out.println(response.getContentAsString());
	}
}
