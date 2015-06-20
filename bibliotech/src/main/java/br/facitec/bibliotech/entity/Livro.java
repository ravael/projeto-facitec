package br.facitec.bibliotech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.facitec.bibliotech.situacao.SituacaoLivro;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Livro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String titulo;
	
	private String autor;
	
	private String categoria;
	
	private long numeroExemplares;
	
	private long isbn;
	
	private long numeroEdicao;
	
	private long quantidadePaginas;
	
	private String subtitulo;
	
	private String estante;
	
	@ManyToOne
	@NotNull
	@JsonProperty("editora")
	private Editora editora;
	
	@Enumerated(EnumType.ORDINAL)
	private SituacaoLivro situacao;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@JsonIgnore
	public long getNumeroExemplares() {
		return numeroExemplares;
	}
	public void setNumeroExemplares(long numeroExemplares) {
		this.numeroExemplares = numeroExemplares;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public long getNumeroEdicao() {
		return numeroEdicao;
	}
	public void setNumeroEdicao(long numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}
	public long getQuantidadePaginas() {
		return quantidadePaginas;
	}
	public void setQuantidadePaginas(long quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getEstante() {
		return estante;
	}
	public void setEstante(String estante) {
		this.estante = estante;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public SituacaoLivro getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoLivro situacao) {
		this.situacao = situacao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
