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
public class X {
    static void m(StringBuilder sb1){
        sb1.append("er");
    }
    public static void main(String[] args) {
        StringBuilder sb2 = new StringBuilder("Moth");
        m(sb2);
        System.out.println(sb2);
    }
}
