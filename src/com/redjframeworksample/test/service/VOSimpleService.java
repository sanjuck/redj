package com.redjframeworksample.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redjframework.test.TestJUnit4Runner;
import com.redjframeworksample.test.service.vo.VOSimple;


@RunWith(TestJUnit4Runner.class)
public class VOSimpleService extends AbstractServiceTemplate {

	/**
	 * Instantiates a new database simple service.
	 */
	public VOSimpleService() {
		super();
	}

	public VOSimple findVoSimple(long id){
		return qm.find(VOSimple.class, "select name from demo where id = ?", id);
	}

	public List<VOSimple> findVoSimples(){
		return qm.findList(VOSimple.class, "select * from demo");
	}

	public int add(VOSimple vo){
		return qm.persist("insert into demo(id,name) values(NEXT VALUE FOR demo_seq,:name)", vo);
	}

	@Test
	public void test01(){
		VOSimple voSimple = new VOSimple();
		voSimple.setName("YOUR NAME");

		add(voSimple);

		voSimple = findVoSimple(1);
		System.out.println(voSimple.getName());

		for(VOSimple simple: findVoSimples()){
			System.out.println(simple.getId() + " / " + simple.getName());
		}
	}
}
