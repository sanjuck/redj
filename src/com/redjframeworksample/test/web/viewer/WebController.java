package com.redjframeworksample.test.web.viewer;

import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.viewer.Forward;
import com.redjframework.xos.viewer.JSON;

@Controller("/viewer")
@Default
public class WebController {
	public Object forward(){
		return new Forward();
	}

	public Object json(){
		return new JSON("success");
	}
}
