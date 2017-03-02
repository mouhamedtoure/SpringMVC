package fr.demos.formation.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="typeCompte")
public class Compte {

	@Size(min = 2, max = 10)
	private String nom;
	private String prenom;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateNaissance;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@Id
	private String email;

	@JoinColumn(name = "compte_id")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Adresse> listeAdresses;

	public Compte() {
		super();
	}

	public Compte(String nom, String prenom, LocalDate dateNaissance, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
	}

	public Compte(String nom, String prenom, LocalDate dateNaissance, String email, List<Adresse> listeAdresses) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.listeAdresses = listeAdresses;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Adresse> getListeAdresses() {
		return listeAdresses;
	}

	public void setListeAdresses(List<Adresse> listeAdresses) {
		this.listeAdresses = listeAdresses;
	}

}
