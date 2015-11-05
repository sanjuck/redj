package com.redjframeworksample.test.web.ajax;

import com.redjframework.ajc.common.JSONMarshallAndUNmarshaller;
import com.redjframework.annotations.Autoassign;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.MarshallAndUnmarshaller;
import com.redjframework.xos.viewer.Forward;
import com.redjframework.xos.viewer.JSON;
import com.redjframeworksample.test.service.ListService;

@Controller("/ajax")
@Default
@MarshallAndUnmarshaller(unmarshaller=JSONMarshallAndUNmarshaller.class)
public class WebController {

	@Autoassign ListService service;


	public Object list(){
		return new Forward().data("rows", service.findList());
	}

	public JSON save(String no, String value){
		System.out.println("no >> " + no);
		System.out.println("value >> " + value);

		service.add(value);

		return new JSON("success");
	}
}
