<%
    int cid=(int)session.getAttribute("cid");
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("select * from appointment where cid=?");
    ps.setInt(1, cid);
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
            <th>Showroom name</th>
            <th>City</th>
            <th>Date</th>
        </tr>
    </thead>
    <tbody>
<%
String date="",sname="",city="";
int sid=0;
while(rs.next())
{
    sid=rs.getInt(2);
    date=rs.getString(3);
    java.sql.PreparedStatement ps1=con.prepareStatement("select * from showroom where sid=?");
    ps1.setInt(1, sid);
    java.sql.ResultSet rs1=ps1.executeQuery();
    rs1.next();
    sname=rs1.getString(3);
    city=rs1.getString(2);
    
%>

    
        <tr>
            <td><%=sname%></td>
            <td><%=city%></td>
            <td><%=date%></td>
            
        </tr>


<%
}
%>
    </tbody>
</table>
         
    </body>
</html>
