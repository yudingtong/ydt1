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
public class Price extends BaseModel{

	 /**
     * 注册日期
     */
   // @Formats.DateTime(pattern = "yyyy-MM-dd")
    @Column(name="pricedate",columnDefinition="DATE") 
    public Date pricedate;

    public String code;  //代码
    
    public String name;  //姓名
   
    public double price=0.0;  //价格
    
    public double price1=0.0;  //价格
    
    public double price2=0.0;  //价格
    
    public String des; 	  //描述
    
    public String bak1; 	  //描述
    
    public String bak2; 	  //描述
    
    /**
     * 注册日期
     */
    @Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedTimestamp
    public Date createdate;

   
    
    
}

