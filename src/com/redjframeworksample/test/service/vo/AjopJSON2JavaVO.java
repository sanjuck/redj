package com.redjframeworksample.test.service.vo;

import java.util.Date;

import com.redjframework.bean.annotations.Attribute;

public class AjopJSON2JavaVO {
	enum Mode { a, b };

	long id;
	String name;
	String content;
	Mode mode;
	Date regdate;
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
	@Attribute(dateFormat="yyyy/MM/dd")
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
}
