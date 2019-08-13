package br.com.api.simios;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	// 65 - A = 260
	// 67 - C = 268
	// 71 - G = 284
	// 84 - T = 336

	public static void main(String[] args) {
	    int i;
	// o especificador de formato para caractere (%c)
	// mostra o i-ésimo caractere da tabela ASCII
	    System.out.printf("Caracteres numéricos:\n");
	    for (i=48; i<=57; i++) {
	     // System.out.printf("%c", i);
	    }
	 
	    System.out.printf("\n\nCaracteres alfabéticos maiúsculos:\n");
	    for (i=65; i<=90; i++) {
	      System.out.println("( ");
	      System.out.print(i);
	      System.out.printf("%c", i);
	      System.out.println(" )     ");
	    }
	 
	    System.out.printf("\n\nCaracteres alfabéticos minúsculos:\n");
	    for (i=97; i<=122; i++) {
	    System.out.print(i);
	      System.out.printf("%c", i);
	    }
	    System.out.printf("\n");
	  }
	
/*
	 public static void main(String[] args) {
		int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 11, 15, 22, 23, 24, 25, 26, 27, 28, 35, 39 };
		
		int cont = 0;
		StringBuilder str = new StringBuilder();
		
		String c = String.valueOf(vetor[0]);
		
		for(int i=0; i<vetor.length; i++) {
			if(i < vetor.length -1) {
				if(vetor[i] + 1 == vetor[i + 1]) {
					cont++;
					continue;
				}
			}
			
			if(cont > 0) {
				str.append(c).append(" a ").append(vetor[i]);
				cont=0;
			} else {
				str.append(vetor[i]);
			}
			
			if(i < vetor.length-1) {
				str.append(",");
				c = String.valueOf(vetor[i + 1]);
			}
		}
		
		System.out.println(str);
	}
	*/
}
