<%@page import="java.sql.*"%>
<html>
<%
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/softwaredb","root","root");
ResultSet rs=con.createStatement().executeQuery("select distinct brand from car");    
%>
    <head>
        
          <script>
            var request;
            function showCT(){
                          request=new XMLHttpRequest();
                request.onreadystatechange=getCT;
                var v=document.getElementById("brand").value;
                  request.open("get", "CompareShow?brand="+v, true);
                request.send(null);
                
            }
            function getCT(){
                if(request.readyState==4 && request.status==200){
                    var ans=request.responseText;
                    document.getElementById("CT").innerHTML=ans;
                }
                else
                    document.getElementById("CT").innerHTML="Error......";
                
            }
            
        </script>
    </head>

    <body>
        
        <form action="displaycompare.jsp" method="Get">
            <pre>
       
            Car Brand    : <select name="brand" id="brand" onclick="showCT()">
<%
while(rs.next())
{
    String brand=rs.getString(1);
%>
<option value="<%=brand%>"><%=brand%></option>
<%
}
%>
</select>  Car Model   : <select name="ct" id="CT"></select>
<div id="output"></div>
<%
ResultSet rs1=con.createStatement().executeQuery("select distinct brand from car"); 
%>
          <script>
            var request;
            function showCT1(){
                          request=new XMLHttpRequest();
                request.onreadystatechange=getCT1;
                var v=document.getElementById("brand1").value;
                  request.open("get", "CompareShow?brand="+v, true);
                request.send(null);
                
            }
            function getCT1(){
                if(request.readyState==4 && request.status==200){
                    var ans=request.responseText;
                    document.getElementById("CT1").innerHTML=ans;
                }
                else
                    document.getElementById("CT1").innerHTML="Error......";    
            }
            
        </script>
    </head>     
            Car Brand    : <select name="brand1" id="brand1" onclick="showCT1()">
<%
while(rs1.next())
{
    String brand1=rs1.getString(1);
%>
<option value="<%=brand1%>"><%=brand1%></option>
<%
}
%>
</select>  Car Model   : <select name="ct1" id="CT1"></select>
                  
                            <br><br>
                          <input type="submit" value="Compare"/>

<div id="output"></div>



            </pre>
        </form>        
    </body>
</html>
