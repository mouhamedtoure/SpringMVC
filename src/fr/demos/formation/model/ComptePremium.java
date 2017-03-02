package fr.demos.formation.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "comptepremium")
@DiscriminatorValue("premium")
public class ComptePremium extends Compte {

	private int pourcentagePremium;
	private int niveauPremium;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateFin;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Compte> filleuls;

	public ComptePremium() {
		super();
	}

	public ComptePremium(String nom, String prenom, LocalDate dateNaissance, String email, List<Adresse>listeAdresses, int pourcentagePremium, int niveauPremium, LocalDate dateFin, List<Compte> filleuls) {
		super(nom, prenom, dateNaissance, email, listeAdresses);
		// TODO Auto-generated constructor stub
		
		this.pourcentagePremium = pourcentagePremium;
		this.niveauPremium = niveauPremium;
		this.dateFin = dateFin;
		this.filleuls = filleuls;
	}


	public int getPourcentagePremium() {
		return pourcentagePremium;
	}

	public void setPourcentagePremium(int pourcentagePremium) {
		this.pourcentagePremium = pourcentagePremium;
	}

	public int getNiveauPremium() {
		return niveauPremium;
	}

	public void setNiveauPremium(int niveauPremium) {
		this.niveauPremium = niveauPremium;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	 public List<Compte> getFilleuls() {
	 return filleuls;
	 }
	 public void setFilleuls(List<Compte> filleuls) {
	 this.filleuls = filleuls;
	 }
	

}
