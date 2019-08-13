package br.com.api.sequencia.dna;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("((\\\\d{9}))");
        Matcher m = p.matcher("84676767676584");// r("846767676765");

        if (m.find()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
