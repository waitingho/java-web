/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

import uuu.vgb.entity.Student;

/**
 *
 * @author heweiting
 */
public class TestStudent {
    public static void main(String[] args) {
        Student bob = new Student();
        bob.name = "Bob";
        bob.age = 16;
        Student jian = bob;
//        jian.name = "Jian";
        
        System.out.println(bob.name);
    }
}
