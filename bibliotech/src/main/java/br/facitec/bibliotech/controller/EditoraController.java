package br.facitec.bibliotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.facitec.bibliotech.dao.EditoraDao;
import br.facitec.bibliotech.entity.Editora;

@RestController
public class EditoraController {

	@Autowired
	private EditoraDao editoraDao;
	
	@RequestMapping(value = "/editora", method = RequestMethod.GET)
	public List<Editora> listaTodasEditoras(){
		return editoraDao.getAll();
	}
	
}
