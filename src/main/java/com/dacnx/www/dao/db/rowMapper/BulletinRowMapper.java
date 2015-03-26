package com.dacnx.www.dao.db.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dacnx.www.entry.Bulletin;

/**
 * 公示公告对象转换类
 * 负责将数据库ResultSet对象转换为Bulletin对象
 * @author Administrator
 */
public class BulletinRowMapper implements RowMapper{
	public BulletinRowMapper() {
	}
	
	public Bulletin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bulletin bulletin = new Bulletin();
		bulletin.setId( rs.getString("ID") );
		bulletin.setTitle( rs.getString("TITLE") );
		bulletin.setContent( rs.getString("CONTENT") );
		bulletin.setAuthor_id( rs.getString("AUTHOR_ID") );
		bulletin.setAuthor_name( rs.getString("AUTHOR_NAME") );;
		bulletin.setState(rs.getString("STATE"));
		bulletin.setCreate_time(new java.util.Date( rs.getDate("CREATE_TIME").getTime() ) );
		return bulletin;
	}
}
