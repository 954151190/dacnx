package com.dacnx.www.util;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ���ݿ��ѯ���� (��Ҫ�� Common-DBUtils ��)
 * 
 * @author CaoJia
 */

public class QueryHelper {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(QueryHelper.class);

	// jdbc֧�� getPreparedStatementMetaData ʱʹ�� �����֧����oracle ���캯����true����
	private final static QueryRunner qr = new QueryRunner();
	// �����¼����list
	private final static MapListHandler mapListHandler = new MapListHandler();
	// ���һ��Object(count��)
	private static final ScalarHandler scalarHandler = new ScalarHandler();
	// ���һ����¼
	private static final MapHandler mapHandler = new MapHandler();

	/**
	 * û��where����,���һ����¼
	 * 
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> selectSqlForMap(Connection conn,
			String sql, Object[] params) throws Exception {
		return qr.query(conn, sql, mapHandler, params);
	}

	/**
	 * ��where����,���һ����¼
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> selectSqlForMap(Connection conn,
			String sql) throws Exception {
		return qr.query(conn, sql, mapHandler);
	}

	/**
	 * ��where����,���һ��Object,ͳ����
	 * @param conn
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static Object selectSqlForObject(Connection conn, String sql)
			throws Exception {
		return qr.query(conn, sql, scalarHandler);
	}

	/**
	 * ��wherec����,���һ��Object,ͳ����
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Object selectSqlForObject(Connection conn, String sql,
			Object[] params) throws Exception {
		return qr.query(conn, sql, scalarHandler, params);
	}

	/**
	 * ��where������ѯ
	 * @param conn
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> selectSql(Connection conn,
			String sql) throws Exception {
		return qr.query(conn, sql, mapListHandler);
	}

	/**
	 * ��where������ѯ
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> selectSql(Connection conn,
			String sql, Object[] params) throws Exception {
		return qr.query(conn, sql, mapListHandler, params);
	}

	/**
	 * ����ȫ��
	 * @param conn
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static int updateSql(Connection conn, String sql) throws Exception {
		int ret = 0;
		ret = qr.update(conn, sql);
		return ret;
	}

	/**
	 * ����ɾ���ľ��ô˷���(DBUtil��update����ɾ�Ĳ���)
	 * @param conn
	 * @param sql
	 * @param params preparedstatement�е�Ԥ���������ֵ
	 * @return
	 * @throws Exception
	 */
	public static int updateSql(Connection conn, String sql, Object[] params)
			throws Exception {
		int ret = 0;
		ret = qr.update(conn, sql, params);
		return ret;
	}
	
	
	public static int[] saveSqlBatch(Connection conn, String sql, Object[][] params)
			throws Exception {
		int[] ret = new int[params.length];
		ret = qr.batch(conn, sql, params);
		return ret;
	}

}
