package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.News;

public interface INewsServer {
	/**
	 * ���Ҳ�Ʒ����ID
	 * @param bulletinMap
	 * @return
	 */
	public News selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * ��ҳ��ѯ��Ʒ��Ϣ����
	 * @param bulletinMap
	 * @return
	 */
	public List<News> selectEntryList4Page( Map<String,Object> contextMap );
}
