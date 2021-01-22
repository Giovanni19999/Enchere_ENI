package message;

public class CodeErreur {
	private String code;
	private String libelle;
	
	
	
	public CodeErreur() {
		super();
	}
	
	
	
	public CodeErreur(String code, String libelle) {
		super();
		setCode(code);
		setLibelle(libelle);
	}



	public String getCode() {
		return code;
	}
	public void setCode(String code2) {
		this.code = code2;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
