package com.dio.livecoding.crud.salasdereuniao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarefa")

public class TarefaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer codigo;	
	@Column(nullable = false, length = 50)
	public String descricao;
	@Column(nullable = false)
	public Boolean prioridade;	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Boolean prioridade) {
		this.prioridade = prioridade;
	}


}
