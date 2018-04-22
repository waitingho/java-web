/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductService;

/**
 *
 * @author Patty Tai
 */
public class TestProductService {
    public static void main(String[] args) {
        try {
            ProductService service = new ProductService();
            List<Product> list = service.getAllProducts();
            System.out.println("list = " + list);
            System.out.println(service.getProduct(51));
            
            System.out.println(service.getProductsByNameAndType("色鉛筆", null));
            System.out.println(service.getProductsByNameAndType("色鉛筆", ""));
            
        } catch (VGBException ex) {
            Logger.getLogger(TestProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
