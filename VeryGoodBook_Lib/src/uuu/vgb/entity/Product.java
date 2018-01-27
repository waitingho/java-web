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
public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private int stock;
    private String description;
    private String photoUrl;
//    public int status = 1; //0:新產品, 1:已上架, -1:已停售
    public Product(){
        
    }
    
    public Product(int id,String name, double price){//快速建:右鍵=>insert code =>constructor
        this.id = id;
        this.name = name;
        unitPrice = price;//參數price指派給屬性unitPrice
        }
    
    public Product(int id,String name, double rprice,int stock){
       this(id,name,rprice);//用this呼叫同類別的參數 一定要寫在第一行!!!!!!!!!!
//       this.id = id;
//       this.name = name;
//       unitPrice = dprice; 
       this.stock = stock;
    }

    public void setId(int id){
        this.id = id;
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
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
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

}




