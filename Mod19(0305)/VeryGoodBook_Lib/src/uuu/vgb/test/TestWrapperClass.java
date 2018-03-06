/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.test;

/**
 *
 * @author Patty Tai
 */
public class TestWrapperClass {

    public static void main(String[] args) {
        byte b1 = 1;
        short s1 = 10;
        int i1 = 100;
        double d1 = 1000.5;
        boolean t1 = true;

        //以下為boxing
        Byte theB1 = new Byte(b1);
        Short theS1 = new Short(s1);
        Integer theI1 = new Integer(i1);
        Double theD1 = new Double(d1);
        Boolean theT1 = new Boolean(t1);

        //以下為unboxing
        byte b2 = (byte) (theB1.byteValue() + 3);
        short s2 = (short) (theS1.shortValue() - 1);
        int i2 = theI1.intValue();
        double d2 = theD1.doubleValue();
        boolean t2 = theT1.booleanValue();

        //以下為autoboxing, 適用JDK 5以上的版本
        Byte theB2 = b1; // new Byte(b1)
        Short theS2 = s1; 
        Integer theI2 = i1;
        Double theD2 = d1;
        Boolean theT2 = t1;
        Character theC1 = '1'; //Character theC1 = new Character('1');
        
        //以下為auto-unboxing, 適用JDK 5以上的版本
        Double d3 = theB2 + theD2 + theC1; //Double d3 = new Double(theB2.byteValue() + theD2.doubleValue() + theC1.char);
        System.out.println(d3);
    }
}
