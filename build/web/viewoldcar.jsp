<%
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
    java.sql.PreparedStatement ps=con.prepareStatement("select * from oldcar");
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
            <th>Seller Name</th>
            <th>Brand</th>
            <th>City</th>
            <th>Month</th>
            <th>Year</th>
            <th>Owner type</th>
            <th>Kms</th>
            <th>Price</th>
            <th>Seller Contact</th>
            <th>Image</th>
            
        </tr>
    </thead>
    <tbody>
<%
String sname="",brand="", city="",otype="",phno="";
int month=0,year=0,kms=0,price=0;
while(rs.next())
{
    int cid=rs.getInt(1);
    java.sql.PreparedStatement ps1=con.prepareStatement("select name,phno from customer where cid=? ");
    ps1.setInt(1,cid);
    java.sql.ResultSet rs1=ps1.executeQuery();
    rs1.next();
    sname=rs1.getString(1);
    phno=rs1.getString(2);
    brand=rs.getString(2);
    city=rs.getString(3);
    month=rs.getInt(4);
    year=rs.getInt(5);
    otype=rs.getString(6);
    kms=rs.getInt(7);
    price=rs.getInt(8);
%>

    
        <tr>
            <td><%=sname%></td>
            <td><%=brand%></td>
            <td><%=city%></td>
            <td><%=month%></td>
            <td><%=year%></td>
            <td><%=otype%></td>
            <td><%=kms%></td>
            <td><%=price%></td>
            <td><%=phno%></td>
            <td><img height="100" width="100" src="ImgOldCar?cid=<%=cid%>"/></td>
        </tr>


<%
}
%>
    </tbody>
</table>
         
    </body>
</html>
