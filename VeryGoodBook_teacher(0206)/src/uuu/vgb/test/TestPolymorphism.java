package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.*;

public class TestPolymorphism {

	public static void main(String[] args) {
		Object o1 = "Hello"; //多型宣告		
//		System.out.println(o1.length()); //length()在Object沒有定義
//		o1 = new Object();
		System.out.println(((String)o1).length()); //轉型為String後就有length()
		System.out.println(o1.getClass().getName());//java.lang.String
		System.out.println(o1.toString()); //Hello
		
		String s = ""; //一般宣告
		
		Object o2 = new Product(1, "iPad Mini 4", 15000, 50);//多型宣告
		
		o2 = LocalDate.now();//多型指派
		
		System.out.println(o2.getClass().getName());//?
		System.out.println(o2.toString()); //?
		
		
		Product p = new Outlet(2, "iPad mini 2", 15000, 20, 35);//多型宣告
//		p.setDiscount(35); //setDiscount()在Product沒有定義		
		System.out.println(p.getClass().getName() + ":" + p.getUnitPrice()); //Outlet覆蓋後的getUnitPrice()
		System.out.println(p);
	}

}
