package model;

public class Contact {
	private int id;
	private int id_user;
	private String sujet;
	private String msg;
	private String email;
	private boolean etat;
	
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
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", id_user=" + id_user + ", sujet=" + sujet + ", msg=" + msg + ", email=" + email
				+ ", etat=" + etat + "]";
	}
	
	public Contact() {
		
	}
	
	public Contact(int id, int id_user, String sujet, String msg, String email, boolean etat) {
		this.id = id;
		this.id_user = id_user;
		this.sujet = sujet;
		this.msg = msg;
		this.email = email;
		this.etat = etat;
	}
	
	public Contact(int id_user, String sujet, String msg, String email, boolean etat) {
		this.id_user = id_user;
		this.sujet = sujet;
		this.msg = msg;
		this.email = email;
		this.etat = etat;
	}

}
