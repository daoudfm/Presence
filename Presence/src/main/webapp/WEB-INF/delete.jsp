<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Delete page</title>
	 <style><%@include file="/WEB-INF/cssfiles/style.css"%></style>
   
</head>

<body>
	<header>
            <nav class="menu">
                <a class="menu-item" href="http://localhost:8080/Presence/login">Accueil</a>
                <a class="menu-item" href="http://localhost:8080/Presence/Add"> AddUser</a>
                <a class="menu-item" href="http://localhost:8080/Presence/Delete"> DeleteUser</a>
                <a class="menu-item" href="http://localhost:8080/Presence/logout"> Logout</a>
            </nav>
    </header>
	<h1>Delete User</h1>
      <form name="delete" action="Delete"  method="post">
         <table class="form-style">
            <tr>
               <td>
                  <label>
                     Email <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="text" name="email" class="long"/>  
               </td>
            </tr>
            
            <tr>
               <td>
                  <input type="submit" value="Delete">      
               </td>
            </tr>
         </table>
      </form>
</body>
</html>