package com.dacnx.www.entry;

import java.util.Map;

/**
 * ʵ�������
 * @author Administrator
 *
 */
public class Entry {
	/**
	 * �ж�MAP���Ƿ������Ч����
	 * @param entryMap
	 * @param key
	 * @return
	 */
	protected static boolean isEmpty( Map<String,Object> entryMap , String key ) {
		if( entryMap.containsKey(key) ) {
			if( null != entryMap.get(key) ) {
				return false;
			}
		}
		return true;
	}
}
