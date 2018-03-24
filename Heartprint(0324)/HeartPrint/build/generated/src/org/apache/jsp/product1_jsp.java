package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;
import java.text.NumberFormat;
import uuu.vgb.entity.Outlet;
import uuu.vgb.service.ProductService;
import uuu.vgb.entity.Product;
import java.util.List;

public final class product1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>浪漫手做卡片</title>\n");
      out.write("        <style>\n");
      out.write("            #fiexd-header{\n");
      out.write("                background:pink;\n");
      out.write("                width:98.5%;\n");
      out.write("                position:fixed; /*固定位置定位*/\n");
      out.write("                top:0; /*距離上方 0 像素*/\n");
      out.write("                z-index:9999; /*重疊時會在其他元素之上*/\n");
      out.write("                padding: auto;\n");
      out.write("                text-align: right;\n");
      out.write("                vertical-align: bottom;\n");
      out.write("            }\n");
      out.write("            .inside a{\n");
      out.write("                text-decoration:none\n");
      out.write("            }\n");
      out.write("            .inside a:link{color:white;}\n");
      out.write("            .inside a:visited{color: gray;}\n");
      out.write("            .inside a:hover{color: yellow; }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #header img{\n");
      out.write("                display: block;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                margin-top: 50px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .nav{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .nav a{\n");
      out.write("                text-decoration:none;\n");
      out.write("            }\n");
      out.write("            .nav a:hover{\n");
      out.write("                font-size: 1.5em;\n");
      out.write("                text-decoration: overline;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .section{\n");
      out.write("                float: left;\n");
      out.write("                width: 12%;\n");
      out.write("                min-width:8ex;\n");
      out.write("                background: pink;\n");
      out.write("            }\n");
      out.write("            .article{\n");
      out.write("                /*                float: left;\n");
      out.write("                                width:40%;\n");
      out.write("                                min-height: 60vh;\n");
      out.write("                                background:#FFF0F5;\n");
      out.write("                                border-radius: 50%;\n");
      out.write("                                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19), 0 8px 30px 0 rgba(0, 0, 0, 0.18);*/\n");
      out.write("\n");
      out.write("                float: left;\n");
      out.write("                min-height: 75vh;\n");
      out.write("                width:75%;\n");
      out.write("            }\n");
      out.write("            .aside{\n");
      out.write("                float:right;\n");
      out.write("                width: 12%;\n");
      out.write("                /*background: pink;*/\n");
      out.write("            }\n");
      out.write("            .aside img{\n");
      out.write("                /*                background:#FF0066;\n");
      out.write("                                color:#FFCC99;\n");
      out.write("                                border:4px solid #FF9999;\n");
      out.write("                                padding:5px;*/\n");
      out.write("                width:120px;\n");
      out.write("                height:120px;\n");
      out.write("                position:fixed;\n");
      out.write("                top:50%;\n");
      out.write("                right:10px;\n");
      out.write("                position: absolute; /* position fixed for IE6 */\n");
      out.write("                /*_top:expression(documentElement.scrollTop+100);*/\n");
      out.write("                z-index:3;\n");
      out.write("            }\n");
      out.write("           \n");
      out.write("            .my_list li{\n");
      out.write("                /*background: orange;*/\n");
      out.write("                display: inline-block;\n");
      out.write("                width:250px;\n");
      out.write("                height: 300px;\n");
      out.write("                margin:10px 10px;\n");
      out.write("                box-shadow: 1px 1px 2px gray;\n");
      out.write("                overflow: hidden;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            .my_list li img{\n");
      out.write("                width: 100%;\n");
      out.write("                height: 190px;\n");
      out.write("                /* border-radius: 50%;*/\n");
      out.write("            }\n");
      out.write("            .my_list h4{\n");
      out.write("                font-size: smaller;\n");
      out.write("                text_align:center;\n");
      out.write("            }\n");
      out.write("            /*還沒做完 肏*/\n");
      out.write("            .overlay{\n");
      out.write("                position:absolute;\n");
      out.write("                bottom: 0;\n");
      out.write("                background: rgb(0,0,0);\n");
      out.write("                background: rgba(0, 0, 0, 0.5); /* Black see-through */\n");
      out.write("                background-color:  #f1f1f1;\n");
      out.write("                width: 100%;\n");
      out.write("                transition:0.5s ease;\n");
      out.write("                opacity:0;/*透明效果*/\n");
      out.write("                color:white;\n");
      out.write("                font-size:20px;\n");
      out.write("                padding:20px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .my_list_img:hover.overlay {\n");
      out.write("                opacity: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*            .product_price{\n");
      out.write("                            font-size: smaller;\n");
      out.write("                            padding: 0 10px;\n");
      out.write("                            \n");
      out.write("                        }*/\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");

//        String productId = request.getParameter("productId");

        List<Product> list = null;
        ProductService service = new ProductService();
        list = service.getAllProducts();
//        if(productId != null && productId.matches("\\d+")){
//            p = service.getProduct(Integer.parseInt(productId));
//        }
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"fiexd-header\" >\n");
      out.write("            <div class=\"inside\">\n");
      out.write("\n");
      out.write("                <a  href=\"#\" >Cart</a> |\n");
      out.write("                <a href=\"/HeartPrint/login.jsp\">Logoin</a> |\n");
      out.write("                <a href=\"/HeartPrint/register.jsp\">Register</a> \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"header\" >\n");
      out.write("            <a href=\"/HeartPrint/index.jsp\">\n");
      out.write("                <img src=\"./image/logo.png\">\n");
      out.write("            </a>\n");
      out.write("        </div>   \n");
      out.write("        <br>\n");
      out.write("        <hr color=pink size=\"2\">\n");
      out.write("\n");
      out.write("        <div class=\"nav\">\n");
      out.write("            <a href=\"/HeartPrint/product1.jsp\" >浪漫手做卡片</a> |\n");
      out.write("            <a href=\"\">優質可愛小品</a> |\n");
      out.write("            <a href=\"\">About us</a> \n");
      out.write("        </div><br><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"section\" >\n");
      out.write("            section\n");
      out.write("        </div>\n");
      out.write("        <div class=\"article\"  >\n");
      out.write("            ");
 if (list != null && list.size() > 0) {
      out.write("\n");
      out.write("            <ul class=\"my_list\">\n");
      out.write("                ");
 for (Product p : list) {
      out.write("\n");
      out.write("                <li>\n");
      out.write("                    <div style=\"margin:auto;width: 100%\">\n");
      out.write("                        <img class=\"my_list_img\"src=\"");
      out.print( p.getPhotoUrl());
      out.write("\">\n");
      out.write("                        <div class=\"overlay\">加入購物車</div>\n");
      out.write("                    </div> \n");
      out.write("                    <h4 align=center>");
      out.print( p.getName());
      out.write("</h4>\n");
      out.write("                    <h5 align=center>NT$");
      out.print( p.getUnitPrice());
      out.write("</h5>\n");
      out.write("                </li>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            查無產品資料!\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"aside\" >\n");
      out.write("            aside\n");
      out.write("            <a href=\"#\"> <img  src=\"./image/cart4.gif\"></a> \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <br><br> <br><br> <br><br> <br><br> <br><br>\n");
      out.write("        <div class=\"footer\" style=\"clear:both; color: gray\">\n");
      out.write("            <hr >\n");
      out.write("            Copyright © 2018 HertPrinT Inc. All rights reserved | \n");
      out.write("            Contact information: <a href=\"mailto:hertprint@gmail.com\">hertprint@gmail.com</a>\n");
      out.write("            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>\n");
      out.write("            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>\n");
      out.write("            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr><hr> <hr>\n");
      out.write("            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>\n");
      out.write("            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>\n");
      out.write("            <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr> <hr>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
