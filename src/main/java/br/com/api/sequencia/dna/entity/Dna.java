package br.com.api.sequencia.dna.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author Anderson Nascimento
 *
 */
@DynamoDBTable(tableName = "DNA")
public class Dna {

    private String id;
    private String sequencialdna;
    private Boolean simian;
    private String dna[];

    /**
     * @return the id
     */
    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
    	return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(String id) {
    	this.id = id;
    }

    /**
     * @return the sequencialdna
     */
    @DynamoDBAttribute(attributeName = "sequencialdna")
    public String getSequencialdna() {
        return sequencialdna;
    }


	/**
     * @param sequencialdna the sequencialdna to set
     */
    public void setSequencialdna(String sequencialdna) {
        this.sequencialdna = sequencialdna;
    }

    /**
     * @return the simian
     */
    @DynamoDBAttribute(attributeName = "simian")
    public Boolean getSimian() {
        return simian;
    }

    /**
     * @param simian the simian to set
     */

    public void setSimian(Boolean simian) {
        this.simian = simian;
    }

    /**
     * @return the dna
     */
    
    @DynamoDBIgnore
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
