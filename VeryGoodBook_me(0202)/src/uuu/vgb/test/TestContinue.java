/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

/**
 *
 * @author Administrator
 */
public class TestContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            
                if(i%3 == 0){
                    continue;
                }
                System.out.println(" i= " + i);
        }
        loop1:
        for(int x = 1;x<10;x++){
            loop2:
            for(int y = 1;y<10;y++){
                System.out.print(x+"*"+y+"="+x*y+(y<9?",\t":"\n"));
                if(x==y){
                    System.out.println();
                    continue loop1;
                }
            }
        }
    }
    
}
