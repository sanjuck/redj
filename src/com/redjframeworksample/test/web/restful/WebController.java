package com.redjframeworksample.test.web.restful;

import com.redjframework.http.HTTPMethod.Method;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.viewer.Forward;

@Controller("/restful")
@Default
public class WebController {
	public Object index(Method method){
		System.out.println("method >> " + method);

		return new Forward();
	}
}
