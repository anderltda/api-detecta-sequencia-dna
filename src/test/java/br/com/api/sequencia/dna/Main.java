package br.com.api.sequencia.dna;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] dna = {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "TCCCCA", "TCACTG"};
        Pattern p = Pattern.compile("\\$[ACGT]");
        Matcher m = p.matcher("SATY");// r("846767676765");

        if (m.find()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
