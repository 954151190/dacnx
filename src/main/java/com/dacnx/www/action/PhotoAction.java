package com.dacnx.www.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dacnx.www.entry.Photo;
import com.opensymphony.xwork2.ActionSupport;
  
/**
 * 负责首页中图片数据的展示
 * @author Administrator
 */
public class PhotoAction extends ActionSupport {  
	private static final Logger logger = LoggerFactory.getLogger(PhotoAction.class);
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
    
    public synchronized String showPhoto()  {
    	synchronized (this.photo) {
    		try {
    	        HttpServletResponse response = ServletActionContext.getResponse();
    	    	ServletOutputStream out = response.getOutputStream();
    	    	String photoPath = photoPuth + this.photo.getId() + ".jpg";
    			InputStream is = new FileInputStream(new File(photoPath));
    			int b = 0;
    			byte[] bytes = new byte[0xffff];
    			while ((b = is.read(bytes, 0, 0xffff)) > 0) {
    				out.write(bytes, 0, b);
    			}
    			is.close();
    			out.flush();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
		}
    	return null;
    }
    
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
}