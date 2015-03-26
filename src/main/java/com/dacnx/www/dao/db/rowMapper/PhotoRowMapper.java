package com.dacnx.www.dao.db.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.dacnx.www.entry.Photo;

/**
 * ͼƬ����ת����
 * �������ݿ�ResultSet����ת��ΪPhoto����
 * @author Administrator
 */
public class PhotoRowMapper implements RowMapper{
	private static final Logger logger = LoggerFactory.getLogger(PhotoRowMapper.class);
	public PhotoRowMapper() {
	}
	
	public Photo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Photo photo = new Photo();
		photo.setId( rs.getString("ID") );
		photo.setTitle( rs.getString("TITLE") );
		photo.setState(rs.getString("STATE"));
		photo.setIs_index( rs.getString("IS_INDEX") );
		photo.setCreate_time( new java.util.Date( rs.getDate("CREATE_TIME").getTime() ) );
		photo.setAuthor_name( rs.getString("AUTHOR_NAME") );;
		photo.setAuthor_id( rs.getString("AUTHOR_ID") );
		photo.setPath( rs.getString("PATH") );
		return photo;
	}
}