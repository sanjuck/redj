package com.redjframeworksample.test.web.template;

import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;

@Controller("/template")
@Default
public class WebController {
	WebFrame1 frame1 = new WebFrame1();

	public Object index(){
		return frame1;
	}
}
