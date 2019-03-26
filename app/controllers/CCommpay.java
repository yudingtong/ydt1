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
import java.util.Date;
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
 			resultRtn.msg="query ok";
 	    	
 			List<bookView> bookviewList =new ArrayList();
 			
 			
 				
 			   try {     
 				  
 				  
 				  List<Company> companyList= 
						  ebeanServer.find(Company.class).where().eq("wxid", wxid).findList();
 				 
 				 if(companyList.size()>0) {
 					resultRtn.business.put("Company", companyList); 
 					return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 				   
 				 }else {
 					 
 					 resultRtn.errCode = 401;
					 resultRtn.msg="没有可以管理的单位";
					  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 				 }
 				 
 				    
 				
 				  
				  
 	 	        
 	 	        }catch(Exception e) {
 	 	        	
 	 	        	resultRtn.errCode = 1;
 	           	    resultRtn.msg =e.getMessage();
 	           	    return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 	        }
 	 	        
 				
         	
 	    }//end queryComm
         
         
         
  public Result  manageCom(int flag,String wxid,String adminname,String admintel,String comid,String name,String addshort,String addlong,float lat,float lng,String tel){
        	 
	  
		      ResultRtn resultRtn = new ResultRtn();
		      resultRtn.errCode = 0;
			  resultRtn.msg="Comm add ok";
			  Company company= null;
			  Optional<Company> company1= 
					  ebeanServer.find(Company.class).where().eq("comid", comid).findOneOrEmpty();
				 
				 if(company1.isPresent()) {
					
					 //company = company1.get();
					 resultRtn.errCode = 201;
					 resultRtn.msg="该单位统一社会信用代码已存在";
					  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
				 }
			  
			 
			  if(flag==1&!company1.isPresent()) {
        	  
			  
		          company =  new Company();
		          company.wxid = wxid;
		          //company.adminname=adminname;
		          //company.addlong
		          company.comid =comid;
		          company.name =name;
		          company.addshort  =addshort;
		          
		          company.addlong=addlong;
		          company.lat=lat;
		          company.ing=lng;
		          company.tel=tel;
		          company.status=0; //0 默认为正常状态
		          company.createtime =new Date();
		          
		          company.save();
	          
			  }
			  
        	  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
        	 
         } 
}
