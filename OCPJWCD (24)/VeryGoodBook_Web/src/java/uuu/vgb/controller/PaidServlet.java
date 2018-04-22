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
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.OrderService;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "PaidServlet", urlPatterns = {"/member/paid.do"})
public class PaidServlet extends HttpServlet {

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
        Customer member = (Customer) session.getAttribute("member");
        if (member == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        List<String> errors = new ArrayList<>();
        //1. 取得form data: orderId, amount, bank, fiveCode, transferDate, transferTime
        String orderId = request.getParameter("orderId");
        String amount = request.getParameter("amount");
        String bank = request.getParameter("bank");
        String fiveCode = request.getParameter("fiveCode");
        String transferDate = request.getParameter("transferDate");
        String transferTime = request.getParameter("transferTime");

        if (orderId == null || !orderId.matches("\\d+")) {
            errors.add("訂單編號有誤!");
        }

        if (amount == null || amount.length() == 0) {
            errors.add("必須輸入轉帳金額");
        }
        if (bank == null || bank.length() == 0) {
            errors.add("必須輸入轉帳銀行");
        }
        if (fiveCode == null || fiveCode.length() == 0) {
            errors.add("必須輸入轉帳帳號後5碼");
        }
        if (transferDate == null || transferDate.length() == 0) {
            errors.add("必須輸入轉帳日期");
        }
        if (transferTime == null || transferTime.length() == 0) {
            errors.add("必須輸入轉帳時間");
        }

        //2. 若無誤，呼叫商業邏輯
        if (errors.isEmpty()) {
            OrderService service = new OrderService();
            try {
                service.updateStatusToPaid(Integer.parseInt(orderId), member.getId(),
                        bank, fiveCode, Double.parseDouble(amount), transferDate, transferTime);

                //3.1 redirect to orders_history.jsp
                response.sendRedirect("orders_history.jsp");
                return;

            } catch (VGBException ex) {
                errors.add(ex.toString());
            }
        }
        
        //3.2 forward to paid.jsp
        request.setAttribute("errors", errors);
        request.getRequestDispatcher("paid.jsp").forward(request, response);
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
