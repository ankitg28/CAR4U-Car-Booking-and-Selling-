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
public class AddCar extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        (PrintWriter out = response.getWriter()) 
        {
            String brand="",fuel="",cname="",model="",ctype="",transmission="";
            int price=0;
            double mileage=0;
            byte bt[]=null;
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload uploads=new ServletFileUpload(factory);
            List<FileItem> list=uploads.parseRequest(new ServletRequestContext(request));
            
            for(FileItem fi:list)
            {
            String name=fi.getFieldName();
            if(name.equalsIgnoreCase("brand"))
                    brand=fi.getString();
            else if(name.equalsIgnoreCase("cname"))
                cname=fi.getString();
            else if(name.equalsIgnoreCase("model"))
                model=fi.getString();
            else if(name.equalsIgnoreCase("ctype"))
                ctype=fi.getString();
            else if(name.equalsIgnoreCase("price"))
                price=Integer.parseInt(fi.getString());
            else if(name.equalsIgnoreCase("fuel"))
                fuel=fi.getString();
            else if(name.equalsIgnoreCase("mileage"))
                mileage=Double.parseDouble(fi.getString());
            else if(name.equalsIgnoreCase("transmission"))
                transmission=fi.getString();
            else if(name.equalsIgnoreCase("image"))
                {
                  InputStream in=fi.getInputStream();
                  int n=in.available();
                  bt=new byte[n];
                  in.read(bt);
                  in.close();
                }
            }   
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddCar.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
            PreparedStatement ps=con.prepareStatement("insert into car values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, brand);
            ps.setString(2, cname);
            ps.setString(3, model);
            ps.setString(4, ctype);
            ps.setInt(5,price);
            ps.setString(6, fuel);
            ps.setDouble(7, mileage);
            ps.setString(8, transmission);
            ps.setBytes(9, bt);
            ps.executeUpdate();
            out.println("<h2>Car Added Successfully......</h2>");
            out.println("<a href=NewCar.jsp>Add more cars</a><br>");
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
