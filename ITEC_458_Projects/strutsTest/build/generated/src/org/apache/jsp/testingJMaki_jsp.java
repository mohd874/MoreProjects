package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testingJMaki_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fa_005fwidget_005fname_005fargs_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fa_005fwidget_005fname_005fargs_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fa_005fwidget_005fname_005fargs_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
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
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <h1>JSP Page</h1>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");
      if (_jspx_meth_a_005fwidget_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_a_005fwidget_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  a:widget
    jmaki.runtime.jsp.WidgetTag _jspx_th_a_005fwidget_005f0 = (jmaki.runtime.jsp.WidgetTag) _005fjspx_005ftagPool_005fa_005fwidget_005fname_005fargs_005fnobody.get(jmaki.runtime.jsp.WidgetTag.class);
    _jspx_th_a_005fwidget_005f0.setPageContext(_jspx_page_context);
    _jspx_th_a_005fwidget_005f0.setParent(null);
    // /testingJMaki.jsp(17,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_a_005fwidget_005f0.setName("google.map");
    // /testingJMaki.jsp(17,4) name = args type = null reqTime = true required = false fragment = false deferredValue = false deferredMethod = false expectedTypeName = null methodSignature = null 
    _jspx_th_a_005fwidget_005f0.setArgs("{ centerLat : 37.4041960114344, \n                 centerLon : -122.008194923401 }");
    int[] _jspx_push_body_count_a_005fwidget_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_a_005fwidget_005f0 = _jspx_th_a_005fwidget_005f0.doStartTag();
      if (_jspx_th_a_005fwidget_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_a_005fwidget_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_a_005fwidget_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_a_005fwidget_005f0.doFinally();
      _005fjspx_005ftagPool_005fa_005fwidget_005fname_005fargs_005fnobody.reuse(_jspx_th_a_005fwidget_005f0);
    }
    return false;
  }
}
