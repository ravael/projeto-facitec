package br.facitec.bibliotech.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataEmprestino;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataDevoluçao;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Livro.class)
	private List<Livro> livros = new ArrayList<Livro>();
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity = Aluno.class, fetch = FetchType.LAZY)
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Monografia.class)
	private List<Monografia> monografia;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getDataEmprestino() {
		return dataEmprestino;
	}

	public void setDataEmprestino(Calendar dataEmprestino) {
		this.dataEmprestino = dataEmprestino;
	}

	public Calendar getDataDevoluçao() {
		return dataDevoluçao;
	}

	public void setDataDevoluçao(Calendar dataDevoluçao) {
		this.dataDevoluçao = dataDevoluçao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Monografia> getMonografia() {
		return monografia;
	}

	public void setMonografia(List<Monografia> monografia) {
		this.monografia = monografia;
	}
 	
}
