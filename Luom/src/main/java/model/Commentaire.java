package model;

import java.sql.Date;

public class Commentaire {
	private int id;
	private Date day;
	private int id_produit;
	private int id_user;
	private String contenu;
	private int note;
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
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", day=" + day + ", id_produit=" + id_produit + ", id_user=" + id_user
				+ ", contenu=" + contenu + ", note=" + note + "]";
	}
	
	public Commentaire() {
		
	}
	
	public Commentaire(int id, Date day, int id_produit, int id_user, String contenu, int note) {
		this.id = id;
		this.day = day;
		this.id_produit = id_produit;
		this.id_user = id_user;
		this.contenu = contenu;
		this.note = note;
	}
	
	public Commentaire(Date day, int id_produit, int id_user, String contenu, int note) {
		this.day = day;
		this.id_produit = id_produit;
		this.id_user = id_user;
		this.contenu = contenu;
		this.note = note;
	}
	
	public User getUser() {
		UserDAO udao = new UserDAO();
		User u = udao.getById(this.id_user);
		return u;
	}

}
