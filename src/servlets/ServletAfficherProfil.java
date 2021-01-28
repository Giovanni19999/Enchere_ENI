package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BOUtilisateur;
import managers.ManagerUtilisateur;


/**
 * Servlet implementation class ServletAfficherProfil
 */
@WebServlet("/profil/afficher")
public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAfficherProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MonProfil.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerUtilisateur manager = new ManagerUtilisateur();
		BOUtilisateur user = null;
		
		String num = request.getParameter("profil");
		user = manager.trouverUtilisateur(Integer.parseInt(num));
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AfficherProfil.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

}
