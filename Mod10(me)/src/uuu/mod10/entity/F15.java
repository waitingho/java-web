/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod10.entity;

/**
 *
 * @author Administrator
 */
public class F15 extends Vehicle implements Flyer,Fighter{

    public F15(double MAX_LOAD) {
        super(MAX_LOAD);
    }

    @Override
    public double getCost(int year, int month) {
        return 300_0000;
    }

    @Override
    public void tafeoff() {
         System.out.println("F15 正在起飛");
    }

    @Override
    public void fly() {
        System.out.println("F15 flying");
    }

    @Override
    public void land() {
         System.out.println("F15 在降落");
    }

    @Override
    public void fight() {
        System.out.println("F15 fight");
    }
    
}
