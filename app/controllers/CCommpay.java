package controllers;

import play.db.ebean.EbeanConfig;
import play.libs.Json;
import models.ResultData;
import models.User;
import models.ResultData.MystockView;
import models.Admin;
import models.Book;
import models.Company;
import models.Res;
import models.User_stock_r;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Http.Request;
import repository.DatabaseExecutionContext;
import util.ResultRtn;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import io.ebean.Ebean;
import io.ebean.EbeanServer;





public class CCommpay extends Controller {
	
	
	  
   public static Request request() {
	   System.out.println("---->");
	   return Http.Context.current().request();
	    }

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
         
       
         
         public Result queryRes(String resid) {
        	 
         	ResultRtn resultRtn = new ResultRtn();
  	        resultRtn.errCode = 0;
  			resultRtn.msg="query ok";
  	    	
  			   try {     
  				  
  				  
  				  List<Res> resList= 
 						  ebeanServer.find(Res.class).where().eq("resid", resid).findList();
  				 
  				 if(resList.size()>0) {
  					resultRtn.business.put("res", resList); 
  					return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
  	 				   
  				 }else {
  					 
  					 resultRtn.errCode = 401;
 					 resultRtn.msg="没有可以管理的资源";
 					  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
  				 }
  				 
  				    
  				
  				  
 				  
  	 	        
  	 	        }catch(Exception e) {
  	 	        	
  	 	        	resultRtn.errCode = 1;
  	           	    resultRtn.msg =e.getMessage();
  	           	    return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
  	 	        }
  	 	        
  				
          	
  	    }//end queryRes
         
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
		          company.status=1; //0 默认为正常状态 新增是1，你是超管，审核通过是2，2预订用户可见
		          company.createtime =new Date();
		          
		          company.save();
	          
			  }
			  
        	  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
        	 
         } 
  
  
  
  
  
//public Result  manageRes(int flag,String wxid,String adminname,String admintel,String comid,String name,String addshort,String addlong,float lat,float lng,String tel){
	  public Result  manageRes(int flag,String wxid,String comid,String resid,int type,String name,int size, String starttime,String endtime,String des) throws ParseException
	 
	  {
      
		  String starttime1=java.net.URLDecoder.decode(starttime);
		  String endtime1=java.net.URLDecoder.decode(endtime);
		  SimpleDateFormat sdf =   new SimpleDateFormat( "mm:ss" );
		  
		  
		  ResultRtn resultRtn = new ResultRtn();
	      resultRtn.errCode = 0;
		  resultRtn.msg="Res add ok";
		  Res res= null;
		  
		  
		  if(flag==1) {//新增
		  
			   Optional<Company> com1= 
				  ebeanServer.find(Company.class).where().eq("comid", comid).findOneOrEmpty();
		
		  
			  if(!com1.isPresent()) {
				
				 //company = company1.get();
				 resultRtn.errCode = 301;
				 resultRtn.msg="此资源所属机构不存在";
				  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
			  }
	  
		   res =  new Res();
		   res.d11 = wxid;
          //company.adminname=adminname;
          //company.addlong
		   res.comid =comid;
		   res.name =name;
		   
		  // long time = System.currentTimeMillis();

		   res.resid  =String.valueOf(System.currentTimeMillis());
		   res.type=type;
		   res.size=size;
		   res.starttime=  sdf.parse(starttime1);
		   res.endtime=sdf.parse(endtime1);
		   res.status=0; //0 默认为正常状态
		   res.des =des;
		   res.createtime =new Date();
          
		   res.save();
      
		
		  }else {
			  
		  Optional<Res> res1= 
				  ebeanServer.find(Res.class).where().eq("comid", resid).findOneOrEmpty();
		
			  if(!res1.isPresent()) {
					
					 //company = company1.get();
					 resultRtn.errCode = 301;
					 resultRtn.msg="此资源不存在";
					  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
				  }
			  
		  
			  Res res2=  res1.get();
		  
			  if(flag==3) {
				  res2.delete(); 
				  resultRtn.errCode = 0;
				  resultRtn.msg="资源已经删除";
			      return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
			      
			  }else if(flag==2){
				  
				  res2.d11 = wxid;
		          //company.adminname=adminname;
		          //company.addlong
				   res2.comid =comid;
				   res2.name =name;
				   
				  // long time = System.currentTimeMillis();

				   res2.resid  =resid;
				   res2.type=type;
				   res2.size=size;
				   res2.starttime=  sdf.parse(starttime1);
				   res2.endtime=sdf.parse(endtime1);
				   res2.status=0; //0 默认为正常状态
				   res2.des =des;
				   res2.createtime =new Date();
		          
				   res2.save();
				  
			  }

				  
				  
			  
			 
			  
		  
		  }//flag =2
		  
	  
		  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
	 
 } 
  
  
}
