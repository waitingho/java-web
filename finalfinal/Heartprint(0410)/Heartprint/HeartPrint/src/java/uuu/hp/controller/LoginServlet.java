/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.hp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;
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

        //1. 讀取request中的表單資料並檢查
        request.setCharacterEncoding("UTF-8");
        String userid = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String captcha = request.getParameter("captcha");
        String auto = request.getParameter("auto");

        if (userid == null || userid.length() == 0) {
            errors.add("必須輸入帳號");
        }
        if (pwd == null || pwd.length() == 0) {
            errors.add("必須輸入密碼");
        }
        HttpSession session = request.getSession();
        if (captcha == null || captcha.length() == 0) {
            errors.add("必須輸入驗證碼");
        } else {
            String sessionCaptcha = (String) session.getAttribute("ImageCheckServlet");
            if (!captcha.equalsIgnoreCase(sessionCaptcha)) {
                errors.add("驗證碼不正確");
            } else {
                session.removeAttribute("ImageCheckServlet");
            }
        }

        //2. 當錯誤清單errors是空的，則呼叫CustomerService的login
        if (errors.isEmpty()) {
            //呼叫CustomerService的login
            CustomerService service = new CustomerService();
            try {
                Customer c = service.login(userid, pwd);
                //3.1 當login成功，forward成功畫面: /login_ok.jsp
                //add cookie
                Cookie idCookie = new Cookie("id", userid);
                Cookie autoCookie = new Cookie("auto", "checked");
                if (auto != null) {//要記住帳號, 有效時間: 7天
                    int expDays = 7 * 24 * 60 * 60;
                    idCookie.setMaxAge(expDays);
                    autoCookie.setMaxAge(expDays);
                } else {//不要記住帳號並清除舊的cookie資料
                    idCookie.setMaxAge(0);
                    autoCookie.setMaxAge(0);
                }
                response.addCookie(idCookie);
                response.addCookie(autoCookie);

                //3.1 當login成功，forward成功畫面: login_ok.jsp(做法一)
                //3.1 當login成功，redirect成功畫面: home page(做法二) 
                session.setAttribute("member", c); //資料c存入session範圍
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/product1.jsp");
//                dispatcher.forward(request, response);//用這個方法url會一樣 很瞎
                response.sendRedirect(request.getContextPath()+"/product1.jsp");
                return;

            } catch (VGBException ex) {//商業邏輯錯誤
                this.log("登入失敗", ex);
                if (ex.getCause() == null) {
                    errors.add(ex.toString());//將錯誤訊息加入錯誤清單
                } else {
                    errors.add(ex.toString() + ",請聯絡系統管理員"); //將錯誤訊息加入錯誤清單
                }
            } catch (Exception ex) {//非預期錯誤: RuntimeException
                this.log("登入失敗，發生非預期錯誤", ex);
                errors.add("登入失敗，發生非預期錯誤: " + ex); //將錯誤訊息加入錯誤清單
            }
        }

        //3.2 當檢查有錯或商業邏輯發生錯誤，forward到失敗畫面: login.jsp
        request.setAttribute("errors", errors);//request裡的error會再response結束時殺掉 所以第二次不會看到
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
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
