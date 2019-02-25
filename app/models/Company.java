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
public class Company{

    private static final long serialVersionUID = 1L;
   
    @Id
    public String comid; //单位id
    
    public String name;  //单位名称
   
    public String wxid;  //微信id
    public String addshort; //地址简称
    public String addlong;  //详细地址
    public float  lat;   //地址精度
    public float  ing;   //地址纬度
    public String tel;   //电话
    /**
     * 创建时间
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date createtime;
    public int  status;  //单位状态
    
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date checktime; //审核时间
        
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date modifytime; //修改时间
}

