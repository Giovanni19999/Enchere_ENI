package bo;

import java.time.LocalDateTime;


public class BOArticle {
	private String nom;
	private String categorie;
	private LocalDateTime debut;
	private LocalDateTime fin;
	private String adresse;
	/**
	 * @return the nom
	 */
	public final String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public final void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the categorie
	 */
	public final String getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public final void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	/**
	 * @return the debut
	 */
	public final LocalDateTime getDebut() {
		return debut;
	}
	/**
	 * @param debut the debut to set
	 */
	public final void setDebut(LocalDateTime debut) {
		this.debut = debut;
	}
	/**
	 * @return the fin
	 */
	public final LocalDateTime getFin() {
		return fin;
	}
	/**
	 * @param fin the fin to set
	 */
	public final void setFin(LocalDateTime fin) {
		this.fin = fin;
	}
	/**
	 * @return the adresse
	 */
	public final String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public final void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

}
