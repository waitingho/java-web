/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.mod11.entity;

/**
 *
 * @author Patty Tai
 */
public class MyStatic {
    private static int i;//static attribute, class member, class attribute
    private int j;//non-static attribute, object/instance member, object/instance attribute

    static {
        System.out.println("MyStatic正在載入類別定義1");
        i = 123; //TODO: 從properties檔案讀資料後指派給 i
    }
    
    public MyStatic() {
    }

    public MyStatic(int j) {
        this.i = j; //assignment
        this.j = j; //initialization
    }
    
    /**
     * @return the i
     */
    public static int getI() {
        return i;
    }

    /**
     * @param aI the i to set
     */
    public static void setI(int i) {
        MyStatic.i = i;
    }

    /**
     * @return the j
     */
    public int getJ() {
        return j;
    }

    /**
     * @param j the j to set
     */
    public void setJ(int j) {
        this.j = j;
    }
}
