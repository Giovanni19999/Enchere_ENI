package bo;
	//Utilisateur ou user
public class BOUtilisateur {
	
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String pseudo;
	private int noUtilisateur;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private int credit;
	private boolean adminstrateur;
	
	
	
	
	/**
	 * @return the prenom
	 */
	public final String getPrenom() {
		return prenom;
	}



	/**
	 * @param prenom the prenom to set
	 */
	public final void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	/**
	 * @return the noUtilisateur
	 */
	public final int getNoUtilisateur() {
		return noUtilisateur;
	}



	/**
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public final void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}



	/**
	 * @return the telephone
	 */
	public final String getTelephone() {
		return telephone;
	}



	/**
	 * @param telephone the telephone to set
	 */
	public final void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	/**
	 * @return the rue
	 */
	public final String getRue() {
		return rue;
	}



	/**
	 * @param rue the rue to set
	 */
	public final void setRue(String rue) {
		this.rue = rue;
	}



	/**
	 * @return the codePostal
	 */
	public final String getCodePostal() {
		return codePostal;
	}



	/**
	 * @param codePostal the codePostal to set
	 */
	public final void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	/**
	 * @return the ville
	 */
	public final String getVille() {
		return ville;
	}



	/**
	 * @param ville the ville to set
	 */
	public final void setVille(String ville) {
		this.ville = ville;
	}



	/**
	 * @return the credit
	 */
	public final int getCredit() {
		return credit;
	}



	/**
	 * @param credit the credit to set
	 */
	public final void setCredit(int credit) {
		this.credit = credit;
	}



	/**
	 * @return the adminstrateur
	 */
	public final boolean isAdminstrateur() {
		return adminstrateur;
	}



	/**
	 * @param adminstrateur the adminstrateur to set
	 */
	public final void setAdminstrateur(boolean adminstrateur) {
		this.adminstrateur = adminstrateur;
	}



	public BOUtilisateur() {
		super();
	}
	
	
	
	public BOUtilisateur(String pseudo, String mdp) {
		super();
		setPseudo(pseudo);
		setMdp(mdp);
	}
	
	

	public BOUtilisateur(String nom, String prenom, String email, String mdp, String pseudo,
			String telephone, String rue, String codePostal, String ville) {
		super();
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setPseudo(pseudo);
		setMdp(mdp);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	@Override
	public String toString() {
		return "BOUtilisateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", pseudo="
				+ pseudo + ", noUtilisateur=" + noUtilisateur + ", telephone=" + telephone + ", rue=" + rue
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", credit=" + credit + ", adminstrateur="
				+ adminstrateur + "]";
	}



	


	
	
	
	
	
	
	
	
}
