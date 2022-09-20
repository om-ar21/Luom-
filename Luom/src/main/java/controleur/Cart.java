package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Database;
import model.Panier;
import model.PanierDetails;
import model.Produit;
import model.ProduitDAO;

import java.io.IOException;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Database.Connect();
		
		HttpSession session = request.getSession(true);
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
		
		boolean load=false;
		if(request.getParameter("paddqte")!=null) {
	
			load=true;
			ProduitDAO pdao = new ProduitDAO();
			int bt = Integer.valueOf(request.getParameter("paddqte"));
			Produit prod = pdao.getById(bt);
			System.out.println(prod);
			int qte=Integer.valueOf(request.getParameter("newqte"));
			if(qte <= 0) {
				panier.delete(bt);
			}
			PanierDetails panieradd=new PanierDetails(prod, qte);
			panier=(Panier) session.getAttribute("panier");
			panier.deter(panieradd);
			session.setAttribute("panier", panier);
			
			response.sendRedirect(request.getHeader("referer"));
			
			}
		
		if(!load) {
		request.getRequestDispatcher("cart.jsp").forward(request, response);
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
