package bo;

public class BOCategorie {
	private int noCategorie;
	private String libeler;
	
	
	
	
	
	
	
	
	public BOCategorie() {
		super();
	}
	
	
	public BOCategorie(int noCategorie, String libeler) {
		super();
		setNoCategorie(noCategorie);
		setLibeler(libeler);
	}


	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibeler() {
		return libeler;
	}
	public void setLibeler(String libeler) {
		this.libeler = libeler;
	}


	@Override
	public String toString() {
		return libeler;
	}
	
	
	
}
