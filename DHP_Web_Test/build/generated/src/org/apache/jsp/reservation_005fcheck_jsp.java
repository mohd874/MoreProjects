package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.hotel.model.tracing_bean;
import java.sql.*;
import com.hotel.model.tracing_bean;

public final class reservation_005fcheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("        <title>Reservation Check</title>\r\n");
      out.write("        <style type=\"text/css\" media=\"all\">\r\n");
      out.write("            <!--\r\n");
      out.write("            @import url(\"CSS/hotel.css\");\r\n");
      out.write("            -->\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        <table width=\"800\" height=\"600\" border=\"0\" cellspacing=\"0\" bgcolor=\"#FDD398\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th width=\"200\" height=\"100\" scope=\"col\"><div id=\"logo\"></div></th>\r\n");
      out.write("                <th width=\"300\" height=\"100\" scope=\"col\"><div id=\"location\"></div></th>\r\n");
      out.write("                <th width=\"300\" height=\"100\" scope=\"col\"><div id=\"menu\"></div></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th height=\"300\" width=\"200\" scope=\"row\" bgcolor=\"#FDD398\"><div id=\"navi\"></div></th>\r\n");
      out.write("                <td colspan=\"2\" rowspan=\"2\"><div id=\"center\"></br>\r\n");
      out.write("                    <div id=\"center_center\">\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                        ");
      com.hotel.model.tracing_bean tracing_bean = null;
      synchronized (session) {
        tracing_bean = (com.hotel.model.tracing_bean) _jspx_page_context.getAttribute("tracing_bean", PageContext.SESSION_SCOPE);
        if (tracing_bean == null){
          tracing_bean = new com.hotel.model.tracing_bean();
          _jspx_page_context.setAttribute("tracing_bean", tracing_bean, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <form id=\"form1\" name=\"form1\" method=\"post\" action=\"reservation_update.page\">\r\n");
      out.write("                            Please check if all the information are correct:\r\n");
      out.write("                            <table>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><h1><font color=\"blue\" style=\"italic\" >Personal Information: </font></h1></td>\r\n");
      out.write("                                    <td></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>User name: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.uname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Arrival date: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.ard}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Departure date: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.dpd}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Flight: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.flight}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Credit Card #:</td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.ccn}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Credit Card type: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.cct}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Expiry Month: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.expm}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Exipty Year: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.expy}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Flight: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.flight}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>Confirmation: </td>\r\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.cfm}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><h1><font color=\"blue\" style=\"italic\" >Rooms Information: </font></h1></td>\r\n");
      out.write("                                    <td></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>NO: </td>\r\n");
      out.write("                                    <td>Type</td>\r\n");
      out.write("                                    <td>View</td>\r\n");
      out.write("                                    <td>Price</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            \r\n");
      out.write("                                ");

                                    /*
                                    <c:forEach var="record" items="${tracing_bean.roomT}" varStatus="count">
                                    <tr><td>${count.count} </td><td>${tracing_bean.roomT[count.count]}</td></tr>
                                    </c:forEach>
                                     */

                                    for(int i=0; i<tracing_bean.getRooms_id().length; i++){
                                        out.print("<tr><td>"+(i+1)+" </td><td>"+tracing_bean.roomT[i]+"</td><td>"+tracing_bean.roomV[i]+"</td><td>"+tracing_bean.price[i]+"</td></tr>");
                                        String test = "";

                                    }
                                
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td><label>\r\n");
      out.write("                                        <input type=\"submit\" name=\"Submit\" value=\"Submit\" />\r\n");
      out.write("                                    </label>\r\n");
      out.write("                                    </td>\r\n");
      out.write("                                    <td>&nbsp;</td>\r\n");
      out.write("                                    <td>&nbsp;</td>\r\n");
      out.write("                                    <td>&nbsp;</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th width=\"200\" height=\"200\" scope=\"row\"><div id=\"clock\">\r\n");
      out.write("                    <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"201\" height=\"202\">\r\n");
      out.write("                        <param name=\"movie\" value=\"../SWF/Clock.swf\" />\r\n");
      out.write("                        <param name=\"quality\" value=\"high\" />\r\n");
      out.write("                        <embed src=\"SWF/Clock.swf\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"201\" height=\"202\"></embed>\r\n");
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
}
