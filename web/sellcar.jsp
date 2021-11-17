<html>
    <head>
        
        <title>Sell your car </title>
    <hr>
    </head>
    <body>

            <h1>Car Details</h1>
            <hr>
            
            <form action="AddOldCar" method="Post" enctype="multipart/form-data">
            <pre>
            Brand*      <select name="brand" size="1">
            <option>Maruti Suzuki </option>
            <option>Hyundai </option>
            <option>Honda </option>
            <option>Tata</option>
            <option>Toyota</option>
            <option>Volkswagen</option>
             </select><br>
            City*       <input type="text" name="city" value="Enter City" size="30" /><br>
            Make Year*  <select name="month" size="1">
               <option value="" disabled selected>--Select Month--</option>
               <option >1</option>
               <option >2</option>
               <option >3</option>
               <option >4</option>
               <option >5</option>
               <option >6</option>
               <option >7</option>
               <option >8</option>
               <option >9</option>
               <option >10</option>
               <option >11</option>
               <option >12</option>
           </select><select name="year" size="1">
                                                    
               <option value="" disabled selected>--Select Year--</option>
               <option >2017</option>
               <option >2016</option>
               <option >2015</option>
               <option >2014</option>
               <option >2013</option>
               <option >2012</option>
               <option >2011</option>
               <option >2010</option>
               <option >2009</option>
               <option >2008</option>
               <option >2007</option>
               <option >2006</option>
                   </select><br>
            Owner*      <select name="owner">
               <option value="" disabled selected>--Select owner(s)--</option>
               <option >First Owner</option>
               <option >Second Owner</option>
               <option >Third Owner</option>
               <option >Fourth Owner</option>
                        </select><br>
            Kms Driven* <input type="text" name="kms" value=""  /><br>
            Price(Rs)*  <input type="text" name="price" value=""  /><br>
            Car Pic     <input type="file" name="image" /><br>
                        <input type="submit" class="trial" value="Sell"  />
               </pre>    
               </form>
                               
    </body>
</html>
