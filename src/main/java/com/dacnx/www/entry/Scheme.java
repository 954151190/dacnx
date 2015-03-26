package com.dacnx.www.entry;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * ҵ��ʵ����
 * @author Administrator
 *
 */
public class Scheme extends Entry implements Serializable{
	private String id;
	private String title;
	private String content;
	private Date create_time;
	private String state;
	private String author_name;
	private String author_id;
	
	/**
	 * MAPת��Scheme
	 * @param dataMap
	 * @return
	 */
	public static Scheme Map2Product( Map<String,Object> dataMap ){
		if( null != dataMap && !dataMap.isEmpty() ) {
			Scheme scheme  = new Scheme();
			if( !isEmpty(dataMap, "ID") ) {
				scheme.setId(dataMap.get("ID").toString());
			}
			if( !isEmpty(dataMap, "TITLE") ) {
				scheme.setTitle(dataMap.get("TITLE").toString());
			}
			if( !isEmpty(dataMap, "CONTENT") ) {
				scheme.setContent(dataMap.get("CONTENT").toString());
			}
			if( !isEmpty(dataMap, "CREATE_TIME") ) {
				java.sql.Timestamp timestamp = (java.sql.Timestamp)dataMap.get("CREATE_TIME");
				java.util.Date userCreateTime = new java.util.Date( timestamp.getTime() );
				scheme.setCreate_time( userCreateTime );
			}
			if( !isEmpty(dataMap, "STATE") ) {
				scheme.setState(dataMap.get("STATE").toString());
			}
			if( !isEmpty(dataMap, "AUTHOR_NAME") ) {
				scheme.setAuthor_name(dataMap.get("AUTHOR_NAME").toString());
			}
			if( !isEmpty(dataMap, "AUTHOR_ID") ) {
				scheme.setAuthor_id(dataMap.get("AUTHOR_ID").toString());
			}
			return scheme;
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