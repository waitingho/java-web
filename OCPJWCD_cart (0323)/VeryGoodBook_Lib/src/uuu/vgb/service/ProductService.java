/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.service;

import java.util.List;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

/**
 *
 * @author Patty Tai
 */
public class ProductService {//delegation model
    private ProductsDAO dao = new ProductsDAO();

    //delegate method
    public List<Product> getAllProducts() throws VGBException {
        return dao.selectAllProducts();
    }
    
    public Product getProduct(int id)throws VGBException{
        return dao.selectProductById(id);
    }
    
    public List<Product> getProductsByNameAndType(String name, String type)throws VGBException{
        return dao.selectProductByNameAndType(name, type);
    }    
}
