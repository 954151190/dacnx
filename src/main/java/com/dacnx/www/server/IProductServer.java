package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.Product;

public interface IProductServer {
	/**
	 * ���Ҳ�Ʒ����ID
	 * @param bulletinMap
	 * @return
	 */
	public Product selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * ��ҳ��ѯ��Ʒ��Ϣ����
	 * @param bulletinMap
	 * @return
	 */
	public List<Product> selectEntryList4Page( Map<String,Object> contextMap );
}