package com.redjframeworksample.test.service;

import com.redjframework.annotations.Autoassign;
import com.redjframework.db.QueryBeanManager;
import com.redjframework.db.resource.JDBCDatabaseResource;
import com.redjframework.test.annotation.TestConfiguration;
import com.redjframework.transaction.annotations.Resource;
import com.redjframework.transaction.annotations.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractServiceTemplate.
 *
 * @author sanjuck@gmail.com
 */
@Transactional(autoCommit=true)
@TestConfiguration(resources={"redj*.xml"})
public class AbstractServiceTemplate {

	@Autoassign("derby")
	@Resource
	protected JDBCDatabaseResource databaseResource;

	/** The qm. */
	@Autoassign	protected QueryBeanManager qm;

	public  AbstractServiceTemplate() {
		super();
//		databaseResource.setResourceXML("sqlmap.xml");
	}
}
