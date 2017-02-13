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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.demos.formation.model.Compte;

// Mon CompteDAOMySQL devient un bean

@Repository
public class CompteDAOMySQL implements CompteDAO {

	// Besoin d'un datasource
	// On a rajoute une couche Spring a l'application jee. Il faut expliquer a
	// Spring comment exceder aux ressources jee
	// On prepare le Datasource qui n'est pas un bean mais une ressource geree
	// par le serveur

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Resource()
	private DataSource dataSource;

	public CompteDAOMySQL() throws Exception {

	}

	@Transactional(rollbackFor = SQLException.class)
	@Override
	public void insert(Compte compte) throws Exception {
		// TODO Auto-generated method stub

		try (Connection cx = dataSource.getConnection()) {

			PreparedStatement ps = cx
					.prepareStatement("INSERT INTO  compte(nom, prenom, dateNaissance, email) VALUES (?,?,?,?)");

			/* Ex�cution d'une requ�te d'�criture */

			ps.setString(1, compte.getNom());
			ps.setString(2, compte.getPrenom());
			ps.setDate(3, java.sql.Date.valueOf(compte.getDateNaissance()));
			ps.setString(4, compte.getEmail());

			ps.executeUpdate();
			ps.executeUpdate();

		}

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	@Override
	public List<Compte> select() {

		List<Compte> mesComptes = new ArrayList<Compte>();
		try {
			Connection cx = dataSource.getConnection();

			// Prepared statement pour les donnees dans la table livre
			PreparedStatement contexteRequete = cx.prepareStatement("SELECT * FROM Compte ");

			ResultSet rs = contexteRequete.executeQuery();

			while (rs.next()) {

				String monNom = rs.getString("nom");
				String monPrenom = rs.getString("prenom");
				LocalDate maDateNaissance = rs.getDate("dateNaissance").toLocalDate();
				String monEmail = rs.getString("email");

				Compte compte = new Compte(monNom, monPrenom, maDateNaissance, monEmail);

				mesComptes.add(compte);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return mesComptes;

	}

	@Override
	public void insertTemplate(Compte compte) throws Exception {
		
		jdbcTemplate.update(
				"INSERT INTO  compte(nom, prenom, dateNaissance, email) VALUES (?,?,?,?)",
				new Object[]{compte.getNom(),compte.getPrenom(),java.sql.Date.valueOf(compte.getDateNaissance()),compte.getEmail()
				});
		
		jdbcTemplate.update(
				"INSERT INTO  compte(nom, prenom, dateNaissance, email) VALUES (?,?,?,?)",
				new Object[]{compte.getNom(),compte.getPrenom(),java.sql.Date.valueOf(compte.getDateNaissance()),compte.getEmail()
				});
			
	}
}