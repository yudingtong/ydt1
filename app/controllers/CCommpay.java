package controllers;

import play.data.format.Formats;
import play.db.ebean.EbeanConfig;
import play.libs.Json;
import models.ResultData;
import models.User;
import models.ResultData.MystockView;
import models.Admin;
import models.BaseModel;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import controllers.CCommpay.ComView;
import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.annotation.CreatedTimestamp;





public class CCommpay extends Controller {
	
	
	  
   

	public  class resView{
		   
		   
		public String resid; //资源编码
	    public String validdate;  //可用日期
	    public String name;  //单位名称
	    public String des;   //电话
	    public int size; //容纳人数
	    public int status; //资源状态
	    public String starttime; //审核时间
	    public String endtime; //审核时间
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
	
	
	
	public class ComView {

	    public String comid; //结构代码
	    public String name;  //单位名称
	    public String wxid;  //微信id
	    public String addshort; //地址简称
	    public String addlong;  //详细地址
	    public float  lat;   //地址精度
	    public float  lng;   //地址纬度
	    public String tel;   //电话
	    public String createtime;
	    public int  status;  //单位状态
	    public String checktime; //审核时间
	    public String modifytime; //修改时间
	    public List<Res> resList;
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

	    
         
         
         public Result queryCom(int flag,String wxid) {
        	 
        	
        	 
        	ResultRtn resultRtn = new ResultRtn();
 	        resultRtn.errCode = 0;
 			resultRtn.msg="query ok";
 			//SimpleDateFormat sdf =   new SimpleDateFormat( "mm:ss" );
 			SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
 				
 			if(wxid==null) {
        		 
        		 resultRtn.errCode = 901;
				 resultRtn.msg="wxid 为空";
				  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\"")); 
        		 
        	 }
 			
 			   try {     
 				  
 				  List<ComView> comviewList=new ArrayList<ComView>(); 
 				  
 				
 				 if(flag==1) {
 				 
 					 List<Company> companyList= 
						  ebeanServer.find(Company.class).where().eq("wxid", wxid)
																 .or()
										                        	.eq("status", 0)
										                        	.eq("status", 1)
										                         .endOr()
						                                         .findList();
 				 
 				 if(companyList.size()>0) {
 					 
 					for(int i=0; i<companyList.size(); i++) {
 						
 						ComView comview=new ComView();
 						comview.comid= companyList.get(i).comid;
 						comview.wxid= companyList.get(i).wxid;
 						comview.name= companyList.get(i).name;
 						comview.addshort= companyList.get(i).addshort;
 						comview.addlong= companyList.get(i).addlong;
 						comview.lat= companyList.get(i).lat;
 						comview.lng= companyList.get(i).ing;
 						comview.tel= companyList.get(i).tel;
 						comview.createtime= sdf1.format(companyList.get(i).createtime);
 						comview.status= companyList.get(i).status;
 						comview.checktime= sdf1.format(companyList.get(i).checktime);
 						comview.modifytime= sdf1.format(companyList.get(i).modifytime);
 						
 						
 						List<Res> resList1 = 
 								  ebeanServer.find(Res.class).where().eq("comid.comid", comview.comid).findList(); 
// 						for(i=0; i<resList1.size(); i++) {
// 							
// 							resList1.get(i).createtime=sdf1.format(resList1.get(i).createtime);
// 							
// 						}
 						
 						comview.resList = resList1;
 						
 						comviewList.add(comview);
 					}
 					 
 					 
 					 resultRtn.business.put("Company", comviewList); 
 					 return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 				   
	 				 }else {
	 					 
	 					 resultRtn.errCode = 401;
						 resultRtn.msg="没有可以管理的单位";
						  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
	 				 }
	 				 
 				    
 				 }else if(flag==2) {//end flag==1
 					 
 					 
 					List<Book> bl=  ebeanServer.find(Book.class)   //.fetch("resid")
 														.setDistinct(true)
 														.select("comid")
 							                            .where()
 														.ne("status", 3)
 														
 														//.("status", status)
 															//.between("bookdate", startdate1, enddate1)  
 														.findList();
 					if(bl.size()>0) {	 
 					 
		 					 for(int i=0;i<bl.size();i++) {
		 						
		 						
		 						
		 						ComView comview =new ComView();
		 						comview.comid= bl.get(i).comid.comid;
		 						comview.wxid= bl.get(i).comid.wxid;
		 						comview.name= bl.get(i).comid.name;
		 						comview.addshort= bl.get(i).comid.addshort;
		 						comview.addlong= bl.get(i).comid.addlong;
		 						comview.lat= bl.get(i).comid.lat;
		 						comview.lng= bl.get(i).comid.ing;
		 						comview.tel= bl.get(i).comid.tel;
		 						comview.createtime= sdf1.format(bl.get(i).comid.createtime);
		 						comview.status= bl.get(i).comid.status;
		 						comview.checktime= sdf1.format(bl.get(i).comid.checktime);
		 						comview.modifytime= sdf1.format(bl.get(i).comid.modifytime);
		 						
		 						List<Res> resList1 = 
										  ebeanServer.find(Res.class).where().eq("comid.comid", comview.comid).findList(); 
		// 						List<Res> resList= 
		// 	 							  ebeanServer.find(Res.class)
		// 	 							                             .fetch("comid")   
		// 	 							                             .where()
		// 	 							                             .eq("d11", wxid)
		// 	 							                             .or()
		// 	 							                             	.eq("status", 0)
		// 	 							                             	.eq("status", 1)
		// 	 							                             .endOr()
		// 	 							                             .having()
		// 	 							                             .findList();
		 						
		 						comview.resList = resList1;
		 						comviewList.add(comview);
		 						
		 						 
		 					   }
	 					resultRtn.business.put("Company", comviewList); 
	 					return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 					 
 					 } else {
	 					 
	 					 resultRtn.errCode = 401;
						 resultRtn.msg="没有可以管理的单位";
						  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 					 }
 					 
 					 
 					 
 					 
 				 }else { //end flag=2
 					 
 					resultRtn.errCode = 501;
					 resultRtn.msg="flag标志错误";
					  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\"")); 
 					 
 				 }
 	 	        
 	 	        }catch(Exception e) {
 	 	        	
 	 	        	resultRtn.errCode = 1;
 	           	    resultRtn.msg =e.getMessage();
 	           	    return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
 	 	        }
 	 	        
 				
         	
 	    }//end queryComm
         
       
         
         
         public Result queryRes(String keyword,float lat,float lng,int pagesize,int page) {
        	 
         	ResultRtn resultRtn = new ResultRtn();
  	        resultRtn.errCode = 0;
  			resultRtn.msg="query ok";
  			//SimpleDateFormat sdf =   new SimpleDateFormat( "mm:ss" );
  			SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
  				
  			   try {     
  				  
  				  List<ComView> comviewList=new ArrayList(); 
  			      keyword="%"+keyword+"%";
  				  List<Company> companyList= 
 						  ebeanServer.find(Company.class).where().like("name", keyword)
								 						   .setFirstRow(page)
								 					       .setMaxRows(pagesize)
								 					       .findList();
  				 
  				 if(companyList.size()>0) {
  					 
  					for(int i=0; i<companyList.size(); i++) {
  						
  						ComView comview=new ComView();
  						comview.comid= companyList.get(i).comid;
  						comview.wxid= companyList.get(i).wxid;
  						comview.name= companyList.get(i).name;
  						comview.addshort= companyList.get(i).addshort;
  						comview.addlong= companyList.get(i).addlong;
  						comview.lat= companyList.get(i).lat;
  						comview.lng= companyList.get(i).ing;
  						comview.tel= companyList.get(i).tel;
  						comview.createtime= sdf1.format(companyList.get(i).createtime);
  						comview.status= companyList.get(i).status;
  						comview.checktime= sdf1.format(companyList.get(i).checktime);
  						comview.modifytime= sdf1.format(companyList.get(i).modifytime);
  						
  						
  						List<Res> resList1 = 
  								  ebeanServer.find(Res.class).where().eq("comid.comid", comview.comid).findList(); 
  						
  						//resList1.sort();
//  						for(i=0; i<resList1.size(); i++) {
//  							
//  							resList1.get(i).createtime=sdf1.format(resList1.get(i).createtime);
//  							
//  						}
  						
  						comview.resList = resList1;
  						
  						comviewList.add(comview);
  						
//  						Comparable c =new Comparable<comview>() {
//  						  public int compare(Res o1, Res o2) {
//  			                return o2. - o1;
//  						};
//  					   }	
//  						
//  						comviewList.sort(c);
//  					 
  						
  						//comviewList.sort(Comparator.comparing(ComView::)) {
  						Collections.sort(comviewList, new Comparator<ComView>() {
															@Override
															public int compare(ComView o1, ComView o2) {
																
																System.out.println("O1"+o1.lng);
																System.out.println("O2"+o2.lng);
																
																// TODO Auto-generated method stub
																double var1 = (o1.lng - lng) * (o1.lng - lng)+(o1.lat - lat) * (o1.lat - lat);
																double var2 = (o2.lng - lng) * (o2.lng - lng)+(o2.lat - lat) * (o2.lat - lat);
																
																System.out.println(var1-var2);
																if(var1-var2 > 0)
																  return 1;
																
																return -1;
															}
								  				        }
  						
  						);
  					 
  					}
  					
  				    resultRtn.business.put("Company", comviewList); 
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
         
         
         
         
         
         
         
         
         
         
         public Result queryRes1(String resid) {
        	 
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
			  
			  if(wxid==null) {
	        		 
	        		 resultRtn.errCode = 901;
					 resultRtn.msg="wxid 为空";
					  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\"")); 
	        		 
	        	 }
	 			
			  
			  
			  
			  
			  Company company= null;
			  Optional<Company> company1= 
					  ebeanServer.find(Company.class).where().eq("comid", comid).findOneOrEmpty();
				 
				
			  
			  
			  
			  
			 
			  if(flag==1) {  //新增
        	  
				  if(company1.isPresent()) {
						
						 //company = company1.get();
						 resultRtn.errCode = 201;
						 resultRtn.msg="该单位统一社会信用代码已存在";
						  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
					 }
				  
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
	          
			  }else if(flag==2) { //修改
				  
//				  Optional<Company> company1= 
//						  ebeanServer.find(Company.class).where().eq("comid", comid).findOneOrEmpty();
				  
				  if(company1.isPresent()) {
						
						 //company = company1.get();
						 resultRtn.errCode = 201;
						 resultRtn.msg="该单位统一社会信用代码已存在";
						  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
					 }
				  
//				  Company company2= 
//						  ebeanServer.find(Company.class).where().eq("wxid", wxid)
//						                                         .eq("comid", comid)
//						                                         .eq("admintel", admintel)
//						                                         .findOne();
				  company1.get().wxid = wxid;
				  company1.get().admintel = admintel;
				  company1.get().adminname = adminname;
				  
//				  Optional<Admin>   admin1= 
//						  ebeanServer.find(Admin.class).where().eq("wxid", wxid)
//									                           .eq("adminname", adminname)
//									                           .eq("admintel", admintel)
//						                                        .findOneOrEmpty();
					 
				  
				  
				  
			  }else if(flag==3) { //删除
				  
//				  Optional<Company> company1= 
//						  ebeanServer.find(Company.class).where().eq("comid", comid).findOneOrEmpty();
				  
				  if(company1.isPresent()) {
						
						 //company = company1.get();
						 resultRtn.errCode = 201;
						 resultRtn.msg="该单位统一社会信用代码已存在";
						  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
					 }
			  
				  try{
					  
					 Company company2= 
				     
							 ebeanServer.find(Company.class).where().eq("wxid", wxid)
				                                         .eq("comid", comid)
				                                         .findOne();
					 company2.delete();
				        
				  }catch (Exception e) {
					// TODO: handle exception
					  resultRtn.errCode = 301;
					  resultRtn.msg="delete fail,more than one result was found";
					  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
				  }
				  
		
				  
				  
				 
			  
			  }
			  
			  
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
         } 
  
  
  
  
  
//public Result  manageRes(int flag,String wxid,String adminname,String admintel,String comid,String name,String addshort,String addlong,float lat,float lng,String tel){
	  public Result  manageRes(int flag,String wxid,String comid,String resid,int type,String name,int size, String starttime,String endtime,String des) throws ParseException
	 
	  {
      
		  //String starttime1=java.net.URLDecoder.decode(starttime);
		  //String endtime1=java.net.URLDecoder.decode(endtime);
		  SimpleDateFormat sdf =   new SimpleDateFormat( "mm:ss" );
		  
		  
		  ResultRtn resultRtn = new ResultRtn();
	      resultRtn.errCode = 0;
		  resultRtn.msg="Res add ok";
		  Res res= null;
		  
		  if(wxid==null) {
     		 
     		 resultRtn.errCode = 901;
				 resultRtn.msg="wxid 为空";
				  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\"")); 
     		 
     	 }
			
		  
		  Optional<Company> com1= 
				  ebeanServer.find(Company.class).where().eq("comid", comid).findOneOrEmpty();
		  
		  if(flag==1) {//新增
		  
			  
		
		  
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
		   res.comid =com1.get();
		   res.name =name;
		   
		  // long time = System.currentTimeMillis();

		   res.resid  =String.valueOf(System.currentTimeMillis());
		   res.type=type;
		   res.size=size;
		   res.starttime=  starttime;
		   res.endtime=endtime;
		   res.status=1; //0 默认为正常状态
		   res.des =des;
		   res.createtime =new Date();
          
		   res.save();
      
		
		  }else {
			  
		  Optional<Res> res1= 
				  ebeanServer.find(Res.class).where().eq("resid", resid).findOneOrEmpty();
		
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
				   res2.comid =com1.get();
				   res2.name =name;
				   
				  // long time = System.currentTimeMillis();

				   res2.resid  =resid;
				   res2.type=type;
				   res2.size=size;
				   res2.starttime=  starttime;
				   res2.endtime= endtime;
				   res2.status=0; //0 默认为正常状态
				   res2.des =des;
				   res2.createtime =new Date();
		          
				   res2.save();
				  
			  }

				  
				  
			  
			 
			  
		  
		  }//flag =2
		  
	  
		  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
	 
 } 
  
  
}
