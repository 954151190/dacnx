package com.dacnx.www.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * ��ʾ����ʵ����
 * @author Administrator
 *
 */
public class Bulletin extends Entry implements Serializable{
	private String id;
	private String title;
	private String content;
	private Date create_time;
	private String state;
	private String author_name;
	private String author_id;
	
	/**
	 * MAPת��Bulletin
	 * @param bulletinMap
	 * @return
	 */
	public static Bulletin Map2Bulletin( Map<String,Object> bulletinMap ){
		if( null != bulletinMap && !bulletinMap.isEmpty() ) {
			Bulletin bulletin  = new Bulletin();
			if( !isEmpty(bulletinMap, "ID") ) {
				bulletin.setId(bulletinMap.get("ID").toString());
			}
			if( !isEmpty(bulletinMap, "TITLE") ) {
				bulletin.setTitle(bulletinMap.get("TITLE").toString());
			}
			if( !isEmpty(bulletinMap, "CONTENT") ) {
				bulletin.setContent(bulletinMap.get("CONTENT").toString());
			}
			if( !isEmpty(bulletinMap, "CREATE_TIME") ) {
				java.sql.Timestamp timestamp = (java.sql.Timestamp)bulletinMap.get("CREATE_TIME");
				java.util.Date userCreateTime = new java.util.Date( timestamp.getTime() );
				bulletin.setCreate_time( userCreateTime );
			}
			if( !isEmpty(bulletinMap, "STATE") ) {
				bulletin.setState(bulletinMap.get("STATE").toString());
			}
			if( !isEmpty(bulletinMap, "AUTHOR_NAME") ) {
				bulletin.setAuthor_name(bulletinMap.get("AUTHOR_NAME").toString());
			}
			if( !isEmpty(bulletinMap, "AUTHOR_ID") ) {
				bulletin.setAuthor_id(bulletinMap.get("AUTHOR_ID").toString());
			}
			return bulletin;
		}else{
			return null;
		}
	}
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
}