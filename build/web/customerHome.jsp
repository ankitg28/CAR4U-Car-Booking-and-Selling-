<%
String name=(String)session.getAttribute("cname");
%>
<html>
    <body>
        <h1>Hello <%=name%>!!!!!!!!!</h1>
        <pre>  
        
        <a href="Searchcar.jsp">Search New Car</a>
        <a href="viewoldcar.jsp">Search Old Cars</a>
        <a href="compare.jsp">Compare Cars</a>
        <a href="sellcar.jsp">Sell a Car</a>
        <a href="book.jsp">Book an appointment</a>
        <a href="viewappointment.jsp">View your appointments</a>
        <a href="Logout">Logout</a>
        </pre>
    </body>
</html>
