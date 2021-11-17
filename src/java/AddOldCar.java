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
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.*;
public class AddOldCar extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        (PrintWriter out = response.getWriter()) 
        {
            String brand="",city="",owner="";
            int price=0,year=0,month=0,kms=0;
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
            else if(name.equalsIgnoreCase("city"))
                city=fi.getString();
            else if(name.equalsIgnoreCase("month"))
                month=Integer.parseInt(fi.getString());
            else if(name.equalsIgnoreCase("year"))
                year=Integer.parseInt(fi.getString());
            else if(name.equalsIgnoreCase("owner"))
                owner=fi.getString();
            else if(name.equalsIgnoreCase("kms"))
                kms=Integer.parseInt(fi.getString());
            else if(name.equalsIgnoreCase("price"))
                price=Integer.parseInt(fi.getString());
            
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
                Logger.getLogger(AddOldCar.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
            PreparedStatement ps=con.prepareStatement("insert into oldcar values(?,?,?,?,?,?,?,?,?)");
            HttpSession session=request.getSession();
            int cid= (int) session.getAttribute("cid")  ;
            ps.setInt(1,cid );
            ps.setString(2, brand);
            ps.setString(3, city);
            ps.setInt(4,month );
            ps.setInt(5,year);
            ps.setString(6, owner);
            ps.setInt(7,kms );
            ps.setInt(8, price);
            ps.setBytes(9, bt);
            ps.executeUpdate();
            out.println("<h2>Car Added Successfully......</h2>");
            
            out.println("<a href=adminHome.jsp>Home</a><br>");
        } catch (SQLException ex) {
            Logger.getLogger(AddOldCar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddOldCar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddOldCar.class.getName()).log(Level.SEVERE, null, ex);
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
