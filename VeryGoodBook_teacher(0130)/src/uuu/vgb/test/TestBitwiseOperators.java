/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

/**
 *
 * @author Administrator
 */
public class TestBitwiseOperators {
    public static void main(String[] args) {
        byte a = 3, b = 5;
        int r1, r2;
        System.out.println(r1=a & b);//1
        System.out.println(r2=a | b);//7
        
       // System.out.println(a|(b+a)&b);//3
        
        System.out.println(a ^ b);//6
        System.out.println(~a);//-4+1
        
        char c='3', d='5';
        int rtn = c & a;
        System.out.println(rtn);//3
        System.out.println(c | a);//31
        System.out.println(c ^ a);//48
        
        int i = 15; 
        System.out.println(Integer.toBinaryString(i));//00000000000...1111
        System.out.println(i >> 2); //000...011 , 15/4 = 3
        System.out.println(i << 1); //011110, 15*2=30
        
        i = -15;
        System.out.println(Integer.toBinaryString(i));//111111111...0001
        System.out.println(i >> 2); //11111111111...00 , -15/4 = -4
        System.out.println(i << 1); //1111111...000100, -15*2=-30
        
        char c1 = 65535;
        System.out.println(c1 >> 1);
         
        a = -3;//1111111.101
        System.out.println(a>>>1);        
    }
}
