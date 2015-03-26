package com.dacnx.www.server.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dacnx.www.dao.db.rowMapper.ProductRowMapper;
import com.dacnx.www.entry.Page;
import com.dacnx.www.entry.Product;
import com.dacnx.www.server.IProductServer;
import com.dacnx.www.util.BuildSQLUtil;
import com.dacnx.www.util.QueryHelper;
import com.dacnx.www.util.StaticVariable;

public class ProductServerImpl implements IProductServer {
	private static final Logger logger = LoggerFactory.getLogger(ProductServerImpl.class);
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return this .jdbcTemplate;
	}
	
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate ) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Product selectEntry4ID(Map<String, Object> contextMap) throws Exception{
		Product product = (Product)contextMap.get(StaticVariable.MS_PRODUCT_OBJECT);
		List<Object> fields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		fields.add("ID");
		values.add(product.getId());
		String selectSQL = BuildSQLUtil.buildSelectAllFieldsWithConditionSQL(StaticVariable.TABLE_NAME_PRODUCT, fields.toArray());
		Product retProduct = (Product)jdbcTemplate.queryForObject(selectSQL, values.toArray() ,new ProductRowMapper());
		return retProduct;
	}
	
	public List<Product> selectEntryList4Page(Map<String, Object> contextMap) {
		//��ȡ��ҳ��Ϣ
		Page page = (Page)contextMap.get(StaticVariable.PAGE_PRODUCT);
		//����������
		int numberMax = page.getCount() * page.getNumber();
		//����������
		int numberMin = numberMax - page.getCount();
		String sql = "SELECT * FROM ( SELECT A.*, ROWNUM RN FROM (SELECT * FROM "+StaticVariable.TABLE_NAME_PRODUCT+") A WHERE ROWNUM <= "+numberMax+" ) WHERE RN >= "+numberMin+"";
		List<Product> productList = jdbcTemplate.query(sql , new ProductRowMapper());
		//��ѯ����
		long countNumber = jdbcTemplate.queryForLong("SELECT COUNT(0) FROM " + StaticVariable.TABLE_NAME_PRODUCT);
		page.setAllCount( (int)countNumber );
		return productList;
	}
}