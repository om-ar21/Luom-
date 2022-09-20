package model;

public class Souscategorie {
private int id;
private String titre;
private int id_cat;

private boolean del;

public boolean isDel() {
	return del;
}
public void setDel(boolean del) {
	this.del = del;
}

public Categorie getCategorie() {
	CategorieDAO cdao = new CategorieDAO();
	Categorie c = cdao.getById(this.id_cat);
	return c;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public int getId_cat() {
	return id_cat;
}

public void setId_cat(int id_cat) {
	this.id_cat = id_cat;
}

public Souscategorie(String titre, int id_cat) {
	super();
	this.titre = titre;
	this.id_cat = id_cat;
}
public Souscategorie() {

}
public Souscategorie(int id, String titre, int id_cat) {
	super();
	this.id = id;
	this.titre = titre;
	this.id_cat = id_cat;
}

@Override
public String toString() {
	return "Souscategorie [id=" + id + ", titre=" + titre + ", id_cat=" + id_cat + "]";
}

}
