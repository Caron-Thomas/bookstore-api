package com.thomas.bookstore.dtos;

import java.io.Serializable;

import com.thomas.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String  Nome;
	private String  descricao;
	
	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO( Categoria obj ) {
		super();
		this.id        = obj.getId();
		this.Nome 	   = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
