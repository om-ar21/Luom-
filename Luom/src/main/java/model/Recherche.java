package model;

import java.sql.Date;

public class Recherche {
private int id;
private int id_user;
private String mot;
private Date rech;

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
public String getMot() {
	return mot;
}
public void setMot(String mot) {
	this.mot = mot;
}
public Date getRech() {
	return rech;
}
public void setRech(Date rech) {
	this.rech = rech;
}
public Recherche(int id, int id_user, String mot, Date rech) {
	super();
	this.id = id;
	this.id_user = id_user;
	this.mot = mot;
	this.rech = rech;
}
public Recherche(int id_user, String mot, Date rech) {
	super();
	this.id_user = id_user;
	this.mot = mot;
	this.rech = rech;
}
public Recherche() {
	super();
}

@Override
public String toString() {
	return "Recherche [id=" + id + ", id_user=" + id_user + ", mot=" + mot + ", rech=" + rech + "]";
}

}
