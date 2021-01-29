package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BOArticle;
import bo.BOUtilisateur;
import exceptions.BusinessException;
import managers.ManagerArticle;
import managers.ManagerUtilisateur;

/**
 * Servlet implementation class ServletCreationCompte
 */
@WebServlet("/compte/creation")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreationCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/CreationCompte.jsp");
		if (rd != null ) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BOUtilisateur utilisateur = new BOUtilisateur(); 
		utilisateur.setPseudo(request.getParameter("pseudo"));
		utilisateur.setMdp(request.getParameter("motdepasse"));
		String confirmation =request.getParameter("confirmation");
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setTelephone(request.getParameter("telephone"));
		utilisateur.setRue(request.getParameter("rue"));
		utilisateur.setCodePostal(request.getParameter("codepostal"));
		utilisateur.setVille(request.getParameter("ville"));
		
		try {
			new ManagerUtilisateur().creationUtilisateur(utilisateur, confirmation);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("/retour/encheres");
			if (rd != null ) {rd.forward(request, response);}
			
		} catch (Exception e) {
			BusinessException exeption = new BusinessException();
			String erreur=exeption.lecteurMessage(e.getMessage());
			request.setAttribute("erreur",erreur);
			
			doGet(request, response);
		}
		
	} 

}
