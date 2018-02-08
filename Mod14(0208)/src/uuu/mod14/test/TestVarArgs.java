/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.mod14.test;

/**
 *
 * @author Patty Tai
 */
public class TestVarArgs {
    public static void main(String[] args) {
        System.out.println(sum(11, 32.5));
        System.out.println(sum(11, 32.5, 28));
        System.out.println(sum()); //0
        System.out.println(sum(1)); //0
        System.out.println(sum(11, 32.5, 28, 25));//caller
        System.out.println(sum(new double[]{11, 32.5, 28, 25}));//caller
    }
    
    public static double sum(double a, double b){
        System.out.println("sum(double a, double b)");
        return a+b;
    }

    public static double sum(double a, double b, double c){
        System.out.println("sum(double a, double b, double c)");
        return a+b+c;
    }

    public static double sum(Integer a){
        System.out.println("sum(Integer a)");
        return a;
    }

    
    public static double sum(double... dataArray){ //worker
        System.out.println("sum(double... dataArray)");
        double sum = 0;
        for(double data:dataArray){
            sum = sum + data;
        }
        return sum;
    }
}
