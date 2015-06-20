package br.facitec.bibliotech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.facitec.bibliotech.dao.UsuarioDao;
import br.facitec.bibliotech.entity.Usuario;

public class HomeController {

	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping(value = "/")
	public String login(){
		return "redirect:/pages/lock-screen";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Usuario usuario, HttpSession session) {
		Usuario dadosLogin = usuarioDao.login(usuario);
		if (dadosLogin != null) {
			 session.setAttribute("usuarioLogado", dadosLogin);
			return "redirect:/home";
		} else {
			return "index/index";
		}
	}
}
