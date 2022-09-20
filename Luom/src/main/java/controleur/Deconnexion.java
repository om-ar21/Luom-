package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Deconnexion
 */
public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deconnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession( true );
        session.setAttribute( "userid", 0 );
        session.setAttribute( "usernom", "" );
        session.setAttribute( "isConnected", false );
        
        session.removeAttribute("creaok");
        session.invalidate();
        
        //response.sendRedirect(request.getHeader("referer")); //la le pb est que ça empeche le refresh le referer.
        //response.sendRedirect("Index");
        
        boolean error=false;
        String ref = (String)request.getHeader("referer");
        
        String url = ((HttpServletRequest)request).getRequestURL().toString();
        
        if(ref.equals("http://localhost:8080/Luom/Moncompte")) {
        error = true;}
        
        if(ref.equals("http://localhost:8080/Luom/Modifierinfo")) {
            error = true;}
        
        if(ref.equals("http://localhost:8080/Luom/Ajouteradresse")) {
            error = true;}
        
        if (error==true) {
          response.sendRedirect("Index");
          //evite la page qui frise quand je suis sur le client et pas 
          //besoin de le faire pour la commande car grace à mon algo il me met une belle 404 i am an happy lulu
        }
        
        if (error==false) {
        	response.sendRedirect(request.getHeader("referer"));
        }
        
        System.out.print(request.getHeader("referer"));
        System.out.print(url);
        System.out.print(ref);
        System.out.print(error);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
