package com.redjframeworksample.test.web.template;

import com.redjframework.xos.annotations.Template;
import com.redjframework.xos.viewer.Forward;

// TODO: Auto-generated Javadoc
/**
 * The Class WEB.
 *
 * 웹 페이지 프레임
 */
@Template(frame = "/WEB-INF/jsp/template/webframe1.jsp")
public class WebFrame1 extends Forward {
	String menu;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	@Override
	public void reset() {
		this.menu = null;
		super.reset();
	}
}
