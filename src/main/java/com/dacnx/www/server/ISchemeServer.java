package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.Scheme;

public interface ISchemeServer {
	/**
	 * ���Ҳ�Ʒ����ID
	 * @param bulletinMap
	 * @return
	 */
	public Scheme selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * ��ҳ��ѯ��Ʒ��Ϣ����
	 * @param bulletinMap
	 * @return
	 */
	public List<Scheme> selectEntryList4Page( Map<String,Object> contextMap );
	
	/**
	 * ��ҳ����ҵ�����Ͳ�ѯҵ����Ϣ����
	 * @param contextMap
	 * @return
	 */
	public List<Scheme> selectEntryList4Page4Type( Map<String,Object> contextMap );
	
}
