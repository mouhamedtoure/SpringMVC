package fr.demos.formation.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import fr.demos.formation.model.Compte;


// Mon CompteDAOMySQL devient un bean

@Repository
public class CompteDAOMySQL implements CompteDAO {

	
	// Besoin d'un datasource
	// On a rajoute une couche Spring a l'application jee. Il faut expliquer a Spring comment exceder aux ressources jee 
	// On prepare le Datasource qui n'est pas un bean mais une ressource geree par le serveur
	
	@Resource()
	private DataSource dataSource;


	public CompteDAOMySQL() throws Exception {

	}

	@Override
	public void insert(Compte compte) {
		// TODO Auto-generated method stub

		Connection cx;
		try {
			cx = dataSource.getConnection();

			PreparedStatement ps = cx.prepareStatement("INSERT INTO  compte(nom, prenom, dateNaissance, email) VALUES (?,?,?,?)");

			/* Exécution d'une requête d'écriture */
			
			ps.setString(1, compte.getNom());
            ps.setString(2,compte.getPrenom());
            ps.setDate(3,java.sql.Date.valueOf(compte.getDateNaissance()));
            ps.setString(4,compte.getEmail());
            
            ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<Compte> select() {

		List <Compte> mesComptes= new ArrayList<Compte>();
		try {
			Connection cx = dataSource.getConnection();

			// Prepared statement pour les donnees dans la table livre
			PreparedStatement contexteRequete = cx.prepareStatement("SELECT * FROM Compte ");
			
			
			ResultSet rs = contexteRequete.executeQuery();

			while (rs.next()) {

				String monNom = rs.getString("nom");
				String monPrenom = rs.getString("prenom");
				LocalDate maDateNaissance= rs.getDate("dateNaissance").toLocalDate();
				String monEmail= rs.getString("email");
		
				
				Compte compte = new Compte(monNom, monPrenom, maDateNaissance, monEmail);
			
				mesComptes.add(compte);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mesComptes;

	}

}
