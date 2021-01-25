package managers;

import java.util.ArrayList;

import bo.BOCategorie;
import dal.CategorieDAOJdbc;

public class ManagerCategorie {
	private ArrayList<BOCategorie> liste;
	
	
	public ArrayList<BOCategorie> recupererCategorie() throws Exception{
		CategorieDAOJdbc dal=new CategorieDAOJdbc();
		liste= dal.selectAll();
		for (BOCategorie boCategorie : liste) {
			System.out.println(boCategorie.toString());
		}
		return liste;
	}
		
}
