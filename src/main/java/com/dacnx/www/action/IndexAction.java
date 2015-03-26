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
 * ������ҳ���ݲɼ�
 * @author Administrator
 */
public class IndexAction extends ActionSupport {  
	private static final Logger logger = LoggerFactory.getLogger(IndexAction.class);
	/**
	 * ҵ�������
	 */
    private ISchemeServer schemeServer;
    /**
     * ��Ʒ������
     */
    private IProductServer productServer;
    /**
     * ��ʾ���������
     */
    private IBulletinServer bulletinServer;
    /**
     * ũ��Ҫ�ŷ�����
     */
    private INewsServer newsServer;
    /**
     * ͼƬ������
     */
    private IPhotoServer photoserver;
    /**
     * ҵ�����ͷ�����
     */
    private ISchemeTypeServer schemeTypeServer;
    
    /**
     * ��ʾ�������ݼ���
     */
    private List<Bulletin> bulletinList;
    /**
     * ��Ʒ���ݼ���
     */
    private List<Product> productList;
    /**
     * ҵ���������ݼ���
     */
    private List<SchemeType> schemeTypeList;
    /**
     * ҵ�����ͷ���洢��ҵ�����ݼ���
     */
    Map<String,List<Scheme>> schemeMap;
    /**
     * ҵ�����ݼ���-��˾ҵ��
     */
    private List<Scheme> schemeCompanyList;
    /**
     * ҵ�����ݼ���-����ҵ��
     */
    private List<Scheme> schemePersonList;
    /**
     * ҵ�����ݼ���-����ҵ��
     */
    private List<Scheme> schemeClearList;
    /**
     * ҵ�����ݼ���-���п�ҵ��
     */
    private List<Scheme> schemeCardList;
    /**
     * ũ��Ҫ�����ݼ���
     */
    private List<News> newsList;
    /**
     * ��ҳ����ͼƬ���ݼ���
     */
    private List<Photo> photoList;
    /**
     * ��ҳչʾ��������
     */
    private Photo photo;
    
    /**
     * �洢ͼƬ��·������ʱ��
     */
    public static String photoPuth = "C:\\impageManage\\";
    
    @Override
    public String execute() throws Exception {
    	return SUCCESS;
    }
    
    /**
     * ��תҳ��
     * @return
     */
    public String toIndex(){
    	try{
    		//���������Ķ���
    		Map<String,Object> contextMap = new HashMap<String,Object>();
    		//��ȡ������Ϣ-���������Ķ�����
    		this.selectAllDate( contextMap );
    		//���action���ݼ���
    		this.pushAllDate(contextMap);
    		return SUCCESS;
    	}catch(Exception ex) {
    		logger.error("��ҳ��Ϣ����ʧ�ܣ���ת���쳣��ҳ��");
    		return SUCCESS;
    	} 
    }
    
    /**
     * ����������Ϣ
     * @param contextMap
     */
    private void selectAllDate( Map<String,Object> contextMap ){
    	//��ȡ��ʾ�������ݼ���
    	Page bulletinPage = new Page( 1 , 5 );
    	contextMap.put(StaticVariable.PAGE_BULLETIN, bulletinPage);
		List<Bulletin> bulletinList = bulletinServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_BULLETIN, bulletinList);
		
		//��ȡ��Ʒ���ݼ���
		Page productPage = new Page( 1 , 8 );
		contextMap.put(StaticVariable.PAGE_PRODUCT, productPage);
		List<Product> productList = productServer.selectEntryList4Page(contextMap); 
		contextMap.put(StaticVariable.DATA_INDEX_PRODUCT, productList);
		
		//��ȡũ��Ҫ�����ݼ���
		Page newswPersonPage = new Page(1 , 6);
		contextMap.put(StaticVariable.PAGE_NEWS, newswPersonPage);
		List<News> newsPersonList = newsServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_NEWS, newsPersonList);
		
		//��ȡ��ҳ����ͼƬ���ݼ���
		List<Photo> photoList = photoserver.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_PHOTO, photoList);
		
		//��ȡ��ҳչʾ��ҵ�����ͼ���
		List<SchemeType> schemeTypeList = schemeTypeServer.selectEntryList4IsShow(null);
		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_TYPE, schemeTypeList);
		this.schemeMap = new HashMap<String,List<Scheme>>(); 
		//����ҵ�����ͻ�ȡ��Ӧ��ҵ��������Ϣ����
		for( SchemeType st : schemeTypeList ) {
			//��ҳ��Ϣ
			Page schemePage = new Page(1 , 6);
			contextMap.put(StaticVariable.PARAMETER_SCHEME_TYPE, st.getId());
			contextMap.put(StaticVariable.PAGE_SCHEME, schemePage);	
			List<Scheme> schemeList = schemeServer.selectEntryList4Page4Type(contextMap);
			this.schemeMap.put(st.getTitle(), schemeList);
		}
//		//��ȡҵ��-���п��������ݼ���
//		Page schemeCardPage = new Page(1 , 6);
//		contextMap.put(StaticVariable.PAGE_SCHEME_CARD, schemeCardPage);
//		List<Scheme> schemeCardList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_CARD, schemeCardList);
//		
//		//��ȡҵ��-�����������ݼ���
//		Page schemeClearPage = new Page( 1 , 6 );
//		contextMap.put(StaticVariable.PAGE_SCHEME_CLEAR, schemeClearPage);
//		List<Scheme> schemeClearList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_CLEAR, schemeClearList);
//		
//		//��ȡҵ��-��˾�������ݼ���
//		Page schemeCompanyPage = new Page( 1 , 6 );
//		contextMap.put(StaticVariable.PAGE_SCHEME_COMPANY, schemeCompanyPage);
//		List<Scheme> schemeCompanyList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_COMPANY, schemeCompanyList);
//		
//		//��ȡҵ��-�����������ݼ���
//		Page schemePersonPage = new Page( 1 , 6 );
//		contextMap.put(StaticVariable.PAGE_SCHEME_PERSON, schemePersonPage);
//		List<Scheme> schemePersonList = schemeServer.selectEntryList4Page(contextMap);
//		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_PERSON, schemePersonList);
		
		
		
    }
    
    /**
     * ���action���ݼ���
     * @param contextMap
     */
    private void pushAllDate( Map<String,Object> contextMap ){
    	//��乫ʾ��������
    	this.bulletinList = (List<Bulletin>)contextMap.get(StaticVariable.DATA_INDEX_BULLETIN); 
    	//����Ʒ����
    	this.productList = (List<Product>)contextMap.get(StaticVariable.DATA_INDEX_PRODUCT);
    	//���ҵ��-���п���������
    	this.schemeCardList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_CARD);
    	//���ҵ��-������������
    	this.schemeClearList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_CLEAR);
    	//���ҵ��-��˾��������
    	this.schemeCompanyList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_COMPANY);
    	//���ҵ��-������������ 
    	this.schemePersonList = (List<Scheme>)contextMap.get(StaticVariable.DATA_INDEX_SCHEME_PERSON);
    	//���ũ��Ҫ������
    	this.newsList = (List<News>)contextMap.get(StaticVariable.DATA_INDEX_NEWS);
    	//���ͼƬ����
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