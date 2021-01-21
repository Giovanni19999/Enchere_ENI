package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BOUtilisateur;
import managers.ManagerUtilisateur;

/**
 * Servlet implementation class ServletModifierProfil
 */
@WebServlet("/profil/modifier")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierProfil.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BOUtilisateur utilisateur;
		HttpSession session = request.getSession();
		ManagerUtilisateur mngUtilisateur = new ManagerUtilisateur();
		
		utilisateur = new BOUtilisateur(
				request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("email"),
				request.getParameter("mdp"),
				request.getParameter("pseudo"),
				request.getParameter("tel").toString(),
				request.getParameter("rue"),
				request.getParameter("codepostal").toString(),
				request.getParameter("ville"));

		try {
			utilisateur = mngUtilisateur.modifierUtillisateur((BOUtilisateur)session.getAttribute("utilisateur"), utilisateur, request.getParameter("emailconfirmation"), request.getParameter("mdpconfirmation"));
			
			
			session.setAttribute("utilisateur", utilisateur);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MonProfil.jsp");
			if(rd != null) {rd.forward(request, response);}
		} catch (SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierProfil.jsp");
			if(rd != null) {rd.forward(request, response);}
			e.printStackTrace();
		}
		
	}

}
