package com.redjframeworksample.test.service.vo;

import java.io.Serializable;

public class VOWebService implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 2449181129545004688L;
	long id;
	String name;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
