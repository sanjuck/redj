package com.redjframeworksample.test.web.crud;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.ajc.common.JSONMarshallAndUNmarshaller;
import com.redjframework.annotations.Autoassign;
import com.redjframework.db.CRUD;
import com.redjframework.test.TestJUnit4Runner;
import com.redjframework.test.annotation.TestConfiguration;
import com.redjframework.util.JSONUtil;
import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.MarshallAndUnmarshaller;
import com.redjframework.xos.viewer.Forward;
import com.redjframework.xos.viewer.JSON;
import com.redjframeworksample.test.service.DMLVOSimpleService;
import com.redjframeworksample.test.service.vo.DMLVODemo;

@Controller("/crud")
@Default
@RunWith(TestJUnit4Runner.class)
@TestConfiguration(resources={"redj*.xml"})
@MarshallAndUnmarshaller(unmarshaller=JSONMarshallAndUNmarshaller.class)
public class WebController {
	@Autoassign DMLVOSimpleService service;

	public Forward list(){
		return new Forward().data("rows", service.findVoSimples());
	}

	public JSON save(DMLVODemo demo){
		((CRUD)demo).insert();
		return new JSON("success");
	}

	/** The container. */
	TestWebApplicationContainer container = TestWebApplicationContainer.getInstance(System.getProperty("contextPath"));

	/**
	 * Test index.
	 */
	@Test
	public void testIndex(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		request.addHeader("JSON", "JSON");
		request.setMethod("POST");

		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "test name");
		request.setParameter("JSON", JSONUtil.toJSON(data));
		container.submit("/crud/save", request, response);
	}
}
