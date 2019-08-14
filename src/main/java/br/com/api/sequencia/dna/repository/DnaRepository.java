package br.com.api.sequencia.dna.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.api.sequencia.dna.entity.Dna;

/**
 * @author Anderson Nascimento
 *
 */
@EnableScan
public interface DnaRepository extends CrudRepository<Dna, String> {

	List<Dna> findAllBySimian(Boolean simian);
}
