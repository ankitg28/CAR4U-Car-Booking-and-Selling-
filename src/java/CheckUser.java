import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
String unm=request.getParameter("unm");
String pass=request.getParameter("pass");
String utype=request.getParameter("utype");
String save=request.getParameter("save");

if(utype.equals("Admin")){
   ServletConfig cfg=getServletConfig();
        if(unm.equals(cfg.getInitParameter("adminid")) && pass.equals(cfg.getInitParameter("adminpass"))){
                response.sendRedirect("adminHome.jsp");
            /*RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp");
            rd.forward(request, response);*/
        }
        else{
            out.println("<h3>Invalid Admin Details.......</h3>");
            out.println("<a href=index.jsp>Try-Again</a>");
        }
        
}
else if(utype.equals("Customer"))
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
PreparedStatement ps=con.prepareStatement("select * from customer where email=? and password=?");
ps.setString(1,unm);
ps.setString(2, pass);
ResultSet rs=ps.executeQuery();
boolean found=rs.next();


if(save!=null){
                  //create the cookies......
                    Cookie c1=new Cookie("unm", unm);
                    Cookie c2=new Cookie("pass", pass);
                  //set the life time of the cookies......
                    c1.setMaxAge(60*60*24*365);
                   // c2.setMaxAge(60*60);
                  //add cookies to response.......  
                    response.addCookie(c1);
                    response.addCookie(c2);
}

if(found)
{
        int cid=rs.getInt(1);
        String name=rs.getString(3);
        HttpSession session=request.getSession();
        session.setAttribute("cname",name);
        session.setAttribute("cid",cid);
        response.sendRedirect("customerHome.jsp");

}
        else{
            out.println("<h3>Invalid Customer Details.......</h3>");
            out.println("<a href=index.jsp>Try-Again</a>");
        }

}

        } catch (SQLException ex) {
            Logger.getLogger(CheckUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
