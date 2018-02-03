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
public class Truck extends Vehicle {
    public Truck(double MAX_LOAD) {
        super(MAX_LOAD);
    }

    @Override
    public double getCost(int year, int month) {
        return 50000;
    }    
}
