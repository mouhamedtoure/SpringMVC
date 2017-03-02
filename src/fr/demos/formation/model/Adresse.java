package fr.demos.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String type;
	@Min(0)
	private int numero;
	private String libelleVoie;
	private int codePostal;
	private String ville;
	

	
	
	public Adresse(String type, int numero, String libelleVoie, int codePostal, String ville) {
		super();
		this.type = type;
		this.numero = numero;
		this.libelleVoie = libelleVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	public Adresse() {
		super();
	}


	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLibelleVoie() {
		return libelleVoie;
	}
	public void setLibelleVoie(String libelleVoie) {
		this.libelleVoie = libelleVoie;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	

	@Override
	public String toString() {
		return type+ ": " +numero +", "+ " "+ libelleVoie +" "+codePostal + " "+ville;
	}

	
}
