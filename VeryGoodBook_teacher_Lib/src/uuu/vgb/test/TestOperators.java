/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

/**
 *
 * @author Patty Tai
 */
public class TestOperators {

    public static void main(String[] args) {
        System.out.println(1 + 2); //3
        System.out.println('1' + '2'); //99
        System.out.println("1" + 2); //12
        System.out.println(1 / 2); //0
        System.out.println(1 / 2D); //0.5
        System.out.println(100000 * 20000000); //-1454759936
        System.out.println(100000L * 20000000); //2000000000000
        int i = 1;
        System.out.println(i++); //1, i:2
        System.out.println(--i);//i:1, 1
        
        System.out.println(~5); //-6
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(6 & 5); //4
        System.out.println(6 ^ 5);  //3
        System.out.println(6 | 5);//7
        i = 128 ^ 5;
        System.out.println(i);
        
        
        i >>= 3;
        System.out.println(i);
        i >>>= 5;
        System.out.println(i);
    }
}
