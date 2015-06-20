package br.facitec.bibliotech.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.facitec.bibliotech.entity.Livro;

@Repository
@Transactional
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insereLivros(Livro livro){
		entityManager.persist(livro);
	}

	public List<Livro> getAllLivros() {
		CriteriaQuery<Livro> query = entityManager.getCriteriaBuilder().createQuery(Livro.class);
		query.select(query.from(Livro.class));
		List<Livro> lista = entityManager.createQuery(query).getResultList();
		return lista;
	}
	
}
