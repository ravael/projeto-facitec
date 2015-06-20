package br.facitec.bibliotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.facitec.bibliotech.dao.EmprestimoDao;
import br.facitec.bibliotech.entity.Emprestimo;

@RestController
public class RenovaEmprestimoController {

	@Autowired
	private EmprestimoDao emprestimoDao;
	
	@RequestMapping(value = "/renovar", method = RequestMethod.POST)
	public void renovaEmprestimo(@RequestBody Emprestimo emprestimo){
		emprestimoDao.update(emprestimo);
	}
}
