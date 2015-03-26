package com.dacnx.www.server.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dacnx.www.dao.db.rowMapper.ProductRowMapper;
import com.dacnx.www.dao.db.rowMapper.SchemeRowMapper;
import com.dacnx.www.entry.Page;
import com.dacnx.www.entry.Product;
import com.dacnx.www.entry.Scheme;
import com.dacnx.www.server.ISchemeServer;
import com.dacnx.www.util.BuildSQLUtil;
import com.dacnx.www.util.QueryHelper;
import com.dacnx.www.util.StaticVariable;

public class SchemeServerImpl implements ISchemeServer{
	private static final Logger logger = LoggerFactory.getLogger(SchemeServerImpl.class);
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return this .jdbcTemplate;
	}
	
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate ) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Scheme selectEntry4ID(Map<String, Object> contextMap) throws Exception{
		Scheme scheme = (Scheme)contextMap.get(StaticVariable.MS_SCHEME_OBJECT);
		List<Object> fields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		fields.add("ID");
		values.add(scheme.getId());
		String selectSQL = BuildSQLUtil.buildSelectAllFieldsWithConditionSQL(StaticVariable.TABLE_NAME_SCHEME, fields.toArray());
		Scheme retScheme = (Scheme)jdbcTemplate.queryForObject(selectSQL, values.toArray() ,new SchemeRowMapper());
		return retScheme;
	}
	
	public List<Scheme> selectEntryList4Page(Map<String, Object> contextMap) {
		//获取分页信息
		Page page = (Page)contextMap.get(StaticVariable.PAGE_SCHEME);
		//计算最大序号
		int numberMax = page.getCount() * page.getNumber();
		//计算最大序号
		int numberMin = numberMax - page.getCount();
		String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (SELECT * FROM "+StaticVariable.TABLE_NAME_SCHEME+") A WHERE ROWNUM <= "+numberMax+" ) WHERE RN >= "+numberMin+"";
		List<Scheme> schemeList = jdbcTemplate.query(sql , new SchemeRowMapper());
		//查询总数
		long countNumber = jdbcTemplate.queryForLong("SELECT COUNT(0) FROM " + StaticVariable.TABLE_NAME_SCHEME);
		page.setAllCount( (int)countNumber );
		return schemeList;
	}
	
	public List<Scheme> selectEntryList4Page4Type(Map<String, Object> contextMap) {
		//获取业务类型信息
		String type = (String)contextMap.get(StaticVariable.PARAMETER_SCHEME_TYPE);
		//获取分页信息
		Page page = (Page)contextMap.get(StaticVariable.PAGE_SCHEME);
		//计算最大序号
		int numberMax = page.getCount() * page.getNumber();
		//计算最大序号
		int numberMin = numberMax - page.getCount();
		String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (SELECT * FROM "+StaticVariable.TABLE_NAME_SCHEME+" WHERE TYPE = '"+type+"') A WHERE ROWNUM <= "+numberMax+" ) WHERE RN >= "+numberMin+"";
		List<Scheme> schemeList = jdbcTemplate.query(sql , new SchemeRowMapper());
		//查询总数
		long countNumber = jdbcTemplate.queryForLong("SELECT COUNT(0) FROM " + StaticVariable.TABLE_NAME_SCHEME);
		page.setAllCount( (int)countNumber );
		return schemeList;
	}
}