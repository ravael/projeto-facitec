package br.facitec.bibliotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.facitec.bibliotech.dao.LivroDao;
import br.facitec.bibliotech.entity.Livro;
import br.facitec.bibliotech.situacao.SituacaoLivro;

@RestController
public class LivroController {

	@Autowired
	private LivroDao livroDao;

	@RequestMapping(value = "/livros", method = RequestMethod.POST)
	public void cadastraLivro(@RequestBody Livro livro) {
		livro.setSituacao(SituacaoLivro.INDISPONIVEL);
		livroDao.insereLivros(livro);
	}

	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> getAllLivros() {
		return livroDao.getAllLivros();
	}
}
