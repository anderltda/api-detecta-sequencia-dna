package br.com.api.simios;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Teste2 {
// através da claúsula throws indicamos que não iremos
// tratar possíveis erros na entrada de dados realizada
// através do método "read" do pacote de classes System.in
  public static void main(String[] args) throws IOException {
	  Pattern p = Pattern.compile("((\\\\d{9}))");
	  Matcher m = p.matcher("84676767676584");//r("846767676765");

	  if (m.find()) {
	      System.out.println("true");
	  } else {
	      System.out.println("false");
	  }
  }
 
}
