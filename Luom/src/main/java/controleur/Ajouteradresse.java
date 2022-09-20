package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Adresse;
import model.AdresseDAO;
import model.Database;

import java.io.IOException;

/**
 * Servlet implementation class Ajouteradresse
 */
public class Ajouteradresse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouteradresse() {
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
		 boolean load=false;
				if(session.getAttribute("userid")==null) {
					load=true;
					response.sendRedirect("Notconnected"); 
				}else {
					AdresseDAO adressedao = new AdresseDAO();
					int UtilisateurId = (int)session.getAttribute("userid");
					//si le bouton ajouter adresse est cliqué
					if(request.getParameter("ajouter_adresse")!=null) {
						load=true;
						Adresse adr = new Adresse();
						String adresse=request.getParameter("rue");
						String cp = request.getParameter("cp");
						String ville = request.getParameter("ville");
						String pays = request.getParameter("pays");
						
						adr.setAdresse(adresse);
						adr.setCp(cp);
						adr.setId_user(UtilisateurId);
						adr.setVille(ville);
						adr.setPays(pays);
						adressedao.save(adr);
						response.sendRedirect("Moncompte");
					}
					
				}
				if(!load) {
				request.getRequestDispatcher( "ajouteradresse.jsp" ).forward( request, response );
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
