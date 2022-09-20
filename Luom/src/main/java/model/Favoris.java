package model;

public class Favoris {
private int id;
private int id_produit;
private int id_user;

private int fav;

public int getFav() {
	return fav;
}
public void setFav(int fav) {
	this.fav = fav;
}
public Produit getProduit(int id_produit) {
	ProduitDAO prod = new ProduitDAO();
	Produit p = prod.getById(id_produit);
	return p;
}

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

public Favoris(int id, int id_produit, int id_user, User user) {
	super();
	this.id = id;
	this.id_produit = id_produit;
	this.id_user = id_user;
}
public Favoris(int id_produit, int id_user, User user) {
	super();
	this.id_produit = id_produit;
	this.id_user = id_user;
}
public Favoris() {
	super();
}
public Favoris(int id, int id_produit, int id_user) {
	super();
	this.id = id;
	this.id_produit = id_produit;
	this.id_user = id_user;
}
public Favoris(int id_produit, int id_user) {
	super();
	this.id_produit = id_produit;
	this.id_user = id_user;
}

@Override
public String toString() {
	return "Favoris [id=" + id + ", id_produit=" + id_produit + ", id_user=" + id_user + ", fav=" + fav + "]";
}



}
