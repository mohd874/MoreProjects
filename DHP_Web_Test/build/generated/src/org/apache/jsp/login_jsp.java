package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("         \r\n");
      out.write("        <title>Untitled Document</title>\r\n");
      out.write("        <style type=\"text/css\" media=\"all\">\r\n");
      out.write("            <!--\r\n");
      out.write("            @import url(\"CSS/hotel.css\");\r\n");
      out.write("            -->\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      com.hotel.model.tracing_bean user_info = null;
      synchronized (session) {
        user_info = (com.hotel.model.tracing_bean) _jspx_page_context.getAttribute("user_info", PageContext.SESSION_SCOPE);
        if (user_info == null){
          user_info = new com.hotel.model.tracing_bean();
          _jspx_page_context.setAttribute("user_info", user_info, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("       \r\n");
      out.write("        <table width=\"800\" height=\"600\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th width=\"200\" height=\"100\" scope=\"col\"><div id=\"logo\"></div></th>\r\n");
      out.write("                <th width=\"300\" height=\"100\" scope=\"col\"><div id=\"location\">\r\n");
      out.write("                    <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"396\" height=\"100\">\r\n");
      out.write("                        <param name=\"movie\" value=\"SWF/Head_Left_login.swf\" />\r\n");
      out.write("                        <param name=\"quality\" value=\"high\" />\r\n");
      out.write("                        <embed src=\"SWF/Head_Left_login.swf\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"396\" height=\"100\"></embed>\r\n");
      out.write("                    </object>\r\n");
      out.write("                </div></th>\r\n");
      out.write("                <th width=\"300\" height=\"100\" scope=\"col\"><div id=\"menu\"></div></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th height=\"300\" width=\"200\" scope=\"row\"><div id=\"navi\"></div></th>\r\n");
      out.write("                <td colspan=\"2\" rowspan=\"2\"><div id=\"center\"></br></br><form id=\"form1\" name=\"form1\" method=\"post\" action=\"login.page\">\r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                    \r\n");
      out.write("                    <p align=\"center\"><strong><span class=\"style6\">User Name</span>:  ");
      out.print( user_info.getUname() );
      out.write("\r\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.hotel.model.tracing_bean)_jspx_page_context.findAttribute("user_info")).getUname())));
      out.write("\r\n");
      out.write("                        <label>\r\n");
      out.write("                            <input type=\"text\" name=\"uname\" id=\"uname\"/>\r\n");
      out.write("                        </label>\r\n");
      out.write("                    </strong></p>\r\n");
      out.write("                    <p align=\"center\"><strong> Password:  \r\n");
      out.write("                        <label>\r\n");
      out.write("                            <input type=\"password\" name=\"pass\" id=\"pass\"/>\r\n");
      out.write("                        </label>\r\n");
      out.write("                    </strong></p>\r\n");
      out.write("                    <p align=\"center\">\r\n");
      out.write("                        <input type=\"submit\" name=\"Submit\" value=\"Login\">\r\n");
      out.write("                        <input name=\"reset\" type=\"reset\" id=\"reset\" value=\"Reset\">\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p align=\"center\">register as new customer <a href=\"www.google.com\">here</a> </p>\r\n");
      out.write("                </form>\r\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                </div></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th height=\"200\" width=\"200\" scope=\"row\"><div id=\"clock\">\r\n");
      out.write("                    <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"201\" height=\"202\">\r\n");
      out.write("                        <param name=\"movie\" value=\"SWF/Clock.swf\" />\r\n");
      out.write("                        <param name=\"quality\" value=\"high\" />\r\n");
      out.write("                        <embed src=\"../Clock.swf\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"201\" height=\"202\"></embed>\r\n");
      out.write("                    </object>\r\n");
      out.write("                </div></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </body>\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_info.uname != user_info.empty_string && user_info.uname != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            ");
        org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user_info"), "uname", "666", null, null, false);
        out.write("            \r\n");
        out.write("            ");
        org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user_info"), "utype", "", null, null, false);
        out.write("\r\n");
        out.write("            ");
        if (true) {
          _jspx_page_context.forward("home.jsp");
          return true;
        }
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
