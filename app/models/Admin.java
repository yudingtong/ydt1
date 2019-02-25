package models;

import play.data.format.Formats;
import play.data.validation.Constraints;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.annotation.CreatedTimestamp;



/**
 * Company entity managed by Ebean
 */
@Entity 
public class Admin{

   
    @Id
    public String wxid;  //微信id
    
    public String name;  //姓名
   
    public int    type;  	 //用户类型
    public String tel; 	 //手机号
    
    
    /**
     * 注册日期
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date regdate;
    
    
}

