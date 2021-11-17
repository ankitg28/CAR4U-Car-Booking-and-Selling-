<%
    
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("select * from showroom");
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
            <th>City</th>
            <th>Showroom name</th>
            <th>Brand</th>
            <th>Address</th>
        </tr>
    </thead>
    <tbody>
<%
String brand="", city="",sname="",address="";
int sid;
while(rs.next())
{
    sid=rs.getInt(1);
    city=rs.getString(2);
    sname=rs.getString(3);
    brand=rs.getString(4);
    address=rs.getString(5);
%>

    
        <tr>
            <td><%=city%></td>
            <td><%=sname%></td>
            <td><%=brand%></td>
            <td><%=address%></td>
            <td><a href="removedshowroom.jsp?sid=<%=sid%>">x</a></td>
        </tr>


<%
}
%>
    </tbody>
</table>
    
         
    </body>
</html>
