package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.SchemeType;

public interface ISchemeTypeServer {
	/**
	 * ���Ӳ�Ʒ
	 * @param bulletinMap
	 */
	public void saveEntry( Map<String,Object> contextMap ) throws Exception;
	
	/**
	 * ������Ӳ�Ʒ��Ϣ���񷽷�
	 * @param bulletinMap
	 * @return
	 */
	public Map<String,Object> saveEntryServer( Map<String,Object> contextMap );
	
	/**
	 * �������ҵ����Ϣ���񷽷�
	 * @param bulletinMap
	 * @return
	 */
	public Map<String,Object> updateEntryServer( Map<String,Object> contextMap );
	
	/**
	 * ����ɾ��ҵ����񷽷�
	 * @param bulletinMap
	 * @return
	 */
	public Map<String,Object> deleteEntryServer( Map<String,Object> contextMap );
	
	/**
	 * ����ҵ��
	 * @param bulletinMap
	 * @return
	 */
	public boolean updateEntry( Map<String,Object> contextMap ) throws Exception;
	
	/**
	 * ɾ��ҵ��
	 * @param bulletinMap
	 * @return
	 */
	public boolean deleteEntry( Map<String,Object> contextMap ) throws Exception ;
	
	/**
	 * ����ҵ�����ID
	 * @param bulletinMap
	 * @return
	 */
	public Map<String,Object> selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * ��ҳ��ѯҵ����Ϣ����
	 * @param bulletinMap
	 * @return
	 */
	public List<SchemeType> selectEntryList4Page( Map<String,Object> contextMap );
	
	/**
	 * ��ѯҵ��������Ϣ����
	 * @param contextMap
	 * @return
	 */
	public List<SchemeType> selectEntryList( Map<String,Object> contextMap ) throws Exception;
	
	/**
	 * ��ѯҵ��������Ϣ����-ֻ��չʾ��ҳ�������
	 */
	public List<SchemeType> selectEntryList4IsShow( Map<String,Object> contextMap );
}
