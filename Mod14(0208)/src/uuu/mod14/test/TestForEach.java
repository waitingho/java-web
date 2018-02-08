/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod14.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patty Tai
 */
public class TestForEach {

    public static void main(String[] args) {
        int a[] = {45, 67, 33, 21, 9};
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }

//        List<Integer> a = new ArrayList<>(); 
//        a.add(45);a.add(67);a.add(33);a.add(21);a.add(9);
//        for(int i=0;i<a.size();i++){
//            System.out.println("a["+i+"] = " + a.get(i));
//        }

        for (int data : a) {  //:右邊:陣列或集合, :左邊必須依據陣列或集合(List, Set)中元素型別宣告一個新的block變數
            System.out.println("data: " + data);
        }

    }
}
