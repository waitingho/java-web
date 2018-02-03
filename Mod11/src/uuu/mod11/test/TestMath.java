/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.mod11.test;

import static java.lang.Math.*;

/**
 *
 * @author Patty Tai
 */
public class TestMath {
    public static void main(String[] args) {
        System.out.println(round(5.3));
        System.out.println(round(7.6));
        
        long i = Math.round(5.3);
        int j = Math.round(5.3f);
        System.out.println("i = " + i);
        
        System.out.println(ceil(5.1));
    }
}
