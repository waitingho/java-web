/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import uuu.vgb.entity.Product;

/**
 *
 * @author heweiting
 */
public class TestEqualsOperator {
    public static void main(String[] args) {
        int i = 1;
        double j = 1;
        System.out.println(i == j);
        System.out.println(i != j);
        System.out.println(1 != '1');
        System.out.println('1');
        
        boolean b1 = true, b2 = false;
        System.out.println(b1==b2);
        System.out.println(b1!=b2);
        
        Product p1 = new Product(1,"mouse",200);
        Product p2 = new Product(1,"mouse",200);
        
        System.out.println(p1 == p2);
        
        p1 = p2;
        
        System.out.println(p1==p2);
        
    }
}
