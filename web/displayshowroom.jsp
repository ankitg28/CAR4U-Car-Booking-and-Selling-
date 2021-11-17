<%
    String city=request.getParameter("city");
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("select * from showroom where city=?");
    ps.setString(1, city);
    java.sql.ResultSet rs=ps.executeQuery();
    session.setAttribute("date",request.getParameter("date"));
    session.setAttribute("month",request.getParameter("month"));
    session.setAttribute("city",city);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Results..</title>
    </head>
    
    <body>
       
    <table border="5" width="4" cellspacing="3">
    <thead>
        <tr>
            <th>City</th>
            <th>Showroom name</th>
            <th>Brand </th>
            <th>Address</th>
        </tr>
    </thead>
    <tbody>
<%
String sname="",brand="",address="";
int sid;
while(rs.next())
{
    sid=rs.getInt(1);
    sname=rs.getString(3);
    brand=rs.getString(4);
    address=rs.getString(5);
    
%>

    
        <tr>
            <td><%=city%></td>
            <td><%=sname%></td>
            <td><%=brand%></td>
            <td><%=address%></td>
            <td><a href="BookShowroom?sid=<%=sid%>" > Book</a></td>
        </tr>


<%
}
%>
    </tbody>
</table>
    </body>
</html>
