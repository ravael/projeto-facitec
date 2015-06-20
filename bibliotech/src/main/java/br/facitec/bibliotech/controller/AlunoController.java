package br.facitec.bibliotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.facitec.bibliotech.dao.AlunoDao;
import br.facitec.bibliotech.entity.Aluno;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoDao alunoDao;
	
	@RequestMapping(value = "/cadastroAluno", method = RequestMethod.POST)
	public void cadastroAluno(@RequestBody Aluno aluno){
		alunoDao.insert(aluno);
	}
	
	@RequestMapping(value = "/pesquisaTodosAlunos", method = RequestMethod.GET)
	public List<Aluno> pesquisaTodosAlunos(){
		return alunoDao.findAll();
	}
	
	@RequestMapping(value = "/atualizaAluno", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Aluno aluno) {
		alunoDao.update(aluno);
	}
}
