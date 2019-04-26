import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import controllers.CCommpay.ComView;

public class T1 {


	
	
	public static void main(String[] args) {
		List<Developer> listDevs = ComparatorTest.getDevelopers();

		System.out.println("排序前:");
		//JAVA8的写法，循环
		listDevs.forEach((developer)->System.out.println(developer));

		//第一个Lambda写法，JAVA8的写法
		//listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());

		//第二个Lambda写法，JAVA8的写法
		//listDevs.sort((o1, o2)->o1.getAge()-o2.getAge());

		// 第三个Lambda写法，JAVA8的写法
		listDevs.sort(Comparator.comparing(Developer::getAge));

		System.out.println("排序后:");
		//JAVA8的写法，循环
		listDevs.forEach((developer)->System.out.println(developer));		
		  
		  
		
       System.out.println("qqq");
	}

}
