/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uuu.vgb.entity.Cart;
import uuu.vgb.entity.CartItem;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "UpdateCartServlet", urlPatterns = {"/member/update_cart.do"})
public class UpdateCartServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");        
        Customer member = (Customer)session.getAttribute("member");
        if(cart==null){
            response.sendRedirect(request.getContextPath()+"/products_list.jsp");
            return;
        }else if(member==null && cart!=null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;            
        }
        
        Set<CartItem> trashSet = new HashSet<>();
        //1. 取得form中的parameter
        for(CartItem item:cart.getCartItemSet()){
            Product p = item.getProduct();
            String quantity=request.getParameter("quantity_"+p.getId());
            String delete=request.getParameter("delete_"+p.getId());            
            //2. 呼叫商業邏輯
            if(delete==null && quantity!=null && quantity.matches("\\d+")){
                //修改商品p的數量
                cart.updateCartItem(p, Integer.parseInt(quantity));
            }else if(delete!=null){
                //直接刪除商品p的所屬的CartItem
                //cart.removeCartItem(p); //除了最後一筆，其他會在這裡發生runtime-exception: ConcurrentModificationException
                
                //將要刪除商品p的所屬的CartItem加入trashSet
                trashSet.add(item);
            }
        }
        
        //2.2從trashSet到cart.getCartItemSet()刪除對應的item
        for(CartItem item:trashSet){
            cart.removeCartItem(item.getProduct());
        }
        
        //3.redirect回到/member/cart.jsp
        if("我要結帳".equals(request.getParameter("submit"))){
            response.sendRedirect(request.getContextPath() + "/member/check_out.jsp");        
        }else{
            response.sendRedirect(request.getContextPath() + "/member/cart.jsp");        
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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

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
