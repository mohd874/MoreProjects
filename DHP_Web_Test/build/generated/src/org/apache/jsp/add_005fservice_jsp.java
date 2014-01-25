package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fservice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Service</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("    <form name=\"form1\" method=\"post\" action=\"add_service_control.page\">\n");
      out.write("      <table width=\"500\" height=\"138\">\n");
      out.write("        <tr>\n");
      out.write("          <th colspan=\"2\" scope=\"col\"><h1>Add Service</h1></th>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <th scope=\"row\">Service Type: </th>\n");
      out.write("          <td><label>\n");
      out.write("            <input name=\"service_type\" type=\"text\" id=\"service_type\">\n");
      out.write("          </label></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <th scope=\"row\">Service Description: </th>\n");
      out.write("          <td><label>\n");
      out.write("          <textarea name=\"service_desc\" id=\"service_desc\"></textarea>\n");
      out.write("          </label></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("          <th scope=\"row\"><label>\n");
      out.write("            <input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("          </label></th>\n");
      out.write("          <td><label>\n");
      out.write("            <input name=\"reset\" type=\"reset\" id=\"reset\" value=\"Reset\">\n");
      out.write("          </label></td>\n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("      <p></p>\n");
      out.write("      <p></p>\n");
      out.write("      <p></p>\n");
      out.write("          <p>\n");
      out.write("            <a href=\"home.jsp\">HOME</a>\n");
      out.write("          </p>\n");
      out.write("      \n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
