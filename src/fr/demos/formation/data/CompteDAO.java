package fr.demos.formation.data;

import java.util.List;

import fr.demos.formation.model.Compte;

public interface CompteDAO {
	
	void insert(Compte compte) throws Exception;
	List <Compte> select();
}
