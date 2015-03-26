package com.dacnx.www.dao.db.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dacnx.www.entry.Product;

/**
 * 产品对象转换类
 * 负责将数据库ResultSet对象转换为Product对象
 * @author Administrator
 */
public class ProductRowMapper implements RowMapper{
	public ProductRowMapper() {
	}
	
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId( rs.getString("ID") );
		product.setTitle( rs.getString("TITLE") );
		product.setContent( rs.getString("CONTENT") );
		product.setAuthor_id( rs.getString("AUTHOR_ID") );
		product.setAuthor_name( rs.getString("AUTHOR_NAME") );;
		product.setState(rs.getString("STATE"));
		product.setCreate_time(new java.util.Date( rs.getDate("CREATE_TIME").getTime() ) );
		return product;
	}
}
