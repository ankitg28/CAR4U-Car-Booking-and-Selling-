<%
    String model=request.getParameter("model");
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("delete from car where model=?");
    ps.setString(1, model);
    ps.executeUpdate();
    response.sendRedirect("deletecar.jsp");
    
%>

