package com.ipiecoles.java.java220;

import java.util.Collections;
import java.util.HashSet;

public class Unite<O> {
	private O responsable;
	private HashSet<O> membres;
	
	public O getResponsable() {
		return responsable;
	}
	public void setResponsable(O responsable) {
		this.responsable = responsable;
	}
	public Unite() {
		
	}
	public HashSet<O> getMembres() {
		return membres;
	}
	public void setMembres(HashSet<O> membres) {
		this.membres = membres;
	}
	
	public Unite(O membre) {
		this.responsable = membre;
		this.membres.add(membre);
	}
	public void ajouterMembre(O[] membres) {
		Collections.addAll(this.membres, membres);
	}
	@Override
	public String toString() {
		return "Unite [responsable=" + responsable + ", membres=" + membres + "]";
	}
}
