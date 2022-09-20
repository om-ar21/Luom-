package model;

public class Produit {
	private int id;
	private int id_s_cat;
	private String titre;
	private String presentation;
	private String img;
	private double prix;
	private int stock;
	private int stock_minimum;
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
	public int getId_s_cat() {
		return id_s_cat;
	}
	public void setId_s_cat(int id_s_cat) {
		this.id_s_cat = id_s_cat;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStock_minimum() {
		return stock_minimum;
	}
	public void setStock_minimum(int stock_minimum) {
		this.stock_minimum = stock_minimum;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", id_s_cat=" + id_s_cat + ", titre=" + titre + ", presentation=" + presentation
				+ ", img=" + img + ", prix=" + prix + ", stock=" + stock + ", stock_minimum=" + stock_minimum + "]";
	}
	
	public Produit() {
		
	}
	
	public Produit(int id, int id_s_cat, String titre, String presentation, String img, double prix, int stock,
			int stock_minimum) {
		this.id = id;
		this.id_s_cat = id_s_cat;
		this.titre = titre;
		this.presentation = presentation;
		this.img = img;
		this.prix = prix;
		this.stock = stock;
		this.stock_minimum = stock_minimum;
	}
	
	public Produit(int id_s_cat, String titre, String presentation, String img, double prix, int stock,
			int stock_minimum) {
		this.id_s_cat = id_s_cat;
		this.titre = titre;
		this.presentation = presentation;
		this.img = img;
		this.prix = prix;
		this.stock = stock;
		this.stock_minimum = stock_minimum;
	}
	
	public Categorie getCat() {
		SouscategorieDAO sdao = new SouscategorieDAO();
		Souscategorie ss = sdao.getById(this.id_s_cat);
		int categ = ss.getId_cat();
		CategorieDAO cdao = new CategorieDAO();
		Categorie c = cdao.getById(categ);
		return c;
	}
	
	public Favoris getFavoris(int id) {
		FavorisDAO fav = new FavorisDAO();
		Favoris f = fav.getByIdProduit(id);
		return f;
		
	}
}
