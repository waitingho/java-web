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
public class Product{
    private int id; //PKey, 必要
    private String name; //必要
    private double unitPrice; //定價，也是售價
    private int stock=10; 
    private String description;
    private String photoUrl;
    
    public Product(){    	
    	System.out.println("Product()有執行");
    }
    
    public Product(int id, String name,double price){
        this.id = id;
        this.name = name;
        this.unitPrice = price;
    }

    public Product(int id, String name, double unitPrice, 
            int stock) {
        this(id, name, unitPrice);        
//        this.id = id;
//        this.name = name;
//        this.unitPrice = unitPrice;        
        this.stock = stock;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 查詢產品定價(即售價)
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * 修改產品定價(即售價)
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) { 
        this.unitPrice = unitPrice;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the photoUrl
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * @param photoUrl the photoUrl to set
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ "{" 
                + "id=" + id  + ", 名稱=" + name + ", 定價=" + unitPrice 
                + ", 庫存="  + stock + ",\n 描述=" + description 
                + ",\n 圖片url=" + photoUrl + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
}
