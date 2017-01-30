package fr.demos.formation.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.formation.model.Compte;

public class CompteDAOMySQL implements CompteDAO {

	private Context context;
	private DataSource dataSource;

	public CompteDAOMySQL() throws Exception {

		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/SpringMVC");

	}

	@Override
	public void insert(Compte compte) {
		// TODO Auto-generated method stub

		Connection cx;
		try {
			cx = dataSource.getConnection();

			java.sql.Statement statement = (java.sql.Statement) cx.createStatement();

			/* Exécution d'une requête d'écriture */

			statement.executeUpdate("INSERT INTO  compte (nom, prenom, anneDeNaissance, email) VALUES ('"
					+ compte.getNom() + "','" + compte.getPrenom() + "','" + compte.getAnneeDeNaissance() + "','"
					+ compte.getEmail() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
