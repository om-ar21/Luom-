package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categorie;
import model.CategorieDAO;
import model.Coordonnees;
import model.CoordonneesDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Footer
 */
public class Footer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Footer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CoordonneesDAO coordao = new CoordonneesDAO();
		Coordonnees cord= coordao.getById(1);
		request.setAttribute("cord", cord);
		
		CategorieDAO catdao = new CategorieDAO();
		ArrayList<Categorie> cat= catdao.getAll();
		request.setAttribute("cats", cat);
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
