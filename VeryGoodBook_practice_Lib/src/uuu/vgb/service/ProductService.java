/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.service;

import uuu.vgb.entity.Product;

/**
 *
 * @author heweiting
 */
public class ProductService {
    public double calculateProductInventory (Product product){
        return product.getUnitprice()*product.getStock();
    }
    public Product getProduct(int id){
        Product p = new Product();
        p.setId(id);
        p.setName("R20");
        p.setUnitprice(2000);
        p.setStock(20);
        return p;
    }
}
