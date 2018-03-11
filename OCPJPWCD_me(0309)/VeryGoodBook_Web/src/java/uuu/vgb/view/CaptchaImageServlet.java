/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class CaptchaImageServlet extends HttpServlet {

    private int len = 6, width = 16 * 2 + 12 * len, height = 20;

    public CaptchaImageServlet(){
        System.out.println("CaptchaImageServlet 建立一個物件");
    }
    
    @Override
    public void init(){
        String length = this.getInitParameter("length");
        if(length!=null && length.matches("\\d+")){
            len = Integer.parseInt(length);
            width = 16 * 2 + 12 * len;
        }
    }
    
    private BufferedImage generateImage(String rand, int width, int height) {

        //開始建立圖片
        BufferedImage image
                = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();   //取得影像繪圖區

        //畫出背景方塊
        g.setColor(getRandomColor(200, 250)); //設定繪圖區背景色
        g.fillRect(0, 0, width, height);    //在繪圖區畫個長方型

        //畫干擾線讓背景雜亂
        Random random = new Random();
        g.setColor(getRandomColor(170, 210));

        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        //畫出認證文字
        g.setFont(new Font("Arial", Font.PLAIN, 18));//設定字體
        g.setColor(getRandomColor(20, 140));
        //將認證文字畫到image中
        g.drawString(rand, 16, 16);
        g.dispose();
        return image;
    }

    private Color getRandomColor(int fc, int bc) {

        //在參數設定的範圍內，隨機產生顏色
        Random random = new Random();

        if (fc > 255) {
            fc = 255;
        }

        if (bc > 255) {
            bc = 255;
        }

        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

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
        String rand = null;
        HttpSession session = request.getSession();//第15張session介紹
        //1.亂數產生 大寫英文字母或數字 字串(36)
        if (rand == null) {
            rand = "";
            Random r = new Random();
            for (int i = 0; i < len; i++) {
                int data = r.nextInt(35);
                rand += (data < 10 ? (char) (data + '0') : (char) (data - 10 + 'A'));

            }
//            session.setAttribute(getServletName(), rand); //(之後必須加回這行code)
        }
        //2.字串繪製成image
        BufferedImage image = generateImage(rand, width, height);

        //3.將image輸出到response
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        try (ServletOutputStream outStream = response.getOutputStream();) {      //將影像輸出到頁面
            ImageIO.write(image, "JPEG", outStream);

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
