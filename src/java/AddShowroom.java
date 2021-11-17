import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.*;
public class AddShowroom extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        (PrintWriter out = response.getWriter()) 
        {
            String brand="",city="",sname="",address="";
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload uploads=new ServletFileUpload(factory);
            List<FileItem> list=uploads.parseRequest(new ServletRequestContext(request));
            
            for(FileItem fi:list)
            {
            String name=fi.getFieldName();
            if(name.equalsIgnoreCase("brand"))
                    brand=fi.getString();
            else if(name.equalsIgnoreCase("sname"))
                sname=fi.getString();
            else if(name.equalsIgnoreCase("city"))
                city=fi.getString();
            else if(name.equalsIgnoreCase("address"))
                address=fi.getString();
            
            }   
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddCar.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
            PreparedStatement ps=con.prepareStatement("insert into showroom(city,sname,brand,address) values(?,?,?,?)");
            
            ps.setString(1, city);
            ps.setString(2, sname);
            ps.setString(3, brand);
            ps.setString(4, address);
            ps.executeUpdate();
            out.println("<h2>Showroom Added Successfully......</h2>");
            out.println("<a href=adminHome.jsp>Home</a><br>");
        } catch (SQLException ex) {
            Logger.getLogger(AddCar.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(AddCar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(AddCar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
