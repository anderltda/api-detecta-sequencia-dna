package br.com.api.sequencia.dna.entity;

import java.io.Serializable;

public class Dna implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] dna;

	/**
	 * @return the dna
	 */
	public String[] getDna() {
		return dna;
	}

	/**
	 * @param dna the dna to set
	 */
	public void setDna(String[] dna) {
		this.dna = dna;
	}

}