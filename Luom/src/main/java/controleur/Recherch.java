package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Database;
import model.Favoris;
import model.FavorisDAO;
import model.Panier;
import model.PanierDetails;
import model.Produit;
import model.ProduitDAO;
import model.UserDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Recherch
 */
public class Recherch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
        ProduitDAO produitdao=new ProduitDAO();
		ArrayList<Produit> produitstrouves = new ArrayList<Produit>();
		
		HttpSession session = request.getSession( true );
		String mot=request.getParameter("mot");
		produitstrouves=produitdao.Rechercher(mot); 
	  
		System.out.println(produitstrouves);
		request.setAttribute("mot", mot);
		request.setAttribute("produitstrouves", produitstrouves);
		
		boolean load=false;
		
		if(request.getParameter("padd")!=null) {
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
		load=true;
		int bt = Integer.valueOf(request.getParameter("padd"));
		Produit prod = produitdao.getById(bt);
		
		int qte= 1;
		PanierDetails panieradd=new PanierDetails(prod, qte);
					
		Panier panier=(Panier) session.getAttribute("panier");
		panier.ajouter(panieradd);
		session.setAttribute("panier", panier);
		
		if (request instanceof HttpServletRequest) {
			 String url = ((HttpServletRequest)request).getRequestURL().toString();
			 String queryString = ((HttpServletRequest)request).getQueryString();
			 response.sendRedirect(url + "?" + queryString);
		}
		
		}
		
		if(request.getParameter("paddqte")!=null) {
			
			load=true;
			int bt = Integer.valueOf(request.getParameter("paddqte"));
			Produit prod = produitdao.getById(bt);
			System.out.println(prod);
			int qte=Integer.valueOf(request.getParameter("newqte"));
			Panier panier=(Panier) session.getAttribute("panier");
			if(qte <= 0) {
				qte=0;
				panier.delete(bt);
			}
			PanierDetails panieradd=new PanierDetails(prod, qte);
			panier.ajouter(panieradd);
			session.setAttribute("panier", panier);
			
			response.sendRedirect(request.getHeader("referer"));
			
			}
		
		Favoris fv = new Favoris();
		FavorisDAO favorisdao = new FavorisDAO();
		if(request.getParameter("btnadd")!=null) {
			load=true;
			
			int idp = Integer.valueOf(request.getParameter("idp"));
			System.out.println(idp);
			int userid=(int)session.getAttribute("userid");
			fv.setId_produit(idp);
			fv.setId_user(userid);
			favorisdao.save(fv);
			fv=favorisdao.getById(userid);
			
			request.setAttribute("userid", userid);
			request.setAttribute("userid", userid);
			
			response.sendRedirect(request.getHeader("referer"));
		
		}
		if(request.getParameter("btnrmv")!=null) {
			load=true;
			int idp = Integer.valueOf(request.getParameter("idp"));
			int userid=(int)session.getAttribute("userid");
			favorisdao.hideById(idp, userid);
			response.sendRedirect(request.getHeader("referer"));
		}
		
		if(!load) {
		request.getRequestDispatcher( "recherche.jsp" ).forward( request, response );
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
