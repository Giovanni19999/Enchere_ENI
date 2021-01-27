package managers;

import java.util.ArrayList;

import bo.BOArticle;
import bo.BOCategorie;
import bo.BOUtilisateur;
import dal.ArticleDAOJdbc;

public class ManagerArticle {
	
	Exception INSER_DATE_INVERSER =new Exception("21000");
	
	
	public void InsertArticle(BOArticle article) throws Exception {
		
		if (article.getDebut().isAfter(article.getFin())) {
			throw INSER_DATE_INVERSER;
		}
		
		
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
	
	public ArrayList<BOArticle> rechecheArticleCo(String saisie, BOCategorie cat,BOUtilisateur user){
		ArrayList<BOArticle> listeRecherche=rechecheArticle(saisie,cat);
		ArrayList<BOArticle> listeParticipe=new ManagerEnchere().recupererArticleEncherie(user);
		
		
		if (listeParticipe != null) {
			
			for (int i = 0; i < listeParticipe.size(); i++) {
				if (!listeRecherche.contains(listeParticipe.get(i))){
					listeParticipe.remove(i);
				}
			}
			listeRecherche.removeAll(listeParticipe);
			
			listeParticipe.addAll(listeRecherche);
			
		
		}else {
			listeParticipe=listeRecherche;
		}
		return listeParticipe;
	}
	
	
	
	public BOArticle rechercheUnArticle(int noArt) {
		
		BOArticle art= new ArticleDAOJdbc().selctById(noArt);
		
		
		return art;
		
	}
	
	
	
	
}

