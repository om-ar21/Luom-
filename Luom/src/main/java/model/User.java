package model;

import java.sql.Date;

public class User {
private int id;
private String nom;
private String prenom;
private Date inscription;
private String email;
private String mdp;
private boolean del;

public boolean isDel() {
	return del;
}
public void setDel(boolean del) {
	this.del = del;
}

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
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public Date getInscription() {
	return inscription;
}
public void setInscription(Date inscription) {
	this.inscription = inscription;
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
public User(int id, String nom, String prenom, Date inscription, String email, String mdp) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.inscription = inscription;
	this.email = email;
	this.mdp = mdp;
}
public User(String nom, String prenom, Date inscription, String email, String mdp) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.inscription = inscription;
	this.email = email;
	this.mdp = mdp;
}
public User() {
	super();
}
@Override
public String toString() {
	return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", inscription=" + inscription + ", email="
			+ email + ", mdp=" + mdp + "]";
}



}
