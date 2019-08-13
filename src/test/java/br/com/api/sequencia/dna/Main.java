package br.com.api.sequencia.dna;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    
    public static final String PATTERN_A = "[A]{4,}";
    public static final String PATTERN_C = "[C]{4,}";
    public static final String PATTERN_G = "[G]{4,}";
    public static final String PATTERN_T = "[T]{4,}";

    public static void main(String[] args) {

        String[] simioDna =  {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "TCCCCA", "TCACTG"};
        String[] humanoDna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        
        String[] novo ={"CTGAGA",
        "CTATTC",
        "TATTGT",
        "AGTGGG",
        "TTCCCA",
        "TCACTG"};
        
       // String[] dna = simioDna;
        String[] dna = humanoDna;

        //String[] dna = novo;
        
        
        start(dna);

        /*
         * for (String dna : horizontais(dnas)) { System.out.println("A - " + isA(dna));
         * System.out.println("C - " + isC(dna)); System.out.println("G - " + isG(dna));
         * System.out.println("T - " + isT(dna)); }
         * 
         * System.out.println("===============================");
         * 
         * 
         * 
         * for (String dna : verticais(dnas)) { System.out.println("A - " + isA(dna));
         * System.out.println("C - " + isC(dna)); System.out.println("G - " + isG(dna));
         * System.out.println("T - " + isT(dna)); }
         * 
         * System.out.println("===============================");
         * 
         * 
         * 
         * 
         * for (Object dna : diagonais(dnas)) { System.out.println("A - " + isA((String) dna));
         * System.out.println("C - " + isC((String) dna)); System.out.println("G - " + isG((String)
         * dna)); System.out.println("T - " + isT((String) dna)); }
         * 
         * System.out.println("===============================");
         */
         
         

    }
    
    
    public static void start(String[] dna) {
        System.out.println(startMain(dna));;
    }


    private static boolean startMain(String[] dna) {
        
        for (String string : dna) {
            if(is(string)) {
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
            if(is(string)) {
                return true;
            }
        }
        
        List<String> diagonais = diagonais(arrayDiagonais);
        
        for (String string : diagonais) {
            if(is(string)) {
                return true;
            }
        }
        
        return false;
    }

    private static List<String> diagonais(String[][] arrayDiagonais) {

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
    

    
    private static boolean is(final String dna) {
        
        String patterns[] = { PATTERN_A, PATTERN_C, PATTERN_G, PATTERN_T };
        
        for (String regex : patterns) {
            
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(dna);
            
            if(m.find()) {
                return true;
            }
        }

        return false;
    }

   

}
