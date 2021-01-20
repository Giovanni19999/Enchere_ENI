package managers;

import javax.servlet.http.HttpServletRequest;

import bo.BOConnection;
import dal.UtilisateurDAOJdbc;


public class ManagerConnection {
	
	public String validationConnection(HttpServletRequest request) throws Exception {
		
		String id=request.getParameter("identifiant");
		String mdp=request.getParameter("mdp");
		BOConnection connection;
		BOConnection base;
		String pseudo = null;
		UtilisateurDAOJdbc c = new UtilisateurDAOJdbc();
		Exception eConnection = null;
		
		if (id.contains("@")) {
			connection=new BOConnection();
			connection.setEmail(id);
			connection.setMdp(mdp);
			
			
			try {
				base=c.selectByEmail(connection.getEmail());
				
				if (connection.getMdp().equals(base.getMdp())) {
					pseudo=base.getNom();
				}else {
					throw eConnection;
				}
			}catch (Exception e){
				throw new Exception("Email ou mot de passe incorrect");
			}
		}else {
			connection=new BOConnection(id, mdp);
			try {
				base=c.selectByPseudo(connection.getNom());
				
				if (connection.getMdp().equals(base.getMdp())) {
					pseudo=base.getNom();
				}else {
					throw eConnection;
				}
			}catch (Exception e){
				throw new Exception("Pseudo ou mot de passe incorrect");
			}
			
		}
		
		return pseudo;
	}
	
	
	
}
