package br.com.api.sequencia.dna.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.sequencia.dna.entity.Dna;
import br.com.api.sequencia.dna.repository.DnaRepository;
import br.com.api.sequencia.dna.response.Response;

/**
 * @author Anderson Nascimento
 *
 */
@Service
@Transactional
public class DetectaSequenciaGeneticaService {
    
    private static final String PATTERN_A = "[A]{4,}";
    private static final String PATTERN_C = "[C]{4,}";
    private static final String PATTERN_G = "[G]{4,}";
    private static final String PATTERN_T = "[T]{4,}";
    
    @Autowired
    private DnaRepository dnaRepository;
    
    /**
     * Método responsável por retorna as estatísticas de verificações de DNA, onde deve informar 
     * a ​quantidade de DNA’s símios, quantidade de DNA’s humanos, e a proporção de símios para 
     * a população humana.
     */
    @Cacheable("stats-cache")
    public Response stats() {
    	return new Response((List<Dna>) dnaRepository.findAll());
    }
    
    /**
     * Método responsável por inserir e atualizar os dados do DNA e checar se é um simian ou não
     * 
     * @param dna - Object a ser persistido
     */
    @CachePut("stats-cache")
    public boolean isSimian(Dna dna) {
        
        boolean simian = isSimian(dna.getDna());

        dna.setSimian(simian);
        
        dnaRepository.save(dna);
        
        return simian;
    }
    
	/**
     * Método responsável por ser capaz de identificar corretamente símios de um humano.
     * 
     * @param dna - Array de DNA(s)
     * @return - verdadeiro ou falso
     */
    public boolean isSimian(String[] dna) {

        for (String string : dna) {
            if (is(string)) {
                return true;
            }
        }

        String arrayVerticais[] = new String[dna.length];
        String arrayDiagonais[][] = new String[dna.length][dna.length];

        for (int e = 0; e < dna.length; e++) {
            for (int i = 0; i < dna.length; i++) {
                arrayVerticais[i] += dna[e].charAt(i);
                arrayDiagonais[e][i] = String.valueOf(dna[e].charAt(i));
            }
        }

        for (String string : arrayVerticais) {
            if (is(string)) {
                return true;
            }
        }

        List<String> diagonais = diagonais(arrayDiagonais);

        for (String string : diagonais) {
            if (is(string)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Método privado responsável por verificar sequencia nas diagonais da matriz, e transforma-lá
     * em uma matriz horizontal
     * 
     * @param arrayDiagonais - Array bidimensional
     * @return - Lista organizada em uma matriz horizontal
     */
    private List<String> diagonais(final String[][] arrayDiagonais) {

        List<String> diagonais = new ArrayList<String>();

        int dimension = arrayDiagonais.length;

        String value = new String();

        for (int e = 0; e < dimension * 2; e++) {

            for (int i = 0; i <= e; i++) {

                int index = e - i;

                if (index < dimension && i < dimension) {
                    value += arrayDiagonais[index][i];
                }
            }

            diagonais.add(value);

            value = new String();
        }

        return diagonais;
    }

    /**
     * Método privado responsável por verificar cada nó do DNA e checar se existe uma sequencia
     * 
     * @param dna - Nó de cada DNA
     * @return - verdadeiro ou falso
     */
    private boolean is(final String dna) {

        String patterns[] = { PATTERN_A, PATTERN_C, PATTERN_G, PATTERN_T };

        for (String regex : patterns) {

            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(dna);

            if (m.find()) {
                return true;
            }
        }

        return false;
    }
}