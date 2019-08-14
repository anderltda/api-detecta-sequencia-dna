package br.com.api.sequencia.dna.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Anderson Nascimento
 *
 */
@Service
@Transactional
public class DetectaSequenciaGeneticaService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DetectaSequenciaGeneticaService.class);

    private static final String PATTERN_A = "[A]{4,}";
    private static final String PATTERN_C = "[C]{4,}";
    private static final String PATTERN_G = "[G]{4,}";
    private static final String PATTERN_T = "[T]{4,}";

    
	/**
     * Nível 1: Desenvolva um método ou função que esteja de acordo com a assinatura proposta
     * isSimian(String[] dna), que seja capaz de identificar corretamente símios.
     * 
     * @param dna
     * @return
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
     * @param arrayDiagonais
     * @return
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
     * @param dna
     * @return
     */
    private boolean is(final String dna) {

        String patterns[] = {PATTERN_A, PATTERN_C, PATTERN_G, PATTERN_T};

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
