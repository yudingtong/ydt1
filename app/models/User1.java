package models;

import play.data.format.Formats;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.ebean.annotation.CreatedTimestamp;



/**
 * Company entity managed by Ebean
 */
@Entity 
public class User1 extends BaseModel{

   
    @Column(unique=true)
    public String wxid;  //微信id
    
    public String name;  //真实姓名
   
    public int    type;  	 //用户类型
    
    public String tel; 	 //手机号
    
    public String com; 	 //现单位
    
    public String userinfo; 	 //用户信息
    
    int  bint1 = 0;
    
    int  bint2 = 0;
    
    @Column(nullable=true)
    public String b1; 	 //用户信息
    
    @Column(nullable=true)
    public String b2; 	 //用户信息
    
    @Column(nullable=true)
    public String avatar_large; 	 //用户信息
    
    @Column(nullable=true)
    public String avatar_mini; 	 //用户信息
    
    @Column(nullable=true)
    public String location; 	 //用户信息
    
    @Column(nullable=true)
    public String website; 	 //用户信息
    
    @Column(nullable=true)
    public String avatar_normal; 	 //用户信息
    
    @Column(nullable=true)
    public String bio; 	 //用户信息
    
    @Column(nullable=true)
    public String btc; 	 //用户信息
    
    @Column(nullable=true)
    public String url; 	 //用户信息
    
    
    /**
     * 注册日期
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date regdate;
    
    
    
    
}

