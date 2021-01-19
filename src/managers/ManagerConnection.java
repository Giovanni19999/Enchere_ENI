package managers;

import javax.servlet.http.HttpServletRequest;

import bo.BOConnection;


public class ManagerConnection {
	
	public String validationConnection(HttpServletRequest request) {
		
		String id=request.getParameter("identifiant");
		String mdp=request.getParameter("mdp");
		BOConnection connection;
		String pseudo = null;
		
		
		
		if (id.contains("@")) {
			connection=new BOConnection();
			connection.setEmail(id);
			connection.setMdp(mdp);
		}else {
			connection=new BOConnection(id, mdp);
			pseudo=connection.getNom();
		}
		
		
		
		
		
		return pseudo;
	}
	
	
	
}
