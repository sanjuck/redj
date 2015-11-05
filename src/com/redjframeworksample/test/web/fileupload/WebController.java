package com.redjframeworksample.test.web.fileupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.redjframework.http.multipart.FilePart;
import com.redjframework.xos.TestWebApplicationContainer;
import com.redjframework.xos.annotations.Controller;
import com.redjframework.xos.annotations.Default;
import com.redjframework.xos.annotations.Multipart;
import com.redjframework.xos.annotations.RequestParam;
import com.redjframework.xos.test.TestMultipartData;
import com.redjframework.xos.viewer.Forward;
import com.redjframework.xos.viewer.JSON;
import com.redjframeworksample.test.service.vo.VOFile;

@Controller("/fileupload")
@Default
public class WebController {
	public Object index(){
		return new Forward();
	}

	@Multipart
	public JSON upload(@RequestParam VOFile file) throws IOException{

		System.out.println(System.getProperty("user.home"));

		System.out.println(file);
		FilePart fp0 = file.getFile()[0];
		System.out.println(fp0.element().move(System.getProperty("user.home") + "/tmp/" + System.currentTimeMillis() + fp0.getSrcFilename()));

		FilePart fp1 = file.getFile()[1];
		System.out.println(fp1.element().move(System.getProperty("user.home") + "/tmp/" + System.currentTimeMillis() + fp1.getSrcFilename()));

		return new JSON("success").data("file01", fp0).data("file02", fp1);
	}

	TestWebApplicationContainer container = TestWebApplicationContainer.getInstance(System.getProperty("contextPath"));

	@Test
	public void testIndex2() throws FileNotFoundException, IOException{
		final TestMultipartData multipartData = new TestMultipartData("UTF-8", "-----1234");
		multipartData.addPart("file", new File(System.getProperty("user.home") + "/사진/1389611632_Nature_Full_HD_Wallpapers_71.jpg"));
		multipartData.addPart("file", new File(System.getProperty("user.home") + "/사진/스크린샷, 2014-01-05 01:38:36.png"));

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		request.setMethod("POST");
		request.setContentType("multipart/form-data; boundary=-----1234");

		container.submit("/fileupload/upload", request, response, multipartData);
		System.out.println(response.getContentAsString());
	}
}
