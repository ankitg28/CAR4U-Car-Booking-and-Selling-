<%
    int sid =Integer.parseInt(request.getParameter("sid"));
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("delete from showroom where sid=?");
    ps.setInt(1, sid);
    ps.executeUpdate();
    response.sendRedirect("deleteshowroom.jsp");
    
%>

