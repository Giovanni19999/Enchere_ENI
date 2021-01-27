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
					System.out.println("erreur");
				
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
	
	
	
	Exception MODIFIER_MDP_INCORRECT = new Exception("20100");
	Exception MODIFIER_MDP_IDENTIQUE = new Exception("20101");
	Exception MODIFIER_EMAIL_INCORRECT = new Exception("20102");
	Exception MODIFIER_EMAIL_IDENTIQUE = new Exception("20103");
	Exception MODIFIER_EMAIL_MANQUANT =  new Exception("20104");
	
	
	
	
	public BOUtilisateur modifierUtillisateur (BOUtilisateur preMod, BOUtilisateur postMod,String newEmail,String newMdp) throws Exception{
		
		try {
		if (preMod.getMdp().equals(postMod.getMdp())) {
			
			
			
			if ((postMod.getEmail().isEmpty()||postMod.getEmail().isBlank()) && (newEmail.isBlank()||newEmail.isEmpty())){
				
				postMod.setEmail(preMod.getEmail());
				
			}else if(!postMod.getEmail().isEmpty() && !postMod.getEmail().isBlank() 
					&& (!newEmail.isBlank()&& !newEmail.isEmpty())
					&& (postMod.getEmail().equals(preMod.getEmail()))
					&& (!postMod.getEmail().equals(newEmail))){
				
				postMod.setEmail(newEmail);
				
			}else if((postMod.getEmail().equals(newEmail))){
				
				throw MODIFIER_EMAIL_IDENTIQUE;
				
			}else if (newEmail.isBlank() || newEmail.isEmpty()) {
				
				throw MODIFIER_EMAIL_MANQUANT;
				
			}else {
				
				throw MODIFIER_EMAIL_INCORRECT;
			}
			
			postMod.setNoUtilisateur(preMod.getNoUtilisateur());
			postMod.setCredit(preMod.getCredit());
			postMod.setAdminstrateur(preMod.isAdminstrateur());
			
			if ( (!newMdp.isBlank()||!newMdp.isEmpty())) {
				if (!preMod.getMdp().equals(newMdp)) {
					postMod.setMdp(newMdp);
				}else {
					throw MODIFIER_MDP_IDENTIQUE;
				}
				
			}
			
			
			if (!preMod.equals(postMod)) {
				UtilisateurDAOJdbc c = new UtilisateurDAOJdbc();
				c.updateById(postMod);
		
			}
		} else {
			throw MODIFIER_MDP_INCORRECT;
		}
		
		}catch (Exception finale) {
			
			throw new Exception(finale.getMessage()); 
			
		}
		return postMod;
	}
	
	public void suprimerUtilisateur (BOUtilisateur user) {
		/*dal delete by Id*/
	}
	
	
	
	
	
}



	



