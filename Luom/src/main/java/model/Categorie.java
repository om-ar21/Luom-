package model;

import java.util.ArrayList;

public class Categorie {
	private int id;
	private String titre;
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Categorie(int id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}
	public Categorie(String titre) {
		super();
		this.titre = titre;
	}
	public Categorie() {
		super();
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", titre=" + titre + "]";
	}
	
	public ArrayList<Souscategorie> ciblesscat() {
		SouscategorieDAO sscatdao = new SouscategorieDAO();
		int idcat = this.getId();
		ArrayList<Souscategorie> sscat = sscatdao.getAllById(idcat);
		return sscat;
	}
	
}
