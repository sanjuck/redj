package com.redjframeworksample.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redjframework.db.annotation.SqlMapper;
import com.redjframework.test.TestJUnit4Runner;
import com.redjframeworksample.test.service.vo.VOSimple;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseSimpleService.
 *
 * @author sanjuck@gmail.com
 */

@RunWith(TestJUnit4Runner.class)
@SqlMapper
public class SQLFromXMLSimpleService extends AbstractServiceTemplate {

	/**
	 * Instantiates a new database simple service.
	 */
	public SQLFromXMLSimpleService() {
		super();
	}

	/**
	 * Find msg.
	 *
	 * @param id the no
	 * @return the string
	 */
	public String findMsg(long id){
		return qm.find(String.class, "@findMsgByID", id);
	}

	/**
	 * Find msg.
	 *
	 * @param simple the simple
	 * @return the string
	 */
	public String findMsg(VOSimple simple){
		return qm.find(String.class, "@findMsg", simple);
	}

	/**
	 * Test01.
	 */
	@Test
	public void test01(){
		VOSimple simple =  new VOSimple();
		simple.setId(1);
		System.out.println(findMsg(simple));
	}
}
