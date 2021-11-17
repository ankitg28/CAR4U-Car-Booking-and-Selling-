package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class compare_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<html>\n");

Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
ResultSet rs=con.createStatement().executeQuery("select distinct brand from car");    

      out.write("\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("          <script>\n");
      out.write("            var request;\n");
      out.write("            function showCT(){\n");
      out.write("                          request=new XMLHttpRequest();\n");
      out.write("                request.onreadystatechange=getCT;\n");
      out.write("                var v=document.getElementById(\"brand\").value;\n");
      out.write("                  request.open(\"get\", \"CompareShow?brand=\"+v, true);\n");
      out.write("                request.send(null);\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            function getCT(){\n");
      out.write("                if(request.readyState==4 && request.status==200){\n");
      out.write("                    var ans=request.responseText;\n");
      out.write("                    document.getElementById(\"CT\").innerHTML=ans;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                    document.getElementById(\"CT\").innerHTML=\"Error......\";\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <form action=\"displaycompare.jsp\" method=\"Get\">\n");
      out.write("            <pre>\n");
      out.write("       \n");
      out.write("            Car Brand    : <select name=\"brand\" id=\"brand\" onclick=\"showCT()\">\n");

while(rs.next())
{
    String brand=rs.getString(1);

      out.write("\n");
      out.write("<option value=\"");
      out.print(brand);
      out.write('"');
      out.write('>');
      out.print(brand);
      out.write("</option>\n");

}

      out.write("\n");
      out.write("</select>  Car Model   : <select name=\"ct\" id=\"CT\"></select>\n");
      out.write("<div id=\"output\"></div>\n");

ResultSet rs1=con.createStatement().executeQuery("select distinct brand from car"); 

      out.write("\n");
      out.write("          <script>\n");
      out.write("            var request;\n");
      out.write("            function showCT1(){\n");
      out.write("                          request=new XMLHttpRequest();\n");
      out.write("                request.onreadystatechange=getCT1;\n");
      out.write("                var v=document.getElementById(\"brand1\").value;\n");
      out.write("                  request.open(\"get\", \"CompareShow?brand=\"+v, true);\n");
      out.write("                request.send(null);\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            function getCT1(){\n");
      out.write("                if(request.readyState==4 && request.status==200){\n");
      out.write("                    var ans=request.responseText;\n");
      out.write("                    document.getElementById(\"CT1\").innerHTML=ans;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                    document.getElementById(\"CT1\").innerHTML=\"Error......\";    \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>     \n");
      out.write("            Car Brand    : <select name=\"brand1\" id=\"brand1\" onclick=\"showCT1()\">\n");

while(rs1.next())
{
    String brand1=rs1.getString(1);

      out.write("\n");
      out.write("<option value=\"");
      out.print(brand1);
      out.write('"');
      out.write('>');
      out.print(brand1);
      out.write("</option>\n");

}

      out.write("\n");
      out.write("</select>  Car Model   : <select name=\"ct1\" id=\"CT1\"></select>\n");
      out.write("                  \n");
      out.write("                            <br><br>\n");
      out.write("                          <input type=\"submit\" value=\"Compare\"/>\n");
      out.write("\n");
      out.write("<div id=\"output\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </pre>\n");
      out.write("        </form>        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
