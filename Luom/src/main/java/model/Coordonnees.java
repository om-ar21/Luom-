package model;

public class Coordonnees {
	private int id;
	private String nom; 
	private String adresse;
	private String tel;
	private String email;
	private String logo;
	
	
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Coordonnees(int id, String nom, String adresse, String tel, String email, String logo) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.logo = logo;
	}
	public Coordonnees(String nom, String adresse, String tel, String email, String logo) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.logo = logo;
	}
	public Coordonnees() {
		super();
	}
	@Override
	public String toString() {
		return "Coordonnees [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", tel=" + tel + ", email=" + email
				+ ", logo=" + logo + "]";
	}
	
	

}
