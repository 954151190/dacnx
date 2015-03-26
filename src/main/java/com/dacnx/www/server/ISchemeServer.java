package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.Scheme;

public interface ISchemeServer {
	/**
	 * 查找产品根据ID
	 * @param bulletinMap
	 * @return
	 */
	public Scheme selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * 分页查询产品信息集合
	 * @param bulletinMap
	 * @return
	 */
	public List<Scheme> selectEntryList4Page( Map<String,Object> contextMap );
	
	/**
	 * 分页并按业务类型查询业务信息集合
	 * @param contextMap
	 * @return
	 */
	public List<Scheme> selectEntryList4Page4Type( Map<String,Object> contextMap );
	
}
