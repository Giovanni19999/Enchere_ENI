package managers;

import java.util.ArrayList;

import bo.BOArticle;
import bo.BOCategorie;
import dal.ArticleDAOJdbc;

public class ManagerArticle {

	public void InsertArticle(BOArticle article) {
		ArticleDAOJdbc ArticleDAO = new ArticleDAOJdbc();
		ArticleDAO.InsertArticle(article);
	}
	
	public ArrayList<BOArticle> rechecheArticle(String saisie, BOCategorie cat){
		ArrayList<BOArticle> liste=null;
		if (cat==null) {
			liste=new ArticleDAOJdbc().selctByRecherche(saisie);
		}else {
			liste=new ArticleDAOJdbc().selctByCat(saisie, cat.getNoCategorie());
		}
		
		
		return liste;
		
	}
		
}

