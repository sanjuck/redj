package com.redjframeworksample.test.web.service;

import com.redjframework.ajc.common.JSONMarshallAndUNmarshaller;
import com.redjframework.annotations.Autoassign;
import com.redjframeworksample.test.service.HelloworldService;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.MarshallAndUnmarshaller;

@Controller("/service")
@Default
@MarshallAndUnmarshaller(unmarshaller=JSONMarshallAndUNmarshaller.class)
public class WebController {
	@Autoassign HelloworldService service;

	public Object list(){
		return service.findMsg();
	}
}
