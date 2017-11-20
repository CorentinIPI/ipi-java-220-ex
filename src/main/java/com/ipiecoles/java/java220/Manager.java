package com.ipiecoles.java.java220;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;

public class Manager extends Employe {

	private HashSet<Technicien> equipe = new HashSet();
	@Override
	public Double getPrimeAnnuelle() {
		// TODO Auto-generated method stub
		Integer nbMembre=this.equipe.size();
		Double temp;
		temp=Entreprise.primeAnnuelleBase().doubleValue()+Entreprise.PRIME_MANAGER_PAR_TECHNICIEN*nbMembre.doubleValue();
		return temp;
	}
	public HashSet getEquipe() {
		return equipe;
	}
	
	public void setEquipe(HashSet equipe) {
		this.equipe=equipe;
	}
	public void ajoutTechnicienEquipe(Technicien T) {
		this.equipe.add(T);
	}
	//String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade
	public void ajoutTechnicienEquipe(String nom, String prenom,String matricule,LocalDate date, Double salaire ,Integer grade) {
		Technicien t= new Technicien(nom,prenom,matricule,date,salaire,grade);
		this.equipe.add(t);
	}
	public void setSalaire(Double salaire) {
		Double temp;
		Double temp2;
		Integer nbMembre = this.equipe.size();
		temp=salaire*Entreprise.INDICE_MANAGER;
		temp2=salaire*(0.1*nbMembre);
		super.setSalaire(temp+temp2);
	}
	public void augmenterSalaire(Double pourcentage) {
		this.augmenterSalaireEquipe(pourcentage);
		super.augmenterSalaire(pourcentage);
	}
	private void augmenterSalaireEquipe(Double pourcentage) {
		for(Technicien c:equipe) {
			c.augmenterSalaire(pourcentage);
		}
	}
	
	public List<Technicien> equipeParGrade() {
	
		return this.equipe.stream().sorted().collect(Collectors.toList());
		
	}
	
	public Double salaireEquipeGrade1() {
		return this.equipe.stream().filter(x->x.getGrade().equals(1)).mapToDouble(Technicien::getSalaire).sum();
	}
	
}
