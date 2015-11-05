package com.redjframeworksample.test.service.vo;

import com.redjframework.db.annotation.Condition;
import com.redjframework.db.annotation.DML;
import com.redjframework.db.annotation.Reference;
import com.redjframework.db.annotation.Updatable;

@DML(insert="insert into demo(id,name) values(NEXT VALUE FOR demo_seq,:name)",
delete="delete from demo where id = :id",
update="update demo set ${updatable} where id = :id and ${condition.join(' or ')}",
select="select * from demo where id = :id")
public class DMLVODemo {
	@Condition
	long id;
	@Updatable
	String name;
	DMLVODemoFile demoFile;

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
	@Reference("select * from demo_file where id = :id")
	public DMLVODemoFile getDemoFile() {
		return demoFile;
	}
	public void setDemoFile(DMLVODemoFile demoFile) {
		this.demoFile = demoFile;
	}

}
