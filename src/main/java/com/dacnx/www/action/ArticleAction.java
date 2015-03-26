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
import com.dacnx.www.server.IBulletinServer;
import com.dacnx.www.server.INewsServer;
import com.dacnx.www.server.IPhotoServer;
import com.dacnx.www.server.IProductServer;
import com.dacnx.www.server.ISchemeServer;
import com.dacnx.www.util.StaticVariable;
import com.opensymphony.xwork2.ActionSupport;
  
/**
 * �����б��뵥�������²ɼ�
 * @author Administrator
 */
public class ArticleAction extends ActionSupport {  
	private static final Logger logger = LoggerFactory.getLogger(ArticleAction.class);
	/**
	 * ��������
	 */
	private String articleType;
	/**
	 * ����Ψһ��ʶ
	 */
	private String articleId;
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
     * ��ʾ�������ݼ���
     */
    private List<Bulletin> bulletinList;
    /**
     * ��Ʒ���ݼ���
     */
    private List<Product> productList;
    /**
     * ҵ�����ݼ���-�ۺ�
     */
    private List<Scheme> schemeList;
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
     * ��ʾ�������ݶ���
     */
    private Bulletin bulletin;
    /**
     * ��Ʒ���ݶ���
     */
    private Product product;
    /**
     * ҵ�����ݶ���
     */
    private Scheme scheme ;
    /**
     * ũ��Ҫ�����ݶ���
     */
    private News news;
    /**
     * ��ҳ����ͼƬ���ݼ���
     */
    private List<Photo> photoList;
    /**
     * ��ҳչʾ��������
     */
    private Photo photo;
    
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
     * ��ת�����������͵��б�ҳ��
     * @return
     */
    public String toAricleList(){
    	//����ͨ��ɽ���Ķ���
    	Map<String,Object> contextMap = new HashMap<String,Object>();
    	//����ҵ��ͨ�����ݲ�ѯ
    	//��ȡ��ҳ����ͼƬ���ݼ���
		List<Photo> photoList = photoserver.selectEntryList4Page(contextMap);
		this.photoList = photoList;
    	//����ҵ�����ͽ��в�ͬ�Ĳ�ѯ����ת����ͬ���б�ҳ��
    	if( this.articleType.equals("BL") ) {
    		//��ȡ��ʾ�������ݼ���
        	Page bulletinPage = new Page( 1 ,20 );
        	contextMap.put(StaticVariable.PAGE_BULLETIN, bulletinPage);
    		//��乫ʾ��������
    		this.bulletinList = bulletinServer.selectEntryList4Page(contextMap);
    		//��乫ʾ��������
    		return "bulletinList";
    	}else if( this.articleType.equals("PL") ){
    		//��ȡ��Ʒ���ݼ���
    		Page productPage = new Page( 1 , 20 );
    		contextMap.put(StaticVariable.PAGE_PRODUCT, productPage);
    		this.productList = productServer.selectEntryList4Page(contextMap); 
    		return "productList";
    	}else if( this.articleType.equals("SL") ) {
    		//��ȡҵ��
    		Page schemeCardPage = new Page(1 , 20);
    		contextMap.put(StaticVariable.PAGE_SCHEME, schemeCardPage);
    		this.schemeList = schemeServer.selectEntryList4Page(contextMap);
    		return "schemeList";
    	}else if ( this.articleType.equals("NL") ) {
    		//��ȡũ��Ҫ��
    		Page newsCardPage = new Page(1 , 20);
    		contextMap.put(StaticVariable.PAGE_NEWS, newsCardPage);
    		this.newsList = newsServer.selectEntryList4Page(contextMap);
    		return "newsList";
    	}
    	return SUCCESS;
    }
    
    /**
     * ��ת�����������͵�չʾҳ��
     */
    public String toAricle(){
    	try {
    		//����ͨ��ɽ���Ķ���
        	Map<String,Object> contextMap = new HashMap<String,Object>();
        	//����ҵ��ͨ�����ݲ�ѯ
        	//��ȡ��ҳ����ͼƬ���ݼ���
    		List<Photo> photoList = photoserver.selectEntryList4Page(contextMap);
	    	//����ҵ�����ͽ��в�ͬ�Ĳ�ѯ����ת����ͬ���б�ҳ��
	    	if( this.articleType.equals("BL") ) {
	    		//��ȡ��ʾ��������
	    		contextMap.put(StaticVariable.MS_BULLETIN_OBJECT, this.bulletin);
				this.bulletin = bulletinServer.selectEntry4ID( contextMap );
	    		return "bulletin";
	    	}else if( this.articleType.equals("PL") ){
	    		//��ȡ��Ʒ����
	    		contextMap.put(StaticVariable.MS_PRODUCT_OBJECT, this.product);
	    		this.product = productServer.selectEntry4ID(contextMap); 
	    		return "product";
	    	}else if( this.articleType.equals("SL") ) {
	    		//��ȡҵ������
	    		contextMap.put(StaticVariable.MS_SCHEME_OBJECT, this.scheme);
	    		this.scheme = schemeServer.selectEntry4ID(contextMap);
	    		return "scheme";
	    	}else if( this.articleType.equals("NL") ){
	    		//��ȡũ��Ҫ������
	    		contextMap.put(StaticVariable.MS_NEWS_OBJECT, this.news);
	    		this.news = newsServer.selectEntry4ID(contextMap);
	    		return "news";
	    	}
    	} catch (Exception ex) {
			logger.error("��ȡ����չʾ��Ϣʧ��" , ex);
		}
    	return SUCCESS;
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
		
		//��ȡҵ��-���п��������ݼ���
		Page schemeCardPage = new Page(1 , 6);
		contextMap.put(StaticVariable.PAGE_SCHEME_CARD, schemeCardPage);
		List<Scheme> schemeCardList = schemeServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_CARD, schemeCardList);
		
		//��ȡҵ��-�����������ݼ���
		Page schemeClearPage = new Page( 1 , 6 );
		contextMap.put(StaticVariable.PAGE_SCHEME_CLEAR, schemeClearPage);
		List<Scheme> schemeClearList = schemeServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_CLEAR, schemeClearList);
		
		//��ȡҵ��-��˾�������ݼ���
		Page schemeCompanyPage = new Page( 1 , 6 );
		contextMap.put(StaticVariable.PAGE_SCHEME_COMPANY, schemeCompanyPage);
		List<Scheme> schemeCompanyList = schemeServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_COMPANY, schemeCompanyList);
		
		//��ȡҵ��-�����������ݼ���
		Page schemePersonPage = new Page( 1 , 6 );
		contextMap.put(StaticVariable.PAGE_SCHEME_PERSON, schemePersonPage);
		List<Scheme> schemePersonList = schemeServer.selectEntryList4Page(contextMap);
		contextMap.put(StaticVariable.DATA_INDEX_SCHEME_PERSON, schemePersonList);
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

	public Bulletin getBulletin() {
		return bulletin;
	}

	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public List<Scheme> getSchemeList() {
		return schemeList;
	}

	public void setSchemeList(List<Scheme> schemeList) {
		this.schemeList = schemeList;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
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

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
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
}