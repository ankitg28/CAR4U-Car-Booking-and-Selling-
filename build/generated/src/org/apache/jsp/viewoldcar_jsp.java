package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewoldcar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");


    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("select * from oldcar");
    java.sql.ResultSet rs=ps.executeQuery();
    

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Search Results..</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("    <table border=\"5\" width=\"4\" cellspacing=\"3\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Seller Name</th>\n");
      out.write("            <th>Brand</th>\n");
      out.write("            <th>City</th>\n");
      out.write("            <th>Month</th>\n");
      out.write("            <th>Year</th>\n");
      out.write("            <th>Owner type</th>\n");
      out.write("            <th>Kms</th>\n");
      out.write("            <th>Price</th>\n");
      out.write("            <th>Seller Contact</th>\n");
      out.write("            <th>Image</th>\n");
      out.write("            \n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");

String sname="",brand="", city="",otype="",phno="";
int month=0,year=0,kms=0,price=0;
while(rs.next())
{
    int cid=rs.getInt(1);
    java.sql.PreparedStatement ps1=con.prepareStatement("select name,phno from customer where cid=? ");
    ps1.setInt(1,cid);
    java.sql.ResultSet rs1=ps1.executeQuery();
    rs1.next();
    sname=rs1.getString(1);
    phno=rs1.getString(2);
    brand=rs.getString(2);
    city=rs.getString(3);
    month=rs.getInt(4);
    year=rs.getInt(5);
    otype=rs.getString(6);
    kms=rs.getInt(7);
    price=rs.getInt(8);

      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(sname);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(brand);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(city);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(month);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(year);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(otype);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(kms);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(price);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(phno);
      out.write("</td>\n");
      out.write("            <td><img height=\"100\" width=\"100\" src=\"ImgOldCar?cid=");
      out.print(cid);
      out.write("\"/></td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("\n");

}

      out.write("\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("         \n");
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
