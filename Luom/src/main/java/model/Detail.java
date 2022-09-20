package model;

public class Detail {
	private int id;
	private int id_cmd;
	private int id_produit;
	private int qte;
	private double prix;
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
	public int getId_commandes() {
		return id_cmd;
	}
	public void setId_commandes(int id_commandes) {
		this.id_cmd = id_commandes;
	}
	public int getId_produits() {
		return id_produit;
	}
	public void setId_produits(int id_produits) {
		this.id_produit = id_produits;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Detail(int id, int id_commandes, int id_produits, int qte, double prix) {
		this.id = id;
		this.id_cmd = id_commandes;
		this.id_produit = id_produits;
		this.qte = qte;
		this.prix = prix;
	}
	public Detail(int id_commandes, int id_produits, int qte, double prix) {

		this.id_cmd = id_commandes;
		this.id_produit = id_produits;
		this.qte = qte;
		this.prix = prix;
	}
	
	public Detail() {

	}
	
	public Produit cibleprod() {
		Produit p = new Produit();
		int idprod = this.getId_produits();
		ProduitDAO pdao = new ProduitDAO();
		p=pdao.getById(idprod);
		return p;
	}
	
	public Commande cmd() {
        Commande c = new Commande();
        CommandeDAO cdao = new CommandeDAO();
        c = cdao.getById(this.getId_commandes());
        return c;
    }
}
