package bo;

import java.time.LocalDateTime;

public class BOEnchere {
	private BOUtilisateur utilisateur;
	private BOArticle article;
	private LocalDateTime date;
	private float montant;
	
	
	
	
	
	
	/**
	 * @return the utilisateur
	 */
	public BOUtilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(BOUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	/**
	 * @return the article
	 */
	public BOArticle getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(BOArticle article) {
		this.article = article;
	}
	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	
	
}
