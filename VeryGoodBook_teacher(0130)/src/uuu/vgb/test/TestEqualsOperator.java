/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;

/**
 *
 * @author Administrator
 */
public class TestEqualsOperator {
    public static void main(String[] args) {
        int i = 1;
        double j = 1;
        System.out.println(i==j);//true
        System.out.println(i!=j);//false
        System.out.println(1!='1');//true
        
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1==b2);//false
        System.out.println(b1!=b2);//true
        
//        Customer c1 = new Customer("A123456789", "張三豐", "123456");
        Product p1 = new Product(1, "mouse", 200);
        Product p2 = new Product(1, "mouse", 200);
        
        System.out.println(p1==p2); //false
        System.out.println(p1.equals(p2)); //false, 尚未override Product類別的equals
        
        p2 = p1; 
        System.out.println(p1==p2); //true
        System.out.println(p1.equals(p2));//true
    }
}
