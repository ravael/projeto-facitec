package br.facitec.bibliotech.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.facitec.bibliotech.entity.Aluno;

@Repository
@Transactional
public class AlunoDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static List<Aluno> alunos = new ArrayList<Aluno>();
	
	public void insert(Aluno aluno){
		entityManager.persist(aluno);
	}
	
	public List<Aluno> findAll(){
		CriteriaQuery<Aluno> query = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
		query.select(query.from(Aluno.class));
		List<Aluno> lista = entityManager.createQuery(query).getResultList();
		entityManager.close();
		return lista;
	}
	
	public void delete(Aluno aluno){
		entityManager.find(Aluno.class, aluno.getMatricula());
		entityManager.remove(aluno);
	}

	public void update(Aluno aluno) {
		Aluno alunoExistente = getByMatricula(aluno.getMatricula());
		entityManager.merge(alunoExistente);
	}

	public Aluno getByMatricula(String matricula) {
		for (Aluno a : alunos) {
			if (a.getMatricula().equals(matricula)) {
				return a;
			}
		}
		throw new RuntimeException("Aluno não encontrado");
	}


}
