package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Database;
import model.Panier;

import java.io.IOException;

/**
 * Servlet implementation class Cart
 */
public class MiniCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiniCart() {
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
		Panier panier=(Panier) session.getAttribute("panier");
		int pastille = panier.count();
		request.setAttribute("countart", pastille);
		
		int allproduit = panier.countAll(panier.articles);
		request.setAttribute("countallart", allproduit);
		request.setAttribute("fe", panier.articles);
		
		double tot = panier.total();
		request.setAttribute("T", tot);
		
		request.getRequestDispatcher("miniCart.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
