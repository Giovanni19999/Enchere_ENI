package bo;
	//Utilisateur ou user
public class BOUtilisateur {
	
	private String nom;
	private String email;
	private String mdp;
	private String pseudo;
	
	
	
	public BOUtilisateur() {
		super();
	}
	
	
	
	
	public BOUtilisateur(String pseudo, String mdp) {
		super();
		setPseudo(pseudo);
		setMdp(mdp);
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
		return "BOUtilisateur [nom=" + nom + ", email=" + email + ", mdp=" + mdp + ", pseudo=" + pseudo + "]";
	}
	
	
	
	
}
