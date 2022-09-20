package model;

import java.sql.Date;

public class Ees {
	private int id;
	private int id_produit;
	private int id_fournisseur;
	private Date datee;
	private int qte;
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
	public int getId_produit() {
		return id_produit;
	}
	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	public int getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public Date getDatee() {
		return datee;
	}
	public void setDatee(Date datee) {
		this.datee = datee;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	@Override
	public String toString() {
		return "Ees [id=" + id + ", id_produit=" + id_produit + ", id_fournisseur=" + id_fournisseur + ", datee="
				+ datee + ", qte=" + qte + "]";
	}
	
	public Ees() {
		
	}
	
	public Ees(int id, int id_produit, int id_fournisseur, Date datee, int qte) {
		this.id = id;
		this.id_produit = id_produit;
		this.id_fournisseur = id_fournisseur;
		this.datee = datee;
		this.qte = qte;
	}
	
	public Ees(int id_produit, int id_fournisseur, Date datee, int qte) {
		this.id_produit = id_produit;
		this.id_fournisseur = id_fournisseur;
		this.datee = datee;
		this.qte = qte;
	}
	
}
