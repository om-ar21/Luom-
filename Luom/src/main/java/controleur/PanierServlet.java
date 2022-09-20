package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Commande;
import model.CommandeDAO;
import model.Detail;
import model.DetailDAO;
import model.Panier;
import model.PanierDetails;
import model.Produit;
import model.ProduitDAO;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Servlet implementation class PanierServlet
 */
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean commandevalide=false;
		//valider la commande.
		
		if(request.getParameter("idtosuppr")!=null) {
			int idprod= Integer.valueOf(request.getParameter("idtosuppr"));
			HttpSession session = request.getSession(true);
			
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
			
			Panier panier=(Panier) session.getAttribute("panier");
			panier.delete(idprod);
			session.setAttribute("panier", panier);
			commandevalide=true;
			
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
			
			response.sendRedirect(request.getHeader("referer"));
		}
		
		if(request.getParameter("idtominus")!=null) {
			int idprod= Integer.valueOf(request.getParameter("idtominus"));
			HttpSession session = request.getSession(true);
			
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
			
			Panier panier=(Panier) session.getAttribute("panier");
			int prdnbr = panier.deleteOne(idprod);
			if(prdnbr <= 0) {
				panier.delete(idprod);
			}
			session.setAttribute("panier", panier);
			commandevalide=true;
			
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
			response.sendRedirect(request.getHeader("referer"));
		}
		
		if(request.getParameter("idtoup")!=null) {
			int idprod= Integer.valueOf(request.getParameter("idtoup"));
			HttpSession session = request.getSession(true);
			
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
			
			ProduitDAO produitdao = new ProduitDAO();
			Produit prod = produitdao.getById(idprod);
			int qte= 1;
			PanierDetails panieradd=new PanierDetails(prod, qte);
			Panier panier=(Panier) session.getAttribute("panier");
			panier.ajouter(panieradd);
			session.setAttribute("panier", panier);
			commandevalide=true;
			
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
			
			response.sendRedirect(request.getHeader("referer"));
		}
		
		if(request.getParameter("com")!=null) {
			
			commandevalide=true;
			response.sendRedirect("Intercom");
		}
			
			HttpSession session = request.getSession(true);
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute("panier", panier_temp);
			}
			
			Panier panier=(Panier) session.getAttribute("panier");
			request.setAttribute("fe", panier.articles);
			
			double tot = panier.total();
			request.setAttribute("T", tot);
			
			if(!commandevalide) {
			request.getRequestDispatcher("panier.jsp").forward(request, response);
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
