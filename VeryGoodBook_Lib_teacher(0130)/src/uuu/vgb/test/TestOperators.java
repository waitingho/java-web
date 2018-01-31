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

        i = 32;
        i = (i << 2);
        System.out.println("i = " + i); //128

        i = 32;
        i >>= 2; //   i = (int)(i>> 2)
        System.out.println("i = " + i);//8

        i = -32;
        i >>= 2; //   i = (int)(i>> 2)
        System.out.println("i = " + i);//-8

        i = 32;
        i >>>= 2; //   i = (int)(i>> 2)
        System.out.println("i = " + i);//8

        i = -32;
        i >>>= 2; //   i = (int)(i>> 2)
        System.out.println("i = " + i);//1073741816

        //三元運算子
        int grade = 55;
        char a = (grade >= 60 ? 'A' : 'D');
//        if(grade>=60){
//            a = 'A';
//        }else{
//            a = 'D';
//        }
        System.out.println(a);

        int unitPrice = 200;
        double price = unitPrice > 100 ? 99.5 : 50;
        System.out.println("price = " + price);        
        
        Object price2 = unitPrice > 100?"99.5元":50;//autoboxing, polymorphism
        System.out.println(price2);

    }
}
