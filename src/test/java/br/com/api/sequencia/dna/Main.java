package br.com.api.sequencia.dna;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String[] simioDna =  {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "TCCCCA", "TCACTG"};
        String[] humanoDna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        String[] dnas = humanoDna;

        for (String dna : horizontais(dnas)) {
            System.out.println("A - " + isA(dna));
            System.out.println("C - " + isC(dna));
            System.out.println("G - " + isG(dna));
            System.out.println("T - " + isT(dna));
        }

        System.out.println("===============================");



        for (String dna : verticais(dnas)) {
            System.out.println("A - " + isA(dna));
            System.out.println("C - " + isC(dna));
            System.out.println("G - " + isG(dna));
            System.out.println("T - " + isT(dna));
        }

        System.out.println("===============================");
         



        for (Object dna : diagonais(dnas)) {
            System.out.println("A - " + isA((String) dna));
            System.out.println("C - " + isC((String) dna));
            System.out.println("G - " + isG((String) dna));
            System.out.println("T - " + isT((String) dna));
        }

        System.out.println("===============================");
         
         

    }

    private static String[] horizontais(String[] dna) {
        return dna;
    }

    private static String[] verticais(String[] dna) {
        
        String verticais[] = new String[dna.length];
        String arrayConerted[][] = new String[dna.length][dna.length];

        for (int e = 0; e < dna.length; e++) {
            for (int i = 0; i < dna.length; i++) {
                verticais[i] += dna[e].charAt(i);
                arrayConerted[e][i] = String.valueOf(dna[e].charAt(i));
            }
        }
        
        
        return verticais;
    }

    private static Object[] diagonais(String[] dna) {

        List<String> diagonais = new ArrayList<String>();

        String[][] array = convertArrayInTwoDimensional(dna);

        int dimension = array.length;
        
        String value = new String();

        for (int e = 0; e < dimension * 2; e++) {

            for (int i = 0; i <= e; i++) {

                int index = e - i;
                
                if (index < dimension && i < dimension) {
                    
                    value += array[index][i];
                    
                }
            }

            diagonais.add(value);
            
            value = new String();
        }

        return diagonais.toArray();
    }
    
    
    private static String[][] convertArrayInTwoDimensional(String[] dna) {
        
        String arrayConerted[][] = new String[dna.length][dna.length];
        
        for (int e = 0; e < dna.length; e++) {            
            for (int i = 0; i < dna.length; i++) {
                arrayConerted[e][i] = String.valueOf(dna[e].charAt(i));
            }
        }
        
        return  arrayConerted;
    }


    private static boolean isA(final String dna) {

        Pattern p = Pattern.compile("[A]{4,}");
        Matcher m = p.matcher(dna);

        return m.find();
    }

    private static boolean isC(final String dna) {
        Pattern p = Pattern.compile("[C]{4,}");
        Matcher m = p.matcher(dna);

        return m.find();
    }

    private static boolean isG(final String dna) {
        Pattern p = Pattern.compile("[G]{4,}");
        Matcher m = p.matcher(dna);

        return m.find();
    }

    private static boolean isT(final String dna) {
        Pattern p = Pattern.compile("[T]{4,}");
        Matcher m = p.matcher(dna);

        return m.find();
    }

}
