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
public class Outlet extends Product {

    private int discount=10;

    public Outlet() {
    	super();
    	System.out.println("Outlet()有執行");
    }    
//    
	public Outlet(int id, String name, double unitPrice, int stock, 
			int discount) {
		super(id, name, unitPrice, stock);
		this.discount = discount;
	}

	public Outlet(int id, String name, double unitPrice, int stock) {
		super(id, name, unitPrice, stock);
	}

	public Outlet(int id, String name, double price) {
		super(id, name, price);
	}

	/**
     * 查詢售價
     * @return 用定價計算折扣後的售價
     */    
    @Override
    public double getUnitPrice() { //overriding method        
        return super.getUnitPrice() * (100-discount) / 100 ;
    }
    
    /**
     * 查詢定價
     * @return unitPrice
     */
    public double getListPrice(){
        return super.getUnitPrice();
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDiscountString() {
        int discount = (100 - this.discount);
        String rtn = (discount % 10 == 0 ? discount / 10 : discount) + "折";
        return rtn;
    }

    @Override
    public String toString() {
        return super.toString() + "\n折扣=" + getDiscountString() 
                + ",售價=" + this.getUnitPrice();
    }
    
    
}
