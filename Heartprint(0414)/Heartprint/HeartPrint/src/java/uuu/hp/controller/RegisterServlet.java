/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.hp.controller;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uuu.vgb.entity.BloodType;
import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.CustomerService;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register.do"})
public class RegisterServlet extends HttpServlet {

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
         //1.取得form data: id, name,..., 檢查
         request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String captcha = request.getParameter("captcha");

        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
       
        
        if (id == null || id.length() == 0) {
            errors.add("必須輸入帳號");
            
        }
       
        if (name == null || name.length() == 0){
            errors.add("必須輸入姓名");
        }
        if(pwd1!=null && pwd1.length()> 0 && 
                pwd2!= null && pwd2.length()>0){
            if(!pwd1.equals(pwd2)){
             errors.add("密碼與確認密碼不一致");
        }
        }else{
            errors.add("必須輸入一致的密碼與確認密碼");
        }
        if(gender == null || gender.length()==0){
            errors.add("必須輸入性別");
        }
        if(email == null || email.length() == 0){
            errors.add("必須輸入Email");
        }
        if(birthday == null || birthday.length() == 0){
            errors.add("必須輸入生日");
        }
       HttpSession session = request.getSession(); 
        if (captcha == null || captcha.length() == 0) {
            errors.add("必須輸入驗證碼");
    }else{
            String sessionCaptcha = (String)session.getAttribute("RegisterImageCheckServlet");
            if(!captcha.equalsIgnoreCase(sessionCaptcha)){
                errors.add("驗證碼不正確");
            }else{
                session.removeAttribute("RegisterImageCheckServlet");
            }            
        }    
        //2. 若無誤, 則執行商業邏輯 todo
        if (errors.isEmpty()) {
            Customer c = new Customer();
            try {
                c.setId(id);
                c.setName(name);
                c.setPassword(pwd1);
                c.setGender(gender.charAt(0));
                c.setEmail(email);
                c.setBirthday(birthday);
                
                //TODO: 用其他非必要欄位的setter來傳值
                c.setAddress(address);
                c.setPhone(phone);
                
                CustomerService service = new CustomerService();
                service.register(c);

                //3.1 forward to register_ok.jsp
//                request.setAttribute("member", c);
                 session.setAttribute("member", c);//資料c存入session範圍
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product1.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
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
