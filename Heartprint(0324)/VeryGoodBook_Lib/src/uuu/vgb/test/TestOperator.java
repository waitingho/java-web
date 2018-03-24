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
public class TestOperator {
    public static void main(String[] args) {
        
        int i = 32;
        i = i<<2;
        System.out.println("i = " + i);
    
        i=-32;
        i>>=2;
        System.out.println("i = " + i);
        
        
        //三元運算子
        int grate = 55;
        char a = (grate>=65?'A':'D');//第一個是布林值 第二個是true 第三個是false
        System.out.println(a);
        
        int uniPrice = 40;
        double price = uniPrice > 100 ? 99.5 : 50;
        System.out.println("price = " + price);
        
        Object price2 = (uniPrice > 100)?"99.5":50;//autoboxing, polymorphism
        System.out.println(price2);
        
        
    }
    
         
    
}
