package controllers;

import play.db.ebean.EbeanConfig;
import play.libs.Json;
import models.ResultData;
import models.User;
import models.User1;
import models.ResultData.MystockView;
import models.Admin;
import models.Book;
import models.Company;
import models.User_stock_r;
import play.mvc.Controller;
import play.mvc.Result;
import repository.DatabaseExecutionContext;
import util.AESCBCUtil_old;
import util.AesCbcUtil;
import util.HttpRequest;
import util.HttpRequest2;
import util.ResultRtn;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;

import io.ebean.Ebean;
import io.ebean.EbeanServer;





public class CUtil extends Controller {
	
	
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
		
				
				
				String encryptedData2="CH0TLWUYa%2BCm7jbHIR%2Bksfs9Yl9gcw%2FjzbDKy4Iu%2F6Q3bFPrsVdN7BhFViD0WgZrxFU4S1pFDPTgK6YAoPmGNCGDxCF3kWJ6RXgmCPHjyHMqiWq3%2BHy6bi01lVataLrwMbFvTQOhVj%2FBua%2FpDr1tQftp0vFUAOdqaTbyCoJ3p%2B9f5GM%2FQyiOm2TPPWaXJAMQ3I14zNhYJdhAsZ5Gs7D23jPv5qYwY%2FCH8e7BHQsSOYbZl3G%2FjwTpxRCsaU32B2e4%2FUYOJdmThaX69K3d%2FsDZ6ENm0%2B1DGOsZfrLMo64SvF1pPWzoDqJNRvgLOaVq%2BgsUdChbfD2MpMoZAUOdCpfJt5ym6f7VFjSFKAoxfevcd4uiSFFdb7zqLJSpGHq%2BtVBILZW4OrjklajeiU1tnuRhycBkBTGc94T1SxynH%2BvPQCGI7iFqIzj1vvXAkllfqw2ObVSCOST6e7EvixjmDdhTPilaXDt%2BvYJ7KkEEgqzEung%3D";
	 			//+ "&iv=RxleqHBN0LGF41vAYSFxAg%3D%3D&code=0712ge5028xBQT0FVM202wpd5022ge5l";
		
	 	
	 	String iv2="RxleqHBN0LGF41vAYSFxAg%3D%3D";
		String session_key1="n8GavmojeyfipP9oX96aMw==";
				
				
				String session_key2="C\\/KyyrZhxkDi1l9VJyTykA==";
				//System.out.println(getId1(encryptedData,iv,code));
				
				 try {
					 String iv=URLDecoder.decode(iv2, "UTF-8");
			    	 String encryptedData=URLDecoder.decode(encryptedData2, "UTF-8");
			    	 
			    	 //String session_key=URLDecoder.decode(session_key1, "UTF-8");
					 
					String result = AesCbcUtil.decrypt(encryptedData, session_key1, iv, "UTF-8");
					System.out.println("result" +result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
//		 //解析相应内容（转换成json对象）
//        JSONObject json;
//        String sr="{\"session_key\":\"C\\/KyyrZhxkDi1l9VJyTykA==\",\"openid\":\"oCLgA5VXuhQbIxCo7ss6TzDRAzeo\"}";
//        System.out.println("JSONObject"+ string2Json(sr));
//        String session_key="";
//        try {
//			json = new JSONObject( string2Json(sr));
//			 System.out.println("JSONObject"+ json);
//            //获取会话密钥（session_key）
//           session_key = json.getString("session_key");
//           
//           System.out.println("===>"+ session_key);
//        
//        }catch(Exception e) {}
//        
		// TODO Auto-generated method stub

	}
	

	private final EbeanServer ebeanServer;

    @Inject
    public CUtil(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
    }

	    /**
	     * An action that responds with the {@link Counter}'s current
	     * count. The result is plain text. This action is mapped to
	     * <code>GET</code> requests with a path of <code>/count</code>
	     * requests by an entry in the <code>routes</code> config file.
	     */

    public Result getId1() {
   	 
   	 System.out.println(this.request().uri());
    	ResultRtn resultRtn = new ResultRtn();
//        resultRtn.errCode = 0;
//		resultRtn.msg="ok";
		
 	String encryptedData1="e4pD3Lb%2FAVqlstXBgZMJNsup218gjAlXGwmnAQKCM3hbH8TOykV5TkByGQFihNUjHz3eTUACPDFqZhvFUutI5R%2FUzVYBQkiFb600nZux0mKOlKvrHcrltoMtX58LoRcvlTLZ2WeHhLoz0ZRJWxbp79%2BGj42PXlOxmqjjRGfb5oCpw5mjbX1M3nrCLK2HQCTgeb%2B06BCJwTFxczYMFluUfD9N%2FXWxBhOx8lRSXmTkaSVGNKv81LmBv3hvfxgmwk7%2B2IngBpbWwmGitchyrecBn9E6OvulSLshyEfaT3GoHYKsSuy7lqQ5mfxLQA%2FQR1R6WTMUjqJThn%2FK6GRTCRU%2Bi1eNLI4AeJLhlKBCq36Nl%2F3kRfu342210UplvNO2uXdYGw1CxbB51R6PoPOySbZm6VerYc7G47cLzyfPj21boiTfeBcI59YR9gzfEg%2B1J7LxgXvnGI7CMwL3gYl9tDKpVZ71o6KO6I45SFytCCbKPdE%3D";
	
 	String encryptedData2="CH0TLWUYa%2BCm7jbHIR%2Bksfs9Yl9gcw%2FjzbDKy4Iu%2F6Q3bFPrsVdN7BhFViD0WgZrxFU4S1pFDPTgK6YAoPmGNCGDxCF3kWJ6RXgmCPHjyHMqiWq3%2BHy6bi01lVataLrwMbFvTQOhVj%2FBua%2FpDr1tQftp0vFUAOdqaTbyCoJ3p%2B9f5GM%2FQyiOm2TPPWaXJAMQ3I14zNhYJdhAsZ5Gs7D23jPv5qYwY%2FCH8e7BHQsSOYbZl3G%2FjwTpxRCsaU32B2e4%2FUYOJdmThaX69K3d%2FsDZ6ENm0%2B1DGOsZfrLMo64SvF1pPWzoDqJNRvgLOaVq%2BgsUdChbfD2MpMoZAUOdCpfJt5ym6f7VFjSFKAoxfevcd4uiSFFdb7zqLJSpGHq%2BtVBILZW4OrjklajeiU1tnuRhycBkBTGc94T1SxynH%2BvPQCGI7iFqIzj1vvXAkllfqw2ObVSCOST6e7EvixjmDdhTPilaXDt%2BvYJ7KkEEgqzEung%3D";
 			//+ "&iv=RxleqHBN0LGF41vAYSFxAg%3D%3D&code=0712ge5028xBQT0FVM202wpd5022ge5l";
	
 	
 	String iv1="=RxleqHBN0LGF41vAYSFxAg%3D%3D";
	String code1="071Gw0iQ1N3tz21vwYiQ1KgfiQ1Gw0iH";
	String session_key1="n8GavmojeyfipP9oX96aMw==";
	//System.out.println(getId1(encryptedData,iv,code));
	String result ="";
	 try {
		 String iv=URLDecoder.decode(iv1, "UTF-8");
    	 String encryptedData=URLDecoder.decode(encryptedData1, "UTF-8");
    	 
    	 String session_key=URLDecoder.decode(session_key1, "UTF-8");
		 
		 result = AesCbcUtil.decrypt(encryptedData, session_key1, iv, "UTF-8");
		System.out.println("result" +result);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}    
			  
		resultRtn.business.put("Id", result); 
		//System.out.println("http send"+ Json.toJson(result).toString().replaceAll("null", "\"\""));	
    	return ok(Json.toJson(resultRtn).toString().replaceAll("null", "\"\""));
    	
    }//end login
         
         
         public Result getId_decode(String encryptedData, String iv, String code) {
        	 
        	 System.out.println(this.request().uri());
//        	ResultRtn resultRtn = new ResultRtn();
// 	        resultRtn.errCode = 0;
// 			resultRtn.msg="ok";
 			
 			Map remap=decodeUserInfo( encryptedData,  iv,  code);	    
				  
 // 		resultRtn.put("Id", remap); 
 			System.out.println("http send"+ Json.toJson(remap).toString().replaceAll("null", "\"\""));	
 	    	return ok(Json.toJson(remap).toString().replaceAll("null", "\"\""));
         	
 	    }//end login
         
        
         public Result getId(String encryptedData, String iv, String code) {
        	 
        	 System.out.println(this.request().uri());
//        	ResultRtn resultRtn = new ResultRtn();
// 	        resultRtn.errCode = 0;
// 			resultRtn.msg="ok";
        	  //登录凭证不能为空
            
             
           //小程序唯一标识   (在微信小程序管理后台获取)
             String wxspAppid = "wx3d099e67aa7ff91b";
             //小程序的 app secret (在微信小程序管理后台获取)
             String wxspSecret = "e73e90677142d3796f08b216d7a50d41";
             //授权（必填）
             
             
             String grant_type = "authorization_code";


             //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
             //请求参数
             String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
             //发送请求
             
             String sr = HttpRequest2.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
             
             System.out.println("http send"+ params);
             
             System.out.println("http get"+ sr);
 	    	return ok(sr);
         	
 	    }//end login
         
        
 
         
         
 //        （服务端 java）自己的服务器发送code到微信服务器获取openid（用户唯一标识）和session_key（会话密钥），最后将encryptedData、iv、session_key通过AES解密获取到用户敏感数据
//
 //        a、获取秘钥并处理解密的controller（这里用的是springMVC）  
         
         /**
          * 解密用户敏感数据
          *
          * @param encryptedData 明文,加密数据
          * @param iv            加密算法的初始向量
          * @param code          用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和 session_key
          * @return
          */
       
         public Map decodeUserInfo(String encryptedData1, String iv1, String code) {

        	 Map map = new HashMap();

             //登录凭证不能为空
             if (code == null || code.length() == 0) {
                 map.put("status", 0);
                 map.put("msg", "code 不能为空");
                 return map;
             }

             //小程序唯一标识   (在微信小程序管理后台获取)
//             String wxspAppid = "xxxxxxxxxxxxxx";
//             //小程序的 app secret (在微信小程序管理后台获取)
//             String wxspSecret = "xxxxxxxxxxxxxx";
//             //授权（必填）
             
           //小程序唯一标识   (在微信小程序管理后台获取)
             String wxspAppid = "wx3d099e67aa7ff91b";
             //小程序的 app secret (在微信小程序管理后台获取)
             String wxspSecret = "e73e90677142d3796f08b216d7a50d41";
             //授权（必填）
             
             
             String grant_type = "authorization_code";


             //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
             //请求参数
             String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
             //发送请求
             
             String sr = HttpRequest2.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
             
             System.out.println("http send"+ params);
             
             System.out.println("http get"+ sr);
             //解析相应内容（转换成json对象）
             JSONObject json;
             String session_key="";
				
			 try {
				json = new JSONObject(string2Json(sr));
				 System.out.println("JSONObject"+ json);
             //获取会话密钥（session_key）
             session_key = json.getString("session_key");
             
             System.out.println("session_key"+ session_key);
             //用户的唯一标识（openid）
             String openid = (String) json.get("openid");
			
			 } catch (JSONException e1) {
				
				 System.out.println("JSONException"+ e1);
					// TODO Auto-generated catch block
					//e1.printStackTrace();
			 }
		
             //////////////// 2、对encryptedData加密数据进行AES解密其中包含这openid和unionid ////////////////
             try {
            	 
            	 String iv=URLDecoder.decode(iv1, "UTF-8");
    	    	 String encryptedData=URLDecoder.decode(URLEncoder.encode(encryptedData1, "UTF-8"), "UTF-8");
            	 
               //  String result = AESCBCUtil.decrypt1(encryptedData, session_key, iv, "UTF-8");
            	// String result = AESCBCUtil_old.decrypt2(encryptedData, session_key, iv, "UTF-8");
            	 //String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            	 String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
				 System.out.println("result" +result); 
            	 if (null != result && result.length() > 0) {
                     map.put("status", 1);
                     map.put("msg", "解密成功");

                    // JSONObject userInfoJSON = JSONObject.fromObject(result);
                     JSONObject userInfoJSON =new JSONObject(result);
                     Map userInfo = new HashMap();
                     userInfo.put("openId", userInfoJSON.get("openId"));
                     userInfo.put("nickName", userInfoJSON.get("nickName"));
                     userInfo.put("gender", userInfoJSON.get("gender"));
                     userInfo.put("city", userInfoJSON.get("city"));
                     userInfo.put("province", userInfoJSON.get("province"));
                     userInfo.put("country", userInfoJSON.get("country"));
                     userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                    // userInfo.put("unionId", userInfoJSON.get("unionId"));
                     map.put("userInfo", userInfo);
                     return map;
                 }
             } catch (Exception e) {
            	 System.out.println("AESCBCUtil"+ e);
             }
             map.put("status", 0);
             map.put("msg", "解密失败");
             return map;
         }         
         
         
         public Result getIdNew(String encryptedData1, String iv1, String code) throws JSONException {

			 Map map = new HashMap();
		
		     //登录凭证不能为空
		     if (code == null || code.length() == 0) {
		         map.put("errcode", 0);
		         map.put("errmsg", "code 不能为空");
		         map.put(" oid", "");
		         return ok(Json.toJson(map).toString().replaceAll("null", "\"\"")); 
		     }        
	 
	 
           //小程序唯一标识   (在微信小程序管理后台获取)
             String wxspAppid = "wx3d099e67aa7ff91b";
             //小程序的 app secret (在微信小程序管理后台获取)
             String wxspSecret = "e73e90677142d3796f08b216d7a50d41";
             //授权（必填）
             
             
             String grant_type = "authorization_code";


             //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
             //请求参数
             String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
             //发送请求
             
             String sr = HttpRequest2.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
             
             System.out.println("http send"+ params);
             
             System.out.println("http get"+ sr);
             //解析相应内容（转换成json对象）
             JSONObject json=new JSONObject(sr);
             String openid ="";
             String errcode ="0";
             String errmsg ="";
			 try {
				
			
             //获取会话密钥（session_key）
             //session_key = json.getString("session_key");
             //用户的唯一标识（openid）
              
			
              
               
                if(json.has("openid"))
                	openid = (String)json.get("openid");
                else {
                	openid = "";   
                	errcode =String.valueOf( json.get("errcode"));
                    errmsg = (String) json.get("errmsg");
                }
			 } catch (JSONException e1) {
				
				 System.out.println("JSONException"+ e1);
					// TODO Auto-generated catch block
					//e1.printStackTrace();
			 }
			 
			
			 
			 map.put("errcode", errcode);
	         map.put("errmsg", errmsg);
	         map.put("oid", openid);
	         return ok(Json.toJson(map).toString().replaceAll("null", "\"\""));  
		
			       
         
   }         
         
         
         
         public Result getId2(String encryptedData1, String iv1, String code) throws JSONException {

			 Map map = new HashMap();
		
		     //登录凭证不能为空
		     if (code == null || code.length() == 0) {
		         map.put("errcode", 0);
		         map.put("errmsg", "code 不能为空");
		         map.put(" oid", "");
		         return ok(Json.toJson(map).toString().replaceAll("null", "\"\"")); 
		     }        
	 
	 
           //小程序唯一标识   (在微信小程序管理后台获取)
             String wxspAppid = "wx964e02850dd92fc7";
             //小程序的 app secret (在微信小程序管理后台获取)
             String wxspSecret = "7dce83dea4fc15f52ca70bb8d10a7f5f";
             //授权（必填）
             
             
             String grant_type = "authorization_code";


             //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
             //请求参数
             String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type + "&connect_redirect=1";
             //发送请求
             
             String sr = HttpRequest2.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
             
             System.out.println("http send"+ params);
             
             System.out.println("http get"+ sr);
             //解析相应内容（转换成json对象）
             JSONObject json=new JSONObject(sr);
             String openid ="";
             String errcode ="0";
             String errmsg ="";
			 try {
				
				
			
             //获取会话密钥（session_key）
             //session_key = json.getString("session_key");
             //用户的唯一标识（openid）
              
               
                if(json.has("openid"))
                	openid = (String)json.get("openid");
                else {
                	openid = "";   
                	errcode =String.valueOf( json.get("errcode"));
                    errmsg = (String) json.get("errmsg");
                }
			 } catch (JSONException e1) {
				
				 System.out.println("JSONException"+ e1);
					// TODO Auto-generated catch block
					//e1.printStackTrace();
			 }
			 
//			 User1 user1=new User1();
//        	 user1.wxid =openid;
//        	 user1.name ="";
//        	 user1.tel ="";
//        	 user1.com ="";
//        	 user1.userinfo ="";
//        	 
//        	 user1.save();
			 
			 map.put("errcode", errcode);
	         map.put("errmsg", errmsg);
	         map.put("oid", openid);
	         map.put("sessionid", (String)json.get("session_key"));
	         return ok(Json.toJson(map).toString().replaceAll("null", "\"\""));  
		
			       
         
   }           
         
         /**
          * JSON字符串特殊字符处理，比如：“\A1;1300”
          * @param s
          * @return String
          */
         public static String string2Json(String s) {      
             StringBuffer sb = new StringBuffer();      
             for (int i=0; i<s.length(); i++) {
             	char c = s.charAt(i);  
             	 switch (c){
//             	 case '\':      
//                      sb.append("\\\"");      
//                      break;      
                  case '\\':      
                      sb.append("\\\\");      
                      break;      
                  case '/':      
                      sb.append("\\/");      
                      break;      
                  case '\b':      
                      sb.append("\\b");      
                      break;      
                  case '\f':      
                      sb.append("\\f");      
                      break;      
                  case '\n':      
                      sb.append("\\n");      
                      break;      
                  case '\r':      
                      sb.append("\\r");      
                      break;      
                  case '\t':      
                      sb.append("\\t");      
                      break;      
                  default:      
                      sb.append(c);   
             	 }
              }    
             return sb.toString();   
             }
           
         
         
}
