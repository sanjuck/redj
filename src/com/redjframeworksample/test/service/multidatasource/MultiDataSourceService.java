package com.redjframeworksample.test.service.multidatasource;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.redjframework.aop.BeforeAdvice;
import com.redjframework.db.QueryBeanManager;
import com.redjframework.db.resource.JDBCDatabaseResource;
import com.redjframework.test.TestJUnit4Runner;
import com.redjframework.test.annotation.TestConfiguration;
import com.redjframework.transaction.annotations.Resource;
import com.redjframework.transaction.annotations.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class MultiDataSourceService.
 *
 * @author sanjuck@gmail.com
 */
@RunWith(TestJUnit4Runner.class)
@TestConfiguration(resources={"redj.xml"})
@Transactional(autoCommit=true)
public class MultiDataSourceService implements BeforeAdvice {

	/** The database resource01. */
	@Resource JDBCDatabaseResource databaseResource01 = new JDBCDatabaseResource(
            "org.apache.derby.jdbc.EmbeddedDriver",
            "jdbc:derby:"+ System.getProperty("java.io.tmpdir") +"/SAMPLEDB_01;create=true",
            null, null);

	/** The database resource02. */
	@Resource JDBCDatabaseResource databaseResource02 = new JDBCDatabaseResource(
            "org.apache.derby.jdbc.EmbeddedDriver",
            "jdbc:derby:"+ System.getProperty("java.io.tmpdir") +"/SAMPLEDB_02;create=true",
            null, null);

	/** The qm01. */
	@Resource
	protected QueryBeanManager qm01 = new QueryBeanManager(databaseResource01);

	/** The qm02. */
	@Resource
	protected QueryBeanManager qm02 = new QueryBeanManager(databaseResource02);

	/**
	 * table check before advice.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 * @param arg2 the arg2
	 * @return the object[]
	 * @throws Throwable the throwable
	 */
	@Override
	public Object[] before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {

		int cnt = qm01.find(int.class, "select count(*) from sys.systables WHERE tablename='DEMO'");
		if(cnt == 0){
			qm01.persist("create table demo(id int, name varchar(100))");
		}

		cnt = qm02.find(int.class, "select count(*) from sys.systables WHERE tablename='DEMO'");
		if(cnt == 0){
			qm02.persist("create table demo(id int, name varchar(100))");
		}

		return arg1;
	}

	/**
	 * Instantiates a new database simple service.
	 */
	public MultiDataSourceService() {
		super();
	}

	/**
	 * Adds the.
	 */
	public void add(){
		qm01.persist("insert into demo(id,name) values(0,'name')");
		qm02.persist("insert into demo(id,name) values(0,'name')");
	}

	/**
	 * Find list.
	 */
	public void findList(){
		System.out.println(qm01.findList(HashMap.class, "select * from demo"));
		System.out.println(qm02.findList(HashMap.class, "select * from demo"));
	}

	/**
	 * Test01.
	 */
	@Test
	public void test01(){
		add();
		findList();
	}
}
