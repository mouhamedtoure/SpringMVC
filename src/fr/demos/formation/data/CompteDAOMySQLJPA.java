package fr.demos.formation.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.demos.formation.model.Adresse;
import fr.demos.formation.model.Compte;

@Repository
public class CompteDAOMySQLJPA implements CompteDAO {

	// Le contexte de persistance utilis� dans l'injection est par d�faut
	// transactionnel
	// l'entity manager manipule un contexte transactionnel

	@PersistenceContext
	private EntityManager em;

	// Annotation @Transactional g�re la transaction par AOP
	@Override
	@Transactional()
	public void insert(Compte compte) throws Exception {
		// 1: La m�thode �tant marqu�e transactionnelle, begin
		// 2: Place dans le contexte un nouvel objet (pas encore en base)
		em.merge(compte);
		// 3: flush (insert dans la base) du contexte autolatqieu avant le
		// commit
		// 4: La m�thode �tant marqu�e tarnsactionnelle, commit ou rollback
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compte> select() {
		// TODO Auto-generated method stub

		// // Texte de la requ�te
		// String query = "select c from Compte c";
		//
		// // Preparation d'un objet requete
		// TypedQuery<Compte> q = em.createQuery(query, Compte.class);
		//
		// // Obtention du r�sultat
		// List<Compte> listeComptes = q.getResultList();
		//
		//// for(Compte c: listeComptes){
		////
		//// for(Adresse a:c.getListeAdresses()){
		////
		////
		//// }
		//// }

		String query = "select distinct c from Compte c left join fetch c.listeAdresses lad where lad.ville=?";
		TypedQuery<Compte> q = em.createQuery(query, Compte.class);
		q.setParameter(0, "Paris");
		List<Compte> listeComptes = q.getResultList();
		return listeComptes;
	}

	@Override
	public Compte find(String email) {

		Compte c = em.find(Compte.class, email);
		return c;

	}

}
