package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.Photo;

public interface IPhotoServer {
	/**
	 * ����ͼƬ
	 * @param bulletinMap
	 */
	public void saveEntry( Map<String,Object> contextMap ) throws Exception;
	
	/**
	 * �������ͼƬ��Ϣ���񷽷�
	 * @param bulletinMap
	 * @return
	 */
	public Map<String,Object> saveEntryServer( Map<String,Object> contextMap );

	/**
	 * �������ͼƬ������񷽷�
	 * @param contextMap
	 * @return
	 */
	public Map<String,Object> saveFileServer( Map<String,Object> contextMap );
	
	/**
	 * ����ɾ��ͼƬ���񷽷�
	 * @param bulletinMap
	 * @return
	 */
	public Map<String,Object> deleteEntryServer( Map<String,Object> contextMap );
	
	/**
	 * ����ɾ��ͼƬ�ļ����񷽷�
	 * @param contextMap
	 * @return
	 */
	public Map<String,Object> deleteFileServer( Map<String,Object> contextMap );
	
	/**
	 * ɾ��ͼƬ
	 * @param bulletinMap
	 * @return
	 */
	public boolean deleteEntry( Map<String,Object> contextMap ) throws Exception ;
	
	/**
	 * ����ͼƬ����ID
	 * @param bulletinMap
	 * @return
	 */
	public Map<String,Object> selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * ��ҳ��ѯͼƬ��Ϣ����
	 * @param bulletinMap
	 * @return
	 */
	public List<Photo> selectEntryList4Page( Map<String,Object> contextMap );
}
