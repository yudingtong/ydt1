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
import java.util.Arrays;
import java.util.Base64.Decoder;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

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
	     * @throws ParseException 
	     */
    public Result   bookRes(String wxid,String resid,String bookdate,String starttime,String endtime,String name,String tel,String title,String des) throws ParseException  
    {
    	 ResultRtn resultRtn = new ResultRtn();
         resultRtn.errCode = 0;
	   	 resultRtn.msg="ok";
	     SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyyMMdd" );
	     
	     SimpleDateFormat sdf2 =   new SimpleDateFormat( "HH:mm" );
	     
	     SimpleDateFormat sdf3 =   new SimpleDateFormat( "HH:mm" );
	     
	     if(wxid==null) {
    		 
    		 resultRtn.errCode = 901;
			 resultRtn.msg="wxid 为空";
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\"")); 
    		 
    	 }
			
	     
//	  	 Date starttime1 =sdf2.parse(starttime);
//	  	 Date endtime1 =sdf2.parse(endtime);
	  	 
	  	// int [1440] time2 ;
	  	// Vector time =new Vector();

//	  	int time2[] = new int[60*24];
//	  	 
//	  	 for(int i=0;i<time2.length;i++) {
//	  		 
//	  		time2[i]=0;
//	  		 
//	  	 }
//	  	
//	  	 String s = Arrays.toString(time2);
	  	 
//	  	 int starthour=starttime1.getHours();
//    	 int endhour=endtime1.getHours();
//
//    	 for(int i =0;i<endhour-starthour;i++){
//    	 
//    		 time.add(starthour,1);
//    		 
//    	 }
    	 
    	 
    	 //System.out.println("starthour:"+starthour+"endhour"+endhour +"time"+time);
	  	  //	  	  List<queryBook> qbList= new ArrayList();
//	    	//先查询所有资源的预定情况
	  	  
	  	  
	  	  
	  	 if(starttime.compareTo(endtime)>0) {
	  		  resultRtn.errCode = 301;
			  resultRtn.msg="starttime 大于 endtime，参数不对 ";
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\"")); 
	  		 
	  		 
	  	 }
	  	 
	  	 
	  	Optional<Res> res1= 
				  ebeanServer.find(Res.class).where().eq("resid", resid)
				                                      .findOneOrEmpty();
	  	 
	  	 if(!res1.isPresent()) {
				
			 //company = company1.get();
			  resultRtn.errCode = 304;
			  resultRtn.msg="此资源不存在或者不可用";
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
		  }	  
	  	
	  	
	  	 if(starttime.compareTo(res1.get().starttime) < 0 || endtime.compareTo(res1.get().endtime)>0) {
	  		 
	  		  resultRtn.errCode = 702;
			  resultRtn.msg="该时间段不可用,超过资源边界";
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
	  		 
	  		 
	  	 }
	  	 
	  	 
	  	if(res1.get().status!=1) {
	  		 
	  		  resultRtn.errCode = 703;
			  resultRtn.msg="该资源状态异常，目前无法预定";
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
	  		 
	  		 
	  	 }
	  	 
	  	 Optional<Book> book1= 
				  ebeanServer.find(Book.class).where().eq("resid.resid", resid) 
				                                      //.eq("bookdate", sdf1.parse(bookdate))
				                                 .or()
				  									.and()
				  									  .lt("starttime", starttime)
				  									  .gt("endtime", starttime)
				  									.endAnd()
				  									.and()
				  									  .lt("starttime", endtime)
				  									  .gt("endtime", endtime)
				  									.endAnd() 
				  									.and()
				  									  .ge("starttime", starttime)
				  									  .le("endtime", endtime)
				  									.endAnd() 
				  								.endOr()    
				  								.findOneOrEmpty();
	  	  
	  	 if(book1.isPresent()) {
				
			 //company = company1.get();
			  resultRtn.errCode = 701;
			  resultRtn.msg="该时间段已被预定";
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
		  }	 
	  	 
	  	// res1.get().d12="111";
	  	 
	  	// res1.get().save();
	  	 
	  	Book nbook =new Book();
	  	nbook.comid = res1.get().comid;
	  	nbook. wxid =wxid;
	  	nbook. starttime =starttime;
	  	nbook. endtime =endtime;
	  	nbook. name =name;
	  	nbook. tel =tel;
	  	nbook. title =title;
	  	nbook. des =des;
	  	nbook.bookid = "B"+System.currentTimeMillis();
	  	nbook.resid =res1.get();
	  	nbook.status =1;
	  	nbook.save();
	  	
	   	 return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));	  
	    	
    }
	    
    public Result   queryBooked(String comid,String startdate,String enddate)   
    {
  	 
  	  ResultRtn resultRtn = new ResultRtn();
        resultRtn.errCode = 0;
  	  resultRtn.msg="ok";
  	  
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
	  
	  if(wxid==null) {
 		 
 		 resultRtn.errCode = 901;
			 resultRtn.msg="wxid 为空";
			  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\"")); 
 		 
 	 }
		
	  
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
	  List<Book> bookList= new ArrayList();
	  
	  List<queryBook> qbList= new ArrayList();
	  
	  
	  if(flag==2) {
		  
		    bookList= 
				  ebeanServer.find(Book.class)   //.fetch("Res.comid.name")
				                                  .fetch("resid")
				                                      .where().eq("wxid", wxid)
				  									  .eq("status", status)
                                                       .between("bookdate", startdate1, enddate1)  
				                                       .findList();
		    
	  }else if(flag==1) {
		  
		  bookList= 
				  ebeanServer.find(Book.class)   //.fetch("Res.comid.name")
				                                  .fetch("resid")
				                                      .where().eq("comid.wxid", wxid)
				  									  .eq("status", status)
                                                       .between("bookdate", startdate1, enddate1)  
				                                       .findList();
		  
		  
	  }
			 
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
		    
	  
	  
	  if(bookList.size()==0) {
		  resultRtn.errCode = -1;
		  resultRtn.msg="没有符合条件的记录 ";
		  
	  }
	  resultRtn.business.put("book", qbList);
	  return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));	  
	  
  }
  
  
}
