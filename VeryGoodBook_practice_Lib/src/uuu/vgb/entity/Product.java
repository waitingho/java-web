/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.entity;

/**
 *
 * @author heweiting
 */
public class Product {
    private int id;
    private String name;
    private double unitprice;
    private boolean free;
    private int stock;
    private String description;
    private String photoUrl;
    
    public Product(){}

    public Product(int id, String name, double unitprice) {
        this.id = id;
        this.name = name;
        this.unitprice = unitprice;
    }

    public Product(int id, String name, double unitprice, int stock) {
//        this.id = id;
//        this.name = name;
//        this.unitprice = unitprice;
        this(id, name, unitprice);
        this.stock = stock;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    
}
