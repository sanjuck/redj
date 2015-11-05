package com.redjframeworksample.test.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redjframework.test.TestJUnit4Runner;

// TODO: Auto-generated Javadoc
/**
 * The Class DatabaseSimpleService.
 *
 * @author sanjuck@gmail.com
 */
@RunWith(TestJUnit4Runner.class)
public class DatabaseSimpleService extends AbstractServiceTemplate {

	/**
	 * Instantiates a new database simple service.
	 */
	public DatabaseSimpleService() {
		super();
	}

	/**
	 * Find msg.
	 *
	 * @return the string
	 */
	public String findMsg(){
		return qm.find(String.class, "select 'message' from demo");
	}

	/**
	 * Find msg.
	 *
	 * @param id the no
	 * @return the string
	 */
	public String findMsg(long id){
		return qm.find(String.class, "select name from demo where id = ?", id);
	}

	/**
	 * Find list msg.
	 *
	 * @return the list
	 */
	public List<Map> findListMsg(){
		return qm.findList(Map.class, "select * from demo");
	}

	/**
	 * Adds the.
	 *
	 * @param name the name
	 * @return the int
	 */
	public int add(String name){
		int id = qm.find(int.class, "values ( next value for DEMO_SEQ )");

		if(qm.persist("insert into demo(id,name) values(?,?)", id, name) != 0){
			return id;
		}
		else
			return 0;
	}

	@Test
	public void test01(){
		int id = add("message");
		assertNotEquals(0, id);
		assertEquals("message", findMsg(id));
		assertNotEquals(0, findListMsg().size());

		for(Map map: findListMsg()){
			System.out.println(map);
		}
	}
}
