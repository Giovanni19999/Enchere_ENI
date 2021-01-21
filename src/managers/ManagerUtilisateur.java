package managers;


import java.sql.SQLException;

import bo.BOUtilisateur;
import dal.UtilisateurDAOJdbc;

		
public class ManagerUtilisateur {
	
	public BOUtilisateur validationConnection(String id, String mdp) throws Exception {
	
		BOUtilisateur base;
		UtilisateurDAOJdbc c = new UtilisateurDAOJdbc();
		Exception connexion = null;
		
		if (id.contains("@")) {			
			
			try {
				base=c.selectByEmail(id);
				
				if (!mdp.equals(base.getMdp())) {
					throw connexion;
				}
			}catch (Exception e){
				throw new Exception("Email ou mot de passe incorrect");
			}
		}else {
			try {
				base=c.selectByPseudo(id);
				
				if (!mdp.equals(base.getMdp())) {
					throw connexion;
				}
			}catch (Exception e){
				throw new Exception("Pseudo ou mot de passe incorrect");
			}
		}
		return base;
	}
	
	
	public void modifierUtillisateur (BOUtilisateur preMod, BOUtilisateur postMod) throws SQLException {
		if (!preMod.equals(postMod)) {
			UtilisateurDAOJdbc c = new UtilisateurDAOJdbc();
			c.updateById(postMod);
		}
	}
	
	public void suprimerUtilisateur (BOUtilisateur user) {
		/*dal delete by Id*/
	}
	
	
	
	
	
}



	



