package controllers;

import play.db.ebean.EbeanConfig;
import play.libs.Json;
import models.ResultData;
import models.ResultData.MystockView;
import models.Admin;
import models.Book;
import models.User_stock_r;
import play.mvc.Controller;
import play.mvc.Result;
import repository.DatabaseExecutionContext;
import util.ResultRtn;

import java.util.ArrayList;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import io.ebean.Ebean;
import io.ebean.EbeanServer;





public class Clogin extends Controller {
	
	
	public  class MystockView{
		   
		   
		   public String stockCode;
		   public String stockName;
		   
		   
		
		
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	private final EbeanServer ebeanServer;

    @Inject
    public Clogin(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
    }

	    /**
	     * An action that responds with the {@link Counter}'s current
	     * count. The result is plain text. This action is mapped to
	     * <code>GET</code> requests with a path of <code>/count</code>
	     * requests by an entry in the <code>routes</code> config file.
	     */

	    
         
         
         public Result login(int flag,String wxid) {
        	 
        	ResultRtn resultRtn = new ResultRtn();
 	        resultRtn.errCode = 0;
 			resultRtn.msg="login ok";
 	    	String Lname="";
 	    	String Ltel="";
 			
 			List<User_stock_r>   User_stock_r_list =null;
 			
 			if(flag==1) {} 
 			else if(flag==3) {}
 			else if(flag==2){
 				
 			   try {     
 				  Optional<Admin> admin= 
 						  ebeanServer.find(Admin.class).where().eq("wxid", wxid).findOneOrEmpty();
 				   
 				  if(admin.isPresent()) {
 					      
 					 Lname= admin.get().name;
 				     Ltel= admin.get().tel;
 				     
 				  }
 				  
 	 	        
 	 	        }catch(Exception e) {
 	 	        	
 	 	        	resultRtn.errCode = 1;
 	           	    resultRtn.msg =e.getMessage();
 	           	    return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 	        }
 	 	        
 				
 				 
 				
 				
 				
 				
 			}//end else
 			
 			resultRtn.business.put("name", Lname);
 			resultRtn.business.put("tel", Ltel);
 			
 	    	return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
         	
 	    }//end login
}
