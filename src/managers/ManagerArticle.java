package managers;

import java.util.ArrayList;

import bo.BOArticle;
import bo.BOCategorie;
import dal.ArticleDAOJdbc;

public class ManagerArticle {

	public void VendreArticle(BOArticle article) {
		ArticleDAOJdbc ArticleDAO = new ArticleDAOJdbc();
		ArticleDAO.VendreArticle(article);
	}
	
	public ArrayList<BOArticle> rechecheArticle(String saisie, BOCategorie cat){
		
		
		
		
		
		return null;
		
	}
		
}

