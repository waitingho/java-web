/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uuu.vgb.entity.Cart;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.PaymentType;
import uuu.vgb.entity.ShippingType;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.OrderService;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/member/check_out.do"})
public class CheckOutServlet extends HttpServlet {

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
        //0.
        HttpSession session = request.getSession();
        Customer member = (Customer) session.getAttribute("member");
        Cart cart = (Cart) session.getAttribute("cart");
        if (member == null || cart == null) {
            this.log("結帳時member, cart皆不是null");
            response.sendRedirect(request.getContextPath() + "/member/cart.jsp");
            return;
        }

        List<String> errors = new ArrayList<>();
        //1.取出form中的parameter: paymentType, shippingType
        //name, email,phone, adds, 並檢查之            
        String paymentType = request.getParameter("paymentType");
        String shippingType = request.getParameter("shippingType");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String addr = request.getParameter("addr");
        if (paymentType == null || paymentType.length() == 0) {
            errors.add("必須選擇付款方式");
        }
        if (shippingType == null || shippingType.length() == 0) {
            errors.add("必須選擇貨運方式");
        }
        if (name == null || name.length() == 0) {
            errors.add("必須輸入收件人姓名");
        }
        if (email == null || email.length() == 0) {
            errors.add("必須輸入收件人電郵");
        }
        if (phone == null || phone.length() == 0) {
            errors.add("必須輸入收件人電話");
        }
        if (addr == null || addr.length() == 0) {
            errors.add("必須輸入送件地址");
        }

        //2.若無誤，則呼叫商業邏輯
        if (errors.isEmpty()) {
            Order order = new Order();
            order.setMember(member);
            order.add(cart);
            order.setPaymentType(PaymentType.valueOf(paymentType));
            order.setPaymentFee(order.getPaymentType().getFee());
            order.setShippingType(ShippingType.valueOf(shippingType));
            order.setShippingFee(order.getShippingType().getFee());
            order.setReceiverName(name);
            order.setReceiverEmail(email);
            order.setReceiverPhone(phone);
            order.setShippingAddr(addr);

            OrderService service = new OrderService();
            try {
                service.createOrder(order);

                //3.1 redirect 
                response.sendRedirect(request.getContextPath() + "/member/orders_history.jsp");
                return;
            } catch (VGBException ex) {
                errors.add(ex.toString());
            }
        }

        //3.2 forward check_out.jsp
        request.setAttribute("errors", errors);
        request.getRequestDispatcher("check_out.jsp").forward(request, response);
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
