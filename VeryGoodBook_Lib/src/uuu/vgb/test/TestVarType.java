/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

/**
 *
 * @author heweiting
 */
public class TestVarType {
     public static void main(String[] args) {
        byte a;
        short b ;
        int c;
        long d;
        
        //整數類
        a = 123;//10進位
        b = 011;//8進位
        c = 0x1_000_000;//16進位
        d = 0b010110;
         System.out.println("a = " + a);
         System.out.println("byte的範圍" + Byte.MIN_VALUE+ "~"+ Byte.MAX_VALUE);
         
         System.out.println("b = " + b);
         System.out.println("shortㄉ範圍" + Short.MIN_VALUE+"~"+Short.MAX_VALUE);
         
         System.out.println("c = " + c);
         System.out.println("int範圍" + Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
         
         System.out.println("d = " + d);
         System.out.println("longㄉ範圍"+Long.MIN_VALUE+"~"+Long.MAX_VALUE);
         
         String s = "wwwwwwww";
         System.out.println(s.length());
         
         //浮點數類
         float f = 1.0f - 0.8f;  //IEEE 754
         System.out.println("f = " + f);
         System.out.println("float的範圍"+Float.MIN_VALUE+"~"+Float.MAX_VALUE);
         
         //文字類
         char char1 = '1';
         char char2 = '貳';
         char char3 = '?';
         System.out.println(char1);
         System.out.println(char2);        
         System.out.println(char3);   
         
         //邏輯類
         boolean married = 100<3;
         System.out.println(married);
    }
}
