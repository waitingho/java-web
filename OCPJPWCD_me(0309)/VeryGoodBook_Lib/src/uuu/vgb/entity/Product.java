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
    private int id;//PKey
    private String name;//必要欄位
    private double unitPrice;//是定價也是售價
    private int stock;
    private String description;
    private String photoUrl;
//    public int status = 1; //0:新產品, 1:已上架, -1:已停售
    public Product(){
        System.out.println("product()有執行喔");
    }//一定要有不然會GG雖然是無參數建構子
    
    public Product(int id,String name, double price){//快速建:右鍵=>insert code =>constructor
        this.id = id;
        this.name = name;
        unitPrice = price;//參數price指派給屬性unitPrice
        }
    
    public Product(int id,String name, double price,int stock){
       this(id,name,price);//用this呼叫同類別的參數 一定要寫在第一行!!!!!!!!!!
//       this.id = id;
//       this.name = name;
//       unitPrice = rprice; 
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
     * 查詢產品訂價(即售價)
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * 修改產品訂價(及售價)
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
        return this.getClass().getSimpleName() + ":\n "
                +"{id:" + id + "\n name:" + name + " \n unitPrice:" + unitPrice
                + "\n stock:" + stock + "\n description:" + description
                + "\n photoUrl:" + photoUrl+"}";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof Product){
//          if(obj!=null && obj.getClass()==Product.class){
            Product p = (Product)obj;
            if(this.id == p.id
                    && this.name!=null && this.name.equals(p.name)
//                    && this.unitPrice == p.unitPrice
                    ){
                return true; 
            }
                
        }
        return false;
    }
    
    
}




