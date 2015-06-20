package br.facitec.bibliotech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.facitec.bibliotech.entity.Editora;

@Repository
@Transactional
public class EditoraDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Editora> getAll(){
		CriteriaQuery<Editora> query = entityManager.getCriteriaBuilder().createQuery(Editora.class);
		query.select(query.from(Editora.class));
		List<Editora> lista = entityManager.createQuery(query).getResultList();
		return lista;
	}
}
