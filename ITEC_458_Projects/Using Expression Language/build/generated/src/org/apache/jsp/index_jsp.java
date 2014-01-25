package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Simple Calculator</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Simple Calculator</h1>\n");
      out.write("        \n");
      out.write("        <form action=\"calc\" method=\"post\">\n");
      out.write("            A:<input type=\"text\" name=\"txtA\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${a}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/><br/>\n");
      out.write("            B:<input type=\"text\" name=\"txtB\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${b}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            \n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"add\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" />Add\n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"subtract\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c[1]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" />Subtract\n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"multiply\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c[2]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" />Multiply\n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"divide\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c[3]}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(" />Divide\n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            Result: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${result}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Calculate\"/>\n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            <div style=\"color:red\">\n");
      out.write("                ");

                    List<String> errors = (List)request.getAttribute("errors");
                    if(errors != null){
                        for(String str : errors){
                            out.println("<li>"+str+"</li>");
                        }
                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
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
