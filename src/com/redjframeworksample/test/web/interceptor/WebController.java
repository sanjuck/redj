package com.redjframeworksample.test.web.interceptor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.Interceptor;

@Controller("/interceptor")
@Default
@Interceptor(AccessCheckInterceptor.class)

public class WebController {
	public String access(){
		return "access";
	}

	public String deny(){
		return "deny";
	}

	TestWebApplicationContainer container = TestWebApplicationContainer.getInstance(System.getProperty("contextPath"));

	@Test
	public void testDeny(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		WebController a = container.create(WebController.class, request, response);
		assertEquals(a.access(), "access");
		assertEquals(a.deny(), "deny by interceptor");
	}
}
