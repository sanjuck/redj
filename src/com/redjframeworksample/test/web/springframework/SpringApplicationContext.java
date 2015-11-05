package com.redjframeworksample.test.web.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.redjframework.aop.Advice;
import com.redjframework.bean.BeanFactory;

public class SpringApplicationContext implements BeanFactory {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/com/springframework/test/service/service-context.xml");

	@Override
	public <T> T create(Class<T> arg0, Object[] arg1, Advice... arg2) {
		return context.getBean(arg0);
	}

	@Override
	public boolean isTarget(Object arg0) {
		return true;
	}

	@Override
	public Object valueOf(String arg0) {
		return null;
	}
}
