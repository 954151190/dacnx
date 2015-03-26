package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.Bulletin;

public interface IBulletinServer {
	/**
	 * ���ҹ�ʾ�������ID
	 * @param bulletinMap
	 * @return
	 */
	public Bulletin selectEntry4ID( Map<String,Object> bulletinMap ) throws Exception; 
	
	/**
	 * ��ҳ��ѯ��ʾ������Ϣ����
	 * @param bulletinMap
	 * @return
	 */
	public List<Bulletin> selectEntryList4Page( Map<String,Object> bulletinMap );
}
