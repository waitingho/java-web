/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod14.test;

import java.util.Arrays;

/**
 *
 * @author Patty Tai
 */
public class TestArray {

    public static void main(String[] args) {
        int a[] = new int[3]; //a:one-dimension int array
        int[] b[], c[][];//b:two-dimension int array, c: three-dimension int array

        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] = " + a[i]);
            a[i] = i + 1;
            System.out.println(" -> " + a[i]);
        }

        char[] charArray[] = new char[3][2];
        a[0] = charArray[0][0];
        System.out.println("a[0]:" + a[0]);

        b = new int[3][2];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println("b[" + i + "][" + j + "]=" + b[i][j]);
            }
        }

        System.out.println("*************************************************");
        b = new int[3][];
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i] != null ? b[i].length : null);
        }

        b[0] = a;
        b[1] = new int[2];
        b[2] = new int[3];
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                for (int j = 0; j < b[i].length; j++) {
                    System.out.println("b[" + i + "][" + j + "]=" + b[i][j]);
                }
            }
        }

        c = new int[2][][];
        c[0] = b;
        c[1] = new int[2][];
        c[1][0] = new int[3];
        c[1][1] = new int[0];

        String[] strs = new String[3];
        for (int i = 0; i < strs.length; i++) {
            System.out.println("strs[" + i + "]=" + strs[i]);
            strs[i] = "Test" + i;
            System.out.println("strs[" + i + "]=" + strs[i]);
        }

        ///demo: 初始化陣列元素
        int[] grades = new int[]{85, 70, 58};

        //demo: Arrays.toString()
        System.out.println("a.toString(): "+ Arrays.toString(a));//java.util.Arrays, a:[0,2,3]
        System.out.println("b.toString(): "+ Arrays.deepToString(b));//java.util.Arrays
        
        //demo: 改變陣列的大小(舊方法)
        int[] newA = new int[a.length-1];//newA:[0,0]
        System.arraycopy(a, 0, newA, 0, newA.length<=a.length?newA.length:a.length);
        System.out.println("newA.toString(): "+ Arrays.toString(newA));//java.util.Arrays, newA:[0,2,3, 0]

        //demo: 改變陣列的大小(新方法)
        int[] newA2 = Arrays.copyOf(a, a.length+1);
        System.out.println("newA2.toString(): "+ Arrays.toString(newA2));//java.util.Arrays, newA2:[0,2,3, 0]
        Arrays.sort(newA2);
        System.out.println("newA2.toString(): "+ Arrays.toString(newA2));//java.util.Arrays, newA2:[0,0,2,3]
        
        
        //以下示範參考型別陣列的指派
        Object[] objs = new Object[3];
        objs[0] = 1;
        objs[1] = 0.2;
        objs[2] = 100L;
//        objs = new Number[3];        
        objs[2] = "String";  //若objs參考到new Number[3], 會發生Unchecked Exception: ArrayStoreException
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i].getClass().getName());
        }

        //考古題測試 mod14, part I, Q3: 
        int[][] array = {{0}, {0, 1}, {0, 2, 4}, {0, 3, 6, 9}, {0, 4, 8, 12, 16}};
        System.out.println(array[4][1]);
//        System.out.println(array[1][4]);//執行時期會發生:Unchecked Exception: ArrayIndexOutOfBoundsException: 4
    }
}
