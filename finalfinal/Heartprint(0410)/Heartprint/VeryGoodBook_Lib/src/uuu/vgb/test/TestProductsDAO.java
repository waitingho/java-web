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
import uuu.vgb.service.ProductsDAO;

/**
 *
 * @author Patty Tai
 */
public class TestProductsDAO {

    public static void main(String[] args) {
        try {
            ProductsDAO dao = new ProductsDAO();
//            List<Product> list = dao.selectAllProducts();
//            System.out.println("list = " + list);
//            System.out.println(dao.selectProductById(77));
             System.out.println(dao.selectProductIdbyQuantity());
//            System.out.println(dao.selectProductByNameAndType("公公", null));
//            System.out.println(dao.selectProductByStyle("house"));
//            System.out.println(dao.selectProductByRND());
//             System.out.println(dao.selectStockById(41));
// System.out.println(dao.selectPriceeetById());
        } catch (VGBException ex) {
            Logger.getLogger(TestProductsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
