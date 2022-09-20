package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ContactDAO;
import model.Contact;
import model.Coordonnees;
import model.CoordonneesDAO;
import model.Database;

import java.io.IOException;

/**
 * Servlet implementation class Contact
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		
		CoordonneesDAO coordonneesdao = new CoordonneesDAO();
		
		Coordonnees cord= coordonneesdao.getById(1);
		
		boolean load=false;
		
		if(request.getParameter("submit")!=null) {
			
			load=true;
			boolean ok=false;
			
			String e = request.getParameter("email");
			String s = request.getParameter("subject");
			String m = request.getParameter("contactMessage");
			
			if(!e.isEmpty() && !s.isEmpty() && !m.isEmpty()) {
				
				ContactDAO cdao = new ContactDAO();
				Contact c = new Contact();
				HttpSession session = request.getSession(true);
				if(session.getAttribute("userid")!=null) {
					int iduser = (int) session.getAttribute("userid");
					c.setId_user(iduser);
				}else{
					c.setId_user(1);
				};
				c.setEmail(e);
				c.setSujet(s);
				c.setMsg(m);
				
				cdao.save(c);

				ok=true; 
				session.setAttribute("creaok", ok);
				}
				else {
				HttpSession session = request.getSession(true);
				session.setAttribute("creaok", ok);
				}
			
			response.sendRedirect(request.getHeader("referer"));
			
			}
		
		if(!load) {
		request.getRequestDispatcher("contact.jsp").forward(request, response);
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
