package tools;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

public class formatTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//format1();
		format1();
		try {
			test();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void format1(){
		
		String t="wxid:String,name:String,tel:String,com:String,userInfo:String ";
		String t1[]=t.split(",");
		StringBuffer re=new StringBuffer();
		for(int i=0; i<t1.length;i++) {
			String t2[]= t1[i].split(":");
			String t3  = t2[1]+" "+t2[0];
			
			re.append(t3+",");
		}
		
		System.out.println(re);
		
		
	}
	
	
	public static void format2(){
		
		String t="wxid、resid、bookdate、starttime、endtime、name、tel、title、des";
		String t1[]=t.split("、");
		StringBuffer re=new StringBuffer();
		for(int i=0; i<t1.length;i++) {
			//String t2[]= t1[i].split(":");
			String t3  = "String " + t1[i]+";";
			
			re.append(t3+"\n");
		}
		
		System.out.println(re);
		
		
	}
	
	
	public String addBinary(String a, String b){
		BigInteger decimalValue_a = new BigInteger(a, 2); //2是二进制，默认是十进制
		BigInteger decimalValue_b = new BigInteger(b, 2);
		BigInteger sum = decimalValue_a.add(decimalValue_b);
		String str = sum.toString(2);
		return str;
	}

	
	public static void test() throws ParseException{
		
	String 	starttime ="11:30";
	String 	endtime ="15:30";
	 SimpleDateFormat sdf1 =   new SimpleDateFormat( "yyyyMMdd" );
     
     SimpleDateFormat sdf2 =   new SimpleDateFormat( "HH:mm" );
     
     SimpleDateFormat sdf3 =   new SimpleDateFormat( "HH:mm" );
     
  	 Date starttime1 =sdf2.parse(starttime);
  	 Date endtime1 =sdf2.parse(endtime);
  	 
  	 int [] time = new int[24] ;
  	 int time2[] = new int[60*24];
  	 
  	 for(int i=0;i<time2.length;i++) {
  		 
  		time2[i]=0;
  		 
  	 }
  	
  	 String s = Arrays.toString(time2);
  	 int starthour=starttime1.getHours();
	 int endhour=endtime1.getHours();

	 for(int i =0;i<endhour-starthour;i++){
	 
		 time2[starthour+i]=1;
	//	 time1.setCharAt(starthour+i, '1');
	 }
	 
	 System.out.println("starthour:"+starthour+"endhour"+endhour +"time"+s);
	}

}
