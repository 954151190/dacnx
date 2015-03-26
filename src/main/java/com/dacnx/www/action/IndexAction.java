package com.dacnx.www.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dacnx.www.entry.Bulletin;
import com.dacnx.www.entry.News;
import com.dacnx.www.entry.Page;
import com.dacnx.www.entry.Photo;
import com.dacnx.www.entry.Product;
import com.dacnx.www.entry.Scheme;
import com.dacnx.www.entry.SchemeType;
import com.dacnx.www.server.IBulletinServer;
import com.dacnx.www.server.INewsServer;
import com.dacnx.www.server.IPhotoServer;
import com.dacnx.www.server.IProductServer;
import com.dacnx.www.server.ISchemeServer;
import com.dacnx.www.server.ISchemeTypeServer;
import com.dacnx.www.util.StaticVariable;
import com.opensymphony.xwork2.ActionSupport;
  
/**
 * 负责首页数据采集
 * @author Administrator
 */
public class IndexAction extends ActionSupport {  
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
	/**
	 * 业务服务类
	 */
    private ISchemeServer schemeServer;
    /**
     * 产品服务类
     */
    private IProductServer productServer;
    /**
     * 公示公告服务类
     */
    private IBulletinServer bulletinServer;
    /**
     * 农信要闻服务类
     */
    private INewsServer newsServer;
    /**
     * 图片服务类
     */
    private IPhotoServer photoserver;
    /**
     * 业务类型服务类
     */
    private ISchemeTypeServer schemeTypeServer;
    
    /**
     * 公示公告数据集合
     */
    private List<Bulletin> bulletinList;
    /**
     * 产品数据集合
     */
    private List<Product> productList;
    /**
     * 业务类型数据集合
     */
    private List<SchemeType> schemeTypeList;
    /**
     * 业务类型分组存储的业务数据集合
     */
    Map<String,List<Scheme>> schemeMap;
    /**
     * 业务数据集合-公司业务
     */
    private List<Scheme> schemeCompanyList;
    /**
     * 业务数据集合-个人业务
     */
    private List<Scheme> schemePersonList;
    /**
     * 业务数据集合-清算业务
     */
    private List<Scheme> schemeClearList;
    /**
     * 业务数据集合-银行卡业务
     */
    private List<Scheme> schemeCardList;
    /**
     * 农信要闻数据集合
     */
    private List<News> newsList;
    /**
     * 首页滚动图片数据集合
     */
    private List<Photo> photoList;
    /**
     * 首页展示单独对象
     */
    private Photo photo;
    
    /**
     * 存储图片的路径（临时）
     */
    public static String photoPuth = "C:\\impageManage\\";
    
    @Override
    public String execute() throws Exception {
    	return SUCCESS;
    }
    
    /**
     * 跳转页面
     * @return
     */
    public String toIndex(){
    	try{
    		//生成上下文对象
    		Map<String,Object> contextMap = new HashMap<String,Object>();
    		//获取数据信息-存入上下文对象中
    		this.selectAllDate( contextMap );
    		//填充action数据集合
    		this.pushAllDate(contextMap);
    		return SUCCESS;
    	}catch(Exception ex) {
    		logger.error("首页信息加载失败，跳转到异常首页。");
    		return SUCCESS;
    	} 
    }
    
    /**
     * 查找数据信息
     * @param contextMap
     */
    private void selectAllDate( Map<String,Object> contextMap ){
    	//获取公示公告数据集合
    	Page bulletinPage = new Page( 1 , 5 );
    	contextMap.put(StaticVariable.PAGE_BULLETIN, bulletinPage);
		List<Bulletin> bulletinList = bulletinServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_BULLETIN, bulletinList);
		
		//获取产品数据集合
		Page productPage = new Page( 1 , 8 );
		contextMap.put(StaticVariable.PAGE_PRODUCT, productPage);
		List<Product> productList = productServer.selectEntryList4Page(contextMap); 
		contextMap.put(StaticVariable.DATA_INDEX_PRODUCT, productList);
		
		//获取农信要闻数据集合
		Page newswPersonPage = new Page(1 , 6);
		contextMap.put(StaticVariable.PAGE_NEWS, newswPersonPage);
		List<News> newsPersonList = newsServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_NEWS, newsPersonList);
		
		//获取首页滚动图片数据集合
		List<Photo> photoList = photoserver.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_PHOTO, photoList);
		
		//获取首页展示的业务类型集合
		List<SchemeType> schemeTypeList = schemeTypeServer.selectEntryList4IsShow(null);
		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_TYPE, schemeTypeList);
		this.schemeMap = new HashMap<String,List<Scheme>>(); 
		//根据业务类型获取对应的业务文章信息集合
		for( SchemeType st : schemeTypeList ) {
			//分页信息
			Page schemePage = new Page(1 , 6);
			contextMap.put(StaticVariable.PARAMETER_SCHEME_TYPE, st.getId());
			contextMap.put(StaticVariable.PAGE_SCHEME, schemePage);	
			List<Scheme> schemeList = schemeServer.selectEntryList4Page4Type(contextMap);
			this.schemeMap.put(st.getTitle(), schemeList);
		}
//		//获取业务-银行卡类型数据集合
//		Page schemeCardPage = new Page(1 , 6);
//		contextMap.put(StaticVariable.PAGE_SCHEME_CARD, schemeCardPage);
//		List<Scheme> schemeCardList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_CARD, schemeCardList);
//		
//		//获取业务-清算类型数据集合
//		Page schemeClearPage = new Page( 1 , 6 );
//		contextMap.put(StaticVariable.PAGE_SCHEME_CLEAR, schemeClearPage);
//		List<Scheme> schemeClearList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_CLEAR, schemeClearList);
//		
//		//获取业务-公司类型数据集合
//		Page schemeCompanyPage = new Page( 1 , 6 );
//		contextMap.put(StaticVariable.PAGE_SCHEME_COMPANY, schemeCompanyPage);
//		List<Scheme> schemeCompanyList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_COMPANY, schemeCompanyList);
//		
//		//获取业务-个人类型数据集合
//		Page schemePersonPage = new Page( 1 , 6 );
//		contextMap.put(StaticVariable.PAGE_SCHEME_PERSON, schemePersonPage);
//		List<Scheme> schemePersonList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_PERSON, schemePersonList);
		
		
		
    }
    
    /**
     * 填充action数据集合
     * @param contextMap
     */
    private void pushAllDate( Map<String,Object> contextMap ){
    	//填充公示公告数据
    	this.bulletinList = (List<Bulletin>)contextMap.get(StaticVariable.DATA_INDEX_BULLETIN); 
    	//填充产品数据
    	this.productList = (List<Product>)contextMap.get(StaticVariable.DATA_INDEX_PRODUCT);
    	//填充业务-银行卡类型数据
    	this.schemeCardList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_CARD);
    	//填充业务-清算类型数据
    	this.schemeClearList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_CLEAR);
    	//填充业务-公司类型数据
    	this.schemeCompanyList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_COMPANY);
    	//填充业务-各人类型数据 
    	this.schemePersonList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_PERSON);
    	//填充农信要闻数据
    	this.newsList = (List<News>)contextMap.get(StaticVariable.DATA_INDEX_NEWS);
    	//填充图片数据
    	this.photoList = (List<Photo>)contextMap.get(StaticVariable.DATA_INDEX_PHOTO);
    }
    
    

	public ISchemeServer getSchemeServer() {
		return schemeServer;
	}

	public void setSchemeServer(ISchemeServer schemeServer) {
		this.schemeServer = schemeServer;
	}

	public IProductServer getProductServer() {
		return productServer;
	}

	public void setProductServer(IProductServer productServer) {
		this.productServer = productServer;
	}

	public IBulletinServer getBulletinServer() {
		return bulletinServer;
	}

	public void setBulletinServer(IBulletinServer bulletinServer) {
		this.bulletinServer = bulletinServer;
	}

	public List<Bulletin> getBulletinList() {
		return bulletinList;
	}

	public void setBulletinList(List<Bulletin> bulletinList) {
		this.bulletinList = bulletinList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Scheme> getSchemeCompanyList() {
		return schemeCompanyList;
	}

	public void setSchemeCompanyList(List<Scheme> schemeCompanyList) {
		this.schemeCompanyList = schemeCompanyList;
	}

	public List<Scheme> getSchemePersonList() {
		return schemePersonList;
	}

	public void setSchemePersonList(List<Scheme> schemePersonList) {
		this.schemePersonList = schemePersonList;
	}

	public List<Scheme> getSchemeClearList() {
		return schemeClearList;
	}

	public void setSchemeClearList(List<Scheme> schemeClearList) {
		this.schemeClearList = schemeClearList;
	}

	public List<Scheme> getSchemeCardList() {
		return schemeCardList;
	}

	public void setSchemeCardList(List<Scheme> schemeCardList) {
		this.schemeCardList = schemeCardList;
	}

	public INewsServer getNewsServer() {
		return newsServer;
	}

	public void setNewsServer(INewsServer newsServer) {
		this.newsServer = newsServer;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public IPhotoServer getPhotoserver() {
		return photoserver;
	}

	public void setPhotoserver(IPhotoServer photoserver) {
		this.photoserver = photoserver;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public ISchemeTypeServer getSchemeTypeServer() {
		return schemeTypeServer;
	}

	public void setSchemeTypeServer(ISchemeTypeServer schemeTypeServer) {
		this.schemeTypeServer = schemeTypeServer;
	}

	public List<SchemeType> getSchemeTypeList() {
		return schemeTypeList;
	}

	public void setSchemeTypeList(List<SchemeType> schemeTypeList) {
		this.schemeTypeList = schemeTypeList;
	}

	public Map<String, List<Scheme>> getSchemeMap() {
		return schemeMap;
	}

	public void setSchemeMap(Map<String, List<Scheme>> schemeMap) {
		this.schemeMap = schemeMap;
	}
}