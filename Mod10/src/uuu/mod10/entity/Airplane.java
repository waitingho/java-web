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
public class Airplane extends Vehicle implements Flyer{
    public Airplane(double MAX_LOAD) {
        super(MAX_LOAD);
    }

    @Override
    public double getCost(int year, int month) {
        return 100_0000;
    }

    @Override
    public void takeOff() {
        System.out.println("飛機正要起飛");
    }

    @Override
    public void fly() {
        System.out.println("飛機正在飛行");
    }

    @Override
    public void land() {
        System.out.println("飛機正要降落");
    }    
}
