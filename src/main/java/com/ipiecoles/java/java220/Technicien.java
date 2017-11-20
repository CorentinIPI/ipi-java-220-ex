package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe implements Comparable<Technicien> {

	private Integer grade;
	
	public Technicien() {
		
	}
	public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
		super(nom,prenom,matricule,dateEmbauche,salaire);
		this.grade=grade;
	}
	
	@Override
	public Double getPrimeAnnuelle() {
		// TODO Auto-generated method stub
		Double temp;
		Double salairebase;
		Double temp2;
		String pourcentage=this.grade+"0";
		temp = Double.parseDouble(pourcentage);
		salairebase=Entreprise.primeAnnuelleBase();
		temp2= salairebase+(temp*salairebase)/100;
		temp=salairebase;
		Double temp3;
		temp3 = (this.getNombreAnneeAnciennete().doubleValue())*Entreprise.PRIME_ANCIENNETE;
		temp+=temp3+temp2;
		return temp;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) throws TechnicienException {
		if(grade>=1 && grade<=5) {
			this.grade = grade;
		}else {
			throw new TechnicienException(this,grade);
		}
	}
	public void setSalaire(Double unSalaire) {
		Double temp = 0.0;
		String pourcentage=this.grade+"0";
		temp=Double.parseDouble(pourcentage);
		temp=unSalaire+(temp*unSalaire)/100;
		
		super.setSalaire(temp);
	}
	
	public Integer getNbConges() {
		return super.getNbConges()+this.getNombreAnneeAnciennete();

	}
	public int compareTo(Technicien t) {
		// TODO Auto-generated method stub
		
		return Integer.compare(t.grade, this.grade);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Technicien other = (Technicien) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		return true;
	}

}
