package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/trace_n_taglib.jsp");
    _jspx_dependants.add("/navigation_buttons.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_otherwise.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("        <title>Reservation</title>\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("            <!--\r\n");
      out.write("            @import url(\"CSS/ndesign.css\");\r\n");
      out.write("            -->\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"JavaScript\" src=\"java_script/pupdate.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("        <script language=\"JavaScript\" src=\"java_script/agreement_head.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"ndesign\" id=\"cssall\">\r\n");
      out.write("            <div class=\"ndesign\" id=\"nlocation\">\r\n");
      out.write("                <div align=\"center\">\r\n");
      out.write("                    <p>&nbsp;</p>\r\n");
      out.write("                    <p><img src=\"location gif/Reservation.gif\" width=\"295\" height=\"100\"></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      com.hotel.model.tracing_bean tracing_bean = null;
      synchronized (session) {
        tracing_bean = (com.hotel.model.tracing_bean) _jspx_page_context.getAttribute("tracing_bean", PageContext.SESSION_SCOPE);
        if (tracing_bean == null){
          tracing_bean = new com.hotel.model.tracing_bean();
          _jspx_page_context.setAttribute("tracing_bean", tracing_bean, PageContext.SESSION_SCOPE);
          out.write("\r\n");
          out.write("    ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("tracing_bean"), "uname", "Guest", null, null, false);
          out.write("\r\n");
          out.write("    ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("tracing_bean"), "name", "Guest", null, null, false);
          out.write("\r\n");
          out.write("    ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("tracing_bean"), "title", "", null, null, false);
          out.write("\r\n");
          out.write("    ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("tracing_bean"), "utype", "5", null, null, false);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<div class=\"ndesign\" id=\"menu1\">\r\n");
      out.write("    <div align=\"center\" class=\"style1\"><a href=\"home.jsp\">Home</a></div>\r\n");
      out.write("</div>\r\n");
      out.write("  <div class=\"ndesign\" id=\"menu2\">\r\n");
      out.write("      <div align=\"center\"><span class=\"style1\"><a href=\"facilities.jsp\">Facilities</a></span></div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"ndesign\" id=\"menu3\">\r\n");
      out.write("      <div align=\"center\" class=\"style1\"><a href=\"Rooms.jsp\">Rooms</a></div>\r\n");
      out.write("  </div>");
      out.write("\r\n");
      out.write("            <div class=\"ndesign\" id=\"nwelcome\">\r\n");
      out.write("                <div align=\"center\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"ndesign\" id=\"nclock\">\r\n");
      out.write("                <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"100\" height=\"100\">\r\n");
      out.write("                    <param name=\"movie\" value=\"SWF/Clock.swf\">\r\n");
      out.write("                    <param name=\"quality\" value=\"high\">\r\n");
      out.write("                    <embed src=\"SWF/Clock.swf\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"100\" height=\"100\"></embed>\r\n");
      out.write("                </object>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"ndesign\" id=\"ncenter\">\r\n");
      out.write("                \r\n");
      out.write("                <form id=\"form1\" name=\"form1\" method=\"post\" action=\"reservation.page\" onSubmit=\"return defaultagree(this)\">\r\n");
      out.write("                   \r\n");
      out.write("                    <table width=\"475\" height=\"559\" border=\"0\" cellspacing=\"0\">\r\n");
      out.write("                        <tr>                        </tr>\r\n");
      out.write("                       \r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\">Date of Arrival:\r\n");
      out.write("                            <label></label></td>\r\n");
      out.write("                            <td><p>\r\n");
      out.write("                                <input type=\"text\" name=\"date_arrival\" readonly=\"true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ard}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("                                <font color=\"red\">* </font><a href=\"#\" style=\"color:blue\" onclick=\"getCalendarFor(document.form1.date_arrival);return false\">[Choose Date]</a><font color=\"red\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ht[\"ard\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></p>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\">Date of Depart:</td>\r\n");
      out.write("                            <td><p>\r\n");
      out.write("                                <input type=\"text\" name=\"date_depart\" readonly=\"true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.dpd}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("                                <font color=\"red\">* </font><a href=\"#\" style=\"color:blue\" onclick=\"getCalendarFor(document.form1.date_depart);return false\">[Choose Date]</a><font color=\"red\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ht[\"dpd\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></p>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\">Flight Number: </td>\r\n");
      out.write("                            <td><label>\r\n");
      out.write("                                <input name=\"flight\" type=\"text\" id=\"flight\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.flight}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("                            </label></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\">Credit Card No:\r\n");
      out.write("                            <label> </label></td>\r\n");
      out.write("                            <td><input name=\"credit_card_no\" type=\"text\" maxlength=\"30\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ccn}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("                            <font color=\"red\">* ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ht[\"ccn\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\"> Credit Card Expiry  Month:\r\n");
      out.write("                            <label></label></td>\r\n");
      out.write("                            <td><select name=\"expiry_month\">\r\n");
      out.write("                                <option value=\"\">Select</option>\r\n");
      out.write("                                <option value=\"1\">1</option>\r\n");
      out.write("                                <option value=\"2\">2</option>\r\n");
      out.write("                                <option value=\"3\">3</option>\r\n");
      out.write("                                <option value=\"4\">4</option>\r\n");
      out.write("                                <option value=\"5\">5</option>\r\n");
      out.write("                                <option value=\"6\">6</option>\r\n");
      out.write("                                <option value=\"7\">7</option>\r\n");
      out.write("                                <option value=\"8\">8</option>\r\n");
      out.write("                                <option value=\"9\">9</option>\r\n");
      out.write("                                <option value=\"10\">10</option>\r\n");
      out.write("                                <option value=\"11\">11</option>\r\n");
      out.write("                                <option value=\"12\">12</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                            <font color=\"red\">* ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ht[\"expm\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\">Credit Card Expiry Year:\r\n");
      out.write("                            <label></label>\r\n");
      out.write("                            <label></label></td>\r\n");
      out.write("                            <td><select name=\"expiry_year\">\r\n");
      out.write("                                <option value=\"\">Select</option>\r\n");
      out.write("                                <option value=\"2000\">2000</option>\r\n");
      out.write("                                <option value=\"2001\">2001</option>\r\n");
      out.write("                                <option value=\"2002\">2002</option>\r\n");
      out.write("                                <option value=\"2003\">2003</option>\r\n");
      out.write("                                <option value=\"2004\">2004</option>\r\n");
      out.write("                                <option value=\"2005\">2005</option>\r\n");
      out.write("                                <option value=\"2006\">2006</option>\r\n");
      out.write("                                <option value=\"2007\">2007</option>\r\n");
      out.write("                                <option value=\"2008\">2008</option>\r\n");
      out.write("                                <option value=\"2009\">2009</option>\r\n");
      out.write("                                <option value=\"2010\">2010</option>\r\n");
      out.write("                                <option value=\"2011\">2011</option>\r\n");
      out.write("                                <option value=\"2012\">2012</option>\r\n");
      out.write("                                <option value=\"2013\">2013</option>\r\n");
      out.write("                                <option value=\"2014\">2014</option>\r\n");
      out.write("                                <option value=\"2015\">2015</option>\r\n");
      out.write("                                <option value=\"2016\">2016</option>\r\n");
      out.write("                                <option value=\"2017\">2017</option>\r\n");
      out.write("                                <option value=\"2018\">2018</option>\r\n");
      out.write("                                <option value=\"2019\">2019</option>\r\n");
      out.write("                                <option value=\"2020\">2020</option>\r\n");
      out.write("                                <option value=\"2021\">2021</option>\r\n");
      out.write("                                <option value=\"2022\">2022</option>\r\n");
      out.write("                                <option value=\"2023\">2023</option>\r\n");
      out.write("                                <option value=\"2024\">2024</option>\r\n");
      out.write("                                <option value=\"2025\">2025</option>\r\n");
      out.write("                                <option value=\"2026\">2026</option>\r\n");
      out.write("                                <option value=\"2027\">2027</option>\r\n");
      out.write("                                <option value=\"2028\">2028</option>\r\n");
      out.write("                                <option value=\"2029\">2029</option>\r\n");
      out.write("                                <option value=\"2030\">2030</option>\r\n");
      out.write("                                <option value=\"2031\">2031</option>\r\n");
      out.write("                                <option value=\"2032\">2032</option>\r\n");
      out.write("                                <option value=\"2033\">2033</option>\r\n");
      out.write("                                <option value=\"2034\">2034</option>\r\n");
      out.write("                                <option value=\"2035\">2035</option>\r\n");
      out.write("                                <option value=\"2036\">2036</option>\r\n");
      out.write("                                <option value=\"2037\">2037</option>\r\n");
      out.write("                                <option value=\"2038\">2038</option>\r\n");
      out.write("                                <option value=\"2039\">2039</option>\r\n");
      out.write("                                <option value=\"2040\">2040</option>\r\n");
      out.write("                                <option value=\"2041\">2041</option>\r\n");
      out.write("                                <option value=\"2042\">2042</option>\r\n");
      out.write("                                <option value=\"2043\">2043</option>\r\n");
      out.write("                                <option value=\"2044\">2044</option>\r\n");
      out.write("                                <option value=\"2045\">2045</option>\r\n");
      out.write("                                <option value=\"2046\">2046</option>\r\n");
      out.write("                                <option value=\"2047\">2047</option>\r\n");
      out.write("                                <option value=\"2048\">2048</option>\r\n");
      out.write("                                <option value=\"2049\">2049</option>\r\n");
      out.write("                                <option value=\"2050\">2050</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                            <font color=\"red\">* ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ht[\"expy\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\">Confirm Now:</td>\r\n");
      out.write("                            <td>Yes\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <input name=\"confirmation\" type=\"radio\" value=\"y\"/>\r\n");
      out.write("                            </label>\r\n");
      out.write("                            No\r\n");
      out.write("                            <label>\r\n");
      out.write("                                <input name=\"confirmation\" type=\"radio\" value=\"n\" checked=\"checked\"/>\r\n");
      out.write("                            </label><font color=\"red\">* ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.ht[\"cfm\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\">Note:</td>\r\n");
      out.write("                            <td><label>\r\n");
      out.write("                                <textarea name=\"note\" id=\"note\" >");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("</textarea>\r\n");
      out.write("                            </label></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                Agreement:\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                            \r\n");
      out.write("                            \r\n");
      out.write("                                <input name=\"agreecheck\" type=\"checkbox\" onClick=\"agreesubmit(this)\"><b>I agree to the above terms</b>                                \r\n");
      out.write("                            </td>\r\n");
      out.write("                            \r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\"><div align=\"center\">\r\n");
      out.write("                                <input type=\"submit\" name=\"Submit\" value=\" Next \" disabled>/>\r\n");
      out.write("                            </div></td>\r\n");
      out.write("                            <td><input name=\"reset\" type=\"reset\" id=\"reset\" value=\"Reset\" /></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td height=\"43\" colspan=\"2\"><div align=\"center\"></div></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p align=\"left\">\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p>&nbsp;</p>\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <p>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                        <label></label>\r\n");
      out.write("                    </p>\r\n");
      out.write("                </form>\r\n");
      out.write("                <script>\r\n");
      out.write("                    document.forms.form1.agreecheck.checked=false\r\n");
      out.write("                </script>\r\n");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"ndesign\" id=\"nnavi\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"ndesign\" id=\"welcome\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script language=\"JavaScript\">\r\n");
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
      out.write("        <table border=\"1\" cellspacing=\"1\" cellpadding=\"2\" width=\"200\" bordercolorlight=\"#000000\" bordercolordark=\"#000000\" vspace=\"0\" hspace=\"0\"><form name=\"ppcMonthList\"><tr><td align=\"center\" bgcolor=\"#CCCCCC\"><a href=\"javascript:moveMonth('Back')\" onMouseOver=\"window.status=' ';return true;\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"><b>< </b></font></a><font face=\"MS Sans Serif, sans-serif\" size=\"1\"> \r\n");
      out.write("        <select name=\"sItem\" onMouseOut=\"if(ppcIE){window.event.cancelBubble = true;}\" onChange=\"switchMonth(this.options[this.selectedIndex].value)\" style=\"font-family: 'MS Sans Serif', sans-serif; font-size: 9pt\"><option value=\"0\" selected>2000  January</option><option value=\"1\">2000  February</option><option value=\"2\">2000  March</option><option value=\"3\">2000  April</option><option value=\"4\">2000  May</option><option value=\"5\">2000  June</option><option value=\"6\">2000  July</option><option value=\"7\">2000  August</option><option value=\"8\">2000  September</option><option value=\"9\">2000  October</option><option value=\"10\">2000  November</option><option value=\"11\">2000  December</option><option value=\"0\">2001  January</option></select></font><a href=\"javascript:moveMonth('Forward')\" onMouseOver=\"window.status=' ';return true;\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"><b> ></b></font></a></td></tr></form></table>\r\n");
      out.write("        <table border=\"1\" cellspacing=\"1\" cellpadding=\"2\" bordercolorlight=\"#000000\" bordercolordark=\"#000000\" width=\"200\" vspace=\"0\" hspace=\"0\"><tr align=\"center\" bgcolor=\"#CCCCCC\"><td width=\"20\" bgcolor=\"#FFFFCC\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Su</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Mo</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Tu</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">We</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Th</font></b></td><td width=\"20\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Fr</font></b></td><td width=\"20\" bgcolor=\"#FFFFCC\"><b><font face=\"MS Sans Serif, sans-serif\" size=\"1\">Sa</font></b></td></tr></table>\r\n");
      out.write("        <script language=\"JavaScript\">\r\n");
      out.write("            if (document.all) {\r\n");
      out.write("            document.writeln(\"</div>\");\r\n");
      out.write("            document.writeln(\"<div id=\\\"monthDays\\\" style=\\\"position:absolute; left:0px; top:52px; z-index:8; width:200px; height:17px; overflow: visible; visibility:inherit; background-color: #FFFFFF; border: 1px none #000000\\\"> </div></div>\");}\r\n");
      out.write("            else if (document.layers) {\r\n");
      out.write("            document.writeln(\"</layer>\");\r\n");
      out.write("            document.writeln(\"<layer id=\\\"monthDays\\\" left=\\\"0\\\" top=\\\"52\\\" width=\\\"200\\\" height=\\\"17\\\" z-index=\\\"8\\\" bgcolor=\\\"#FFFFFF\\\" visibility=\\\"inherit\\\"> </layer></layer>\");}\r\n");
      out.write("            else {/*NOP*/}\r\n");
      out.write("        </script>\r\n");
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
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.note != ''}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(' ');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${field_values.note}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(' ');
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_0(_jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_1(_jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_2(_jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_3(_jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_otherwise_0(_jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '4'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/customer_navi_logout.html", out, false);
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '3'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/Receptionist_navi_logout.html", out, false);
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_when_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_2.setPageContext(_jspx_page_context);
    _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
    if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/officer_navi_logout.html", out, false);
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_when_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
    return false;
  }

  private boolean _jspx_meth_c_when_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_3 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_3.setPageContext(_jspx_page_context);
    _jspx_th_c_when_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_3 = _jspx_th_c_when_3.doStartTag();
    if (_jspx_eval_c_when_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/admin_navi_logout.html", out, false);
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_when_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_3);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/guest_navi_login.html", out, false);
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
