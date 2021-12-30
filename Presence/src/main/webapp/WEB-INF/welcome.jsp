<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>

 	<a href="http://localhost:8080/Presence/logout"> <B> Logout </B> </a>
 	<a href="http://localhost:8080/Presence/Add"> <B> AddUser </B> </a>
 	<a href="http://localhost:8080/Presence/Delete"> <B> DeleteUser </B> </a>
 	<h1>Welcome ${user.nom} ${user.prenom}</h1>
 	<h1> Username: ${user.email} </h1> 
 	<h1> Password: ${user.motdepasse}</h1>
	<h2> You are login successfully ...</h2>
	

</body>
</html>