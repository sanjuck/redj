package com.redjframeworksample.test.service;

import java.util.ArrayList;
import java.util.List;

import com.redjframework.transaction.annotations.Transactional;

@Transactional(autoCommit=true)
public class ListService {
	static List<String> rows = new ArrayList<String>();

	public List<String> findList(){
		return rows;
	}

	public void add(String value){
		rows.add(value);
	}
}
