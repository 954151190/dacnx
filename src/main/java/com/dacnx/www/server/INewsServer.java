package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.News;

public interface INewsServer {
	/**
	 * 查找产品根据ID
	 * @param bulletinMap
	 * @return
	 */
	public News selectEntry4ID( Map<String,Object> contextMap ) throws Exception; 
	
	/**
	 * 分页查询产品信息集合
	 * @param bulletinMap
	 * @return
	 */
	public List<News> selectEntryList4Page( Map<String,Object> contextMap );
}
