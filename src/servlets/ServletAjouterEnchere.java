package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BOArticle;
import bo.BOCategorie;
import bo.BOUtilisateur;
import exceptions.BusinessException;
import managers.ManagerArticle;

/**
 * Servlet implementation class AjouterEnchere
 */
@WebServlet("/encheres/ajouter")
public class ServletAjouterEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouterEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDateTime dateString = LocalDateTime.now();
		
		String formatMonth = null;
		String formatDay = null;
		String formatHour = null;
		String formatMin = null;
		
		if(dateString.getMonthValue() < 10) {
			formatMonth = "0" + dateString.getMonthValue();
		} else {
			formatMonth = dateString.getMonthValue() + "";
		}
		
		if(dateString.getDayOfMonth() < 10) {
			formatDay = "0" + dateString.getDayOfMonth();
		} else {
			formatDay = dateString.getDayOfMonth() + "";
		}
		
		if(dateString.getHour() < 10) {
			formatHour = "0" + dateString.getHour();
		} else {
			formatHour = dateString.getHour() + "";
		}
		
		if(dateString.getMinute() < 10) {
			formatMin = "0" + dateString.getMinute();
		} else {
			formatMin = dateString.getMinute() + "";
		}
		
		System.out.println(dateString.getYear());
		String dateStringFormater = dateString.getYear() + "-" + formatMonth + "-" + formatDay + "T" + formatHour + ":" + formatMin;
		System.out.println(dateStringFormater);
		request.setAttribute("dateMaintenant", dateStringFormater);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MiseEnVenteEnchere.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerArticle manager = new ManagerArticle();
		BOArticle article = new BOArticle();
		
		BOCategorie categorie = new BOCategorie();
		categorie.setNoCategorie(Integer.parseInt(request.getParameter("categorie")));
		
		
		HttpSession session = request.getSession();
		BOUtilisateur utilisateur = null;
		utilisateur = (BOUtilisateur) session.getAttribute("utilisateur");
		
		article.setNom(request.getParameter("nomenchere"));
		article.setCategorie(categorie);
		article.setDebut(LocalDateTime.parse(request.getParameter("datedebutenchere") + ":00"));
		article.setFin(LocalDateTime.parse(request.getParameter("datefinenchere") + ":00"));
		article.setAdresse(request.getParameter("adresseretraitenchere"));
		article.setDescription(request.getParameter("descriptionenchere"));
		article.setPrixIni(Float.parseFloat((request.getParameter("prixenchere"))));
		article.setUtilisateur(utilisateur);
		
		
		try {
			article = manager.InsertArticle(article);
			
			
			request.setAttribute ("article",article);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Enchere.jsp");
			if(rd != null) {rd.forward(request, response);}
						
		} catch (Exception e) {
			//String erreur=exeption.lecteurMessage(e.getMessage());
			//request.setAttribute("erreur",erreur);
			
			doGet(request, response);
		}
	}

}
