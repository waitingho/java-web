/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.VIP;

/**
 *
 * @author Administrator
 */
public class TestEqualsOperator {

    public static void main(String[] args) {
        try {
            int i = 1;
            double j = 1;
            System.out.println(i == j);//true
            System.out.println(i != j);//false
            System.out.println(1 != '1');//true
            
            boolean b1 = true;
            boolean b2 = false;
            System.out.println(b1 == b2);//false
            System.out.println(b1 != b2);//true
            
//        Customer c1 = new Customer("A123456789", "張三豐", "123456");
Product p1 = new Product(1, "mouse", 0.3);
double k = 0.1+0.1+0.1;
Product p2 = new Product(1, "mouse", k);

System.out.println(p1 == p2); //false, p1, p2沒有參考到同一個物件
System.out.println("p1.equals(p2): " + p1.equals(p2)); //true, 已經override Product類別的equals(id, name, unitPrice)

p2 = p1;
System.out.println(p1 == p2); //true, p1, p2有參考到同一個物件(第28行建立的物件)
System.out.println(p1.equals(p2));//true

Outlet o1 = new Outlet(1, "mouse", 200);
System.out.println("p1.price:" + p1.getUnitPrice());//200
System.out.println("o1.price:" + o1.getUnitPrice());//180
System.out.println(p1 == o1); //false
System.out.println(p1.equals(o1));//true

Customer c1 = new Customer("A123456789", "張三豐", "123456",
        'M', "test123@gmail.com");

Customer c2 = new Customer("A123456789", "張三豐", "666666",
        'M', "test123@gmail.com");

VIP v = new VIP("A123456789", "張三豐", "123456",
        'M', "test123@gmail.com", 20);

System.out.println(c1==c2); //false
System.out.println(c1.equals(c2)); //true
System.out.println(c1==v); //false
System.out.println(c1.equals(v)); //true
        } catch (VGBException ex) {
            Logger.getLogger(TestEqualsOperator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
