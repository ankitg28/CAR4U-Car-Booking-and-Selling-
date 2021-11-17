import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reg extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reg.class.getName()).log(Level.SEVERE, null, ex);
            }
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
                
PreparedStatement ps=con.prepareStatement("insert into customer(password,name,phno,email,address,city,pincode,gender) values(?,?,?,?,?,?,?,?)");
ps.setString(1, request.getParameter("pass"));
ps.setString(2, request.getParameter("name"));
ps.setString(3, request.getParameter("phno"));
ps.setString(4, request.getParameter("email"));
ps.setString(5, request.getParameter("address"));
ps.setString(6, request.getParameter("city"));
ps.setString(7, request.getParameter("pin"));
ps.setString(8, request.getParameter("gender"));
ps.executeUpdate();
out.println("<h3>User registered Successfully....</h3>");
out.println("<a href=index.jsp>Login Now</a><br>");
            
        } catch (SQLException ex) {
            out.println(ex);
        } finally {            
            out.close();
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
