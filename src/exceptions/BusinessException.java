package exceptions;


import java.util.ArrayList;

import message.CodeErreur;
import message.ListCodeErreur;




public class BusinessException  {
	
	public String lecteurMessage(String code) {
		String[] codeSplit=code.split(" ");
		ListCodeErreur instance=new ListCodeErreur();
		int taille = instance.appelListeExeption();
		String message = "";
		int erreur;
		for (int i = 0; i < taille; i++) {
			System.out.println(instance.getCodeErreur(i).getCode());
			
			for (String code1 : codeSplit) {
				System.out.println(code1);
				if (code1.equals(instance.getCodeErreur(i).getCode())){
					System.out.println("bon");
					message=message+" "+instance.getCodeErreur(i).getLibelle();
				}
				
			}
		}
		
		return message;
		
	}
	
	
	
	
}