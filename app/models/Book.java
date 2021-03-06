package models;

import play.data.format.Formats;
import play.data.validation.Constraints;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.ebean.Model;
import io.ebean.annotation.CreatedTimestamp;



/**
 * Company entity managed by Ebean
 */
@Entity 
public class Book  extends Model{

    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="resid")
    public Res resid; //资源编号
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="comid")
    public Company comid; //资源编号
    
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
	public String bookid;  //预约编号
   
    
//    @ManyToOne
//    public Admin role;
    /**
     * 创建时间
     */
	@JsonIgnore
    @Formats.DateTime(pattern = "yyyy-MM-dd")
   // @CreatedTimestamp
    public Date bookdate;
    
	@Transient
    public String bookdate1;
   
    public String starttime; //审核时间
        
  
    public String endtime; //修改时间

    public String wxid; //微信id
    public String name;  //详细地址
    public String tel;   //电话
    public String title;   //电话
    public String des; //地址简称
    public String attendee;  //详细地址
    public String maillist;   //电话
    
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date booktime; //审核时间
    
    public int  status=1;   //1待审核、2审核通过、3审核拒绝、4取消
    
    
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date chektime; //修改时间

    



}

