<html>
<head>
<title>Student Management System</title>
</head>
<body>

<h2> Student Registration</h2>

<form action = "updateStudent" method ="post">

  Enter Student id: <input type = "text" name = "id" required/><br><br>
  Student Name:<input type = "text"  name = "name" required/><br><br>
  Phone Number: <input type = "text"  name = "phoneNumber"  required/><br><br>
  MALE: <input type = "radio" name ="gender" value ="male">
  FEMALE: <input type = "radio" name = "gender" value="female"><br><br>
  Department: <input type = "text" name = "department" required/><br><br>

 <button type ="submit" value ="Submit"/>UPDATE STUDENT</button>

</form>

</body>
</html>