/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod10.test;

import uuu.mod10.entity.Airplane;
import uuu.mod10.entity.F15;
import uuu.mod10.entity.F16;
import uuu.mod10.entity.Fighter;
import uuu.mod10.entity.FighterII;
import uuu.mod10.entity.Flyer;
import uuu.mod10.entity.RiverBarge;
import uuu.mod10.entity.Truck;
import uuu.mod10.entity.Vehicle;

/**
 *
 * @author Patty Tai
 */
public class TestTruck {

    public static void main(String[] args) {
        Truck t = new Truck(2);
        System.out.println(t);

        RiverBarge r = new RiverBarge(10);
        System.out.println(r);

        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = t;
        vehicles[1] = r;
        vehicles[2] = new Airplane(3);
        vehicles[3] = new Truck(5);
        vehicles[4] = new F15(1);
        vehicles[5] = new F16(1);
        double sum = 0;
        double totalCost = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                sum = sum + vehicles[i].getMAX_LOAD();
                totalCost = totalCost + vehicles[i].getCost(2017, 12);
                if (vehicles[i] instanceof Flyer) {
                    Flyer f = (Flyer) vehicles[i];                    
                    f.takeOff();
                    if(f instanceof FighterII){
                        ((FighterII) f).fly(300);
                    }else{
                        f.fly();
                    }
                    if (f instanceof Fighter) {
                        ((Fighter) f).fight();
                    }
                    f.land();
                }
            }
        }
        System.out.println("sum = " + sum);
        System.out.println("totalCost = " + totalCost);

    }
}
