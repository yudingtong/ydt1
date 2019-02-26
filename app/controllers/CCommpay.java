package controllers;

import play.db.ebean.EbeanConfig;
import play.libs.Json;
import models.ResultData;
import models.User;
import models.ResultData.MystockView;
import models.Admin;
import models.Book;
import models.Company;
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





public class CCommpay extends Controller {
	
	
	public  class bookView{
		   
		   
		   public String comid;
		   public String resid;
		   public String bookid;
		   public String bookdate;
		   public String starttime;
		   public String endtime;
		   public String wxid;
		   public String name;
		   public String tel;
		   public String title;
		   public String des;
		   public String attendee;
		   public String maillist;
		   public String booktime;
		  
		   
		
		
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	private final EbeanServer ebeanServer;

    @Inject
    public CCommpay(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
    }

	    /**
	     * An action that responds with the {@link Counter}'s current
	     * count. The result is plain text. This action is mapped to
	     * <code>GET</code> requests with a path of <code>/count</code>
	     * requests by an entry in the <code>routes</code> config file.
	     */

	    
         
         
         public Result queryCom(String wxid) {
        	 
        	ResultRtn resultRtn = new ResultRtn();
 	        resultRtn.errCode = 0;
 			resultRtn.msg="login ok";
 	    	
 			List<bookView> bookviewList =new ArrayList();
 			
 			
 				
 			   try {     
 				  
 				  
 				  Optional<Company> company= 
						  ebeanServer.find(Company.class).where().eq("wxid", wxid).findOneOrEmpty();
 				 
 				 if(company.isPresent()) {
 					resultRtn.business.put("name", company); 
 					return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 				   
 				 }
 				 
 				    
 				
 				  
				  
 	 	        
 	 	        }catch(Exception e) {
 	 	        	
 	 	        	resultRtn.errCode = 1;
 	           	    resultRtn.msg =e.getMessage();
 	           	    return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 	        }
 	 	        
 				
 				 
 				
 				
 				
 				
 			
 			
 			
 		
 	    	return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
         	
 	    }//end login
}
