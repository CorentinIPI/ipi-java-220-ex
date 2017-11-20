package com.ipiecoles.java.java220;

public class TechnicienException extends Exception {

	public TechnicienException() {
		
	}
	
	public TechnicienException(Technicien emp,Integer grade) {
		super("Le grade doit être compris entre 1 et 5 : "+grade+", technicien : Technicien{grade="+emp.getGrade()+"} Employe{nom='"+emp.getNom()+"', prenom='"+emp.getPrenom()+"', matricule='"+emp.getMatricule()+"', dateEmbauche="+emp.getDateEmbauche()+", salaire="+emp.getSalaire()+"}");
	}
}
