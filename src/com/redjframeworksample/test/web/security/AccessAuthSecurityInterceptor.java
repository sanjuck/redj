package com.redjframeworksample.test.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redjframework.xos.HandlerInvocation;
import com.redjframework.xos.interceptor.HandlerInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class AccessAuthSecurityInterceptor.
 *
 * @author sanjuck@gmail.com
 */
public class AccessAuthSecurityInterceptor implements HandlerInterceptor{

	/* (non-Javadoc)
	 * @see com.redjframework.xos.interceptor.HandlerInterceptor#invoke(com.redjframework.xos.HandlerInvocation)
	 */
	public Object invoke(HandlerInvocation arg0) throws Exception {
		HttpServletRequest request = arg0.getRequest();
		HttpServletResponse response = arg0.getResponse();
		Class<?> cls = arg0.getHandler().getClass();

		// annotation
		AccessAuth accessAuth = arg0.getMethod().getAnnotation(AccessAuth.class);
		if(accessAuth == null)
			accessAuth = cls.getAnnotation(AccessAuth.class);

		// access auth check
		if(accessAuth != null){
			String userRoleValue = request.getParameter("AUTH");
			ROLE userRole = userRoleValue == null ? ROLE.USER : ROLE.valueOf(userRoleValue);

			for(ROLE systemRole: accessAuth.value()){
				if(systemRole == userRole)
					return arg0.proceed();
			}
		}

		// deny
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		return null;
	}
}
