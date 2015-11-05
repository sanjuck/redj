package com.redjframeworksample.test.web.interceptor;

import com.redjframework.xos.HandlerInvocation;
import com.redjframework.xos.interceptor.HandlerInterceptor;

public class AccessCheckInterceptor implements HandlerInterceptor{

	public Object invoke(HandlerInvocation arg0) throws Exception {
		if("deny".equals(arg0.getMethodName())){
			return "deny by interceptor";
		}

		return arg0.proceed();
	}
}
