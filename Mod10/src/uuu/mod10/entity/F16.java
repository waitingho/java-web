/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.mod10.entity;

/**
 *
 * @author Patty Tai
 */
public class F16 extends Vehicle implements FighterII{

    public F16(double MAX_LOAD) {
        super(MAX_LOAD);
    }

    @Override
    public double getCost(int year, int month) {
        return 350_0000;
    }

    @Override
    public void fly(int speed) {
        System.out.println(this.getClass().getSimpleName() 
                + "以時速" + speed + "km在飛行");
    }

    @Override
    public void takeOff() {
        System.out.println(this.getClass().getSimpleName() + "正在起飛");
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName()+"在飛行");
    }

    @Override
    public void land() {
        System.out.println(this.getClass().getSimpleName()+"在降落");
    }

    @Override
    public void fight() {
        System.out.println(this.getClass().getSimpleName()+"在作戰");
    }

}
