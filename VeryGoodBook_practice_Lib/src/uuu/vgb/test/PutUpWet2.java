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
class PutUpWet2 {
    static String s = "" ;
    static void doIt(long x){s +="L ";}
    static void doIt(Integer x){s += "I ";}
    static void doIt(Object x){s+="O ";}
    public static void main(String[] args) {
        int x = 1;
        Integer ia[] = {1,2};
        doIt(x);
        doIt(ia);
        System.out.println(s);
        
    }
}
