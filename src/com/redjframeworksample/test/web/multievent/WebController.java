package com.redjframeworksample.test.web.multievent;

import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.viewer.JSON;

/**
 * /multievent/info01+info02
 *
 *
 * @author sanjuck
 *
 */
@Controller("/multievent")
@Default
public class WebController {
	JSON success = new JSON("success");

	public JSON info01(){
		return success.data("info01", "INFO01");
	}

	public JSON info02(){
		return success.data("info02", "INFO02");
	}
}
