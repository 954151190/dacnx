package com.dacnx.www.dao.db.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dacnx.www.entry.Scheme;

/**
 * 产品对象转换类
 * 负责将数据库ResultSet对象转换为Scheme对象
 * @author Administrator
 */
public class SchemeRowMapper implements RowMapper{
	public SchemeRowMapper() {
	}
	
	public Scheme mapRow(ResultSet rs, int rowNum) throws SQLException {
		Scheme scheme = new Scheme();
		scheme.setId( rs.getString("ID") );
		scheme.setTitle( rs.getString("TITLE") );
		scheme.setContent( rs.getString("CONTENT") );
		scheme.setAuthor_id( rs.getString("AUTHOR_ID") );
		scheme.setAuthor_name( rs.getString("AUTHOR_NAME") );;
		scheme.setState(rs.getString("STATE"));
		scheme.setCreate_time(new java.util.Date( rs.getDate("CREATE_TIME").getTime() ) );
		return scheme;
	}
}
