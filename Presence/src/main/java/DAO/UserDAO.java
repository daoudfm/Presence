package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Admin;
import model.Enseignant;
import model.User;

public class UserDAO {
	private Connection connection;

	public UserDAO() {
		this.connection = null;
	}

	// connection to database
	public void connectDB() throws InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/présence", "root", "FDFD97+h");
			System.out.println("Connection avec succes a la base de donnees !");
		} catch (ClassNotFoundException cnf) {
			System.out.print("Driver non chargé...");
		} catch (SQLException sqlex) {
			System.out.println("Incapable de connecter a la base de donnees...");
		}

	}
	
	public User checkLogin(String username, String password)
			throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		
		User user = null;

		try {
			
			connectDB();
			
			requete = "SELECT * FROM user WHERE email = ? and motdepasse = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();			
			
	        if (result.next()) {
	        	if(result.getString("type").equals("Admin")) {
	        		user = new Admin();
	        		user.setNom(result.getString("nom"));
		            user.setPrenom(result.getString("prenom"));
		            user.setAdresse(result.getString("adresse"));
		            user.setTelephone (result.getInt("telephone"));
		            user.setEmail(result.getString("email"));
		            user.setMotdepasse(result.getString("motdepasse"));
	        	}else {
	        		if(result.getString("type").equals("Enseignant")) {
	        			user = new Enseignant();
	        			 user.setNom(result.getString("nom"));
	     	            user.setPrenom(result.getString("prenom"));
	     	            user.setAdresse(result.getString("adresse"));
	     	            user.setTelephone (result.getInt("telephone"));
	     	            user.setEmail(result.getString("email"));
	     	            user.setMotdepasse(result.getString("motdepasse"));
	        		}
	        	}

	        }
	        
			statement.close();

			System.out.println("succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return user;
	}
	
	
	
	public void addUser(User user) throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement stmt;
		
		connectDB();

		try {

			requete = "INSERT INTO user(nom,prenom,adresse,telephone,email,motdepasse,type,dateNaissance) VALUES(?,?,?,?,?,?,?,?)";			
			stmt = connection.prepareStatement(requete);
			
			stmt.setString(1,user.getNom());
			stmt.setString(2,user.getPrenom());
			stmt.setString(3,user.getAdresse());
			stmt.setInt(4,user.getTelephone());
			stmt.setString(5,user.getEmail());
			stmt.setString(6,user.getMotdepasse());
			if(user instanceof Admin) {
				stmt.setString(7, "Admin");
			}else {
				if(user instanceof Enseignant) {
					stmt.setString(7, "Enseignant");
				}else {
					stmt.setString(7, "Etudiant");
				}
			}
			stmt.setDate(8,user.getDateNaissance());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public void deleteUser(User user) throws InstantiationException, IllegalAccessException {
		String requete;
		PreparedStatement stmt;
		
		connectDB();

		try {

			requete = "DELETE FROM présence.user WHERE email = ?";
			stmt = connection.prepareStatement(requete);
			stmt.setString(1,user.getEmail());
			stmt.executeUpdate();
			stmt.close();

			System.out.println("DELETED !");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<User> getUsers() throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		
		User user = null;
		ArrayList<User> usersList = new ArrayList<User>();
		
		try {
			
			connectDB();
			
			requete = "SELECT * FROM user";
			statement = connection.prepareStatement(requete);
			
			
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {
	        	
	            user = new User();
	            user.setNom(result.getString("nom"));
	            user.setPrenom(result.getString("prenom"));
	            user.setAdresse(result.getString("adresse"));
	            user.setTelephone (result.getInt("elephone"));
	            user.setEmail(result.getString("email"));
	            user.setMotdepasse(result.getString("motdepasse"));      
	            usersList.add(user);
	        }
	        
			statement.close();

			System.out.println("Users --- succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return usersList;
	}
}
