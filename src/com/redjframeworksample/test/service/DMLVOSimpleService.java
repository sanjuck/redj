package com.redjframeworksample.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redjframework.db.CRUD;
import com.redjframework.test.TestJUnit4Runner;
import com.redjframeworksample.test.service.vo.DMLVODemo;

// TODO: Auto-generated Javadoc
/**
 * The Class DMLVOSimpleService.
 *
 * @author sanjuck@gmail.com
 */

@RunWith(TestJUnit4Runner.class)
public class DMLVOSimpleService extends AbstractServiceTemplate {

	/**
	 * Instantiates a new database simple service.
	 */
	public DMLVOSimpleService() {
		super();
	}

	/**
	 * Find vo simple.
	 *
	 * @param vo the vo
	 * @return the dMLVO simple
	 */
	public DMLVODemo findVoSimple(DMLVODemo vo){
		return qm.select(vo).get();
	}

	/**
	 * Find vo simples.
	 *
	 * @return the list
	 */
	public List<DMLVODemo> findVoSimples(){
		return qm.findList(DMLVODemo.class, "select * from demo");
	}

	/**
	 * Adds the.
	 *
	 * @param vo the vo
	 * @return the int
	 */
	public int add(DMLVODemo vo){
		return qm.insert(vo);
	}

	public int update(DMLVODemo vo){
		return qm.update(vo, null);
	}

	/**
	 * Test01.
	 */
	@Test
	public void test01(){
		DMLVODemo voSimple = new DMLVODemo();
		voSimple.setId(1);
		voSimple.setName("YOUR NAME DML");

		add(voSimple);
		update(voSimple);

		voSimple = findVoSimple(voSimple);
		System.out.println(voSimple.getName());

		voSimple.setName("YOUR NAME DML UPDATE ");
		((CRUD)voSimple).update();

		for(DMLVODemo simple: findVoSimples()){
			System.out.println(simple.getId() + " / " + simple.getName());
		}
	}
}
