package model;

public class Admin {
	private int id;
	private String nom;
	private String email;
	private String mdp;
	private int id_privilege;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getId_privilege() {
		return id_privilege;
	}
	public void setId_privilege(int id_privilege) {
		this.id_privilege = id_privilege;
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", nom=" + nom + ", email=" + email + ", mdp=" + mdp + ", id_privilege="
				+ id_privilege + "]";
	}
	
	public Admin() {
		
	}
	
	public Admin(int id, String nom, String email, String mdp, int id_privilege) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.id_privilege = id_privilege;
	}
	
	public Admin(String nom, String email, String mdp, int id_privilege) {
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.id_privilege = id_privilege;
	}
	
}
