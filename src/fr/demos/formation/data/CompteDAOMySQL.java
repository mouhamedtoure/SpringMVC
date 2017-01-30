package fr.demos.formation.data;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import fr.demos.formation.model.Compte;

public class CompteDAOMySQL implements CompteDAO {

	@Resource(name="jdbc/SpringMVC")
	private DataSource dataSource;


	public CompteDAOMySQL() throws Exception {

	}

	@Override
	public void insert(Compte compte) {
		// TODO Auto-generated method stub

		Connection cx;
		try {
			cx = dataSource.getConnection();

			Statement statement = (Statement) cx.createStatement();

			/* Exécution d'une requête d'écriture */

			
			
			statement.executeUpdate("INSERT INTO  compte (nom, prenom, dateNaissance, email) VALUES (?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
