package models;

import play.data.format.Formats;
import java.util.Date;
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
    @Formats.DateTime(pattern = "yyyy-MM-dd")
    @CreatedTimestamp
    public Date pricedate;

    public String code;  //代码
    
    public String name;  //姓名
   
    public double price;  //价格
    
    public double price1;  //价格
    
    public double price2;  //价格
    
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

