package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uuu.vgb.entity.Customer;
import java.util.Calendar;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/subviews/global_lib.jsp");
    _jspx_dependants.add("/WEB-INF/subviews/footer.jsp");
  }

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

    String uri = request.getRequestURI();
    Customer member = null;
    if (uri.indexOf(request.getContextPath() + "/member") >= 0) {
        member = (Customer) session.getAttribute("member");
        if (member == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link href=\"");
      out.print( request.getContextPath() );
      out.write("/style/vgb.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script\n");
      out.write("            src=\"https://code.jquery.com/jquery-1.12.4.js\" \n");
      out.write("            integrity=\"sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=\"\n");
      out.write("            crossorigin=\"anonymous\">\n");
      out.write("        </script> \n");
      out.write("     ");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function goBackShop(){\n");
      out.write("                location.href = \"");
      out.print( request.getContextPath() );
      out.write("/products_list.jsp\";\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/subviews/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("subtitle", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("購物車", request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("        <div class='article'>\n");
      out.write("            <form method=\"GET\" action=\"update_cart.do\">\n");
      out.write("                <table border='1' cellspacing='1' cellpadding='3' style='width:75%;margin: auto'>  \n");
      out.write("                    <caption>購物車</caption>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>名 稱</th>\n");
      out.write("                            <th>顏 色</th>\n");
      out.write("                            <th>定 價</th>\n");
      out.write("                            <th>折 扣</th>\n");
      out.write("                            <th>售 價</th>\n");
      out.write("                            <th>數 量</th>\n");
      out.write("                            <th>刪 除</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>                    \n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>1 Microsoft® SQL Server® 2016管理實戰</td>\n");
      out.write("                            <td> </td>\n");
      out.write("                            <td>699.0</td>\n");
      out.write("                            <td>79折</td>\n");
      out.write("                            <td>552.21</td>\n");
      out.write("                            <td><input name='quantity' type='number' min='1' max='10' value='1'></td>\n");
      out.write("                            <td><input name='delete' type='checkbox'></td>\n");
      out.write("                        </tr>                       \n");
      out.write("                    </tbody>\n");
      out.write("                    <tfoot>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\">總金額:</td>\n");
      out.write("                            <td colspan=\"3\">1126元</td>\n");
      out.write("                        </tr>            \n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\"><input type='button' value=\"回到賣場\" onclick=\"goBackShop()\"></td>\n");
      out.write("                            <td colspan=\"1\"><input type='submit' value=\"修改購物車\"></td>\n");
      out.write("                            <td colspan=\"2\"><input type='button' value=\"我要結帳\"></td>\n");
      out.write("                        </tr>                                    \n");
      out.write("                    </tfoot>\n");
      out.write("                </table>                \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"footer\" style=\"clear:both\">\n");
      out.write("            <hr>\n");
      out.write("            版權所有 &copy; 非常好書 2017~");
      out.print( Calendar.getInstance().get(Calendar.YEAR) );
      out.write("\n");
      out.write("            <span style='float: right'>拜訪人次: \n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope[\"app.visitors\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                ,您是第");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope[\"app.visitors\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("位訪客</span>\n");
      out.write("        </div>   ");
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
