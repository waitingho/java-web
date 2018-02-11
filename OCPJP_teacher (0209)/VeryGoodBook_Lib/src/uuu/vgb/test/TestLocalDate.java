/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.time.LocalDate;

/**
 *
 * @author Patty Tai
 */
public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1992,1,15);
        System.out.println(date.getDayOfMonth());
        
    }
}
