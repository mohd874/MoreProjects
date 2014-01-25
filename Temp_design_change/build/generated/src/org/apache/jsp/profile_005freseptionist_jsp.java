package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_005freseptionist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/trace_n_taglib.jsp");
    _jspx_dependants.add("/navigation_buttons.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_transaction_dataSource;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_query_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_query_var_dataSource;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_transaction_dataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_query_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_query_var_dataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.release();
    _jspx_tagPool_sql_transaction_dataSource.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_sql_query_var.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_sql_query_var_dataSource.release();
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

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("        <title>Profile</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            <!--\n");
      out.write("            @import url(\"CSS/ndesign.css\");\n");
      out.write("            -->\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
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
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"ndesign\" id=\"cssall\">\n");
      out.write("            <div class=\"ndesign\" id=\"nlocation\">\n");
      out.write("                <div align=\"center\">\n");
      out.write("                    <p>&nbsp;</p>\n");
      out.write("                    <p><img src=\"location gif/Profile.gif\" width=\"295\" height=\"100\"></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ndesign\" id=\"nwelcome\">\n");
      out.write("                <div align=\"center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ndesign\" id=\"nclock\">\n");
      out.write("                <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\" width=\"100\" height=\"100\">\n");
      out.write("                    <param name=\"movie\" value=\"SWF/Clock.swf\">\n");
      out.write("                    <param name=\"quality\" value=\"high\">\n");
      out.write("                    <embed src=\"SWF/Clock.swf\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" width=\"100\" height=\"100\"></embed>\n");
      out.write("                </object>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ndesign\" id=\"ncenter\">\n");
      out.write("                ");
      if (_jspx_meth_sql_setDataSource_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                \n");
      out.write("                ");
      if (_jspx_meth_sql_transaction_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                \n");
      out.write("                <form id=\"form2\" method=\"post\" action=\"profile_reseptionist.jsp\">\n");
      out.write("                    <p>Select a customer:\n");
      out.write("                        <select name=\"user_id\">\n");
      out.write("                            <option value=\"\"> SELECT </option>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select> \n");
      out.write("                    </p>\n");
      out.write("                    <p>\n");
      out.write("                        <input type=\"submit\" name=\"Submit2\" value=\"Submit\">\n");
      out.write("                    </p>\n");
      out.write("                </form>\n");
      out.write("                <form id=\"form1\" method=\"post\" action=\"profile_admin_control.page\">\n");
      out.write("                    <font color=\"red\">\n");
      out.write("                        <b>\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errors}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("                            \n");
      out.write("                        </b>\n");
      out.write("                    </font>\n");
      out.write("                    <table width=\"500\" border=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"2\"><h1><strong><em><font color=\"#3399FF\" face=\"Arial, Helvetica, sans-serif\">Account Information</font></em></strong></h1></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ndesign\" id=\"nnavi\">\n");
      out.write("                ");
      if (_jspx_meth_c_choose_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ndesign\" id=\"welcome\"></div>\n");
      out.write("        </div>\n");
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

  private boolean _jspx_meth_sql_setDataSource_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:setDataSource
    org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag _jspx_th_sql_setDataSource_0 = (org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag) _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.get(org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag.class);
    _jspx_th_sql_setDataSource_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_setDataSource_0.setParent(null);
    _jspx_th_sql_setDataSource_0.setUrl("jdbc:mysql://localhost:3306/dph_db_test");
    _jspx_th_sql_setDataSource_0.setDriver("com.mysql.jdbc.Driver");
    _jspx_th_sql_setDataSource_0.setUser("root");
    _jspx_th_sql_setDataSource_0.setPassword("7710072");
    _jspx_th_sql_setDataSource_0.setVar("myDB");
    int _jspx_eval_sql_setDataSource_0 = _jspx_th_sql_setDataSource_0.doStartTag();
    if (_jspx_th_sql_setDataSource_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
    return false;
  }

  private boolean _jspx_meth_sql_transaction_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:transaction
    org.apache.taglibs.standard.tag.rt.sql.TransactionTag _jspx_th_sql_transaction_0 = (org.apache.taglibs.standard.tag.rt.sql.TransactionTag) _jspx_tagPool_sql_transaction_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.TransactionTag.class);
    _jspx_th_sql_transaction_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_transaction_0.setParent(null);
    _jspx_th_sql_transaction_0.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myDB}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_sql_transaction_0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_transaction_0 = _jspx_th_sql_transaction_0.doStartTag();
      if (_jspx_eval_sql_transaction_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    ");
          if (_jspx_meth_c_if_0(_jspx_th_sql_transaction_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
            return true;
          out.write("\n");
          out.write("                    \n");
          out.write("                    ");
          if (_jspx_meth_c_if_1(_jspx_th_sql_transaction_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
            return true;
          out.write("\n");
          out.write("                    \n");
          out.write("                    ");
          if (_jspx_meth_sql_query_4(_jspx_th_sql_transaction_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
            return true;
          out.write("\n");
          out.write("                    \n");
          out.write("                    ");
          if (_jspx_meth_sql_query_5(_jspx_th_sql_transaction_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
            return true;
          out.write("\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_sql_transaction_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_sql_transaction_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_transaction_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_transaction_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_transaction_0.doFinally();
      _jspx_tagPool_sql_transaction_dataSource.reuse(_jspx_th_sql_transaction_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sql_transaction_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_transaction_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user_id != '' && param.user_id != null }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_sql_query_0(_jspx_th_c_if_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
          return true;
        out.write("\n");
        out.write("                    \n");
        out.write("                        ");
        if (_jspx_meth_sql_query_1(_jspx_th_c_if_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
          return true;
        out.write("\n");
        out.write("                    ");
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

  private boolean _jspx_meth_sql_query_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_sql_query_0.setVar("employees");
    int[] _jspx_push_body_count_sql_query_0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_0 = _jspx_th_sql_query_0.doStartTag();
      if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_0[0]++;
          _jspx_th_sql_query_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                            select * from sysuser,employees \n");
          out.write("                            where user_id = '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("' AND employee_id = user_id \n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_sql_query_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_0[0]--;
      }
      if (_jspx_th_sql_query_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_0.doFinally();
      _jspx_tagPool_sql_query_var.reuse(_jspx_th_sql_query_0);
    }
    return false;
  }

  private boolean _jspx_meth_sql_query_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_1 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_1.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_sql_query_1.setVar("customers");
    int[] _jspx_push_body_count_sql_query_1 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_1 = _jspx_th_sql_query_1.doStartTag();
      if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_1[0]++;
          _jspx_th_sql_query_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_1.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                            select * from sysuser,customers\n");
          out.write("                            where user_id = '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("' AND customer_id = user_id \n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_sql_query_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_1[0]--;
      }
      if (_jspx_th_sql_query_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_1.doFinally();
      _jspx_tagPool_sql_query_var.reuse(_jspx_th_sql_query_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_sql_transaction_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_transaction_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id != '' && user_id != null }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_sql_query_2(_jspx_th_c_if_1, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
          return true;
        out.write("\n");
        out.write("                    \n");
        out.write("                        ");
        if (_jspx_meth_sql_query_3(_jspx_th_c_if_1, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
          return true;
        out.write("\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_sql_query_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_2 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_2.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_sql_query_2.setVar("employees");
    int[] _jspx_push_body_count_sql_query_2 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_2 = _jspx_th_sql_query_2.doStartTag();
      if (_jspx_eval_sql_query_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_2[0]++;
          _jspx_th_sql_query_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_2.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                            select * from sysuser,employees \n");
          out.write("                            where user_id = '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("' AND employee_id = user_id \n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_sql_query_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_2[0]--;
      }
      if (_jspx_th_sql_query_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_2.doFinally();
      _jspx_tagPool_sql_query_var.reuse(_jspx_th_sql_query_2);
    }
    return false;
  }

  private boolean _jspx_meth_sql_query_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_3 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_3.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_sql_query_3.setVar("customers");
    int[] _jspx_push_body_count_sql_query_3 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_3 = _jspx_th_sql_query_3.doStartTag();
      if (_jspx_eval_sql_query_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_3[0]++;
          _jspx_th_sql_query_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_3.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                            select * from sysuser,customers\n");
          out.write("                            where user_id = '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("' AND customer_id = user_id \n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_sql_query_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_3[0]--;
      }
      if (_jspx_th_sql_query_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_3.doFinally();
      _jspx_tagPool_sql_query_var.reuse(_jspx_th_sql_query_3);
    }
    return false;
  }

  private boolean _jspx_meth_sql_query_4(javax.servlet.jsp.tagext.JspTag _jspx_th_sql_transaction_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_4 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_4.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_transaction_0);
    _jspx_th_sql_query_4.setVar("names");
    int[] _jspx_push_body_count_sql_query_4 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_4 = _jspx_th_sql_query_4.doStartTag();
      if (_jspx_eval_sql_query_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_4[0]++;
          _jspx_th_sql_query_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_4.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                        select user_id, name,surname, usertype.user_type from sysuser, customers, usertype where usertype.type_id = sysuser.user_type AND user_id = customer_id\n");
          out.write("                        order by name\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_sql_query_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_4[0]--;
      }
      if (_jspx_th_sql_query_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_4.doFinally();
      _jspx_tagPool_sql_query_var.reuse(_jspx_th_sql_query_4);
    }
    return false;
  }

  private boolean _jspx_meth_sql_query_5(javax.servlet.jsp.tagext.JspTag _jspx_th_sql_transaction_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_5 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_5.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_transaction_0);
    _jspx_th_sql_query_5.setVar("self");
    int[] _jspx_push_body_count_sql_query_5 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_5 = _jspx_th_sql_query_5.doStartTag();
      if (_jspx_eval_sql_query_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_5[0]++;
          _jspx_th_sql_query_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_5.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                        select user_id, name, surname from sysuser where user_id = '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.userID}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("'\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_sql_query_5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_5[0]--;
      }
      if (_jspx_th_sql_query_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_5.doFinally();
      _jspx_tagPool_sql_query_var.reuse(_jspx_th_sql_query_5);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("name");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${self.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          if (_jspx_meth_c_if_2(_jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write(' ');
          out.write('>');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name.surname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(" </option>\n");
          out.write("                            ");
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
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user_id == name.user_id || user_id == name.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("user");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${names.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          if (_jspx_meth_c_if_3(_jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write(' ');
          out.write('>');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.surname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(" </option>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.user_id == user.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("record");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customers.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td width=\"182\">User name: </td>\n");
          out.write("                                <td width=\"308\">\n");
          out.write("                                    <input name=\"uname\" type=\"text\" id=\"uname\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" readonly=\"true\"/>\n");
          out.write("                                    \n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td><input name=\"Submit\" type=\"submit\" value=\"Reset Password\"> </td>\n");
          out.write("                                <td><font color=\"red\"> This will reset the password to \"0000\"</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            \n");
          out.write("                            <td colspan=\"2\"><h1><strong><em><font color=\"#3399FF\" face=\"Arial, Helvetica, sans-serif\">Personal Information </font></em></strong></h1></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Name:</td>\n");
          out.write("                                <td><input name=\"name\" type=\"text\" id=\"name\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">* ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"name\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Sur Name: </td>\n");
          out.write("                                <td><input name=\"sur_name\" type=\"text\" id=\"sur_name\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.surname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"sur_name\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Title:</td>\n");
          out.write("                                <td>\n");
          out.write("                                <select name=\"title\" id=\"title\">\n");
          out.write("                                    <option value=\"mr\" ");
          if (_jspx_meth_c_if_4(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write(" >Mr.</option>\n");
          out.write("                                    <option value=\"dr\" ");
          if (_jspx_meth_c_if_5(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write(" >Dr.</option>\n");
          out.write("                                    <option value=\"miss\" ");
          if (_jspx_meth_c_if_6(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write(" >Miss</option>\n");
          out.write("                                    <option value=\"mrs\" ");
          if (_jspx_meth_c_if_7(_jspx_th_c_forEach_2, _jspx_page_context, _jspx_push_body_count_c_forEach_2))
            return true;
          out.write(" >Mrs.</option>\n");
          out.write("                                </select>\n");
          out.write("                                <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"title\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Phone Number: </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <input name=\"phone\" type=\"text\" id=\"phone\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.phone_number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Moblie Number: </td>\n");
          out.write("                                <td><input name=\"mobile\" type=\"text\" id=\"mobile\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.mobile_number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">*</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Fax:</td>\n");
          out.write("                                <td><input name=\"fax\" type=\"text\" id=\"fax\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.fax}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Address:</td>\n");
          out.write("                                <td><input name=\"address\" type=\"text\" id=\"address\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">*</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Passport Number: </td>\n");
          out.write("                                <td><input name=\"passport\" type=\"text\" id=\"passport\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.passport_number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>P.O.Box:</td>\n");
          out.write("                                <td><input name=\"b_o_box\" type=\"text\" id=\"b_o_box\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.b_o_box}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Nationality:</td>\n");
          out.write("                                <td>\n");
          out.write("                                    <select name=\"nationality\" size=\"1\">\n");
          out.write("                                        <option value=\"select\">Select</option>\n");
          out.write("                                        <option value=\"afghanistan\">Afghanistan</option>\n");
          out.write("                                        <option value=\"albania\">Albania</option>\n");
          out.write("                                        <option value=\"algeria\">Algeria</option>\n");
          out.write("                                        <option value=\"andorra\">Andorra</option>\n");
          out.write("                                        <option value=\"anguilla\">Anguilla</option>\n");
          out.write("                                        <option value=\"antigua_and_barbuda\">Antigua and Barbuda</option>\n");
          out.write("                                        <option value=\"argentina\">Argentina</option>\n");
          out.write("                                        <option value=\"armenia\">Armenia</option>\n");
          out.write("                                        <option value=\"aruba\">Aruba</option>\n");
          out.write("                                        <option value=\"ashmore_and_cartier_islands\">Ashmore and Cartier Islands</option>\n");
          out.write("                                        <option value=\"australia\">Australia</option>\n");
          out.write("                                        <option value=\"austria\">Austria</option>\n");
          out.write("                                        <option value=\"azerbaijan\">Azerbaijan</option>\n");
          out.write("                                        <option value=\"bahamas\">Bahamas</option>\n");
          out.write("                                        <option value=\"bahrain\">Bahrain</option>\n");
          out.write("                                        <option value=\"bangladesh\">Bangladesh</option>\n");
          out.write("                                        <option value=\"barbados\">Barbados</option>\n");
          out.write("                                        <option value=\"belarus\">Belarus</option>\n");
          out.write("                                        <option value=\"belgium\">Belgium</option>\n");
          out.write("                                        <option value=\"belize\">Belize</option>\n");
          out.write("                                        <option value=\"benin\">Benin</option>\n");
          out.write("                                        <option value=\"bhutan\">Bhutan</option>\n");
          out.write("                                        <option value=\"bolivia\">Bolivia</option>\n");
          out.write("                                        <option value=\"bosnia_and_herzegovina\">Bosnia and Herzegovina</option>\n");
          out.write("                                        <option value=\"botswana\">Botswana</option>\n");
          out.write("                                        <option value=\"brazil\">Brazil</option>\n");
          out.write("                                        <option value=\"british\">British</option>\n");
          out.write("                                        <option value=\"brunei\">Brunei</option>\n");
          out.write("                                        <option value=\"bulgaria\">Bulgaria</option>\n");
          out.write("                                        <option value=\"burkina_faso\">Burkina Faso</option>\n");
          out.write("                                        <option value=\"burma\">Burma</option>\n");
          out.write("                                        <option value=\"burundi\">Burundi</option>\n");
          out.write("                                        <option value=\"cambodia\">Cambodia</option>\n");
          out.write("                                        <option value=\"cameroon\">Cameroon</option>\n");
          out.write("                                        <option value=\"canada\">Canada</option>\n");
          out.write("                                        <option value=\"cape_verde\">Cape Verde</option>\n");
          out.write("                                        <option value=\"cayman_islands\">Cayman Islands</option>\n");
          out.write("                                        <option value=\"central_african_republic\">Central African Republic</option>\n");
          out.write("                                        <option value=\"chad\">Chad</option>\n");
          out.write("                                        <option value=\"chile\">Chile</option>\n");
          out.write("                                        <option value=\"china\">China</option>\n");
          out.write("                                        <option value=\"colombia\">Colombia</option>\n");
          out.write("                                        <option value=\"comoros\">Comoros</option>\n");
          out.write("                                        <option value=\"congo\">Congo</option>\n");
          out.write("                                        <option value=\"congo_Dem_rep\">Congo, Dem. Rep.</option>\n");
          out.write("                                        <option value=\"cook_islands\">Cook Islands</option>\n");
          out.write("                                        <option value=\"costa_rica\">Costa Rica</option>\n");
          out.write("                                        <option value=\"cote_d'ivoire\">Cote d'Ivoire</option>\n");
          out.write("                                        <option value=\"croatia\">Croatia</option>\n");
          out.write("                                        <option value=\"cuba\">Cuba</option>\n");
          out.write("                                        <option value=\"cyprus\">Cyprus</option>\n");
          out.write("                                        <option value=\"czech_republic\">Czech Republic</option>\n");
          out.write("                                        <option value=\"denmark\">Denmark</option>\n");
          out.write("                                        <option value=\"deutschland\">Deutschland</option>\n");
          out.write("                                        <option value=\"djibouti\">Djibouti</option>\n");
          out.write("                                        <option value=\"dominica\">Dominica</option>\n");
          out.write("                                        <option value=\"dominican_republic\">Dominican Republic</option>\n");
          out.write("                                        <option value=\"east_timor\">East Timor</option>\n");
          out.write("                                        <option value=\"ecuador\">Ecuador</option>\n");
          out.write("                                        <option value=\"egypt\">Egypt</option>\n");
          out.write("                                        <option value=\"el_salvador\">El Salvador</option>\n");
          out.write("                                        <option value=\"equatorial_guinea\">Equatorial Guinea</option>\n");
          out.write("                                        <option value=\"eritrea\">Eritrea</option>\n");
          out.write("                                        <option value=\"estonia\">Estonia</option>\n");
          out.write("                                        <option value=\"ethiopia\">Ethiopia</option>\n");
          out.write("                                        <option value=\"faroe_islands\">Faroe Islands</option>\n");
          out.write("                                        <option value=\"fiji\">Fiji</option>\n");
          out.write("                                        <option value=\"finland\">Finland</option>\n");
          out.write("                                        <option value=\"france\">France</option>\n");
          out.write("                                        <option value=\"french_guyana\">French Guyana</option>\n");
          out.write("                                        <option value=\"french_polynesia\">French Polynesia</option>\n");
          out.write("                                        <option value=\"fyrom\">F.Y.R.O.M.</option>\n");
          out.write("                                        <option value=\"gabon\">Gabon</option>\n");
          out.write("                                        <option value=\"gambia\">Gambia</option>\n");
          out.write("                                        <option value=\"georgia\">Georgia</option>\n");
          out.write("                                        <option value=\"germany\">Germany</option>\n");
          out.write("                                        <option value=\"ghana\">Ghana</option>\n");
          out.write("                                        <option value=\"great_britain\">Great Britain</option>\n");
          out.write("                                        <option value=\"greece\">Greece</option>\n");
          out.write("                                        <option value=\"greenland\">Greenland</option>\n");
          out.write("                                        <option value=\"grenada\">Grenada</option>\n");
          out.write("                                        <option value=\"guadeloupe\">Guadeloupe</option>\n");
          out.write("                                        <option value=\"guam\">Guam</option>\n");
          out.write("                                        <option value=\"guatemala\">Guatemala</option>\n");
          out.write("                                        <option value=\"guernsey\">Guernsey</option>\n");
          out.write("                                        <option value=\"guinea\">Guinea</option>\n");
          out.write("                                        <option value=\"guinea_bissau\">Guinea-Bissau</option>\n");
          out.write("                                        <option value=\"guyana\">Guyana</option>\n");
          out.write("                                        <option value=\"haiti\">Haiti</option>\n");
          out.write("                                        <option value=\"holland\">Holland</option>\n");
          out.write("                                        <option value=\"honduras\">Honduras</option>\n");
          out.write("                                        <option value=\"hungary\">Hungary</option>\n");
          out.write("                                        <option value=\"iceland\">Iceland</option>\n");
          out.write("                                        <option value=\"india\">India</option>\n");
          out.write("                                        <option value=\"indonesia\">Indonesia</option>\n");
          out.write("                                        <option value=\"iran\">Iran</option>\n");
          out.write("                                        <option value=\"iraq\">Iraq</option>\n");
          out.write("                                        <option value=\"ireland \">Ireland </option>\n");
          out.write("                                        <option value=\"isle_of_man\">Isle of Man</option>\n");
          out.write("                                        <option value=\"israel\">Israel</option>\n");
          out.write("                                        <option value=\"italy\">Italy</option>\n");
          out.write("                                        <option value=\"jamaica\">Jamaica</option>\n");
          out.write("                                        <option value=\"japan\">Japan</option>\n");
          out.write("                                        <option value=\"jordan\">Jordan</option>\n");
          out.write("                                        <option value=\"kazakstan\">Kazakstan</option>\n");
          out.write("                                        <option value=\"kenya\">Kenya</option>\n");
          out.write("                                        <option value=\"kiribati\">Kiribati</option>\n");
          out.write("                                        <option value=\"korea_north\">Korea, North</option>\n");
          out.write("                                        <option value=\"korea_south\">Korea, South</option>\n");
          out.write("                                        <option value=\"kuwait\">Kuwait</option>\n");
          out.write("                                        <option value=\"kyrgyzstan\">Kyrgyzstan</option>\n");
          out.write("                                        <option value=\"laos\">Laos</option>\n");
          out.write("                                        <option value=\"latvia\">Latvia</option>\n");
          out.write("                                        <option value=\"lebanon\">Lebanon</option>\n");
          out.write("                                        <option value=\"lesotho\">Lesotho</option>\n");
          out.write("                                        <option value=\"liberia\">Liberia</option>\n");
          out.write("                                        <option value=\"libya\">Libya</option>\n");
          out.write("                                        <option value=\"liechtenstein\">Liechtenstein</option>\n");
          out.write("                                        <option value=\"lithuania\">Lithuania</option>\n");
          out.write("                                        <option value=\"luxembourg\">Luxembourg</option>\n");
          out.write("                                        <option value=\"madagascar\">Madagascar</option>\n");
          out.write("                                        <option value=\"malawi\">Malawi</option>\n");
          out.write("                                        <option value=\"malaysia\">Malaysia</option>\n");
          out.write("                                        <option value=\"maldives\">Maldives</option>\n");
          out.write("                                        <option value=\"mali\">Mali</option>\n");
          out.write("                                        <option value=\"malta\">Malta</option>\n");
          out.write("                                        <option value=\"marshall_islands\">Marshall Islands</option>\n");
          out.write("                                        <option value=\"martinique\">Martinique</option>\n");
          out.write("                                        <option value=\"mauritania\">Mauritania</option>\n");
          out.write("                                        <option value=\"mauritius\">Mauritius</option>\n");
          out.write("                                        <option value=\"mexico\">Mexico</option>\n");
          out.write("                                        <option value=\"micronesia_federated_states_of\">Micronesia, Federated States Of</option>\n");
          out.write("                                        <option value=\"moldova\">Moldova</option>\n");
          out.write("                                        <option value=\"monaco\">Monaco</option>\n");
          out.write("                                        <option value=\"mongolia\">Mongolia</option>\n");
          out.write("                                        <option value=\"montserrat\">Montserrat</option>\n");
          out.write("                                        <option value=\"morocco\">Morocco</option>\n");
          out.write("                                        <option value=\"mozambique\">Mozambique</option>\n");
          out.write("                                        <option value=\"myanmar\">Myanmar</option>\n");
          out.write("                                        <option value=\"namibia\">Namibia</option>\n");
          out.write("                                        <option value=\"nauru\">Nauru</option>\n");
          out.write("                                        <option value=\"nato\">NATO</option>\n");
          out.write("                                        <option value=\"nepal\">Nepal</option>\n");
          out.write("                                        <option value=\"netherlands\">Netherlands</option>\n");
          out.write("                                        <option value=\"netherlands_antilles\">Netherlands Antilles</option>\n");
          out.write("                                        <option value=\"new_caledonia\">New Caledonia</option>\n");
          out.write("                                        <option value=\"new_zealand\">New Zealand</option>\n");
          out.write("                                        <option value=\"nicaragua\">Nicaragua</option>\n");
          out.write("                                        <option value=\"niger\">Niger</option>\n");
          out.write("                                        <option value=\"nigeria\">Nigeria</option>\n");
          out.write("                                        <option value=\"niue\">Niue</option>\n");
          out.write("                                        <option value=\"norfolk_island\">Norfolk Island</option>\n");
          out.write("                                        <option value=\"north_korea\">North Korea</option>\n");
          out.write("                                        <option value=\"northern_mariana_islands\">Northern Mariana Islands</option>\n");
          out.write("                                        <option value=\"norway\">Norway</option>\n");
          out.write("                                        <option value=\"oman\">Oman</option>\n");
          out.write("                                        <option value=\"pakistan\">Pakistan</option>\n");
          out.write("                                        <option value=\"palau\">Palau</option>\n");
          out.write("                                        <option value=\"palestine\">Palestine</option>\n");
          out.write("                                        <option value=\"panama\">Panama</option>\n");
          out.write("                                        <option value=\"papua_new_guinea\">Papua New Guinea</option>\n");
          out.write("                                        <option value=\"paraguay\">Paraguay</option>\n");
          out.write("                                        <option value=\"peru\">Peru</option>\n");
          out.write("                                        <option value=\"philippines\">Philippines</option>\n");
          out.write("                                        <option value=\"poland\">Poland</option>\n");
          out.write("                                        <option value=\"portugal\">Portugal</option>\n");
          out.write("                                        <option value=\"qatar\">Qatar</option>\n");
          out.write("                                        <option value=\"romania\">Romania</option>\n");
          out.write("                                        <option value=\"russia\">Russia</option>\n");
          out.write("                                        <option value=\"saint_kitts_and_nevis\">Saint Kitts and Nevis</option>\n");
          out.write("                                        <option value=\"saint_lucia\">Saint Lucia</option>\n");
          out.write("                                        <option value=\"saint_pierre_and_miquelon\">Saint Pierre and Miquelon</option>\n");
          out.write("                                        <option value=\"saint_vincent_and_the_grenadines\">Saint Vincent and the Grenadines</option>\n");
          out.write("                                        <option value=\"samoa\">Samoa</option>\n");
          out.write("                                        <option value=\"san_marino\">San Marino</option>\n");
          out.write("                                        <option value=\"sao_tome_and_principe\">Sao Tome and Principe</option>\n");
          out.write("                                        <option value=\"saudi_arabia\">Saudi Arabia</option>\n");
          out.write("                                        <option value=\"senegal\">Senegal</option>\n");
          out.write("                                        <option value=\"serbia_&amp;_montenegro\">Serbia &amp; Montenegro</option>\n");
          out.write("                                        <option value=\"seychelles\">Seychelles</option>\n");
          out.write("                                        <option value=\"sierra_leone\">Sierra Leone</option>\n");
          out.write("                                        <option value=\"singapore\">Singapore</option>\n");
          out.write("                                        <option value=\"slovakia\">Slovakia</option>\n");
          out.write("                                        <option value=\"slovania\">Slovania</option>\n");
          out.write("                                        <option value=\"solomon_islands\">Solomon Islands</option>\n");
          out.write("                                        <option value=\"somalia\">Somalia</option>\n");
          out.write("                                        <option value=\"south_africa\">South Africa</option>\n");
          out.write("                                        <option value=\"south_korea\">South Korea</option>\n");
          out.write("                                        <option value=\"spain\">Spain</option>\n");
          out.write("                                        <option value=\"sri_lanka\">Sri Lanka</option>\n");
          out.write("                                        <option value=\"st_kitts_and_nevis\">St. Kitts and Nevis</option>\n");
          out.write("                                        <option value=\"sudan\">Sudan</option>\n");
          out.write("                                        <option value=\"suriname\">Suriname</option>\n");
          out.write("                                        <option value=\"swaziland\">Swaziland</option>\n");
          out.write("                                        <option value=\"sweden\">Sweden</option>\n");
          out.write("                                        <option value=\"switzerland\">Switzerland</option>\n");
          out.write("                                        <option value=\"syria\">Syria</option>\n");
          out.write("                                        <option value=\"taiwan\">Taiwan</option>\n");
          out.write("                                        <option value=\"tajikistan\">Tajikistan</option>\n");
          out.write("                                        <option value=\"tanzania\">Tanzania</option>\n");
          out.write("                                        <option value=\"thailand\">Thailand</option>\n");
          out.write("                                        <option value=\"togo\">Togo</option>\n");
          out.write("                                        <option value=\"tonga\">Tonga</option>\n");
          out.write("                                        <option value=\"trinidad_and_tobago\">Trinidad and Tobago</option>\n");
          out.write("                                        <option value=\"tunisia\">Tunisia</option>\n");
          out.write("                                        <option value=\"turkey\">Turkey</option>\n");
          out.write("                                        <option value=\"turkmenistan\">Turkmenistan</option>\n");
          out.write("                                        <option value=\"turks_and_caicos_islands\">Turks and Caicos Islands</option>\n");
          out.write("                                        <option value=\"tuvalu\">Tuvalu</option>\n");
          out.write("                                        <option value=\"uganda\">Uganda</option>\n");
          out.write("                                        <option value=\"ukraine\">Ukraine</option>\n");
          out.write("                                        <option value=\"united_arab_emirates\">United Arab Emirates</option>\n");
          out.write("                                        <option value=\"united_kingdom\">United Kingdom</option>\n");
          out.write("                                        <option value=\"england\">England</option>\n");
          out.write("                                        <option value=\"northern_ireland\">Northern Ireland</option>\n");
          out.write("                                        <option value=\"scotland\">Scotland</option>\n");
          out.write("                                        <option value=\"united_states\">United States</option>\n");
          out.write("                                        <option value=\"uruguay\">Uruguay</option>\n");
          out.write("                                        <option value=\"uzbekistan\">Uzbekistan</option>\n");
          out.write("                                        <option value=\"vanuatu\">Vanuatu</option>\n");
          out.write("                                        <option value=\"vatican_city\">Vatican City</option>\n");
          out.write("                                        <option value=\"venezuela\">Venezuela</option>\n");
          out.write("                                        <option value=\"vietnam\">Vietnam</option>\n");
          out.write("                                        <option value=\"yemen\">Yemen</option>\n");
          out.write("                                        <option value=\"yugoslavia\">Yugoslavia</option>\n");
          out.write("                                        <option value=\"zambia\">Zambia</option>\n");
          out.write("                                        <option value=\"zimbabwe\">Zimbabwe</option>\n");
          out.write("                                    </select>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>E-mail:</td>\n");
          out.write("                                <td><input name=\"email\" type=\"text\" id=\"email\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.e_mail}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"email\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Send Account information to the E-mail: </td>\n");
          out.write("                                <td>\n");
          out.write("                                <input name=\"con_email\" type=\"radio\" value=\"y\" />\n");
          out.write("                                Yes\n");
          out.write("                                        \n");
          out.write("                                <input name=\"con_email\" type=\"radio\" value=\"n\" checked=\"checked\" />\n");
          out.write("                                No</td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>\n");
          out.write("                                    <input name=\"Submit\" type=\"submit\" value=\"update\" />\n");
          out.write("                                </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <input type=\"reset\" name=\"reset\" value=\"Reset\" /><input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.user_type}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" name=\"hidden_user_type\">\n");
          out.write("                                    <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" name=\"hidden_user_id\">\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            \n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.title == mr}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.title == dr}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }

  private boolean _jspx_meth_c_if_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_6 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_6.setPageContext(_jspx_page_context);
    _jspx_th_c_if_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_6.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.title == miss}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_6 = _jspx_th_c_if_6.doStartTag();
    if (_jspx_eval_c_if_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_6);
    return false;
  }

  private boolean _jspx_meth_c_if_7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_7 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_7.setPageContext(_jspx_page_context);
    _jspx_th_c_if_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_2);
    _jspx_th_c_if_7.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.title == mrs}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_7 = _jspx_th_c_if_7.doStartTag();
    if (_jspx_eval_c_if_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_7);
    return false;
  }

  private boolean _jspx_meth_c_forEach_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_3.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_3.setParent(null);
    _jspx_th_c_forEach_3.setVar("record");
    _jspx_th_c_forEach_3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${employees.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_forEach_3 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_3 = _jspx_th_c_forEach_3.doStartTag();
      if (_jspx_eval_c_forEach_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td width=\"182\">User name: </td>\n");
          out.write("                                <td width=\"308\">\n");
          out.write("                                    <input name=\"uname\" type=\"text\" id=\"uname\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.user_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" readonly=\"true\"/>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            ");
          if (_jspx_meth_c_choose_0(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td colspan=\"2\"><h1><strong><em><font color=\"#3399FF\" face=\"Arial, Helvetica, sans-serif\">Personal Information </font></em></strong></h1></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Name:</td>\n");
          out.write("                                <td><input name=\"name\" type=\"text\" id=\"name\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"name\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Sur Name: </td>\n");
          out.write("                                <td><input name=\"sur_name\" type=\"text\" id=\"sur_name\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.surname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"sur_name\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Job Title: </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <input name=\"job_title\" type=\"text\" id=\"job_title\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.job_title}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                    <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"job_title\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Marital Status: </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <select name=\"marital_status\">\n");
          out.write("                                        <option value=\"single\" ");
          if (_jspx_meth_c_if_8(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write(" > Single </option>\n");
          out.write("                                        <option value=\"married\" ");
          if (_jspx_meth_c_if_9(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write(" > Married </option>\n");
          out.write("                                    </select>\n");
          out.write("                                    <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"marital_status\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Gender: </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <select id=\"gender\" name=\"gender\" >\n");
          out.write("                                        <option value=\"male\" ");
          if (_jspx_meth_c_if_10(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write(" >Male</option>\n");
          out.write("                                        <option value=\"female\" ");
          if (_jspx_meth_c_if_11(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write(" >Female</option>\n");
          out.write("                                    </select>\n");
          out.write("                                    <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"gender\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                                    \n");
          out.write("                            <tr>\n");
          out.write("                                <td>Phone Number: </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <input name=\"phone\" type=\"text\" id=\"phone\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.phone_number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                    <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"phone\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Moblie Number: </td>\n");
          out.write("                                <td><input name=\"mobile\" type=\"text\" id=\"mobile\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.mobile_number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                                    \n");
          out.write("                            <tr>\n");
          out.write("                                <td>Address:</td>\n");
          out.write("                                <td><input name=\"address\" type=\"text\" id=\"address\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                <font color=\"#CC3300\">*</font></td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Passport Number: </td>\n");
          out.write("                                <td><input name=\"passport\" type=\"text\" id=\"passport\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.passport_number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                    <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"passport\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>P.O.Box:</td>\n");
          out.write("                                <td><input name=\"b_o_box\" type=\"text\" id=\"b_o_box\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.b_o_box}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("                                        \n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Nationality:</td>\n");
          out.write("                                <td>\n");
          out.write("                                    <select name=\"nationality\" size=\"1\">\n");
          out.write("                                        <option value=\"select\">Select</option>\n");
          out.write("                                        <option value=\"afghanistan\">Afghanistan</option>\n");
          out.write("                                        <option value=\"albania\">Albania</option>\n");
          out.write("                                        <option value=\"algeria\">Algeria</option>\n");
          out.write("                                        <option value=\"andorra\">Andorra</option>\n");
          out.write("                                        <option value=\"anguilla\">Anguilla</option>\n");
          out.write("                                        <option value=\"antigua_and_barbuda\">Antigua and Barbuda</option>\n");
          out.write("                                        <option value=\"argentina\">Argentina</option>\n");
          out.write("                                        <option value=\"armenia\">Armenia</option>\n");
          out.write("                                        <option value=\"aruba\">Aruba</option>\n");
          out.write("                                        <option value=\"ashmore_and_cartier_islands\">Ashmore and Cartier Islands</option>\n");
          out.write("                                        <option value=\"australia\">Australia</option>\n");
          out.write("                                        <option value=\"austria\">Austria</option>\n");
          out.write("                                        <option value=\"azerbaijan\">Azerbaijan</option>\n");
          out.write("                                        <option value=\"bahamas\">Bahamas</option>\n");
          out.write("                                        <option value=\"bahrain\">Bahrain</option>\n");
          out.write("                                        <option value=\"bangladesh\">Bangladesh</option>\n");
          out.write("                                        <option value=\"barbados\">Barbados</option>\n");
          out.write("                                        <option value=\"belarus\">Belarus</option>\n");
          out.write("                                        <option value=\"belgium\">Belgium</option>\n");
          out.write("                                        <option value=\"belize\">Belize</option>\n");
          out.write("                                        <option value=\"benin\">Benin</option>\n");
          out.write("                                        <option value=\"bhutan\">Bhutan</option>\n");
          out.write("                                        <option value=\"bolivia\">Bolivia</option>\n");
          out.write("                                        <option value=\"bosnia_and_herzegovina\">Bosnia and Herzegovina</option>\n");
          out.write("                                        <option value=\"botswana\">Botswana</option>\n");
          out.write("                                        <option value=\"brazil\">Brazil</option>\n");
          out.write("                                        <option value=\"british\">British</option>\n");
          out.write("                                        <option value=\"brunei\">Brunei</option>\n");
          out.write("                                        <option value=\"bulgaria\">Bulgaria</option>\n");
          out.write("                                        <option value=\"burkina_faso\">Burkina Faso</option>\n");
          out.write("                                        <option value=\"burma\">Burma</option>\n");
          out.write("                                        <option value=\"burundi\">Burundi</option>\n");
          out.write("                                        <option value=\"cambodia\">Cambodia</option>\n");
          out.write("                                        <option value=\"cameroon\">Cameroon</option>\n");
          out.write("                                        <option value=\"canada\">Canada</option>\n");
          out.write("                                        <option value=\"cape_verde\">Cape Verde</option>\n");
          out.write("                                        <option value=\"cayman_islands\">Cayman Islands</option>\n");
          out.write("                                        <option value=\"central_african_republic\">Central African Republic</option>\n");
          out.write("                                        <option value=\"chad\">Chad</option>\n");
          out.write("                                        <option value=\"chile\">Chile</option>\n");
          out.write("                                        <option value=\"china\">China</option>\n");
          out.write("                                        <option value=\"colombia\">Colombia</option>\n");
          out.write("                                        <option value=\"comoros\">Comoros</option>\n");
          out.write("                                        <option value=\"congo\">Congo</option>\n");
          out.write("                                        <option value=\"congo_Dem_rep\">Congo, Dem. Rep.</option>\n");
          out.write("                                        <option value=\"cook_islands\">Cook Islands</option>\n");
          out.write("                                        <option value=\"costa_rica\">Costa Rica</option>\n");
          out.write("                                        <option value=\"cote_d'ivoire\">Cote d'Ivoire</option>\n");
          out.write("                                        <option value=\"croatia\">Croatia</option>\n");
          out.write("                                        <option value=\"cuba\">Cuba</option>\n");
          out.write("                                        <option value=\"cyprus\">Cyprus</option>\n");
          out.write("                                        <option value=\"czech_republic\">Czech Republic</option>\n");
          out.write("                                        <option value=\"denmark\">Denmark</option>\n");
          out.write("                                        <option value=\"deutschland\">Deutschland</option>\n");
          out.write("                                        <option value=\"djibouti\">Djibouti</option>\n");
          out.write("                                        <option value=\"dominica\">Dominica</option>\n");
          out.write("                                        <option value=\"dominican_republic\">Dominican Republic</option>\n");
          out.write("                                        <option value=\"east_timor\">East Timor</option>\n");
          out.write("                                        <option value=\"ecuador\">Ecuador</option>\n");
          out.write("                                        <option value=\"egypt\">Egypt</option>\n");
          out.write("                                        <option value=\"el_salvador\">El Salvador</option>\n");
          out.write("                                        <option value=\"equatorial_guinea\">Equatorial Guinea</option>\n");
          out.write("                                        <option value=\"eritrea\">Eritrea</option>\n");
          out.write("                                        <option value=\"estonia\">Estonia</option>\n");
          out.write("                                        <option value=\"ethiopia\">Ethiopia</option>\n");
          out.write("                                        <option value=\"faroe_islands\">Faroe Islands</option>\n");
          out.write("                                        <option value=\"fiji\">Fiji</option>\n");
          out.write("                                        <option value=\"finland\">Finland</option>\n");
          out.write("                                        <option value=\"france\">France</option>\n");
          out.write("                                        <option value=\"french_guyana\">French Guyana</option>\n");
          out.write("                                        <option value=\"french_polynesia\">French Polynesia</option>\n");
          out.write("                                        <option value=\"fyrom\">F.Y.R.O.M.</option>\n");
          out.write("                                        <option value=\"gabon\">Gabon</option>\n");
          out.write("                                        <option value=\"gambia\">Gambia</option>\n");
          out.write("                                        <option value=\"georgia\">Georgia</option>\n");
          out.write("                                        <option value=\"germany\">Germany</option>\n");
          out.write("                                        <option value=\"ghana\">Ghana</option>\n");
          out.write("                                        <option value=\"great_britain\">Great Britain</option>\n");
          out.write("                                        <option value=\"greece\">Greece</option>\n");
          out.write("                                        <option value=\"greenland\">Greenland</option>\n");
          out.write("                                        <option value=\"grenada\">Grenada</option>\n");
          out.write("                                        <option value=\"guadeloupe\">Guadeloupe</option>\n");
          out.write("                                        <option value=\"guam\">Guam</option>\n");
          out.write("                                        <option value=\"guatemala\">Guatemala</option>\n");
          out.write("                                        <option value=\"guernsey\">Guernsey</option>\n");
          out.write("                                        <option value=\"guinea\">Guinea</option>\n");
          out.write("                                        <option value=\"guinea_bissau\">Guinea-Bissau</option>\n");
          out.write("                                        <option value=\"guyana\">Guyana</option>\n");
          out.write("                                        <option value=\"haiti\">Haiti</option>\n");
          out.write("                                        <option value=\"holland\">Holland</option>\n");
          out.write("                                        <option value=\"honduras\">Honduras</option>\n");
          out.write("                                        <option value=\"hungary\">Hungary</option>\n");
          out.write("                                        <option value=\"iceland\">Iceland</option>\n");
          out.write("                                        <option value=\"india\">India</option>\n");
          out.write("                                        <option value=\"indonesia\">Indonesia</option>\n");
          out.write("                                        <option value=\"iran\">Iran</option>\n");
          out.write("                                        <option value=\"iraq\">Iraq</option>\n");
          out.write("                                        <option value=\"ireland \">Ireland </option>\n");
          out.write("                                        <option value=\"isle_of_man\">Isle of Man</option>\n");
          out.write("                                        <option value=\"israel\">Israel</option>\n");
          out.write("                                        <option value=\"italy\">Italy</option>\n");
          out.write("                                        <option value=\"jamaica\">Jamaica</option>\n");
          out.write("                                        <option value=\"japan\">Japan</option>\n");
          out.write("                                        <option value=\"jordan\">Jordan</option>\n");
          out.write("                                        <option value=\"kazakstan\">Kazakstan</option>\n");
          out.write("                                        <option value=\"kenya\">Kenya</option>\n");
          out.write("                                        <option value=\"kiribati\">Kiribati</option>\n");
          out.write("                                        <option value=\"korea_north\">Korea, North</option>\n");
          out.write("                                        <option value=\"korea_south\">Korea, South</option>\n");
          out.write("                                        <option value=\"kuwait\">Kuwait</option>\n");
          out.write("                                        <option value=\"kyrgyzstan\">Kyrgyzstan</option>\n");
          out.write("                                        <option value=\"laos\">Laos</option>\n");
          out.write("                                        <option value=\"latvia\">Latvia</option>\n");
          out.write("                                        <option value=\"lebanon\">Lebanon</option>\n");
          out.write("                                        <option value=\"lesotho\">Lesotho</option>\n");
          out.write("                                        <option value=\"liberia\">Liberia</option>\n");
          out.write("                                        <option value=\"libya\">Libya</option>\n");
          out.write("                                        <option value=\"liechtenstein\">Liechtenstein</option>\n");
          out.write("                                        <option value=\"lithuania\">Lithuania</option>\n");
          out.write("                                        <option value=\"luxembourg\">Luxembourg</option>\n");
          out.write("                                        <option value=\"madagascar\">Madagascar</option>\n");
          out.write("                                        <option value=\"malawi\">Malawi</option>\n");
          out.write("                                        <option value=\"malaysia\">Malaysia</option>\n");
          out.write("                                        <option value=\"maldives\">Maldives</option>\n");
          out.write("                                        <option value=\"mali\">Mali</option>\n");
          out.write("                                        <option value=\"malta\">Malta</option>\n");
          out.write("                                        <option value=\"marshall_islands\">Marshall Islands</option>\n");
          out.write("                                        <option value=\"martinique\">Martinique</option>\n");
          out.write("                                        <option value=\"mauritania\">Mauritania</option>\n");
          out.write("                                        <option value=\"mauritius\">Mauritius</option>\n");
          out.write("                                        <option value=\"mexico\">Mexico</option>\n");
          out.write("                                        <option value=\"micronesia_federated_states_of\">Micronesia, Federated States Of</option>\n");
          out.write("                                        <option value=\"moldova\">Moldova</option>\n");
          out.write("                                        <option value=\"monaco\">Monaco</option>\n");
          out.write("                                        <option value=\"mongolia\">Mongolia</option>\n");
          out.write("                                        <option value=\"montserrat\">Montserrat</option>\n");
          out.write("                                        <option value=\"morocco\">Morocco</option>\n");
          out.write("                                        <option value=\"mozambique\">Mozambique</option>\n");
          out.write("                                        <option value=\"myanmar\">Myanmar</option>\n");
          out.write("                                        <option value=\"namibia\">Namibia</option>\n");
          out.write("                                        <option value=\"nauru\">Nauru</option>\n");
          out.write("                                        <option value=\"nato\">NATO</option>\n");
          out.write("                                        <option value=\"nepal\">Nepal</option>\n");
          out.write("                                        <option value=\"netherlands\">Netherlands</option>\n");
          out.write("                                        <option value=\"netherlands_antilles\">Netherlands Antilles</option>\n");
          out.write("                                        <option value=\"new_caledonia\">New Caledonia</option>\n");
          out.write("                                        <option value=\"new_zealand\">New Zealand</option>\n");
          out.write("                                        <option value=\"nicaragua\">Nicaragua</option>\n");
          out.write("                                        <option value=\"niger\">Niger</option>\n");
          out.write("                                        <option value=\"nigeria\">Nigeria</option>\n");
          out.write("                                        <option value=\"niue\">Niue</option>\n");
          out.write("                                        <option value=\"norfolk_island\">Norfolk Island</option>\n");
          out.write("                                        <option value=\"north_korea\">North Korea</option>\n");
          out.write("                                        <option value=\"northern_mariana_islands\">Northern Mariana Islands</option>\n");
          out.write("                                        <option value=\"norway\">Norway</option>\n");
          out.write("                                        <option value=\"oman\">Oman</option>\n");
          out.write("                                        <option value=\"pakistan\">Pakistan</option>\n");
          out.write("                                        <option value=\"palau\">Palau</option>\n");
          out.write("                                        <option value=\"palestine\">Palestine</option>\n");
          out.write("                                        <option value=\"panama\">Panama</option>\n");
          out.write("                                        <option value=\"papua_new_guinea\">Papua New Guinea</option>\n");
          out.write("                                        <option value=\"paraguay\">Paraguay</option>\n");
          out.write("                                        <option value=\"peru\">Peru</option>\n");
          out.write("                                        <option value=\"philippines\">Philippines</option>\n");
          out.write("                                        <option value=\"poland\">Poland</option>\n");
          out.write("                                        <option value=\"portugal\">Portugal</option>\n");
          out.write("                                        <option value=\"qatar\">Qatar</option>\n");
          out.write("                                        <option value=\"romania\">Romania</option>\n");
          out.write("                                        <option value=\"russia\">Russia</option>\n");
          out.write("                                        <option value=\"saint_kitts_and_nevis\">Saint Kitts and Nevis</option>\n");
          out.write("                                        <option value=\"saint_lucia\">Saint Lucia</option>\n");
          out.write("                                        <option value=\"saint_pierre_and_miquelon\">Saint Pierre and Miquelon</option>\n");
          out.write("                                        <option value=\"saint_vincent_and_the_grenadines\">Saint Vincent and the Grenadines</option>\n");
          out.write("                                        <option value=\"samoa\">Samoa</option>\n");
          out.write("                                        <option value=\"san_marino\">San Marino</option>\n");
          out.write("                                        <option value=\"sao_tome_and_principe\">Sao Tome and Principe</option>\n");
          out.write("                                        <option value=\"saudi_arabia\">Saudi Arabia</option>\n");
          out.write("                                        <option value=\"senegal\">Senegal</option>\n");
          out.write("                                        <option value=\"serbia_&amp;_montenegro\">Serbia &amp; Montenegro</option>\n");
          out.write("                                        <option value=\"seychelles\">Seychelles</option>\n");
          out.write("                                        <option value=\"sierra_leone\">Sierra Leone</option>\n");
          out.write("                                        <option value=\"singapore\">Singapore</option>\n");
          out.write("                                        <option value=\"slovakia\">Slovakia</option>\n");
          out.write("                                        <option value=\"slovania\">Slovania</option>\n");
          out.write("                                        <option value=\"solomon_islands\">Solomon Islands</option>\n");
          out.write("                                        <option value=\"somalia\">Somalia</option>\n");
          out.write("                                        <option value=\"south_africa\">South Africa</option>\n");
          out.write("                                        <option value=\"south_korea\">South Korea</option>\n");
          out.write("                                        <option value=\"spain\">Spain</option>\n");
          out.write("                                        <option value=\"sri_lanka\">Sri Lanka</option>\n");
          out.write("                                        <option value=\"st_kitts_and_nevis\">St. Kitts and Nevis</option>\n");
          out.write("                                        <option value=\"sudan\">Sudan</option>\n");
          out.write("                                        <option value=\"suriname\">Suriname</option>\n");
          out.write("                                        <option value=\"swaziland\">Swaziland</option>\n");
          out.write("                                        <option value=\"sweden\">Sweden</option>\n");
          out.write("                                        <option value=\"switzerland\">Switzerland</option>\n");
          out.write("                                        <option value=\"syria\">Syria</option>\n");
          out.write("                                        <option value=\"taiwan\">Taiwan</option>\n");
          out.write("                                        <option value=\"tajikistan\">Tajikistan</option>\n");
          out.write("                                        <option value=\"tanzania\">Tanzania</option>\n");
          out.write("                                        <option value=\"thailand\">Thailand</option>\n");
          out.write("                                        <option value=\"togo\">Togo</option>\n");
          out.write("                                        <option value=\"tonga\">Tonga</option>\n");
          out.write("                                        <option value=\"trinidad_and_tobago\">Trinidad and Tobago</option>\n");
          out.write("                                        <option value=\"tunisia\">Tunisia</option>\n");
          out.write("                                        <option value=\"turkey\">Turkey</option>\n");
          out.write("                                        <option value=\"turkmenistan\">Turkmenistan</option>\n");
          out.write("                                        <option value=\"turks_and_caicos_islands\">Turks and Caicos Islands</option>\n");
          out.write("                                        <option value=\"tuvalu\">Tuvalu</option>\n");
          out.write("                                        <option value=\"uganda\">Uganda</option>\n");
          out.write("                                        <option value=\"ukraine\">Ukraine</option>\n");
          out.write("                                        <option value=\"united_arab_emirates\">United Arab Emirates</option>\n");
          out.write("                                        <option value=\"united_kingdom\">United Kingdom</option>\n");
          out.write("                                        <option value=\"england\">England</option>\n");
          out.write("                                        <option value=\"northern_ireland\">Northern Ireland</option>\n");
          out.write("                                        <option value=\"scotland\">Scotland</option>\n");
          out.write("                                        <option value=\"united_states\">United States</option>\n");
          out.write("                                        <option value=\"uruguay\">Uruguay</option>\n");
          out.write("                                        <option value=\"uzbekistan\">Uzbekistan</option>\n");
          out.write("                                        <option value=\"vanuatu\">Vanuatu</option>\n");
          out.write("                                        <option value=\"vatican_city\">Vatican City</option>\n");
          out.write("                                        <option value=\"venezuela\">Venezuela</option>\n");
          out.write("                                        <option value=\"vietnam\">Vietnam</option>\n");
          out.write("                                        <option value=\"yemen\">Yemen</option>\n");
          out.write("                                        <option value=\"yugoslavia\">Yugoslavia</option>\n");
          out.write("                                        <option value=\"zambia\">Zambia</option>\n");
          out.write("                                        <option value=\"zimbabwe\">Zimbabwe</option>\n");
          out.write("                                    </select>\n");
          out.write("                                    <font color=\"#CC3300\">*</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                <td>Years of Exp: </td>\n");
          out.write("                                <td> <input type=\"text\" maxlength=\"3\" size=\"3\" name=\"years_of_exp\" id=\"years_of_exp\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.years_of_exp}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\n");
          out.write("                                    <font color=\"#CC3300\">*");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ht[\"years_of_exp\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <tr>\n");
          out.write("                                ");
          if (_jspx_meth_sql_query_6(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\n");
          out.write("                                <td>Service: </td>\n");
          out.write("                                <td>\n");
          out.write("                                    <select id=\"service_no\" name=\"service_no\">\n");
          out.write("                                        ");
          if (_jspx_meth_c_forEach_4(_jspx_th_c_forEach_3, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
            return true;
          out.write("\n");
          out.write("                                    </select>\n");
          out.write("                                    <font color=\"#CC3300\">*</font>\n");
          out.write("                                </td>\n");
          out.write("                            </tr>\n");
          out.write("                            <td>\n");
          out.write("                                <input name=\"Submit\" type=\"submit\" value=\"update\" />\n");
          out.write("                            </td>\n");
          out.write("                            <td>\n");
          out.write("                                <input type=\"reset\" name=\"reset\" value=\"Reset\" /><input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.user_type}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" name=\"hidden_user_type\">\n");
          out.write("                                <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.user_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" name=\"hidden_user_id\">\n");
          out.write("                            </td>\n");
          out.write("                            </tr>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_3.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_3);
    }
    return false;
  }

  private boolean _jspx_meth_c_choose_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_when_0(_jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_when_1(_jspx_th_c_choose_0, _jspx_page_context, _jspx_push_body_count_c_forEach_3))
          return true;
        out.write("\n");
        out.write("                                \n");
        out.write("                            ");
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

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.userID != record.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <tr>\n");
        out.write("                                        <td><input name=\"Submit\" type=\"submit\" value=\"Reset Password\"> </td>\n");
        out.write("                                        <td><font color=\"red\">This will reset the password to \"0000\"</font></td>\n");
        out.write("                                    </tr>\n");
        out.write("                                ");
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

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.userID == record.user_id}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <tr>\n");
        out.write("                                    <td colspan=\"2\"><h3><strong>Changing Password </strong><font color=\"#FF0000\">( leave it empty if you don't want to change it ) </font></h3> </td>\n");
        out.write("                                </tr>\n");
        out.write("                                <tr>\n");
        out.write("                                    <td>Old Password:</td>\n");
        out.write("                                    <td><input name=\"old_pass\" type=\"password\" id=\"old_pass\" /></td>\n");
        out.write("                                </tr>\n");
        out.write("                                <tr>\n");
        out.write("                                    <td>New Password: </td>\n");
        out.write("                                    <td><input name=\"new_pass\" type=\"password\" id=\"new_pass\" /></td>\n");
        out.write("                                </tr>\n");
        out.write("                                <tr>\n");
        out.write("                                    <td>Confirm Password: </td>\n");
        out.write("                                    <td><input name=\"con_pass\" type=\"password\" id=\"con_pass\" /></td>\n");
        out.write("                                </tr>    ");
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

  private boolean _jspx_meth_c_if_8(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_8 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_8.setPageContext(_jspx_page_context);
    _jspx_th_c_if_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_8.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.gender == 'single'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_8 = _jspx_th_c_if_8.doStartTag();
    if (_jspx_eval_c_if_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_8);
    return false;
  }

  private boolean _jspx_meth_c_if_9(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_9 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_9.setPageContext(_jspx_page_context);
    _jspx_th_c_if_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_9.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.gender == 'married'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_9 = _jspx_th_c_if_9.doStartTag();
    if (_jspx_eval_c_if_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_9);
    return false;
  }

  private boolean _jspx_meth_c_if_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_10 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_10.setPageContext(_jspx_page_context);
    _jspx_th_c_if_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_10.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.gender == 'male'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_10 = _jspx_th_c_if_10.doStartTag();
    if (_jspx_eval_c_if_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_10);
    return false;
  }

  private boolean _jspx_meth_c_if_11(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_11 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_11.setPageContext(_jspx_page_context);
    _jspx_th_c_if_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_if_11.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.gender == 'female'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_11 = _jspx_th_c_if_11.doStartTag();
    if (_jspx_eval_c_if_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_11);
    return false;
  }

  private boolean _jspx_meth_sql_query_6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_6 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_6.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_sql_query_6.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myDB}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    _jspx_th_sql_query_6.setVar("service");
    int[] _jspx_push_body_count_sql_query_6 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_6 = _jspx_th_sql_query_6.doStartTag();
      if (_jspx_eval_sql_query_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_6[0]++;
          _jspx_th_sql_query_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_6.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                                    select service_no ,service_type from services\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_sql_query_6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_6[0]--;
      }
      if (_jspx_th_sql_query_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_6.doFinally();
      _jspx_tagPool_sql_query_var_dataSource.reuse(_jspx_th_sql_query_6);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_4.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_3);
    _jspx_th_c_forEach_4.setVar("serv");
    _jspx_th_c_forEach_4.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${service.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_forEach_4 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_4 = _jspx_th_c_forEach_4.doStartTag();
      if (_jspx_eval_c_forEach_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                            <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${serv.service_no}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          if (_jspx_meth_c_if_12(_jspx_th_c_forEach_4, _jspx_page_context, _jspx_push_body_count_c_forEach_4))
            return true;
          out.write(' ');
          out.write('>');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${serv.service_type}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(" </option>\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return true;
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_4.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_4);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_12(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_12 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_12.setPageContext(_jspx_page_context);
    _jspx_th_c_if_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_4);
    _jspx_th_c_if_12.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${record.service_no == serv.service_no}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_if_12 = _jspx_th_c_if_12.doStartTag();
    if (_jspx_eval_c_if_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" selected ");
        int evalDoAfterBody = _jspx_th_c_if_12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_12);
    return false;
  }

  private boolean _jspx_meth_c_choose_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_1.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_1.setParent(null);
    int _jspx_eval_c_choose_1 = _jspx_th_c_choose_1.doStartTag();
    if (_jspx_eval_c_choose_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_2(_jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_3(_jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_4(_jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_when_5(_jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("    ");
        if (_jspx_meth_c_otherwise_0(_jspx_th_c_choose_1, _jspx_page_context))
          return true;
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_choose_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_1);
    return false;
  }

  private boolean _jspx_meth_c_when_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_2.setPageContext(_jspx_page_context);
    _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '4'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
    if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/customer_navi_logout.html", out, false);
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

  private boolean _jspx_meth_c_when_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_3 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_3.setPageContext(_jspx_page_context);
    _jspx_th_c_when_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '3'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_3 = _jspx_th_c_when_3.doStartTag();
    if (_jspx_eval_c_when_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/Receptionist_navi_logout.html", out, false);
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

  private boolean _jspx_meth_c_when_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_4 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_4.setPageContext(_jspx_page_context);
    _jspx_th_c_when_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '2'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_4 = _jspx_th_c_when_4.doStartTag();
    if (_jspx_eval_c_when_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/officer_navi_logout.html", out, false);
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_when_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_4);
    return false;
  }

  private boolean _jspx_meth_c_when_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_5 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_5.setPageContext(_jspx_page_context);
    _jspx_th_c_when_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
    _jspx_th_c_when_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tracing_bean.utype == '1'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_when_5 = _jspx_th_c_when_5.doStartTag();
    if (_jspx_eval_c_when_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common_pages2/admin_navi_logout.html", out, false);
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_when_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_5);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletRequest request = (HttpServletRequest)_jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_1);
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
