package br.facitec.bibliotech.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.facitec.bibliotech.entity.Emprestimo;

@Repository
@Transactional
public class EmprestimoDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	public void insereEmprestimo(Emprestimo emprestimo){
		entityManager.persist(emprestimo);
	}

	public List<Emprestimo> getAllEmprestimo() {
		CriteriaQuery<Emprestimo> query = entityManager.getCriteriaBuilder().createQuery(Emprestimo.class);
		query.select(query.from(Emprestimo.class));
		List<Emprestimo> emprestimo = entityManager.createQuery(query).getResultList();
		return emprestimo;
	}

	public void update(Emprestimo emprestimo) {
		Emprestimo empExistente = getById(emprestimo.getId());
		entityManager.merge(empExistente);
	}
	
	public Emprestimo getById(Long id) {
		for (Emprestimo em : emprestimos) {
			if (em.getId() == id) {
				return em;
			}
		}
		throw new RuntimeException("Não há Emprestimos.");
	}
	
}
