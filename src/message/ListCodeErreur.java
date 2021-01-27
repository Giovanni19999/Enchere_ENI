package message;


import java.util.ArrayList;
import java.util.List;

public class ListCodeErreur {
	private ArrayList<CodeErreur> listeCode= null;
	
			
	private void creationListe() {
		listeCode = new ArrayList();
		
		CodeErreur code10000=new CodeErreur("10000", "Id inconnue pour le select");
		listeCode.add(0, code10000);
		
		CodeErreur code10001=new CodeErreur("10001", "Pseudo ou mot de passe incorrect");
		listeCode.add(1, code10001);
		
		CodeErreur code10002=new CodeErreur("10002", "Email ou mot de passe incorrect");
		listeCode.add(2,code10002);
		
		
		CodeErreur code10100=new CodeErreur("10100", "Id inconnue pour l'update");
		listeCode.add(3,code10100);
		
		CodeErreur code11000=new CodeErreur("11000", "Erreur du selectAll");
		listeCode.add(4,code11000);
		
		
		CodeErreur code20000=new CodeErreur("20000", "Pseudo ou mot de passe incorrect");
		listeCode.add(5,code20000);
		
		CodeErreur code20001=new CodeErreur("20001", "Email ou mot de passe incorrect");
		listeCode.add(6,code20001);
		
		CodeErreur code20100=new CodeErreur("20100", "Mot de passe incorrect");
		listeCode.add(7,code20100);
		
		CodeErreur code20101=new CodeErreur("20101", "Les 2 mot de passe doivent être différent");
		listeCode.add(8,code20101);
	
		CodeErreur code20102=new CodeErreur("20102", "L'email rentrée est incorrect");
		listeCode.add(9,code20102);
		
		CodeErreur code20103=new CodeErreur("20103", "Les 2 emails doivent être différent");
		listeCode.add(10,code20103);
		
		CodeErreur code20104=new CodeErreur("20104", "Veiller rentrer une nouvelle email");
		listeCode.add(11,code20104);
		
		CodeErreur code20105=new CodeErreur("20105", "Catégorie invalide");
		listeCode.add(12,code20105);
		
		CodeErreur code21000=new CodeErreur("21000", "La date du debut de l'enchere est superieur a la date de fin");
		listeCode.add(100,code21000);
	}
	
	public int appelListeExeption(){
		if (listeCode==null) {
			creationListe();
		}
		int taille=listeCode.size();
		return taille;
		
	}
	public CodeErreur getCodeErreur(int i) {
		CodeErreur code=listeCode.get(i);
		return code;
	}
}
