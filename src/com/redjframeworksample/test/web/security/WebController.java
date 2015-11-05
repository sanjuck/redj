package com.redjframeworksample.test.web.security;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.Interceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class WebController.
 *
 * @author sanjuck@gmail.com
 */
@Controller("/security")
@Default
@Interceptor(AccessAuthSecurityInterceptor.class)
public class WebController {

	/**
	 * Admin.
	 *
	 * @return the string
	 */
	@AccessAuth(ROLE.ADMIN)
	public String admin(){
		return "admin";
	}

	/**
	 * Op.
	 *
	 * @return the string
	 */
	@AccessAuth(ROLE.OP)
	public String op(){
		return "op";
	}

	/**
	 * User.
	 *
	 * @return the string
	 */
	@AccessAuth({ROLE.ADMIN, ROLE.OP, ROLE.USER})
	public String user(){
		return "user";
	}

	/** The container. */
	TestWebApplicationContainer container = TestWebApplicationContainer.getInstance(System.getProperty("contextPath"));

	/**
	 * Test admin access.
	 */
	@Test
	public void testAdminAccess(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		WebController a = container.create(WebController.class, request, response);

		request.setParameter("AUTH", ROLE.ADMIN.name());
		a.admin();
		assertEquals(response.getStatus(), HttpServletResponse.SC_OK);
	}

	/**
	 * Test admin deny.
	 */
	@Test
	public void testAdminDeny(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		WebController a = container.create(WebController.class, request, response);

		request.setParameter("AUTH", ROLE.USER.name());
		a.admin();
		assertEquals(response.getStatus(), HttpServletResponse.SC_UNAUTHORIZED);
	}

	/**
	 * Test user access.
	 */
	@Test
	public void testUserAccess(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		WebController a = container.create(WebController.class, request, response);

		request.setParameter("AUTH", ROLE.USER.name());
		a.user();
		assertEquals(response.getStatus(), HttpServletResponse.SC_OK);
	}
}
