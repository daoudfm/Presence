package model;

import java.util.Date;

public class Etudiant extends User{
	
	private int matricule;
	private int numBac;
	private int anneeBac;
	
	public Etudiant (String n, String p, String m, String e, Date dn, int t, String a, String s) {
		super(n, p, m, e, dn, t, a, s);
	}
	
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}

	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public int getNumBac() {
		return numBac;
	}
	public void setNumBac(int numBac) {
		this.numBac = numBac;
	}
	public int getAnneeBac() {
		return anneeBac;
	}
	public void setAnneeBac(int anneeBac) {
		this.anneeBac = anneeBac;
	}

}
