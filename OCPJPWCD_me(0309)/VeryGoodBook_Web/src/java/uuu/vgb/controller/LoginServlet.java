/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {

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
        //1.取得request中的form data: id, pwd, captcha 並檢查
        //TODO:
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String captcha = request.getParameter("captcha");
        if (id == null || id.length() == 0) {
            errors.add("必須輸入帳號");
        }
        if (id == null ||pwd.length() == 0) {
            errors.add("必須輸入密碼");
        }
        if (id == null || captcha.length() == 0) {
            errors.add("必須輸入驗證碼");
        }

        //2.當檢查無誤 呼叫商業邏輯:CustomerService的login方法
        if (errors.isEmpty()) {
            CustomerService service = new CustomerService();
            try {
                Customer c = service.login(id, pwd);

                //3.1 當login登入成功顯示成功html畫面
//        response.setContentType("text/html;charset=UTF-8");
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>登入成功</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Welcome~ " + c.getName() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
                return;
            } catch (VGBException ex) {
                this.log("登入失敗:" + ex);
//            System.out.println("登入失敗:" +ex);
                if (ex.getCause() == null) {
                    errors.add(ex.toString());
                } else {
                    errors.add(ex.toString() + ",請聯絡系統管理員");
                }
            }catch(Exception ex){
                this.log("登入失敗,發生非預期錯誤",ex );
                errors.add("登入失敗,發生非預期錯誤");
            }
        }
        //3.2 當資料檢查有錯或商業邏輯發生錯誤,回應失敗的html畫面
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>登入失敗</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>登入失敗~ </h1>");
            out.println("<div>" + errors);
            out.println("<br><a href='login.html'>重新登入</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
