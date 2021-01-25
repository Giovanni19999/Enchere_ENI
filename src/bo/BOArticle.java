package bo;

import java.time.LocalDateTime;


public class BOArticle {
	private int numero;
	private String nom;
	private BOCategorie categorie;
	private LocalDateTime debut;
	private LocalDateTime fin;
	private String adresse;
	private String description;
	private BOUtilisateur utilisateur;
	private int prixIni;
	private String etatInit;
	private String etatComp;
	
	
	


	public BOArticle() {
		super();
	}
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrixIni() {
		return prixIni;
	}
	public void setPrixIni(int prixIni) {
		this.prixIni = prixIni;
	}
	public BOUtilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(BOUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public BOCategorie getCategorie() {
		return categorie;
	}
	public void setCategorie(BOCategorie categorie) {
		this.categorie = categorie;
	}


	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}


	/**
	 * @return the etatInit
	 */
	public String getEtatInit() {
		String tampon;
		if (etatInit.isBlank() || etatInit.isEmpty()) {
			if (etatComp.equalsIgnoreCase("creer")) {
				tampon="CR";
			}else if (etatComp.equalsIgnoreCase("en cours")) {
				tampon="EC";
			}else if (etatComp.equalsIgnoreCase("vendu")) {
				tampon="VD";
			}else {
				tampon="RT";
			}
		}else {
			tampon=etatInit;
		}
		return tampon;
	}


	/**
	 * @param etatInit the etatInit to set
	 */
	public void setEtatInit(String etatInit) {
		this.etatInit = etatInit;
	}


	/**
	 * @return the etatComp
	 */
	public String getEtatComp() {
		String tampon;
		if (etatComp.isBlank() || etatComp.isEmpty()) {
			if (etatInit.equalsIgnoreCase("CR")) {
				tampon="creer";
			}else if (etatInit.equalsIgnoreCase("EC")) {
				tampon="en cours";
			}else if (etatInit.equalsIgnoreCase("VD")) {
				tampon="vendu";
			}else {
				tampon="";
			}
		}else {
			tampon=etatComp;
		}
		return tampon;
		
		
	}


	/**
	 * @param etatComp the etatComp to set
	 */
	public void setEtatComp(String etatComp) {
		this.etatComp = etatComp;
		
	}
	
	
	

}
