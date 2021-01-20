package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BOUtilisateur;
import managers.ManagerUtilisateur;

/**
 * Servlet implementation class ServletConnexionUtilisateur
 */
@WebServlet("/connexion/utilisateur")
public class ServletConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexionUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/FormulaireDeConnexion.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManagerUtilisateur connexionManager = new ManagerUtilisateur();
		HttpSession session = request.getSession();
		
		try {
			BOUtilisateur utilisateur = null;
			utilisateur = connexionManager.validationConnection(request.getParameter("identifiant"), request.getParameter("mdp"));
	
			session.setAttribute("utilisateur", utilisateur);
	
			getServletContext().getRequestDispatcher("/retour/encheres").forward(request, response);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			
			request.setAttribute("erreur", e.getMessage());
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/FormulaireDeConnexion.jsp");
			if(rd != null) {rd.forward(request, response);}
		}
		
	}

}
