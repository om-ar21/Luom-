package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Adresse;
import model.AdresseDAO;
import model.Commande;
import model.CommandeDAO;
import model.Database;
import model.Detail;
import model.DetailDAO;
import model.Panier;
import model.PanierDetails;
import model.Produit;
import model.ProduitDAO;
import model.User;
import model.UserDAO;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Servlet implementation class Intercom
 */
public class Intercom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Intercom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		
		HttpSession session = request.getSession( true );
		boolean ajouteradresse = false;
		
		if((Panier) session.getAttribute("panier")==null) {
			Panier panier_temp=new Panier();
			session.setAttribute( "panier", panier_temp );
		}
		Panier panier=(Panier) session.getAttribute("panier");
		int pastille = panier.count();
		request.setAttribute("countart", pastille);
		
		int allproduit = panier.countAll(panier.articles);
		request.setAttribute("countallart", allproduit);
		request.setAttribute("fe", panier.articles);
		
		double tot = panier.total();
		request.setAttribute("T", tot);
		
		for(PanierDetails pd:panier.articles) {
			int qte = pd.getProduit().getStock();
			int qty = pd.getQte();
			
			if(qty<=qte) {
				
			}
			
			if(qty>qte && qte>0) {
				boolean alertecmd1 = true;
				request.setAttribute("a1", alertecmd1);
			}
			
			if(qte==0) {
				boolean alertecmd2 = true;
				request.setAttribute("a2", alertecmd2);
			}
		
		}
		
		boolean load=false;
		
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Notconnected"); 
		}else {
			if(session.getAttribute("isConnected")==null) {
				load=true;
				session.setAttribute( "isConnected", false );
			}
			
			UserDAO userdao = new UserDAO();
			//pour recupererer l id de l utilisateur 
			int UtilisateurId = (int)session.getAttribute("userid");
			User us = userdao.getById(UtilisateurId);
			
			AdresseDAO adressdao = new AdresseDAO();
			ArrayList<Adresse> adresse = adressdao.getAllByUserId(UtilisateurId);
			request.setAttribute("us", us);
			request.setAttribute("adresse", adresse);
			
			if(request.getParameter("btnvcommande")!=null) {
				
				System.out.println("btn ok");
			
				
				if(Integer.valueOf(request.getParameter("adresse"))==0) {
					
					ajouteradresse=true;
					
				}else {
					int idadresse=Integer.valueOf(request.getParameter("adresse"));
					
					DetailDAO detdao = new DetailDAO();
					int iduser = (int) session.getAttribute("userid");
					Date dat = Date.valueOf(LocalDate.now());
					Commande c = new Commande(iduser,dat,tot);
					CommandeDAO cdao = new CommandeDAO();
					int idcommande = cdao.save(c);
					System.out.println(idcommande);
					
					for(PanierDetails pd:panier.articles) {
						int qte = pd.getProduit().getStock();
						int qty = pd.getQte();
						
						if(qty<=qte) {
							Detail d = new Detail();
							d.setQte(pd.getQte());//la quantité de produits poussée dans le caddie.
							d.setId_commandes(idcommande);
							d.setPrix(pd.getProduit().getPrix());
							d.setId_produits(pd.getProduit().getId());
							
							//maintenant c'est bien beau mais je veux aussi enlever la quantité de produit commandée
							ProduitDAO pdao = new ProduitDAO();
							Produit p = pdao.getById(pd.getProduit().getId());
							p.setStock(qte-qty);
							pdao.save(p);
							/*mettre alerte en sessions*/
							detdao.save(d);
						}
						
						if(qty>qte) {
							Detail d = new Detail();
							d.setQte(qte);//la quantité de produits poussée dans le caddie.
							d.setId_commandes(idcommande);
							d.setPrix(pd.getProduit().getPrix());
							d.setId_produits(pd.getProduit().getId());
							
							/*maintenant c'est bien beau mais je veux aussi enlever la quantité de produit ici ce sera 0
							pour jouer avec le produit j'en apl a la DAO de celui ci*/
							ProduitDAO pdao = new ProduitDAO();
							Produit p = pdao.getById(pd.getProduit().getId());
							p.setStock(0);
							pdao.save(p);
							
							detdao.save(d);
							//evidemment je recalcule le prix que devra payer le client on arnaque pas ici XD.
							Commande commodif = cdao.getById(idcommande);
							Double totavant = commodif.getTotal();
							int nbrartenmoins = qty-qte;
							Double prix = pd.getProduit().getPrix();
							Double aenlever = nbrartenmoins * prix;
							Double newprice = totavant - aenlever;
							commodif.setTotal(newprice);
							cdao.save(commodif);	
							/*mettre alerte en sessions*/
						}
						
						
						if(qte==0) {
							Commande commodif = cdao.getById(idcommande);
							Double totavant = commodif.getTotal();
							int nbrartenmoins = qty; //c'est toute la quantité qu'il avait que je dois lui rembourser lol
							Double prix = pd.getProduit().getPrix();
							Double aenlever = nbrartenmoins * prix;
							Double newprice = totavant - aenlever;
							commodif.setTotal(newprice);
							cdao.save(commodif);
							/*mettre alerte en sessions*/
						}
					
					panier.vider();
					session.setAttribute("panier", panier);
					System.out.println(idadresse);
					
				}
					Commande ctck = cdao.getById(idcommande);
					System.out.print(ctck.getTotal());
					if(ctck.getTotal()<0) {
						cdao.StById(idcommande);
						cdao.save(ctck);
						boolean nope = true;
						request.setAttribute("nope", nope);
					}else if(ctck.getTotal()==0.0) {
						cdao.StById(idcommande);
						cdao.save(ctck);
						boolean nope = true;
						request.setAttribute("nope", nope);
					}else {
						load=true;
					response.sendRedirect("Validation");}
			}
		}
			
			request.setAttribute("ajouteradresse",ajouteradresse);
			
			if(!load) {
			request.getRequestDispatcher("commande.jsp").forward(request, response);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
