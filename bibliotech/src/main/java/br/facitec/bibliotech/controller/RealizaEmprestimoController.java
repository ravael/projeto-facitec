package br.facitec.bibliotech.controller;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.facitec.bibliotech.dao.EmprestimoDao;
import br.facitec.bibliotech.entity.Aluno;
import br.facitec.bibliotech.entity.Emprestimo;
import br.facitec.bibliotech.entity.Livro;
import br.facitec.bibliotech.entity.Monografia;

@RestController
public class RealizaEmprestimoController {

	@Autowired
	private EmprestimoDao emprestimoDao;
	
	Calendar dataRealizacaoEmprestimo = Calendar.getInstance();
	
	private Emprestimo emprestimo;
	
	Aluno raphael = new Aluno();
	Monografia monografia = new Monografia();
	
	public Calendar dataFinalizacaoEmprestimo(){
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.add(Calendar.DAY_OF_MONTH, 15);
		Calendar dataDevolucao = dataAtual;
		return dataDevolucao; 
	}
	
	@RequestMapping(value = "/emprestimo", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	public void realizaEmprestimo(@RequestBody Livro livro){
		emprestimo.setAluno(raphael);
		emprestimo.setLivros(new ArrayList<Livro>());
		emprestimo.setMonografia(new ArrayList<Monografia>());
		emprestimo.setDataEmprestino(dataRealizacaoEmprestimo);
		emprestimo.setDataDevoluçao(dataFinalizacaoEmprestimo());
		emprestimoDao.insereEmprestimo(emprestimo);
	}

	
	
}
