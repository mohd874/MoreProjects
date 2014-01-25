package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class registration_005fcomplete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>Untitled Document</title>\r\n");
      out.write("<style type=\"text/css\" media=\"all\">\r\n");
      out.write("<!--\r\n");
      out.write("@import url(\"CSS/hotel.css\");\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"800\" height=\"600\" border=\"0\" cellspacing=\"0\" bgcolor=\"#FDD398\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th width=\"200\" height=\"100\" scope=\"col\"><div id=\"logo\"></div></th>\r\n");
      out.write("    <th width=\"300\" height=\"100\" scope=\"col\"><div id=\"location\"></div></th>\r\n");
      out.write("    <th width=\"300\" height=\"100\" scope=\"col\"><div id=\"menu\"></div></th>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th height=\"300\" width=\"200\" scope=\"row\" bgcolor=\"#FDD398\"><div id=\"navi\"></div></th>\r\n");
      out.write("    <td colspan=\"2\" rowspan=\"2\"><div id=\"center\">\r\n");
      out.write("\t<div id=\"center_center\">\r\n");
      out.write("\t <font face=\"Times New Roman, Times, serif\"><h1><em><strong> <p>&nbsp;</p>\r\n");
      out.write("\t       <p>Thank you for registration in Daffodils Palace Hotel</p>\r\n");
      out.write("\t       <p>You can now reserve rooms that will satisfy your needs </p></strong></em></h1></font>\r\n");
      out.write("                \r\n");
      out.write("               ");
      out.print(
               pageContext.forward("home.jsp")
               );
      out.write("\r\n");
      out.write("\t</div> \r\n");
      out.write("    </div></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th width=\"200\" height=\"200\" scope=\"row\"><div id=\"clock\">\r\n");
      out.write("      <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"201\" height=\"202\">\r\n");
      out.write("        <param name=\"movie\" value=\"SWF/Clock.swf\" />\r\n");
      out.write("        <param name=\"quality\" value=\"high\" />\r\n");
      out.write("        <embed src=\"../Clock.swf\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"201\" height=\"202\"></embed>\r\n");
      out.write("      </object>\r\n");
      out.write("    </div></th>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
