package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Database;
import model.User;
import model.UserDAO;

import java.io.IOException;

/**
 * Servlet implementation class Modifierinfo
 */
public class Modifierinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifierinfo() {
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
			UserDAO userdao = new UserDAO();
			//pour recupererer l id de l utilisateur 
			int UtilisateurId = (int)session.getAttribute("userid");
			User us = userdao.getById(UtilisateurId);
			//Si le boutton mettre à jour est cliqué
			if (request.getParameter("btncompte")!=null) {
				load=true;
				String nom=request.getParameter("nom");
				String prenom= request.getParameter("prenom");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
			
				
				us.setNom(nom);
				us.setPrenom(prenom);
				us.setEmail(email);
				us.setMdp(password);
				userdao.save(us);
				response.sendRedirect("Moncompte");
			}
			request.setAttribute("us", us);
		}
		
		if(!load) {
			request.getRequestDispatcher( "modifier_info.jsp" ).forward( request, response );
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
