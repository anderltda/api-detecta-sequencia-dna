package br.com.api.sequencia.dna;


import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainTests {

    public static void main(String[] args) {
        /*
         * //Procura 2 dígitos no texto boolean valor = "74".matches("\\d{2}");
         * System.out.println("1 - Procura 2 dígitos no texto " + valor);
         * 
         * //Procura mais de 2 dígitos no texto valor = "846767676765".matches("\\d{99,}");
         * System.out.println("2 - Procura mais de 2 dígitos no texto " + valor);
         * 
         * //Procura dígitos entre os valores de 2 e 5 valor = "2121".matches("\\d{2,5}");
         * System.out.println("3 - Procura dígitos entre os valores de 2 e 5 " + valor);
         * 
         * //Procura dígito entre 0 e 1 vezes valor = "22".matches(".?");
         * System.out.println("4 - Procura dígito entre 0 e 1 vezes " + valor);
         * 
         * //Procura dígito entre 0 e mais vezes valor = "75411".matches(".*");
         * System.out.println("5 - Procura dígito entre 0 e mais vezes " + valor);
         * 
         * //Procura dígito entre 1 e mais vezes valor = "846767".matches(".+");
         * System.out.println("6 - Procura dígito entre 1 e mais vezes " + valor);
         * 
         * //Cria expressão regular resumida da data String data = "02/05/1995"; valor =
         * data.matches("\\d{2}/\\d{2}/\\d{4}"); System.out.println("7 - Data: "+valor);
         * 
         * //Cria a expressão regular resumida do cep String cep = "8545-222"; valor =
         * cep.matches("\\d{4}-\\d{3}"); System.out.println("8 - Cep: "+valor);
         */

        Pattern p = Pattern.compile("[C]{4,}");
        Matcher m = p.matcher("gCCCcg");

        if (m.find()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
