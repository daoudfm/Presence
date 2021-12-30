<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Add User</title>
<style>
	<%@include file="/WEB-INF/cssfiles/style.css"%>
</style>
</head>

<body>

<h1>Add New User</h1>
      <form name="add" action="Add"  method="post">
         <table class="form-style">
            <tr>
               <td>
                  <label>
                     Nom <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="text" name="fname" class="long"/>
               </td>
            </tr>
            
            <tr>
               <td>
                  <label>
                     Prenom <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="text" name="lname" class="long"/>
               </td>
            </tr>
            
            <tr>
               <td>
                  <label>
                     Adresse <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="text" name="adress" class="long"/>
               </td>
            </tr>
            
            <tr>
               <td>
                  <label>
                     Telephone <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="tel" name="telephone" class="long"/>
               </td>
            </tr>
            
            <tr>
               <td>
                  <label>
                    Date de Naissance <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="date" name="dateNaissance" class="long"/>
               </td>
            </tr>
            
            <tr>
               <td>
                  <label>
                     Email <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="email" name="email" class="long"/>
               </td>
            </tr>
            
              <tr>
               <td>
                  <label>
                     Mot de passe <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="password" name="password" class="long"/>
               </td>
            </tr>
            
             <tr>
               <td>
                  <label>
                     type <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <select name="type">
                  	<option></option>
                  	<option value="Etudiant">Etudiant</option>
                  	<option value="Enseignant">Enseignant</option>
                  </select>
               </td>
            </tr>
          
            <tr>
               <td>
                  <input type="submit" value="Add">      
                  <input type="reset" value="Reset"> 
               </td>
            </tr>
         </table>
      </form>
</body>
</html>