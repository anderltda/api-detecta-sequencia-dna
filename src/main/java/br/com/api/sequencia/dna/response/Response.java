package br.com.api.sequencia.dna.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.util.StringUtils;

import br.com.api.sequencia.dna.entity.Dna;

/**
 * 
 * @author Anderson Nascimento
 *
 */
public class Response implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double count_mutant_dna;
	private double count_human_dna;
	private double ratio;
	
	public Response(List<Dna> dnas) {
		
		this.count_mutant_dna = 0d;
		this.count_human_dna = 0d;
		this.ratio = 0d;

		if(!StringUtils.isEmpty(dnas)) {
			
			for (Dna dna : dnas) {
				
				if(dna.getSimian()) {
					count_mutant_dna++;
				} else {
					count_human_dna++;
				}
			}
			
			if(count_human_dna > 0) {
			    ratio = (count_mutant_dna / count_human_dna);
			} else {
			    ratio = (count_mutant_dna);
			}
		}	
	}
	
	/**
	 * @return the count_mutant_dna
	 */
	public double getCount_mutant_dna() {
		return count_mutant_dna;
	}

	/**
	 * @return the count_human_dna
	 */
	public double getCount_human_dna() {
		return count_human_dna;
	}

	/**
	 * @return the ratio
	 */
	public double getRatio() {
		return ratio;
	}
}
