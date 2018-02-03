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
public interface Flyer {
    int speed = 60;
    
    void takeOff();    
    abstract void fly();    
    public abstract void land();
}
