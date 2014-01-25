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
      out.write("            ");

            String a = (String)request.getAttribute("a");
            String b = (String)request.getAttribute("b");
            
            if(a==null)a="";
            if(b==null)b="";
            
      out.write("\n");
      out.write("            A:<input type=\"text\" name=\"txtA\" value=\"");
      out.print(a);
      out.write("\"/><br/>\n");
      out.write("            B:<input type=\"text\" name=\"txtB\" value=\"");
      out.print(b);
      out.write("\"/>\n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            ");

            String [] c = (String[])request.getAttribute("c");
            
            if(c==null)c = new String[] {"","","",""};
            
      out.write("\n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"add\" ");
      out.print(c[0]);
      out.write(" />Add\n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"subtract\" ");
      out.print(c[1]);
      out.write(" />Subtract\n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"multiply\" ");
      out.print(c[2]);
      out.write(" />Multiply\n");
      out.write("            <input type=\"radio\" name=\"rdOperation\" value=\"divide\" ");
      out.print(c[3]);
      out.write(" />Divide\n");
      out.write("            \n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("            ");
 String result = (String)request.getAttribute("result");
                if(result == null)result = "";
            
      out.write("\n");
      out.write("            Result: ");
      out.print( result );
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
