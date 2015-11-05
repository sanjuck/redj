package com.springframework.test.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.redjframework.db.resource.OutterDatabaseResource;

public class SpringManageResource extends OutterDatabaseResource {
	public SpringManageResource(JdbcTemplate jdbcTemplate) {
		super(DataSourceUtils.getConnection(jdbcTemplate.getDataSource()));
	}
}
