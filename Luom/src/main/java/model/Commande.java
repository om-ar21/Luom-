package model;

import java.sql.Date;

public class Commande {
	private int id;
	private int id_user;
	private int id_adresse;
	private Date datec;
	private double total;
	private boolean etat;
	private boolean del;

    public boolean isDel() {
        return del;
    }
    public void setDel(boolean del) {
        this.del = del;
    }
	
	public Commande(int id_user, Date datec, double total) {
		super();
		this.id_user = id_user;
		this.datec = datec;
		this.total = total;
	}
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
	public int getId_adresse() {
		return id_adresse;
	}
	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}
	public Date getDatec() {
		return datec;
	}
	public void setDatec(Date datec) {
		this.datec = datec;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Commande(int id, int id_user, int id_adresse, Date datec, double total, boolean etat) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_adresse = id_adresse;
		this.datec = datec;
		this.total = total;
		this.etat = etat;
	}
	public Commande(int id_user, int id_adresse, Date datec, double total, boolean etat) {
		super();
		this.id_user = id_user;
		this.id_adresse = id_adresse;
		this.datec = datec;
		this.total = total;
		this.etat = etat;
	}
	public Commande() {
		super();
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", id_user=" + id_user + ", id_adresse=" + id_adresse + ", datec=" + datec
				+ ", total=" + total + ", etat=" + etat + "]";
	}
	
	
	
}
