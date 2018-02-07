/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

/**
 *
 * @author Administrator
 */
public class Outlet extends Product{
    private int discount=10;
    public Outlet() {}
    
    public Outlet(int id, String name, double price, 
    		int stock,int discount){
    	super(id,name,price,stock);
    	this.discount = discount;
    }

	public Outlet(int id, String name, double rprice, int stock) {
//		super(id, name, rprice, stock);
		this(id,name,rprice);
		
	}

	public Outlet(int id, String name, double price) {
		super(id, name, price);
		// TODO Auto-generated constructor stub
	}

	/**
    *查詢售價
    * @return 折扣後售價
    */
    @Override
     public double getUnitPrice() {//overriding method
        return super.getUnitPrice()*(100-discount)/100;
    }
     
     /**
      * 查詢原來的定價
      * @return 
      */
     
     public double getListPrice(){
         return super.getUnitPrice();
     }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
        
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
     public String getDiscountString(){
        int discount = (100-this.discount);
        String rtn = (discount % 10 == 0 ? discount / 10 : discount) + "折";
        return rtn;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n discount=" + getDiscountString()
                +"\n 售價="+this.getUnitPrice();
    }

}

