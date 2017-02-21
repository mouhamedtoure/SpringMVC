package fr.demos.formation.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.demos.formation.model.Compte;

@Repository
public class CompteDAOMySQLJPA implements CompteDAO {

	
	// Le contexte de persistance utilis� dans l'injection est par d�faut transactionnel
	// l'entity manager manipule un contexte transactionnel
	
	@PersistenceContext
	private EntityManager em ;


	@Override
	@Transactional
	public void insert(Compte compte) throws Exception {
		
			em.persist(compte);
		
	}


	@Override
	@Transactional(readOnly=true)
	public List<Compte> select() {
		// TODO Auto-generated method stub		
		
		// Texte de la requ�te
		String query= "select c from Compte c";
		
		// Preparation d'un objet requete
		TypedQuery<Compte> q= em.createQuery(query, Compte.class);
		
		// Obtention du r�sultat
		List <Compte> listeComptes = q.getResultList();
		
		return listeComptes;
	}


	@Override
	public Compte find(String email) {
		
		Compte c= em.find(Compte.class, email);
		return c;
		
	}

}
