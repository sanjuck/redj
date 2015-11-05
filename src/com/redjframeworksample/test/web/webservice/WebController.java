package com.redjframeworksample.test.web.webservice;

import com.redjframework.xos.annotations.Webservice;

@Webservice("/webservice")
public class WebController {
	public String get(String name){
		return name + "@HOST";
	}

}
