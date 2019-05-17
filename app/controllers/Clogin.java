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





public class Clogin extends Controller {
	
	
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
 			String LComid="";
 			List<bookView> bookviewList =new ArrayList();
 			
 			if(flag==1) {} 
 			else if(flag==3) {}
 			else if(flag==2){
 				
 			   try {     
 				  Optional<Admin> admin= 
 						  ebeanServer.find(Admin.class).where().eq("wxid", wxid).findOneOrEmpty();
 				  
 				 List<Company> companyL= 
						  ebeanServer.find(Company.class).where().eq("wxid", wxid).findList();
 				 
 				 if(!companyL.isEmpty()) {
 					LComid =companyL.get(0).comid;
 					 
 				 }
 				 
 				 
 				   
 				  if(admin.isPresent()) {
 					      
 					 Lname= admin.get().name;
 				     Ltel= admin.get().tel;
 				     
 				     List<Book> bl=
 				          ebeanServer.find(Book.class).where().eq("wxid", wxid).findList();
 				     
 				    
 				     for(int i=0;i<bl.size();i++) {
 				    	 
 				    	bookView bv=new bookView();
 				    	bv.resid=  bl.get(i).resid.resid;
 				    	bv.attendee = bl.get(i).attendee;
 				    	bv.bookdate = bl.get(i).bookdate.toString();
 				    	bv.bookid = bl.get(i).bookid;
 				    	bv.booktime = bl.get(i).booktime.toString();
 				    	bv.comid = LComid;
 				    	bv.des = bl.get(i).des;
 				    	bv.endtime = bl.get(i).endtime.toString();;
 				    	bv.maillist = bl.get(i).maillist;
 				    	bv.name = bl.get(i).name;
 				    	bv.starttime = bl.get(i).starttime.toString();;
 				    	bv.tel = bl.get(i).tel;
 				    	bv.wxid = bl.get(i).wxid;
 				    	bookviewList.add(bv);
 				     }
 				     
 				  }else {
 					  
 					resultRtn.errCode = 1;
  	           	    resultRtn.msg ="admin is not exsit";
  	           	    return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));  
 					  
 				  }
 				  
 	 	        
 	 	        }catch(Exception e) {
 	 	        	
 	 	        	resultRtn.errCode = 1;
 	           	    resultRtn.msg =e.getMessage();
 	           	    return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 	        }
 	 	        
 				
 				 
 				
 				
 				
 				
 			}//end else
 			
 			resultRtn.business.put("name", Lname);
 			resultRtn.business.put("tel", Ltel);
 			resultRtn.business.put("booklist", bookviewList);
 	    	return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
         	
 	    }//end login
}
