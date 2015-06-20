package br.facitec.bibliotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.facitec.bibliotech.dao.MonografiaDao;
import br.facitec.bibliotech.entity.Monografia;

@RestController
public class MonografiaController {

	@Autowired
	private MonografiaDao monografiaDao;

	@RequestMapping(value = "/inserirMonografia", method = RequestMethod.POST)
	public void cadastraMonografia(@RequestBody Monografia monografia) {
		monografiaDao.insereMonografia(monografia);
	}

	@RequestMapping(value = "/monografia", method = RequestMethod.GET)
	public List<Monografia> getAllMonografia() {
		return monografiaDao.getAllMonografia();
	}
}
