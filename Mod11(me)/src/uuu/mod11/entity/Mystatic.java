/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.mod11.entity;

/**
 *
 * @author Administrator
 */
public class Mystatic {
    private static int i ;//static attribute,class member,class attribute
    private int j = 10;//non-static attribute,object/instance member, object/instance attribute, 
    
    static{
        
        
        System.out.println("Mystatic正在載入類別定義ㄛ");
        i = 123;//TODO: 從properties檔案讀資料後指派給i
    }
    
    public Mystatic() {
    }
    
    public Mystatic(int j){
        this.i = i;//assignment
        this.j = j;//initialization
    }
    
       static{
        System.out.println("Mystatic正在載入類別定義ㄛ");
        i = 456;//TODO: 從properties檔案讀資料後指派給i
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
        Mystatic.i = i;
    }

    /**
     * @return the j
     */
    public int getJ() {
        return j+i;
    }

    /**
     * @param j the j to set
     */
    public void setJ(int j) {
        this.j = j;
    }
}
