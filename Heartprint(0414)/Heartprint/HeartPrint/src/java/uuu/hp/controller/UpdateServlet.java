/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.hp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/member/update.do"})
public class UpdateServlet extends HttpServlet {

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
        List<String> errors = new ArrayList<>();
        response.setContentType("text/html;");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println(name);
//        String password = request.getParameter("password");
//        String pwd = request.getParameter("pwd");
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        if (name == null || name.length() == 0) {
            errors.add("必須輸入姓名");
        }
//        if (password != null || password.length() > 0) {
//            if (!password.equals(pwd1)) {
//                errors.add("與舊密碼不同");
//            }
//        }

        if (pwd1 != null && pwd1.length() > 0
                && pwd2 != null && pwd2.length() > 0) {
            if (!pwd1.equals(pwd2)) {
                errors.add("密碼與確認密碼不一致");
            }
        } 
        if (errors.isEmpty()) {
            try {
                Customer c = new Customer();

                c.setId(id);
                c.setName(name);
//                c.setPassword(password);
                c.setPassword(pwd1);
//                c.setPassword(pwd2);
                c.setEmail(email);
                c.setBirthday(birthday);
                c.setAddress(address);
                c.setPhone(phone);

                CustomerService service = new CustomerService();
                service.update(c);

                //3.1 forward to register_ok.jsp
                request.setAttribute("customer", c);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/update_ok.jsp");
                dispatcher.forward(request, response);
                return;

            } catch (VGBException ex) {
                errors.add(ex.getMessage());
            } catch (Exception ex) {
                this.log("客戶註冊發生非預期錯誤", ex);
                errors.add("客戶註冊發生非預期錯誤:" + ex);
            }
        }

        System.out.println(errors);
        //3.2 forward to register_ok.jsp
        request.setAttribute("errors", errors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        dispatcher.forward(request, response);
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
