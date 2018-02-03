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
public abstract class Vehicle{
    private double MAX_LOAD; //RO
    private double load; //RW

    public Vehicle(double MAX_LOAD) {
        this.MAX_LOAD = MAX_LOAD;
    }

    /**
     * @return the MAX_LOAD
     */
    public double getMAX_LOAD() {
        return MAX_LOAD++;
    }

    /**
     * @return the load
     */
    public double getLoad() {
        return load;
    }

    /**
     * @param load the load to set
     */
    public void setLoad(double load) {
        this.load = load;
    }
    
    public abstract double getCost(int year, int month);

    @Override
    public String toString() {
        return this.getClass().getName() + "{" + "載重上限=" + MAX_LOAD + "公噸, 目前載重量=" + load + "公噸}";
    }
}
