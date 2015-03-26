package com.dacnx.www.server;

import java.util.List;
import java.util.Map;

import com.dacnx.www.entry.Bulletin;

public interface IBulletinServer {
	/**
	 * 查找公示公告根据ID
	 * @param bulletinMap
	 * @return
	 */
	public Bulletin selectEntry4ID( Map<String,Object> bulletinMap ) throws Exception; 
	
	/**
	 * 分页查询公示公告信息集合
	 * @param bulletinMap
	 * @return
	 */
	public List<Bulletin> selectEntryList4Page( Map<String,Object> bulletinMap );
}
