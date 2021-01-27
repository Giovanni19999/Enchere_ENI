package exceptions;

import message.ListCodeErreur;




public class BusinessException  {
	
	public String lecteurMessage(String code) {
		String[] codeSplit=code.split(" ");
		ListCodeErreur instance=new ListCodeErreur();
		int taille = instance.appelListeExeption();
		String message = "";
		for (int i = 0; i < taille; i++) {
			
			for (String code1 : codeSplit) {
				
				if (code1.equals(instance.getCodeErreur(i).getCode())){
					
					message=message+" "+instance.getCodeErreur(i).getLibelle();
				}
				
			}
		}
		
		return message;
		
	}
	
	
	
	
}