package model;

public class Image {
	private int id;
	private int id_produit;
	private String lien;
	
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
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	
	@Override
	public String toString() {
		return "Image [id=" + id + ", id_produit=" + id_produit + ", lien=" + lien + "]";
	}
	
	public Image() {
		
	}
	
	public Image(int id, int id_produit, String lien) {
		this.id = id;
		this.id_produit = id_produit;
		this.lien = lien;
	}
	
	public Image(int id_produit, String lien) {
		this.id_produit = id_produit;
		this.lien = lien;
	}
	
}
