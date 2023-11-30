package com.projetointegrador.erp.model;

public enum MarcaCarro {

	FIAT("Fiat"), 
	VOLKSWAGEN("Volkswagen"),
	FORD("Ford"),
	CHEVROLET("Chevrolet"),
	RENAULT("Renault"),
	TOYOTA("Toyota"),
	HYUNDAI("Hyundai");

	private String descricao;

	MarcaCarro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
