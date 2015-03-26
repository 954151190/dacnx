package com.dacnx.www.dao.db.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.dacnx.www.entry.SchemeType;

/**
 * ��Ʒ����ת����
 * �������ݿ�ResultSet����ת��ΪScheme����
 * @author Administrator
 */
public class SchemeTypeRowMapper implements RowMapper{
	private static final Logger logger = LoggerFactory.getLogger(SchemeTypeRowMapper.class);
	public SchemeTypeRowMapper() {
	}
	
	public SchemeType mapRow(ResultSet rs, int rowNum) throws SQLException {
		SchemeType schemeType = new SchemeType();
		schemeType.setId( rs.getString("ID") );
		schemeType.setTitle( rs.getString("TITLE") );
		String content = rs.getString("CONTENT");
		schemeType.setContent( content );
		schemeType.setAuthor_id( rs.getString("AUTHOR_ID") );
		schemeType.setAuthor_name( rs.getString("AUTHOR_NAME") );;
		schemeType.setState(rs.getString("STATE"));
		schemeType.setCreate_time(new java.util.Date( rs.getDate("CREATE_TIME").getTime() ) );
		schemeType.setIs_show( rs.getString("IS_SHOW") );
		return schemeType;
	}
}