/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.mod11.test;

import uuu.mod11.entity.MyStatic;

/**
 *
 * @author Patty Tai
 */
public class TestMyStatic {
    static int i = 100;
    public static void main(String[] args) {   
        System.out.println(i);
        System.out.println(MyStatic.getI()); //123
        MyStatic.setI(100);
        
        MyStatic obj1 = new MyStatic();
        System.out.println(obj1.getI());//100
        System.out.println(obj1.getJ());//0
        obj1.setI(200);
        obj1.setJ(200);
        System.out.println(obj1.getJ());//200
        
        MyStatic obj2 = new MyStatic();
        System.out.println(obj2.getI());//200
        System.out.println(obj2.getJ());//0
        
    }
}
