package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

import model.CategorieDAO;
import model.Coordonnees;
import model.CoordonneesDAO;
import model.Database;
import model.Favoris;
import model.FavorisDAO;
import model.Panier;
import model.Recherche;
import model.RechercheDAO;
import model.UserDAO;
import model.Categorie;

import java.util.ArrayList;

/**
 * Servlet implementation class Header
 */
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		
		CategorieDAO categoriedao=new CategorieDAO();
		CoordonneesDAO coordonneesdao = new CoordonneesDAO();
		FavorisDAO favorisdao=new FavorisDAO();
		
		HttpSession session = request.getSession( true );
		boolean load=false;
		
		if((Panier) session.getAttribute("panier")==null) {
			Panier panier_temp=new Panier();
			session.setAttribute( "panier", panier_temp );
		}
		
		if(session.getAttribute("isConnected")==null) {
			session.setAttribute( "isConnected", false );
		}
		
		if(session.getAttribute("userid")!=null) {
			int userid=(int)session.getAttribute("userid");
		ArrayList<Favoris> fav = favorisdao.getAllById(userid);
		
		if(request.getParameter("delete")!=null) {
            int id = Integer.valueOf(request.getParameter("delete"));
            favorisdao.hideByIdFav(id);
            load=true;
            response.sendRedirect(request.getHeader("referer"));
        }
		
		request.setAttribute("fav", fav);
		}
		
		int id_user;
		   if((boolean)session.getAttribute("isConnected")==false) {
				id_user=1;
			}else {
				id_user=(int)session.getAttribute("userid");
			}
		System.out.println(id_user);
		   
		
		if(request.getParameter("bcherche")!=null) {
			String mot=request.getParameter("mot");
			
			Recherche recherche = new Recherche();
			RechercheDAO recherchedao= new RechercheDAO();
			
			long mill  = System.currentTimeMillis();
			Date currentdate = new Date(mill);
			recherche.setRech(currentdate);
			recherche.setId_user(id_user);
			recherche.setMot(mot);
			System.out.println(recherche);
			recherchedao.save(recherche);
				
		  }
		
		int nbrfav = favorisdao.getCountFavorisByID(id_user);
		request.setAttribute("nbr_favoris",nbrfav);
		
		Panier panier=(Panier) session.getAttribute("panier");
		int allproduit = panier.countAll(panier.articles);
		request.setAttribute("countallart", allproduit);
		
		ArrayList<Categorie> cat= categoriedao.getAll();
		Coordonnees cord= coordonneesdao.getById(1);
		request.setAttribute("cat", cat);
		request.setAttribute("cord", cord);
		
		if(!load) {
		request.getRequestDispatcher("header.jsp").include(request, response);
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
