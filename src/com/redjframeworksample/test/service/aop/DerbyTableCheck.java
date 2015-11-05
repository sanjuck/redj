package com.redjframeworksample.test.service.aop;

import java.lang.reflect.Method;

import com.redjframework.aop.BeforeAdvice;
import com.redjframework.db.DBTransactionManager;
import com.redjframework.transaction.TransactionIsolation;
import com.redjframeworksample.test.service.AbstractServiceTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class DerbyTableCheck.
 *
 * @author sanjuck@gmail.com
 */
public class DerbyTableCheck extends AbstractServiceTemplate implements BeforeAdvice {

	static boolean tablecreate = false;

	static Object lock = new Object();

	/* (non-Javadoc)
	 * @see com.redjframework.aop.BeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public Object[] before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {

		synchronized(lock){
			if(!tablecreate){
				DBTransactionManager tm = DBTransactionManager.getTransactionManager();
				tm.addTransaction(databaseResource);
				tm.beginTransaction(true);

				int cnt = qm.find(int.class, "select count(*) from sys.systables WHERE tablename='DEMO'");
				if(cnt == 0){
					qm.persist("create table demo(id int, name varchar(100))");
					qm.persist("create sequence demo_seq as bigint start with 1 increment by 1");
				}

				cnt = qm.find(int.class, "select count(*) from sys.systables WHERE tablename='DEMO_FILE'");
				if(cnt == 0){
					qm.persist("create table demo_file(id int, filename varchar(100))");
				}

				tablecreate = true;
				tm.endTransaction();
			}
		}

		return arg1;
	}
}
