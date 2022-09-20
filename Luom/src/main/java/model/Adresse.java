package model;

public class Adresse {
private int id; 
private int id_user;
private String adresse;
private String cp;
private String ville;
private String pays;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getCp() {
	return cp;
}
public void setCp(String cp) {
	this.cp = cp;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}

public Adresse(int id, int id_user, String adresse, String cp, String ville, String pays, User user) {
	super();
	this.id = id;
	this.id_user = id_user;
	this.adresse = adresse;
	this.cp = cp;
	this.ville = ville;
	this.pays = pays;
}
public Adresse(int id_user, String adresse, String cp, String ville, String pays, User user) {
	super();
	this.id_user = id_user;
	this.adresse = adresse;
	this.cp = cp;
	this.ville = ville;
	this.pays = pays;
}
public Adresse() {
	super();
}
public Adresse(int id_user, String adresse, String cp, String ville, String pays) {
	super();
	this.id_user = id_user;
	this.adresse = adresse;
	this.cp = cp;
	this.ville = ville;
	this.pays = pays;
}
public Adresse(int id, int id_user, String adresse, String cp, String ville, String pays) {
	super();
	this.id = id;
	this.id_user = id_user;
	this.adresse = adresse;
	this.cp = cp;
	this.ville = ville;
	this.pays = pays;
}
@Override
public String toString() {
	return "Adresse [id=" + id + ", id_user=" + id_user + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville
			+ ", pays=" + pays + "]";
}






}
