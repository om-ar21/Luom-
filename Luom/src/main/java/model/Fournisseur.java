package model;

public class Fournisseur {
	private int id;
	private String nom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}
	
	public Fournisseur() {
		
	}
	
	public Fournisseur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public Fournisseur(String nom) {
		this.nom = nom;
	}

}
