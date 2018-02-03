/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Administrator
 */
public class TestEqualsOperator {
    public static void main(String[] args) {
        int i = 1;
        double j = 1;
        System.out.println(i==j);//true
        System.out.println(i!=j);
        System.out.println(1!='1');
        
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1==b2);
        System.out.println(b1!=b2);
        
        Product p1 = new Product (1,"mouse",200);
        Product p2 = new Product (1,"mouse",200);
        System.out.println(p1==p2);//兩個new 兩個是不同的物件所以是false
        System.out.println(p1.equals(p2));//true 已經override Product 類別的equals (id,name,unitPrice)
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        p2 = p1;//把p1的物件指派給p2 所以兩個是同個物件 p2的物件變成垃圾
        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));
        
        Customer c1 = new Customer("A123456789","安安","123456",'M',"eee@eee.ee");
        Customer c2 = new Customer("A123456789","安安","123456",'M',"eee@eee.ee");
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));
        
        VIP v = new VIP("A123456789","安安","123456",'M',"eee@eee.ee",20);
        
        System.out.println(c1 == v);
        System.out.println(c1.equals(v));
        
        System.out.println("----------------------");
        
        Outlet o1 = new Outlet(1,"mouse",20);
        System.out.println("p1.price:"+ p1.getUnitPrice());
        System.out.println("o1.price:"+o1.getUnitPrice());
        System.out.println(p1==o1);
        System.out.println(p1.equals(o1));
    }
    
}
