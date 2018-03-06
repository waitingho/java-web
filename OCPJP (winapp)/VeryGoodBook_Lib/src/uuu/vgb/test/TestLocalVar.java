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
public class TestLocalVar {
    public static void main(String[] args) {
        int i=0, j=0;
        if(j==0){
            i=1;            
        }else if(j!=0){
            i=2;            
        }
        System.out.println(i);
    }
}
