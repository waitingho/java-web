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
public class Access {
    private int x = 0;
    private int y = 0;
    public static void main(String[] args) {
        Access accApp = new Access();
        accApp.printThis(1,2);
        accApp.printThat(3,4);
        
    }
    
    public void printThis(int x, int y){
        x = x;
        y = y;
        System.out.println("x:" + this.x + ", y:" + this.y);
    }
    
    public void printThat(int x, int y){
        this.x = x;
        this.y = y;
        System.out.println("x:" + this.x + ", y:" + this.y);
    }
}
