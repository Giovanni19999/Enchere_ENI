package managers;

import java.util.ArrayList;

import bo.BOArticle;
import bo.BOCategorie;
import bo.BOEnchere;
import bo.BOUtilisateur;
import dal.ArticleDAOJdbc;

public class ManagerArticle {
	
	Exception INSER_DATE_INVERSER =new Exception("21000");
	
	
	public BOArticle InsertArticle(BOArticle article) throws Exception {
		
		if (article.getDebut().isAfter(article.getFin())) {
			throw INSER_DATE_INVERSER;
		}
		
		
		ArticleDAOJdbc ArticleDAO = new ArticleDAOJdbc();
		
		ArticleDAO.InsertArticle(article);
		
		article.setNumero(selectNumArticle(article));
		
		return article;
	}
	
	public ArrayList<BOArticle> rechecheArticle(String saisie, String cat){
		ArrayList<BOArticle> liste=null;
		
		ArticleDAOJdbc dal = new ArticleDAOJdbc();
		
		if (cat.isEmpty()) {
			liste=new ArticleDAOJdbc().selctByRecherche(saisie);
		}else {
			liste=dal.selctByCat(saisie, Integer.parseInt(cat));
		}
		
		
		return liste;
		
	}
	
	public ArrayList<BOArticle> rechecheArticleCo(String saisie, String cat,BOUtilisateur user){
		ArrayList<BOArticle> listeRecherche=rechecheArticle(saisie,cat);
		ArrayList<BOArticle> listeParticipe=new ManagerEnchere().recupererArticleEncherie(user);
		ArrayList<BOArticle> indice =new ArrayList<BOArticle>();
		
		if (listeParticipe != null) {
			
			for (BOArticle boArticle : listeParticipe) {
				
			 
				for (BOArticle boArticle2 : listeRecherche) {
					
				
					if (boArticle.getNumero()==boArticle2.getNumero()){
						indice.add(boArticle2);
					}
				}
			}
			
			
			for (BOArticle boArticle : indice) {
				listeRecherche.remove(boArticle);
			};
			
			indice.addAll(listeRecherche);
			
		
		}else {
			indice=listeRecherche;
		}
		return indice;
	}
	
	
	
	public BOArticle rechercheUnArticle(int noArt) {
		
		BOArticle art= new ArticleDAOJdbc().selctById(noArt);
		
		
		return art;
		
	}
	
	public int selectNumArticle(BOArticle art){
		int num = new ArticleDAOJdbc().selectNumByArticle(art);
		return num;
	}
	
	Exception MODIFIER_MONTANT_IDENTIQUE = new Exception("23000");
		


	
	
}

