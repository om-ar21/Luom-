package model;

import java.sql.Date;

public class Visite {
private int id;
private int id_produit;
private int id_user;
private Date datev;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_produit() {
	return id_produit;
}
public void setId_produit(int id_produit) {
	this.id_produit = id_produit;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public Date getDatev() {
	return datev;
}
public void setDatev(Date datev) {
	this.datev = datev;
}


public Visite(int id, int id_produit, int id_user, Date datev, Produit produit, User user) {
	super();
	this.id = id;
	this.id_produit = id_produit;
	this.id_user = id_user;
	this.datev = datev;
}
public Visite(int id_produit, int id_user, Date datev, Produit produit, User user) {
	super();
	this.id_produit = id_produit;
	this.id_user = id_user;
	this.datev = datev;
}

public Visite(int id, int id_produit, int id_user, Date datev) {
	super();
	this.id = id;
	this.id_produit = id_produit;
	this.id_user = id_user;
	this.datev = datev;
}
public Visite(int id_produit, int id_user, Date datev) {
	super();
	this.id_produit = id_produit;
	this.id_user = id_user;
	this.datev = datev;
}
public Visite() {
	super();
}
@Override
public String toString() {
	return "Visite [id=" + id + ", id_produit=" + id_produit + ", id_user=" + id_user + ", datev=" + datev
			+ "]";
}




}
