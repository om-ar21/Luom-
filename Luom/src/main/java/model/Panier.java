package model;

import java.util.ArrayList;

public class Panier {
	public ArrayList<PanierDetails> articles = new ArrayList<>();

	public Panier(ArrayList<PanierDetails> articles) {
		this.articles = articles;
	}

	public Panier() {
		
	}

	@Override
	public String toString() {
		return "Panier [articles=" + articles + "]";
	}
	
	//refs.
	public int count() {
		return this.articles.size();
	}
	
	//produits.
	public int countAll(ArrayList<PanierDetails> articles) {
		ArrayList<PanierDetails> art = articles;
		int nbrprod = 0;
		for(PanierDetails pdet:art){
			int depart = pdet.getQte();
			nbrprod+=depart;
		}
		
		return nbrprod;
	
	}
	
	public void ajouter(PanierDetails p) {
		boolean exist=false;
		for(PanierDetails dp:articles) {
			if(dp.getProduit().getId()==p.getProduit().getId()) {
				exist=true;
				dp.setQte(dp.getQte()+p.getQte());
			}
		}
		if(!exist) {
			articles.add(p);
		}
	}
	
	public void deter(PanierDetails p) {
		for(PanierDetails dp:articles) {
			if(dp.getProduit().getId()==p.getProduit().getId()) {
				dp.setQte(p.getQte());
			}
		}
	}
	
	public int deleteOne(int produitid) {
		PanierDetails detail= new PanierDetails();
		int nbr = 0;
		for(PanierDetails pp:articles) {
			if(pp.getProduit().getId()==produitid) {
				detail=pp;
		detail.setQte(detail.getQte()-1);
		nbr = detail.getQte();
			}
		}
		return nbr;
	}
	
	public double total() {
		double total=0;
		for(PanierDetails pp:articles) {
			total+=pp.getProduit().getPrix()*pp.getQte();
		}
		return total;
	}
	
	public void delete(int produitid) {
		PanierDetails detail= new PanierDetails();
		for(PanierDetails pp:articles) {
			if(pp.getProduit().getId()==produitid) {
				detail=pp;
			}
		}
		articles.remove(detail);
	}
	
	public void vider() {
		articles= new ArrayList<PanierDetails>();
	}

}
