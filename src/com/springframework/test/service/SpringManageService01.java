package com.springframework.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redjframework.db.QueryBeanManager;

@Transactional
@Service
public class SpringManageService01 {

	@Autowired QueryBeanManager qm;

	public String getName(){
		List<Map> list = qm.findList(Map.class, "select * from demo");

		System.out.println(list.size());

		if(list.size() > 0)
			return (String) list.get(0).get("NAME");

		return null;
	}

	public void add() {
		qm.persist("insert into demo(id,name) values(NEXT VALUE FOR demo_seq,?)", "spring test name");
	}
}
