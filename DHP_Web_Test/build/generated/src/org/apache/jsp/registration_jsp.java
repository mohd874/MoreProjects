package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <td colspan=\"2\" rowspan=\"2\"><div id=\"center\"></br>\r\n");
      out.write("\t<div id=\"center_center\">\r\n");
      out.write("\t  <form id=\"form1\" name=\"form1\" method=\"post\" action=\"registeration.page\">\r\n");
      out.write("\t    <table width=\"500\" border=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td colspan=\"2\"><h1><strong><em><font color=\"#3399FF\" face=\"Arial, Helvetica, sans-serif\">Account Information</font></em></strong></h1></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td width=\"157\">User name: </td>\r\n");
      out.write("            <td width=\"327\"><label>\r\n");
      out.write("              <input name=\"uname\" type=\"text\" id=\"uname\" />\r\n");
      out.write("              <font color=\"#CC3300\">*</font></label></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Password:</td>\r\n");
      out.write("            <td><input name=\"pass\" type=\"password\" id=\"pass\" />\r\n");
      out.write("              <font color=\"#CC3300\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Confirm Password: </td>\r\n");
      out.write("            <td><input name=\"con_pass\" type=\"password\" id=\"con_pass\" />\r\n");
      out.write("              <font color=\"#CC3300\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td colspan=\"2\"><h1><strong><em><font color=\"#3399FF\" face=\"Arial, Helvetica, sans-serif\">Personal Information </font></em></strong></h1></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Name:</td>\r\n");
      out.write("            <td><input name=\"name\" type=\"text\" id=\"name\" />\r\n");
      out.write("              <font color=\"#CC3300\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Sur Name: </td>\r\n");
      out.write("            <td><input name=\"sur_name\" type=\"text\" id=\"sur_name\" />\r\n");
      out.write("              <font color=\"#CC3300\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Title:</td>\r\n");
      out.write("            <td><label>\r\n");
      out.write("              <select name=\"title\" id=\"title\">\r\n");
      out.write("                <option value=\"mr\" selected=\"selected\">Mr.</option>\r\n");
      out.write("                <option value=\"dr\">Dr.</option>\r\n");
      out.write("                <option value=\"miss\">Miss</option>\r\n");
      out.write("                <option value=\"mrs\">Mrs.</option>\r\n");
      out.write("              </select>\r\n");
      out.write("              <font color=\"#CC3300\">*</font></label></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Phone Number: </td>\r\n");
      out.write("            <td><label>\r\n");
      out.write("              <input name=\"pre_phone\" type=\"text\" id=\"pre_phone\" size=\"6\" />\r\n");
      out.write("            - \r\n");
      out.write("            <input name=\"phone\" type=\"text\" id=\"phone\" />\r\n");
      out.write("            </label></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Moblie Number: </td>\r\n");
      out.write("            <td><input name=\"pre_mobile\" type=\"text\" id=\"pre_mobile\" size=\"6\" />\r\n");
      out.write("-\r\n");
      out.write("  <input name=\"mobile\" type=\"text\" id=\"mobile\" />\r\n");
      out.write("  <font color=\"#CC3300\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Fax:</td>\r\n");
      out.write("            <td><input name=\"fax\" type=\"text\" id=\"fax\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Address:</td>\r\n");
      out.write("            <td><input name=\"address\" type=\"text\" id=\"address\" />\r\n");
      out.write("              <font color=\"#CC3300\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Passport Number: </td>\r\n");
      out.write("            <td><input name=\"passport\" type=\"text\" id=\"passport\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>P.O.Box:</td>\r\n");
      out.write("            <td><input name=\"b_o_box\" type=\"text\" id=\"b_o_box\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Nationality:</td>\r\n");
      out.write("            <td><label>\r\n");
      out.write("              <select name=\"nationality\" id=\"nationality\">\r\n");
      out.write("                <option value=\"bahrain\">Bahrain</option>\r\n");
      out.write("                <option value=\"saudi\">Saudi Arabia</option>\r\n");
      out.write("                <option value=\"uae\">UAE</option>\r\n");
      out.write("                <option value=\"uk\">UK</option>\r\n");
      out.write("                <option value=\"other\">Other</option>\r\n");
      out.write("              </select>\r\n");
      out.write("            </label></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>E-mail:</td>\r\n");
      out.write("            <td><input name=\"email\" type=\"text\" id=\"email\" />\r\n");
      out.write("              <font color=\"#CC3300\">*</font></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>Send Account information to the E-mail: </td>\r\n");
      out.write("            <td><label>\r\n");
      out.write("              <input name=\"email_confirmation\" type=\"radio\" value=\"y\" />\r\n");
      out.write("              Yes</label>\r\n");
      out.write("              <label>\r\n");
      out.write("              <input name=\"email_confirmation\" type=\"radio\" value=\"n\" checked=\"checked\" />\r\n");
      out.write("              No</label></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><label>\r\n");
      out.write("              <input type=\"submit\" name=\"Submit\" value=\"Submit\" />\r\n");
      out.write("            </label></td>\r\n");
      out.write("            <td><label>\r\n");
      out.write("              <input type=\"reset\" name=\"Submit2\" value=\"Reset\" />\r\n");
      out.write("            </label></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("          </form>\r\n");
      out.write("\t  </div>\r\n");
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
