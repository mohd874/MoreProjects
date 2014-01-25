package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class bookRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("@import url(\"CSS/sample.css\");\r\n");
      out.write(".style1 {\r\n");
      out.write("\tfont-size: 36px;\r\n");
      out.write("\tfont-style: italic;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"800\" height=\"600\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("<div id=\"left_up\"></div>\r\n");
      out.write("<div id=\"center_up\">\r\n");
      out.write("  <div align=\"right\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"center_mid\">\r\n");
      out.write("  <form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\r\n");
      out.write("    <table width=\"560\" height=\"210\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td height=\"43\" colspan=\"2\"><span class=\"style1\">Room Reservation</span>\r\n");
      out.write("                                    <label></label></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                  <td height=\"43\">Room Type:</td>\r\n");
      out.write("                                  <td><select name=\"room_type\">\r\n");
      out.write("                                      <option value=\"*\" selected=\"selected\">All</option>\r\n");
      out.write("                                      <option value=\"lexury\">Lexury</option>\r\n");
      out.write("                                      <option value=\"khaleej\">Khaleej</option>\r\n");
      out.write("                                      <option value=\"royal\">Royal</option>\r\n");
      out.write("                                  </select></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                  <td height=\"43\">Room View:\r\n");
      out.write("                                    <label> </label></td>\r\n");
      out.write("                                  <td><select name=\"room_view\">\r\n");
      out.write("                                      <option value=\"garden\">Garden</option>\r\n");
      out.write("                                      <option value=\"marina\">Marina</option>\r\n");
      out.write("                                      <option value=\"swimming_pool\">Swimming Pool</option>\r\n");
      out.write("                                      <option value=\"*\" selected=\"selected\">All</option>\r\n");
      out.write("                                  </select></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                  <td width=\"170\" height=\"43\"><input type=\"submit\" name=\"Submit\" value=\"Search\" /></td>\r\n");
      out.write("                                  <td width=\"386\"><input name=\"reset\" type=\"reset\" id=\"reset\" value=\"Reset\" /></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                \r\n");
      out.write("                            </table>\r\n");
      out.write("    </form>\r\n");
      out.write("  <p><br />\r\n");
      out.write("  </p>\r\n");
      out.write("  </div>\r\n");
      out.write("<div id=\"left_mid\"></div>\r\n");
      out.write("</td>\r\n");
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
