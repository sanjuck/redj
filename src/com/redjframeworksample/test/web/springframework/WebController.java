package com.redjframeworksample.test.web.springframework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.annotations.Autoassign;
import com.redjframework.test.TestJUnit4Runner;
import com.redjframework.test.annotation.TestConfiguration;
import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.springframework.test.service.SpringManageService01;

// TODO: Auto-generated Javadoc
/**
 * The Class WebController.
 *
 * @author sanjuck@gmail.com
 */
@Controller("/springframework")
@Default
@RunWith(TestJUnit4Runner.class)
@TestConfiguration(resources={"redj-*.xml"})
public class WebController {
	@Autoassign SpringManageService01 service01;

	@Autoassign SpringManageService01 service02;

	/**
	 * http://localhost:8080/helloworld/index.
	 *
	 * @return the string
	 */
	public String index(){
		service01.add();
		return service01.getName();
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
}
