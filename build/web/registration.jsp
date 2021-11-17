<%@page import="java.sql.*"%>
<html>
    <link rel='stylesheet' href='form-style.css' type='text/css' /> 
    <body>
        <script>
            var request;
            function checkId()
            {
            request=new XMLHttpRequest();
            request.onreadystatechange=getResult;
            var v=document.getElementById("email").value;
            request.open("get", "CheckUid?email="+v, true);
            request.send(null);            
            }
            function getResult()
            {
                if(request.readyState==4 && request.status==200)
                {
                    ans=request.responseText;
                    document.getElementById("output").innerHTML=ans;   
                }
                else
                    document.getElementById("output").innerHTML="";    
            }
        </script>
        <h1>Registration Page</h1><hr>
        <form action="Reg" method="Post">
            <pre>
            Name                                 : <input type="text" name="name"/><br>
            Phone number(Format: +91-9876543210) : <input type='tel' name="phno" pattern='[\+]\d{2}[\-]\d{10}' ><br> 
            Email address                        : <input type="email" name="email" id="email"/>   <input type="button" value="Check Email Availablity" onclick="checkId()" /><br>           
            Password                             : <input type="password" name="pass"/><br>
            Postal Address                       : <input type="text" name="address"><br>                   
            City                                 : <input type="text" name="city"/><br>
            Pin-code                             : <input type="text" name="pin"/><br>
            Gender                               : <select name="gender">
            <option>M</option>
            <option>F</option>
            <option>O</option>
            </select><br>
            
            <input type="submit" value="Register"/>
            </pre>
        </form>
        <div id="output"></div>
    </body>
</html>
