package br.facitec.bibliotech.test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.facitec.bibliotech.controller.RealizaEmprestimoController;
import br.facitec.bibliotech.entity.Aluno;
import br.facitec.bibliotech.entity.Emprestimo;
import br.facitec.bibliotech.entity.Livro;
import br.facitec.bibliotech.entity.Monografia;

public class RealizaEmprestimoTest {

	private List<Livro> livros;
	private List<Monografia> monografia;

	@Test
	public void deveRetornarDataQuinzeDiasAposAtual() {
		
		RealizaEmprestimoController remp = new RealizaEmprestimoController();
		remp.dataFinalizacaoEmprestimo();
		
		Calendar dataPrevista = Calendar.getInstance();
		dataPrevista.add(Calendar.DAY_OF_MONTH, 15);
		Calendar dataDevolucao = dataPrevista;
		
		assertEquals(remp.dataFinalizacaoEmprestimo(),dataDevolucao);
	}
	
	@Test
	public void deveRealizarEmprestimoMontandoObjeto(){
		
		Emprestimo emp = new Emprestimo();
		Aluno raphael = new Aluno();

		Calendar dataAtual = Calendar.getInstance();
		dataAtual.add(Calendar.DAY_OF_MONTH, 15);
		Calendar dataDevolucao = dataAtual;

		raphael.setNome("Raphael");
		raphael.setCurso("Sistema de informação");
		raphael.setEmail("raphaa.ld@gmail.com");
		raphael.setMatricula("11-1-011253");
		emp.setAluno(raphael);
		emp.setId(12);
		emp.setLivros(livros);
		emp.setMonografia(monografia);
		emp.setDataDevoluçao(dataDevolucao);
		emp.setDataEmprestino(dataAtual);
		emp.setAluno(raphael);
		
	}

}
