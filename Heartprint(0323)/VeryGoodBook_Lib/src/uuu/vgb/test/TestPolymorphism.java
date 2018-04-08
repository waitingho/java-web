package uuu.vgb.test;

import java.time.LocalDate;

import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;

public class TestPolymorphism {

	public static void main(String[] args) {
		Object o1 = "hi";//多型宣告
		
//		System.out.println(o1.length());//length()在object中沒有定義
		System.out.println(((String)o1).length());//轉型為String後就有length()
		System.out.println(o1.getClass().getName());//java.lang.String
		System.out.println(o1.toString());//hi
		
                
                System.out.println("****************************");
		String s = "";//一般宣告
		
		
		Object o2 = new Product(1,"ipad",15000,50);//多刑型告
		
//		o2 = LocalDate.now();//多行指派
		
		
		System.out.println(o2.getClass().getName());
		System.out.println(o2.toString());
                
                System.out.println("********************************");
		
		Product p = new Outlet(2,"ipad",15000,5,35);
//		p.setDiscount(35);//setDiscount()在Product沒有意義
		
		System.out.println(p.getClass().getName()+":"+ p.getUnitPrice());
		System.out.println(p);

	}

}
