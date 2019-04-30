package models;

import play.data.format.Formats;
import play.data.validation.Constraints;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;



/**
 * Company entity managed by Ebean
 */
@Entity  
public class Res extends BaseModel{

   
	public int type; //资源编码
	public String resid; //资源编码
	
    @JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comid")
	public Company comid; //结构代码
    
    public int size; //容纳人数
    public int status; //资源状态
    
    
    public String name;  //单位名称
   
    
    public Boolean projector; //地址简称
    public Boolean camera;  //详细地址
    public String validdate;  //可用日期

    public String des;   //电话
    
    
    
    //@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public String starttime; //审核时间
       
    
    //@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public String endtime; //审核时间
    
//    @ManyToOne
//    public Admin role;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")   
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date createtime;
    
   
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")   
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date modifytime; //修改时间
    
    public String d11;   //电话
    
    public int d2;   //电话
    
    public double d3;   //电话
    
    @Transient 
    public List<Book> bookList; 
    
}

