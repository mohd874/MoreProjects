package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usingex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Arithmatics Operators</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Arithmatics Operators</h2>\n");
      out.write("        \n");
      out.write("        <p>\n");
      out.write("            There are ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${1 + 2 * 4 - 6 / 2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" apples on the table<br/>\n");
      out.write("            It feels like ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${-4-8}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" degrees today<br/>\n");
      out.write("        \n");
      out.write("        ");

        pageContext.setAttribute("grade", 80);
        
      out.write("\n");
      out.write("        \n");
      out.write("            The average grade is ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${grade >= 95 ? \"perfect\" : \"good\"}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(". <br/>\n");
      out.write("            There are ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${23 / 54}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" apples on the table.<br/>\n");
      out.write("            There are ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${6 div 2}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" apples on the table.<br/>\n");
      out.write("            There are ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${2008 mod 3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" apples on the table.<br/>\n");
      out.write("            There are ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${2008 % 3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" apples on the table.<br/>\n");
      out.write("            \n");
      out.write("        </p>\n");
      out.write("        \n");
      out.write("        <h2>Logical Operators</h2>\n");
      out.write("        \n");
      out.write("        <p>\n");
      out.write("            You are passing: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${grade >= 60 &&  grade <= 100}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            You are passing: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${grade >= 60 and grade <= 100}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            \n");
      out.write("        </P>\n");
      out.write("        \n");
      out.write("        <h2>Comparoson Operaators</h2>\n");
      out.write("        \n");
      out.write("        <p>\n");
      out.write("            4 > '3' ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${4 > '3'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            '4' > 3 ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'4' > 3 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            '4' < '3' ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${'4' < '3'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            4 >= 3 ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${4 >= 3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            4 <= 3 ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${4 <= 3}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            4 == '4' ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${4 == '4'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            \n");
      out.write("        <p/>\n");
      out.write("        \n");
      out.write("        <h2>empty Operator</h2>\n");
      out.write("        <p>\n");
      out.write("            empty \"\" ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty \"\" }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            empty \"something\" ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty \"something\" }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            empty Junk ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty Junk }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            empty grade ==> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty grade }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            \n");
      out.write("        </p>\n");
      out.write("        \n");
      out.write("        <h2>Null Values</h2>\n");
      out.write("        <p>\n");
      out.write("            null == null ==>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ null == null }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            null == \"null\" ==>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ null == \"null\" }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<br/>\n");
      out.write("            \n");
      out.write("        </p>\n");
      out.write("        \n");
      out.write("        \n");
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
}
