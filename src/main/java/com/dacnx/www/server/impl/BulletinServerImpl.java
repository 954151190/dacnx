package com.dacnx.www.server.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dacnx.www.dao.db.rowMapper.BulletinRowMapper;
import com.dacnx.www.entry.Bulletin;
import com.dacnx.www.entry.Page;
import com.dacnx.www.server.IBulletinServer;
import com.dacnx.www.util.BuildSQLUtil;
import com.dacnx.www.util.StaticVariable;

public class BulletinServerImpl implements IBulletinServer {
	private static final Logger logger = LoggerFactory.getLogger(BulletinServerImpl.class);
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return this .jdbcTemplate;
	}
	
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate ) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Bulletin selectEntry4ID(Map<String, Object> bulletinMap) throws Exception{
		Bulletin bulletin = (Bulletin)bulletinMap.get(StaticVariable.MS_BULLETIN_OBJECT);
		List<Object> fields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		fields.add("ID");
		values.add(bulletin.getId());
		String selectSQL = BuildSQLUtil.buildSelectAllFieldsWithConditionSQL(StaticVariable.TABLE_NAME_BULLETIN, fields.toArray());
		Bulletin retBulletin = (Bulletin)jdbcTemplate.queryForObject(selectSQL, values.toArray(), new BulletinRowMapper());
		return retBulletin;
	}
	
	public List<Bulletin> selectEntryList4Page(Map<String, Object> contextMap) {
		//获取分页信息
		Page page = (Page)contextMap.get(StaticVariable.PAGE_BULLETIN);
		//计算最大序号
		int numberMax = page.getCount() * page.getNumber();
		//计算最大序号
		int numberMin = numberMax - page.getCount();
		String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (SELECT * FROM "+StaticVariable.TABLE_NAME_BULLETIN+") A WHERE ROWNUM <= "+numberMax+" ) WHERE RN >= "+numberMin+"";
		List<Bulletin> bulletinList = jdbcTemplate.query(sql , new BulletinRowMapper());
		//查询总数
		long countNumber = jdbcTemplate.queryForLong("SELECT COUNT(0) FROM " + StaticVariable.TABLE_NAME_BULLETIN);
		page.setAllCount( (int)countNumber );
		return bulletinList;
	}
}