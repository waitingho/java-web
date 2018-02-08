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
public class TestOperators {
    public static void main(String[] args) {
        System.out.println(1+2);//3
        System.out.println('1'+ '2');//49+50
        System.out.println("1"+2);//12
        System.out.println(1/2);//0
        System.out.println(1/2D);//0.5
        System.out.println(100000*20000000);
        System.out.println(100000L*20000000);
        
        int i = 1;
        System.out.println(i++);//1
        System.out.println(--i);//1
        
        i = 128^5;
        System.out.println(i);
        i >>= 3;
        System.out.println(i);
        i>>>=5;
        System.out.println(i);
        
        System.out.println("result:"+ 2 + 3 + 5);
        
        
        int n = 25;
        int m = ++n +1;
        
        System.out.println(m);
        
        int a = 1;
//        a++;
        System.out.println(a);
//        System.out.println(a++);
        
        boolean rtn = (++a == 2);
        System.out.println(rtn);
        
        a=127;
        a++;
        System.out.println(a);
        
        short k = 32767;
//        k++;
        System.out.println(k++);
        System.out.println(k);
        System.out.println(k--);
        System.out.println(--k);
        
        //指派運算子
        
        byte n1=1 ,n2 = 2;
        System.out.println(n1 += 100-n2/4);//101
        
        System.out.println(1+(true+(0.5+"Hello")));//1true0.5Hello
        
        //字串運算子
        
       String s = "Hello";
       s+= "World";
        System.out.println(s);
        
        //三元運算子
        
        k = 123_4;
        boolean test;
        
        float t = ((test = false)?1:2.0f);
        System.out.println(t);
        System.out.println((test = false)?1:2.0);
        
        String str = ((test=false)?String.valueOf('k'):"M");
        System.out.println(str);
        
        
        int f = 5;
//        f++;
        System.out.println(2%2);
    }
}
