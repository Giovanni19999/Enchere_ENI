package managers;


import java.sql.SQLException;

import bo.BOUtilisateur;
import dal.UtilisateurDAOJdbc;

		
public class ManagerUtilisateur {
	
	public BOUtilisateur validationConnection(String id, String mdp) throws Exception {
	
		BOUtilisateur base;
		UtilisateurDAOJdbc c = new UtilisateurDAOJdbc();
		Exception connexionPseudo = new Exception("20000");
		Exception connexionEmail = new Exception("20001");
		
		if (id.contains("@")) {			
			
			try {
				base=c.selectByEmail(id);
				
				if (!mdp.equals(base.getMdp())) {
					
					throw connexionEmail;
				}
			}catch (Exception e){
				if (e.getMessage().isBlank() ||e.getMessage().isEmpty()) {
					throw new Exception(connexionEmail.getMessage());
				}else {
			
					throw new Exception(e.getMessage());
				}
			}
			
		}else {
			try {
				base=c.selectByPseudo(id);
				
				if (!mdp.equals(base.getMdp())) {
					
					throw connexionPseudo;
				}
			}catch (Exception e){
				if (e.getMessage().isBlank() ||e.getMessage().isEmpty()) {
					throw new Exception(connexionPseudo.getMessage());
				}else {
					throw new Exception(e.getMessage());
				}
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



	



