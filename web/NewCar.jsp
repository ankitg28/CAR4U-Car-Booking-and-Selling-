<html>
    <body>
        <h1></h1>
        <form action="AddCar" method="Post" enctype="multipart/form-data">
            <pre>
            Car Brand    : <select name="brand">
            <option>Maruti Suzuki </option>
            <option>Hyundai </option>
            <option>Honda </option>
            <option>Tata</option>
            <option>Toyota</option>
            <option>Volkswagen</option>
            </select><br>
            Car Name     : <input type="text" name="cname"/><br>            
            Model        : <input type="text" name="model"/><br>  
            Body Type    : <select name="ctype">
            <option>Hatch Back </option>
            <option>Sedan </option>
            <option>SUV </option>
            <option>MUV</option>
            </select><br>
            Price        : <input type="text" name="price"/><br>
            Fuel         : <select name="fuel">
            <option>Petrol </option>
            <option>Diesel </option>
            <option>CNG </option>
            </select><br>
            Mileage      : <input type="text" name="mileage"/><br>
            Transmission : <select name="transmission">
            <option>Manual </option>
            <option>Automatic </option>
            </select><br>
            Image        : <input type="file" name="image"/><br>            
                           <input type="submit" value="Save"/>            
            </pre>
        </form>
    </body>
</html>
