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
public class RiverBarge extends Vehicle {

    public RiverBarge(double MAX_LOAD) {
        super(MAX_LOAD);
    }

    @Override
    public double getCost(int year, int month) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return 300000;
    }
    
    
}
