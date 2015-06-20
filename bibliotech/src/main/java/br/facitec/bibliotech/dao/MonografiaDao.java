package br.facitec.bibliotech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.facitec.bibliotech.entity.Monografia;

@Repository
@Transactional
public class MonografiaDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insereMonografia(Monografia monogrfia){
		entityManager.persist(monogrfia);
	}
	
	public List<Monografia> getAllMonografia() {
		CriteriaQuery<Monografia> query = entityManager.getCriteriaBuilder().createQuery(Monografia.class);
		query.select(query.from(Monografia.class));
		List<Monografia> lista = entityManager.createQuery(query).getResultList();
		return lista;
	}
}
