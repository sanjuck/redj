package com.redjframeworksample.test.web.excel;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;

@Controller("/excel")
@Default
public class WebController {
	public Object download(){
		return new ExcelViewer();
	}


	/** The container. */
	TestWebApplicationContainer container = TestWebApplicationContainer.getInstance(System.getProperty("contextPath"));

	/**
	 * Test index.
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testDownload() throws UnsupportedEncodingException{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		WebController a = container.create(WebController.class, request, response);
		a.download();

		System.out.println(response.getContentAsString());
	}
}
