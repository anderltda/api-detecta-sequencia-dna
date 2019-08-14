package br.com.api.sequencia.dna;

import br.com.api.sequencia.dna.util.HelpUtil;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] dna = {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "TCCCCA", "TCACTG"};
        
        System.out.println(HelpUtil.convertObjectForJson(dna).replaceAll("\\W", ""));

    }

}
