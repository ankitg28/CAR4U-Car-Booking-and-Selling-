<%
    String brand=request.getParameter("brand");
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("select * from car where brand=?");
    ps.setString(1, brand);
    java.sql.ResultSet rs=ps.executeQuery();
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
            <th>Brand</th>
            <th>Car name</th>
            <th>Car model</th>
            <th>Body type</th>
            <th>Price</th>
            <th>Fuel type</th>
            <th>Mileage</th>
            <th>Transmission</th>
        </tr>
    </thead>
    <tbody>
<%
String fuel="",cname="",model="",ctype="",price="",mileage="",transmission="";
while(rs.next())
{
    cname=rs.getString(2);
    model=rs.getString(3);
    ctype=rs.getString(4);
    fuel=rs.getString(5);
    price=rs.getString(6);
    mileage=rs.getString(7);
    transmission=rs.getString(8);
%>

    
        <tr>
            <td><%=brand%></td>
            <td><%=cname%></td>
            <td><%=model%></td>
            <td><%=ctype%></td>
            <td><%=fuel%></td>
            <td><%=price%></td>
            <td><%=mileage%></td>
            <td><%=transmission%></td>
            <td><img height="100" width="100" src="Image?model=<%=model%>"/></td>
        </tr>


<%
}
%>
    </tbody>
</table>
         
    </body>
</html>
