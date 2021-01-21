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
					connexion = new Exception("Mot de passe incorrect");
					throw connexion;
				}
			}catch (Exception e){
				throw new Exception("Email ou mot de passe incorrect");
			}
		}else {
			try {
				base=c.selectByPseudo(id);
				
				if (!mdp.equals(base.getMdp())) {
					connexion = new Exception("Mot de passe incorrect");
					
					throw connexion;
				}
			}catch (Exception e){
				throw new Exception("Pseudo ou mot de passe incorrect");
			}
		}
		return base;
	}
	
	
	public BOUtilisateur modifierUtillisateur (BOUtilisateur preMod, BOUtilisateur postMod,String newEmail,String newMdp) throws SQLException{
		
		
		if (preMod.getMdp().equals(postMod.getMdp())) {
			if ((postMod.getEmail().isEmpty()||postMod.getEmail().isBlank()) && (newEmail.isBlank()||newEmail.isEmpty())){
				postMod.setEmail(preMod.getEmail());
			}else if(!postMod.getEmail().isEmpty() && !postMod.getEmail().isBlank() 
					&& (!newEmail.isBlank()&& !newEmail.isEmpty())
					&& (!postMod.getEmail().equals(newEmail))
					&& (postMod.getEmail().equals(preMod.getEmail()))){
				
				postMod.setEmail(newEmail);
				
			}
			
			postMod.setNoUtilisateur(preMod.getNoUtilisateur());
			postMod.setCredit(preMod.getCredit());
			postMod.setAdminstrateur(preMod.isAdminstrateur());
			
			if ( (newMdp.isBlank()||newMdp.isEmpty())) {
				if (!preMod.getMdp().equals(newMdp)) {
					preMod.setMdp(newMdp);
				}
				
			}
			
			
			if (!preMod.equals(postMod)) {
				UtilisateurDAOJdbc c = new UtilisateurDAOJdbc();
				c.updateById(postMod);
		
			}
		} else {
			System.out.println("Mot de passe faux");
		}
		return postMod;
	}
	
	public void suprimerUtilisateur (BOUtilisateur user) {
		/*dal delete by Id*/
	}
	
	
	
	
	
}



	



