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
public class TestNatural {
    private int i;
    void disp(){
        while(i<=5){
            for(int i = 1;i<=5;){
                System.out.println(i+" ");
                i++;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        new TestNatural().disp();
    }
}
