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
public class TestMyfor {

    public static void main(String[] args) {
        for (int ii = 0; ii < 4; ii++) {
            System.out.println("ii=" + ii);
            ii = ii + 1;
            System.out.println("********");
        }
        int i = 1;
        int j = 5;
            do {
                System.out.println((i++) + ":" + (--j));

        }   while ((i < 5) || (j > 0));
    }

}
