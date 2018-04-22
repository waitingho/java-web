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
public class TestBreak {

    public static void main(String[] args) {
        int i = 1;
        for (;;) {
            System.out.println(i);
            if (i == 1) {
                break;
            }
        }

        System.out.println("The End");
        
        http://www.uuu.com.tw
        for (int x = 1; x < 10; x++) {

            loop2:
            for (int y = 1; y < 10; y++) {
                System.out.print(x + "*" + y + "=" + x * y + (y < 9 ? ",\t" : "\n"));
                if (x == y) {
                    System.out.println();
                    break;
                }
            }
        }

    }
}
