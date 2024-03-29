package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BOArticle;
import bo.BOCategorie;
import bo.BOUtilisateur;
import exceptions.BusinessException;
import managers.ManagerArticle;
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
		Cookie[] cookies = request.getCookies();
		String user = null;
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("saveUser")) {
				user = cookie.getValue();
				cookie.setValue(user);
				response.addCookie(cookie);
				request.setAttribute("user", cookie.getValue());
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/FormulaireDeConnexion.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ManagerUtilisateur connexionManager = new ManagerUtilisateur();
		HttpSession session = request.getSession();
		BusinessException exeption = new BusinessException();
		try {
			BOUtilisateur utilisateur = null;
			utilisateur = connexionManager.validationConnection(request.getParameter("identifiant"), request.getParameter("mdp"));
	
			session.setAttribute("utilisateur", utilisateur);
			
			if(request.getParameter("resterconnecter") != null){
				Cookie cookie = new Cookie("saveUser",request.getParameter("identifiant"));
				response.addCookie(cookie);
				request.setAttribute("user", cookie.getValue());
			} else {
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie:cookies) {
					if(cookie.getName().equals("saveUser")) {
						cookie.setValue("");
						cookie.setMaxAge(-1);
						response.addCookie(cookie);
						request.setAttribute("user", cookie.getValue());
					}
				}
			}
			ManagerArticle manager =new ManagerArticle();
			ArrayList<BOArticle> article = null;
			if (session.getAttribute("utilisateur")== null) {
				article = manager.rechecheArticle("", "");
				
			} else {
				article = manager.rechecheArticleCo("", "", (BOUtilisateur) session.getAttribute("utilisateur"));
			}
			request.setAttribute("article", article);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Encheres.jsp");
			if(rd != null) {rd.forward(request, response);}

		} catch (Exception e) {
			
			Cookie[] cookies = request.getCookies();
			String user = null;
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("saveUser")) {
					user = cookie.getValue();
					cookie.setValue(user);
					response.addCookie(cookie);
					request.setAttribute("user", cookie.getValue());
				}
			}
			
			String erreur=exeption.lecteurMessage(e.getMessage());
			request.setAttribute("erreur",erreur);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/FormulaireDeConnexion.jsp");
			if(rd != null) {rd.forward(request, response);}
		}
		
	}

}
