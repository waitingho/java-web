/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod11.test;

import uuu.mod11.entity.Mystatic;

/**
 *
 * @author Administrator
 */
public class TestMyStatic {
    static int i =100;
    public static void main(String[] args) {
        
        System.out.println(Mystatic.getI());//0
        Mystatic.setI(100);
        
        Mystatic obj1 = new Mystatic();
        System.out.println(obj1.getI());
        System.out.println(obj1.getJ());
        obj1.setI(200);
        obj1.setJ(200);
        System.out.println(obj1.getJ());
        
        Mystatic obj2 = new Mystatic();
        System.out.println(obj2.getI());
        System.out.println(obj2.getJ());
    }
}
