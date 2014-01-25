package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class events_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
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
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Events Panel</title>\n");
      out.write("        \n");
      out.write("        <script language=\"JavaScript\" src=\"java_script/pupdate.js\">\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <form name=\"form1\" method=\"post\" action=\"events_control.page\">\n");
      out.write("            <label>Date from: \n");
      out.write("                <input type=\"text\" name=\"dateF\">\n");
      out.write("                <a href=\"#\" onclick=\"getCalendarFor(document.form1.dateF);return false\">[Choose Date]</a>\n");
      out.write("            </label>\n");
      out.write("            <p>\n");
      out.write("                <label>Date to:\n");
      out.write("                    <input type=\"text\" name=\"dateT\">\n");
      out.write("                    <a href=\"#\" onclick=\"getCalendarFor(document.form1.dateT);return false\">[Choose Date]</a>\n");
      out.write("                </label>\n");
      out.write("            </p>\n");
      out.write("            <p>Total price       </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Min:\n");
      out.write("                    <input type=\"text\" name=\"minP\">\n");
      out.write("                </label>&nbsp;&nbsp;\n");
      out.write("                <label>Max:\n");
      out.write("                    <input type=\"text\" name=\"maxP\">\n");
      out.write("                </label>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Customer name:\n");
      out.write("                    <input type=\"text\" name=\"c_name\">\n");
      out.write("                </label>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Facility type:\n");
      out.write("                    <input type=\"text\" name=\"typeF\">\n");
      out.write("                </label>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>Event type:\n");
      out.write("                    <input type=\"text\" name=\"typeE\">\n");
      out.write("                </label>\n");
      out.write("            </p>\n");
      out.write("            <p>Action to be performed: \n");
      out.write("                <label>\n");
      out.write("                <input name=\"act\" type=\"radio\" value=\"s\" checked>\n");
      out.write("                Search</label> \n");
      out.write("                <label>\n");
      out.write("                <input name=\"act\" type=\"radio\" value=\"d\">\n");
      out.write("                Delete</label> \n");
      out.write("                <label>\n");
      out.write("                <input name=\"act\" type=\"radio\" value=\"e\">\n");
      out.write("                Edit</label>\n");
      out.write("            </p>\n");
      out.write("            <p>\n");
      out.write("                <label>\n");
      out.write("                    <input type=\"submit\" name=\"Submit\" value=\"Submit\">\n");
      out.write("                </label>\n");
      out.write("            </p>\n");
      out.write("            <p>To 'Add' new event click <a href=\"before_add_event.page\">HERE</a> </p>\n");
      out.write("        \n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        appointment ID\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        Date From\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        Date To\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        comment\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        total price\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        description\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        customer ID\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        facility ID\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        event ID\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("        \n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        ");

            /*
            ResultSet res = (ResultSet)request.getAttribute("results");


            if(res != null){
            //out.println("first loop!!!");
            res.beforeFirst();
            String appointment_no = "";
            while(res.next()){

            out.println("<tr>");
            out.println("<td>");
            out.println(res.getString("appointment_no")); appointment_no = res.getString("appointment_no");
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("date_from"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("date_to"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("comment"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("total_price"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("description"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("customer_id"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("facility_no"));
            out.println("</td>");
            out.println("<td>");
            out.println(res.getString("event_id"));
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=checkbox id=selectedResults value="+ appointment_no +">");
            out.println("</td>");
            out.println("</tr>");

            }
            }else{
            out.print("jsp: res in null");
            }
            out.println("</table>");

            res = (ResultSet)request.getSession().getAttribute("results");


            if(res != null){
            res.beforeFirst();
            out.println("second loop!!!");
            while(res.next()){
            out.println(res.getString("total_price"));
            }
            }else{
            out.print("jsp2: res in null");
            }
             */
        
      out.write("\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            if (document.all) {\n");
      out.write("            document.writeln(\"<div id=\\\"PopUpCalendar\\\" style=\\\"position:absolute; left:0px; top:0px; z-index:7; width:200px; height:77px; overflow: visible; visibility: hidden; background-color: #FFFFFF; border: 1px none #000000\\\" onMouseOver=\\\"if(ppcTI){clearTimeout(ppcTI);ppcTI=false;}\\\" onMouseOut=\\\"ppcTI=setTimeout(\\'hideCalendar()\\',500)\\\">\");\n");
      out.write("            document.writeln(\"<div id=\\\"monthSelector\\\" style=\\\"position:absolute; left:0px; top:0px; z-index:9; width:181px; height:27px; overflow: visible; visibility:inherit\\\">\");}\n");
      out.write("            else if (document.layers) {\n");
      out.write("            document.writeln(\"<layer id=\\\"PopUpCalendar\\\" pagex=\\\"0\\\" pagey=\\\"0\\\" width=\\\"200\\\" height=\\\"200\\\" z-index=\\\"100\\\" visibility=\\\"hide\\\" bgcolor=\\\"#FFFFFF\\\" onMouseOver=\\\"if(ppcTI){clearTimeout(ppcTI);ppcTI=false;}\\\" onMouseOut=\\\"ppcTI=setTimeout('hideCalendar()',500)\\\">\");\n");
      out.write("            document.writeln(\"<layer id=\\\"monthSelector\\\" left=\\\"0\\\" top=\\\"0\\\" width=\\\"181\\\" height=\\\"27\\\" z-index=\\\"9\\\" visibility=\\\"inherit\\\">\");}\n");
      out.write("            else {\n");
      out.write("            document.writeln(\"<p><font color=\\\"#FF0000\\\"><b>Error ! The current browser is either too old or too modern (usind DOM document structure).</b></font></p>\");}\n");
      out.write("        </script>\n");
      out.write("        <noscript><p><font color=\"#FF0000\"><b>JavaScript is not activated !</b></font></p></noscript>\n");
      out.write("        <table border=\"1\" cellspacing=\"1\" cellpadding=\"2\" width=\"200\" bordercolorlight=\"#000000\" bordercolordark=\"#000000\" vspace=\"0\" hspace=\"0\"><form name=\"ppcMonthList\"><tr><td align=\"center\" bgcolor=\"#CCCCCC\"><a href=\"javascript:moveMonth('Back')\" onMouseOver=\"window.status=' ';return true;\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"><b>< </b></font></a><font face=\"MS Sans Serif, sans-serif\" size=\"1\"> \n");
      out.write("        <select name=\"sItem\" onMouseOut=\"if(ppcIE){window.event.cancelBubble = true;}\" onChange=\"switchMonth(this.options[this.selectedIndex].value)\" style=\"font-family: 'MS Sans Serif', sans-serif; font-size: 9pt\"><option value=\"0\" selected>2000  January</option><option value=\"1\">2000  February</option><option value=\"2\">2000  March</option><option value=\"3\">2000  April</option><option value=\"4\">2000  May</option><option value=\"5\">2000  June</option><option value=\"6\">2000  July</option><option value=\"7\">2000  August</option><option value=\"8\">2000  September</option><option value=\"9\">2000  October</option><option value=\"10\">2000  November</option><option value=\"11\">2000  December</option><option value=\"0\">2001  January</option></select></font><a href=\"javascript:moveMonth('Forward')\" onMouseOver=\"window.status=' ';return true;\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"><b> ></b></font></a></td></tr></form></table>\n");
      out.write("        <table border=\"1\" cellspacing=\"1\" cellpadding=\"2\" bordercolorlight=\"#000000\" bordercolordark=\"#000000\" width=\"200\" vspace=\"0\" hspace=\"0\"><tr align=\"center\" bgcolor=\"#CCCCCC\"><td width=\"20\" bgcolor=\"#FFFFCC\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Su</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Mo</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Tu</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">We</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Th</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Fr</font></b></td><td width=\"20\" bgcolor=\"#FFFFCC\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Sa</font></b></td></tr></table>\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            if (document.all) {\n");
      out.write("            document.writeln(\"</div>\");\n");
      out.write("            document.writeln(\"<div id=\\\"monthDays\\\" style=\\\"position:absolute; left:0px; top:52px; z-index:8; width:200px; height:17px; overflow: visible; visibility:inherit; background-color: #FFFFFF; border: 1px none #000000\\\"> </div></div>\");}\n");
      out.write("            else if (document.layers) {\n");
      out.write("            document.writeln(\"</layer>\");\n");
      out.write("            document.writeln(\"<layer id=\\\"monthDays\\\" left=\\\"0\\\" top=\\\"52\\\" width=\\\"200\\\" height=\\\"17\\\" z-index=\\\"8\\\" bgcolor=\\\"#FFFFFF\\\" visibility=\\\"inherit\\\"> </layer></layer>\");}\n");
      out.write("            else {/*NOP*/}\n");
      out.write("        </script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("record");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${results1.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_c_forEach_0.setVarStatus("count");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <tr>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.appointment_no}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.date_from}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.date_to}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.comment}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.total_price}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.description}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.customer_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.facility_no}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.event_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\n");
          out.write("                        </td>\n");
          out.write("                        <td>\n");
          out.write("                            <input type=\"checkbox\" id=\"selectedResults\" name=\"selectedResults\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.appointment_no}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("                        </td>\n");
          out.write("                    </tr>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
