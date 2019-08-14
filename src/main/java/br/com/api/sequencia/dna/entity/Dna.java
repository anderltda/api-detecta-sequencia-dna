package br.com.api.sequencia.dna.entity;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Dna")
public class Dna implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] dna;

	/**
	 * @return the dna
	 */
	@DynamoDBHashKey
	@DynamoDBAttribute
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
