/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.entity;

/**
 *
 * @author Patty Tai
 */
public class VIP extends Customer{
    private int discount = 10;

    public VIP() {
    }

    public VIP(String id, String name, String password) throws VGBException {
        super(id, name, password);
    }

    public VIP(String id, String name, String password, char gender, String email) throws VGBException {
        super(id, name, password, gender, email);
    }
    
    public VIP(String id, String name, String password, char gender, String email, int discount) 
            throws VGBException {
        super(id, name, password, gender, email);
        this.discount = discount;
    }    

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }
    
    public String getDiscountString(){
        int discount = (100-this.discount);
        String rtn = (discount%10==0?discount/10:discount) + "折";
        return rtn;
    }

    /**
     * @param discount 將會指派給屬性discount
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n折扣=" + getDiscountString();
    }
}
