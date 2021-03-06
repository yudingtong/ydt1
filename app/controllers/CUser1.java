package controllers;

import play.db.ebean.EbeanConfig;
import play.libs.Json;
import models.Price;
import models.Stock;
import models.User1;
import play.mvc.Controller;
import play.mvc.Result;
import repository.DatabaseExecutionContext;
import util.ResultRtn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
public class CUser1 extends Controller {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private final EbeanServer ebeanServer;

    @Inject
    public CUser1(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
    }
	

	    /**
	     * An action that responds with the {@link Counter}'s current
	     * count. The result is plain text. This action is mapped to
	     * <code>GET</code> requests with a path of <code>/count</code>
	     * requests by an entry in the <code>routes</code> config file.
	     */
	
	    
	    
         public Result register(String wxid,String name,String tel,String com,String  userInfo) {
	        
        	
        	 
        	 ResultRtn resultRtn = new ResultRtn();
        	 
        	 User1 user1=new User1();
        	 
        	 int count =ebeanServer.find(User1.class).where().eq("wxid", wxid).findCount(); 
 	    	
        	 if(count>0) {
        		 
        		 resultRtn.errCode = count; 
        		 resultRtn.msg = "wxid is 2"; 
        		 return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
        	 }else {
        	 
        	 JsonNode tsonStr= Json.parse(userInfo);
        	 
        	
        	 user1.wxid =wxid;
        	 user1.name =name;
        	 user1.tel =tel;
        	 user1.com =com;
        	 user1.userinfo =userInfo;
        	 user1.avatar_normal=tsonStr.get("avatarUrl").asText();
        	 user1.save();
	    	 resultRtn.errCode = 0;
	    	
	    	 return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
//	    	return ok("--->"+Stock.find.query("code").findUnique().name);
	    	}
	    }

         
//         public Result mystock(String userId) {
// 	        
//// 	    	Stock sk=new Stock("600030");
// 	    	ResultRtn resultRtn = new ResultRtn();
// 	    	List<Stock> sc =ebeanServer.find(Stock.class).where().eq("code", Code).findList();
// 	    	resultRtn.errCode = 0;
// 			resultRtn.business.put("Stock", sc);
// 	    	
// 	    	return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
//// 	    	return ok("--->"+Stock.find.query("code").findUnique().name);
// 	    	
// 	    }
//         

}
