package model;

import java.util.Date;

public class User {
	private String nom;
	private String prenom;
	private String motdepasse;
	private String email;
	private Date dateNaissance;
	private int telephone;
	private String adresse;
	private String sexe;
	
	public User(String n,String p,String m,String e,Date dn, int t,String a, String s) {
		this.nom = n;
		this.prenom = p;
		this.motdepasse = m;
		this.email = e;
		this.dateNaissance = dn;
		this.telephone = t;
		this.adresse = a;
		this.sexe = s;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getDateNaissance() {
		return (java.sql.Date) dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
}
