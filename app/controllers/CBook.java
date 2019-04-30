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

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.annotation.CreatedTimestamp;





public class CBook extends Controller {
	
	
	public  class queryBook{
		public String comid; //资源编码
		public String comname; //资源编码
		public String resid; //资源编码
		public String resname; //资源编码
		public Book bookVeiw; //资源编码
		
		
		
	}
   

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
    public CBook(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
    }

	    /**
	     * An action that responds with the {@link Counter}'s current
	     * count. The result is plain text. This action is mapped to
	     * <code>GET</code> requests with a path of <code>/count</code>
	     * requests by an entry in the <code>routes</code> config file.
	     */

	    
    public Result   queryBooked(String comid,String startdate,String enddate)   
    {
  	 
  	  ResultRtn resultRtn = new ResultRtn();
        resultRtn.errCode = 0;
  	  resultRtn.msg="ok";
  	  Res res= null;
  	  
  	  SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyyMMdd" );
  	  Date startdate1 =null;
  	  Date enddate1=null;
  	
  	  try {
  		
  		 startdate1 = sdf1.parse(startdate);
  		 enddate1=sdf1.parse(enddate);
  		 
  	  } catch (ParseException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	  }
  	  
  	  
  	  System.out.println("--->1"+startdate1);
  	  System.out.println("--->2"+enddate1);
  	  List<Book> bookList= null;
  	  
  	  List<queryBook> qbList= new ArrayList();
  	//先查询所有资源的预定情况
  	  List<Res> resList1 = 
			  ebeanServer.find(Res.class).where().eq("comid.comid",comid).findList(); 
  	  
  	 
      for(int i=0;i<resList1.size();i++) {
  		
    	  resList1.get(i).bookList=
    	  
  				  ebeanServer.find(Book.class)   //.fetch("resid")
  				                                 //     .fetch("comid")
  				                                      .where()
  				                                      .ne("status", 3)
  				                                       .eq("resid.resid",  resList1.get(i).resid)
  				  									   //.("status", status)
                                                       //.between("bookdate", startdate1, enddate1)  
  				                                       .findList();
      
      
    	  
      }	 
  			 
//  		  if(book1.isPresent()) {
//  				
//  				 //company = company1.get();
//  				 resultRtn.errCode = 201;
//  				 resultRtn.msg="该单位统一社会信用代码已存在";
//  				  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
//  			 }
//  		  
//         company =  new Company();
//         company.wxid = wxid;  
//  		  
//  		  
  		    
//  		    for(int i=0; i<bookList.size();i++) {
//  		    	queryBook qb=new queryBook();	
//  		    	qb.comid =bookList.get(i).resid.comid.comid;
//  		    	qb.comname =bookList.get(i).resid.comid.name;
//  		    	qb.resid =bookList.get(i).resid.resid;
//  		    	qb.resname =bookList.get(i).resid.name;
//  		    	qb.bookVeiw =bookList.get(i);
//  		    	qbList.add(qb);
//  		    }
  		    
  	  
  	  if(resList1.size()==0) {
  		  resultRtn.errCode = -1;
  		  resultRtn.msg="没有符合条件的记录 ";
  		  
  	  }
  	  resultRtn.business.put("res", resList1);
  	  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));	  
  	  
    }
          
         
        
  
  
  public Result   queryBook(int flag,String wxid,int status,String startdate,String enddate)   
  {
	 
	  ResultRtn resultRtn = new ResultRtn();
      resultRtn.errCode = 0;
	  resultRtn.msg="ok";
	  Res res= null;
	  
	  SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyyMMdd" );
	  Date startdate1 =null;
	  Date enddate1=null;
	
	  try {
		
		 startdate1 = sdf1.parse(startdate);
		 enddate1=sdf1.parse(enddate);
		 
	  } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  
	  
	  System.out.println("--->1"+startdate1);
	  System.out.println("--->2"+enddate1);
	  List<Book> bookList= null;
	  
	  List<queryBook> qbList= new ArrayList();
	  
	  
	  if(flag==2) {
		  
		    bookList= 
				  ebeanServer.find(Book.class)   //.fetch("Res.comid.name")
				                                  .fetch("resid")
				                                      .where().eq("wxid", wxid)
				  									  .eq("status", status)
                                                       .between("bookdate", startdate1, enddate1)  
				                                       .findList();
			 
//		  if(book1.isPresent()) {
//				
//				 //company = company1.get();
//				 resultRtn.errCode = 201;
//				 resultRtn.msg="该单位统一社会信用代码已存在";
//				  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
//			 }
//		  
//       company =  new Company();
//       company.wxid = wxid;  
//		  
//		  
		    
		    for(int i=0; i<bookList.size();i++) {
		    	queryBook qb=new queryBook();	
		    	qb.comid =bookList.get(i).resid.comid.comid;
		    	qb.comname =bookList.get(i).resid.comid.name;
		    	qb.resid =bookList.get(i).resid.resid;
		    	qb.resname =bookList.get(i).resid.name;
		    	qb.bookVeiw =bookList.get(i);
		    	qbList.add(qb);
		    }
		    
	  }
	  
	  if(bookList.size()==0) {
		  resultRtn.errCode = -1;
		  resultRtn.msg="没有符合条件的记录 ";
		  
	  }
	  resultRtn.business.put("book", qbList);
	  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));	  
	  
  }
  
  
}
