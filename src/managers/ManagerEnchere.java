package managers;

import java.util.ArrayList;

import bo.BOArticle;
import bo.BOUtilisateur;
import dal.ArticleDAOJdbc;
import dal.EnchereDAOJdbc;

public class ManagerEnchere {
	
	public ArrayList<BOArticle> recupererArticleEncherie(BOUtilisateur user){
		ArrayList<BOArticle> listeArt=null;
		ArrayList<Integer> noArticle = null;
		try {
			noArticle=new EnchereDAOJdbc().selectArticleByUtilisateur(user.getNoUtilisateur());
		} catch (Exception e) {
			
		}
		if (noArticle != null) {
			listeArt=new ArrayList<BOArticle>();
			for (Integer i : noArticle) {
				BOArticle art= new ManagerArticle().rechercheUnArticle(i);
				listeArt.add(art);
				
			}
			
		}
		
		return listeArt;
		
	}
}
