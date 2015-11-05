package com.redjframeworksample.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redjframework.test.TestJUnit4Runner;

// TODO: Auto-generated Javadoc
/**
 * The Class HelloworldService.
 *
 * @author sanjuck@gmail.com
 */

@RunWith(TestJUnit4Runner.class)
public class HelloworldService extends AbstractServiceTemplate {

	/**
	 * Find msg.
	 *
	 * @return the string
	 */
	public String findMsg(){
		return "Helloworld [Transaction]";
	}

	/**
	 * Test01.
	 */
	@Test
	public void test01(){
		System.out.println(findMsg());
	}
}
