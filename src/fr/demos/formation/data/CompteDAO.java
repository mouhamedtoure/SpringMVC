package fr.demos.formation.data;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.demos.formation.model.Compte;



public interface CompteDAO {
	
	@Transactional
	void insert(Compte compte) throws Exception;
	
	@Transactional
	void insertTemplate(Compte compte) throws Exception;
	
	@Transactional
	List <Compte> select();
}
