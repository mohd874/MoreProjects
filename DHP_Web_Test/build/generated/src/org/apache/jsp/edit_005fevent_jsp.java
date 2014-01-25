package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class edit_005fevent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("        <script language=\"JavaScript\" src=\"java_script/pupdate.js\" type=\"text/javascript\">\r\n");
      out.write("        </script>\r\n");
      out.write("        <title>Edit Event</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${appointment_no}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.appointment_no}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("        <table border=\"1\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                appointment ID                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                Date From                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                Date To                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                comment                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                total price                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                description                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                customer ID                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                facility ID                    </td>\r\n");
      out.write("                <td>\r\n");
      out.write("                event ID                    </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><label>\r\n");
      out.write("                    <input type=\"text\" name=\"appointment_no\" value=\"\">\r\n");
      out.write("                </label></td>\r\n");
      out.write("                <td><label>\r\n");
      out.write("                    <input type=\"text\" name=\"textfield2\"><a href=\"#\" onClick=\"getCalendarFor(document.form1.dateF);return false\">[Choose Date]</a>\r\n");
      out.write("                </label></td>\r\n");
      out.write("                <td><label>\r\n");
      out.write("                    <input type=\"text\" name=\"textfield3\"><a href=\"#\" onClick=\"getCalendarFor(document.form1.dateF);return false\">[Choose Date]</a>\r\n");
      out.write("                </label></td>\r\n");
      out.write("                <td><input type=\"text\" name=\"textfield32\"></td>\r\n");
      out.write("                <td><input type=\"text\" name=\"textfield33\"></td>\r\n");
      out.write("                <td><input type=\"text\" name=\"textfield34\"></td>\r\n");
      out.write("                <td><input type=\"text\" name=\"textfield35\"></td>\r\n");
      out.write("                <td><input type=\"text\" name=\"textfield36\"></td>\r\n");
      out.write("                <td><input type=\"text\" name=\"textfield37\"></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("\t\t\r\n");
      out.write("        <script language=\"JavaScript\" type=\"text/javascript\">\r\n");
      out.write("            if (document.all) {\r\n");
      out.write("            document.writeln(\"<div id=\\\"PopUpCalendar\\\" style=\\\"position:absolute; left:0px; top:0px; z-index:7; width:200px; height:77px; overflow: visible; visibility: hidden; background-color: #FFFFFF; border: 1px none #000000\\\" onMouseOver=\\\"if(ppcTI){clearTimeout(ppcTI);ppcTI=false;}\\\" onMouseOut=\\\"ppcTI=setTimeout(\\'hideCalendar()\\',500)\\\">\");\r\n");
      out.write("            document.writeln(\"<div id=\\\"monthSelector\\\" style=\\\"position:absolute; left:0px; top:0px; z-index:9; width:181px; height:27px; overflow: visible; visibility:inherit\\\">\");}\r\n");
      out.write("            else if (document.layers) {\r\n");
      out.write("            document.writeln(\"<layer id=\\\"PopUpCalendar\\\" pagex=\\\"0\\\" pagey=\\\"0\\\" width=\\\"200\\\" height=\\\"200\\\" z-index=\\\"100\\\" visibility=\\\"hide\\\" bgcolor=\\\"#FFFFFF\\\" onMouseOver=\\\"if(ppcTI){clearTimeout(ppcTI);ppcTI=false;}\\\" onMouseOut=\\\"ppcTI=setTimeout('hideCalendar()',500)\\\">\");\r\n");
      out.write("            document.writeln(\"<layer id=\\\"monthSelector\\\" left=\\\"0\\\" top=\\\"0\\\" width=\\\"181\\\" height=\\\"27\\\" z-index=\\\"9\\\" visibility=\\\"inherit\\\">\");}\r\n");
      out.write("            else {\r\n");
      out.write("            document.writeln(\"<p><font color=\\\"#FF0000\\\"><b>Error ! The current browser is either too old or too modern (usind DOM document structure).</b></font></p>\");}\r\n");
      out.write("        </script>\r\n");
      out.write("        <noscript><p><font color=\"#FF0000\"><b>JavaScript is not activated !</b></font></p></noscript>\r\n");
      out.write("        <table border=\"1\" cellspacing=\"1\" cellpadding=\"2\" width=\"200\" bordercolorlight=\"#000000\" bordercolordark=\"#000000\" vspace=\"0\" hspace=\"0\"><form name=\"ppcMonthList\"><tr><td align=\"center\" bgcolor=\"#CCCCCC\"><a href=\"javascript:moveMonth('Back')\" onmouseover=\"window.status=' ';return true;\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"><b>< </b></font></a><font face=\"MS Sans Serif, sans-serif\" size=\"1\"> \r\n");
      out.write("        <select name=\"sItem\" onmouseout=\"if(ppcIE){window.event.cancelBubble = true;}\" onchange=\"switchMonth(this.options[this.selectedIndex].value)\" style=\"font-family: 'MS Sans Serif', sans-serif; font-size: 9pt\"><option value=\"0\" selected=\"selected\">2000  January</option><option value=\"1\">2000  February</option><option value=\"2\">2000  March</option><option value=\"3\">2000  April</option><option value=\"4\">2000  May</option><option value=\"5\">2000  June</option><option value=\"6\">2000  July</option><option value=\"7\">2000  August</option><option value=\"8\">2000  September</option><option value=\"9\">2000  October</option><option value=\"10\">2000  November</option><option value=\"11\">2000  December</option><option value=\"0\">2001  January</option></select></font><a href=\"javascript:moveMonth('Forward')\" onmouseover=\"window.status=' ';return true;\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"><b> ></b></font></a></td></tr></form></table>\r\n");
      out.write("        <table border=\"1\" cellspacing=\"1\" cellpadding=\"2\" bordercolorlight=\"#000000\" bordercolordark=\"#000000\" width=\"200\" vspace=\"0\" hspace=\"0\"><tr align=\"center\" bgcolor=\"#CCCCCC\"><td width=\"20\" bgcolor=\"#FFFFCC\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Su</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Mo</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Tu</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">We</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Th</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Fr</font></b></td><td width=\"20\" bgcolor=\"#FFFFCC\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Sa</font></b></td></tr></table>\r\n");
      out.write("        <script language=\"JavaScript\" type=\"text/javascript\">\r\n");
      out.write("            if (document.all) {\r\n");
      out.write("            document.writeln(\"</div>\");\r\n");
      out.write("            document.writeln(\"<div id=\\\"monthDays\\\" style=\\\"position:absolute; left:0px; top:52px; z-index:8; width:200px; height:17px; overflow: visible; visibility:inherit; background-color: #FFFFFF; border: 1px none #000000\\\"> </div></div>\");}\r\n");
      out.write("            else if (document.layers) {\r\n");
      out.write("            document.writeln(\"</layer>\");\r\n");
      out.write("            document.writeln(\"<layer id=\\\"monthDays\\\" left=\\\"0\\\" top=\\\"52\\\" width=\\\"200\\\" height=\\\"17\\\" z-index=\\\"8\\\" bgcolor=\\\"#FFFFFF\\\" visibility=\\\"inherit\\\"> </layer></layer>\");}\r\n");
      out.write("            else {/*NOP*/}\r\n");
      out.write("        </script>  \r\n");
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
