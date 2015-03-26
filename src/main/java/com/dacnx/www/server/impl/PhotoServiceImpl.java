package com.dacnx.www.server.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dacnx.www.action.IndexAction;
import com.dacnx.www.dao.db.rowMapper.PhotoRowMapper;
import com.dacnx.www.entry.Photo;
import com.dacnx.www.entry.User;
import com.dacnx.www.server.IPhotoServer;
import com.dacnx.www.util.BuildSQLUtil;
import com.dacnx.www.util.QueryHelper;
import com.dacnx.www.util.StaticVariable;

public class PhotoServiceImpl implements IPhotoServer{
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoServiceImpl.class);
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return this .jdbcTemplate;
	}
	
	public void setJdbcTemplate( JdbcTemplate jdbcTemplate ) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * �������ͼƬ��Ϣ���񷽷�
	 * @param contextMap
	 */
	public Map<String,Object> saveEntryServer( Map<String,Object> contextMap ) {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put(StaticVariable.MANAGER_RESULT, true);
		try{
			//��ȡ������Ϣ
			Photo photo = (Photo)contextMap.get(StaticVariable.MS_PHOTO_OBJECT);
			//��ʼ������ʱ��
			photo.setCreate_time( new Date() );
			this.saveEntry(contextMap);
		}catch(Exception ex) {
			logger.error("ͼƬ��Ϣ����ʧ�ܣ�ʧ����Ϣ",ex );
			returnMap.put(StaticVariable.MANAGER_RESULT, false);
			returnMap.put(StaticVariable.MANAGER_ERROR_MESSAGE, "ͼƬ��Ϣ����ʧ�ܣ������²�����");
			returnMap.put(StaticVariable.MANAGER_ERROR_EXCEPTION, ex);
		}
		return returnMap;
	}

	/**
	 * �������ͼƬ������񷽷�
	 * @param contextMap
	 * @return
	 */
	public Map<String, Object> saveFileServer(Map<String, Object> contextMap) {
		Map<String,Object> retMap = new HashMap<String,Object>();
		try {
			Photo photo = (Photo)contextMap.get(StaticVariable.MS_PHOTO_OBJECT);
			File inFile = (File)contextMap.get(StaticVariable.MS_PHOTO_FILE_OBJECT);
			File outFile = new File( IndexAction.photoPuth + photo.getId() + ".jpg" );
			InputStream input = new FileInputStream(inFile);
			OutputStream out = new FileOutputStream(outFile);
			int temp = 0;
			while( ( temp = input.read() ) != -1 ) {
				out.write(temp);
			}
			out.close();
			retMap.put(StaticVariable.MANAGER_RESULT, true);
		} catch (Exception ex) {
			logger.error("ͼƬ�ļ��洢ʧ��,",ex);
			retMap.put(StaticVariable.MANAGER_RESULT, false);
			retMap.put(StaticVariable.MANAGER_ERROR_EXCEPTION,ex);
			retMap.put(StaticVariable.MANAGER_ERROR_MESSAGE, "ͼƬ�ļ��洢ʧ��");
		} 
		return retMap;
	}
	
	 public static byte[] readInputStream(InputStream inStream) throws Exception{  
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	        //����һ��Buffer�ַ���  
	        byte[] buffer = new byte[1024];  
	        //ÿ�ζ�ȡ���ַ������ȣ����Ϊ-1������ȫ����ȡ���  
	        int len = 0;  
	        //ʹ��һ����������buffer������ݶ�ȡ����  
	        while( (len=inStream.read(buffer)) != -1 ){  
	            //���������buffer��д�����ݣ��м����������ĸ�λ�ÿ�ʼ����len�����ȡ�ĳ���  
	            outStream.write(buffer, 0, len);  
	        }  
	        //�ر�������  
	        inStream.close();  
	        //��outStream�������д���ڴ�  
	        return outStream.toByteArray();  
	    }  
	
	public Map<String,Object> deleteEntryServer(Map<String, Object> contextMap) {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put(StaticVariable.MANAGER_RESULT, true);
		try{
			//��ȡͼƬ��Ϣ
			Photo photo = (Photo)contextMap.get(StaticVariable.MS_PHOTO_OBJECT);
			//�ж�ͼƬ�Ƿ����
			Map<String,Object> tempPhotoMap = this.selectEntry4ID(contextMap);
			if( null != tempPhotoMap ) {
				//ɾ��ҵ��������Ϣ
				boolean managerBoolean = this.deleteEntry(contextMap);
				if( managerBoolean ) {
					//ִ�гɹ�
				}else{
					//ִ��ʧ��
					returnMap.put(StaticVariable.MANAGER_RESULT, false);
					returnMap.put(StaticVariable.MANAGER_ERROR_MESSAGE, "ͼƬ��Ϣɾ��ʧ�ܣ������²�����");
				}
			}else{
				returnMap.put(StaticVariable.MANAGER_RESULT, false);
				returnMap.put(StaticVariable.MANAGER_ERROR_MESSAGE, "ͼƬ��Ϣ�����ڣ������²�����");
			}
		}catch(Exception ex) {
			logger.error("ɾ��ͼƬ��Ϣʧ��,�쳣��Ϣ" , ex);
			returnMap.put(StaticVariable.MANAGER_RESULT, false);
			returnMap.put(StaticVariable.MANAGER_ERROR_MESSAGE, "ͼƬ��Ϣɾ��ʧ�ܣ������²�����");
			returnMap.put(StaticVariable.MANAGER_ERROR_EXCEPTION, ex);
		}
		return returnMap;
	}
	
	public Map<String, Object> deleteFileServer(Map<String, Object> contextMap) {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		try{
			Photo photo = (Photo)contextMap.get(StaticVariable.MS_PHOTO_OBJECT);
			//��ȡ�ļ���ַ
			String filePath = IndexAction.photoPuth + photo.getId() + ".jpg";
			File deleteFile = new File( filePath );
			if( deleteFile.isFile() && deleteFile.exists() ) {
				deleteFile.delete();
			}
			returnMap.put(StaticVariable.MANAGER_RESULT, true);
		}catch(Exception ex) {
			logger.error("ɾ��ͼƬ�ļ�ʧ�ܡ�" , ex);
			returnMap.put(StaticVariable.MANAGER_RESULT, false);
			returnMap.put(StaticVariable.MANAGER_ERROR_EXCEPTION, ex);
			returnMap.put(StaticVariable.MANAGER_ERROR_MESSAGE, "ɾ��ͼƬ�ļ�ʧ�ܡ�");
		}
		return returnMap;
	}
	
	public void saveEntry(Map<String, Object> contextMap) throws Exception {
		Photo photo = (Photo)contextMap.get(StaticVariable.MS_PHOTO_OBJECT);
		List<Object> fields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		fields.add("ID");
		fields.add("TITLE");
		fields.add("STATE");
		fields.add("CREATE_TIME");
		fields.add("AUTHOR_NAME");
		fields.add("AUTHOR_ID");
		fields.add("PATH");
		
		values.add(photo.getId());
		values.add(photo.getTitle());
		values.add(photo.getState());
		values.add( new java.sql.Date( photo.getCreate_time().getTime() ) );
		values.add(photo.getAuthor_name());
		values.add(photo.getAuthor_id());
		values.add(photo.getPath());
		
		String insertSql = BuildSQLUtil.buildSaveSQL(StaticVariable.TABLE_NAME_PHOTO, fields.toArray());
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		QueryHelper.updateSql(conn, insertSql, values.toArray()); 
	}

	
	
	public boolean deleteEntry(Map<String, Object> contextMap) throws Exception {
		Photo photo = (Photo)contextMap.get(StaticVariable.MS_PHOTO_OBJECT);
		List<Object> whereFields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		whereFields.add("ID");
		values.add(photo.getId());
		String deleteSQL = BuildSQLUtil.buildDeleteWithCondtionSQL(StaticVariable.TABLE_NAME_PHOTO, whereFields.toArray());
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		int i = QueryHelper.updateSql(conn, deleteSQL, values.toArray());
		if( i == 1 ) {
			return true;
		}else{
			return false;
		}
	}

	private Map<String,Object> selectEntry4Login( Map<String,Object> contextMap ) throws Exception {
		User loginUser = (User)contextMap.get(StaticVariable.MS_USER_OBJECT);
		List<Object> whereFields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		whereFields.add("USER_NAME");
		whereFields.add("USER_PASSWORD");
		
		values.add(loginUser.getUser_name());
		values.add(loginUser.getUser_password());
		
		String selectSQL = BuildSQLUtil.buildSelectAllFieldsWithConditionSQL(StaticVariable.TABLE_NAME_USER, whereFields.toArray());
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		Map<String,Object> tempMap = QueryHelper.selectSqlForMap(conn, selectSQL,values.toArray());
		return tempMap;
	}
	
	public Map<String, Object> selectEntry4ID(Map<String, Object> contextMap) throws Exception{
		Photo photo = (Photo)contextMap.get(StaticVariable.MS_PHOTO_OBJECT);
		List<Object> fields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		fields.add("ID");
		values.add(photo.getId());
		String selectSQL = BuildSQLUtil.buildSelectAllFieldsWithConditionSQL(StaticVariable.TABLE_NAME_PHOTO, fields.toArray());
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		Map<String,Object> tempMap = QueryHelper.selectSqlForMap(conn, selectSQL,values.toArray());
		return tempMap;
	}
	
	public Map<String,Object> selectEntry4UserName( Map<String,Object> contextMap ) throws Exception{
		User user = (User)contextMap.get(StaticVariable.MS_USER_OBJECT);
		List<Object> fields = new ArrayList<Object>();
		List<Object> values = new ArrayList<Object>();
		fields.add("USER_NAME");
		values.add(user.getUser_name());
		String selectSQL = BuildSQLUtil.buildSelectAllFieldsWithConditionSQL(StaticVariable.TABLE_NAME_USER, fields.toArray());
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		Map<String,Object> tempMap = QueryHelper.selectSqlForMap(conn, selectSQL,values.toArray());
		return tempMap;
	}
	
	public List<Photo> selectEntryList4Page(Map<String, Object> contextMap) {
		String sql = "select * from " + StaticVariable.TABLE_NAME_PHOTO+ "";
		List<Photo> photoList = jdbcTemplate.query(sql , new PhotoRowMapper());
		return photoList;
	}
}