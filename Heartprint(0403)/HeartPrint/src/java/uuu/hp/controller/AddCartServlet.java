/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uuu.vgb.entity.Cart;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductService;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AddCartServlet", urlPatterns = {"/add_cart.do", "/add_cart_ajax.do"})
public class AddCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //1.取得request中的quantity, productId
       
       String quantity = request.getParameter("quantity");
       String productId = request.getParameter("productId");
        Cart cart = null;
        if(productId!=null && productId.matches("\\d+")){
           try {
               int pid = Integer.parseInt(productId);
               int q = 1;
               if(quantity!=null && quantity.matches("\\d+")){
                   q = Integer.parseInt(quantity);
               }
               ProductService service = new ProductService();
               Product p = service.getProduct(pid);
               if(p!=null){
                   HttpSession session = request.getSession();
                   cart = (Cart)session.getAttribute("cart");
                   if(cart==null){
                       cart = new Cart();
                       session.setAttribute("cart",cart);
                   }
                   cart.addCartItem(p,q);
               }
               
           } catch (Exception ex) {
              this.log("加入購物車失敗:"+ex+",productId:"+productId);
           }
            
        }
        if(request.getRequestURI().indexOf("ajax.do")<1){
            response.sendRedirect(request.getContextPath()+"/member/cart.jsp");
        }else{
             response.sendRedirect(request.getContextPath() +"/small_cart_ajax.jsp"); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
