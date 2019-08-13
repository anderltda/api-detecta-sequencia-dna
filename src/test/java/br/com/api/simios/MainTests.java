package br.com.api.simios;

import java.io.IOException;

public class MainTests {
	
	// 65 - A = 260
	// 67 - C = 268
	// 71 - G = 284
	// 84 - T = 336
	
	  public static void main(String[] args) throws IOException {
		  //char exemplo = 'T'; System.out.println((int)exemplo); //Imprime 65
		  
			String [] dna = { "CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"}; 
			
			isSimian(dna);
	  }
	 
	
	  private static boolean isSimian(String [] dna) {
			
			boolean horizontais = horizontais();
			boolean verticais = verticais();
			boolean diagonais = diagonais();
	
			return true;
		}
	  
	  private static boolean horizontais() {
		  
		String values = new String();
			
			char array[][] = getsArray_();
			
			int A = 65;
			int C = 67;
			int G = 71;
			int T = 84;
			
			for (int i = 0; i < array.length; i++) {
				
				int atual = 0;
				
				int resultado = 0;
				
				//if(i < 4)continue;
				
				for (int e = 0; e < 6; e++) {
					
					atual = (int)array[i][e];
					
					values += (array[i][e]);
					
					resultado += atual;
					
					System.out.println(atual);

					int countA = (resultado % A);
					int cointC = (resultado % C);
					int cointG = (resultado % G);
					int cointT = (resultado % T);
					  

				}
				
				System.out.println(values + "\r" + resultado);
				values = new String();
			
			}
		  
		  
		  return true;
	  }
	  
	  private static boolean verticais() {
		  return true;
	  }
	  
	  private static boolean diagonais() {
		  return true;
	  }
	  
		// 65 - A = 260
	  private static void isA(int result) {
		  
		  int A = 65;
		  
		  int calc = (result % A);
		  
		  if(calc == 0) System.out.println("A - " + calc);
		  
	  }
	  
		// 67 - C = 268
	  private static void isC(int result) {
		  
		  int C = 67;
		  
		  int calc = (result % C);
		  
		  if(calc == 0) System.out.println("C - " + calc);
	  }
	  
	  
		// 71 - G = 284
	  private static void isG(int result) {
		  
		  int G = 71;
		  
		  int calc = (result % G);
		  
		  if(calc == 0) System.out.println("G - " + calc);
		  
	  }
	  
		// 84 - T = 336
	  private static void isT(int result) {
		  
		  int T = 84;
		  
		  int calc = (result % T);
		  
		  if(calc == 0) System.out.println("T - " + calc);
		  
	  }
	  
		private static char[][] getsArray_() {
			
			
			char array[][] = new char[1][6];
			
			array[0][0] = 'T';
			array[0][1] = 'C';
			array[0][2] = 'C';
			array[0][3] = 'C';
			array[0][4] = 'C';
			array[0][5] = 'A';
			

			return array;
		}
	  
		
		private static char[][] getsArray() {
			
			
			char array[][] = new char[6][6];
			
			array[0][0] = 'C';
			array[0][1] = 'T';
			array[0][2] = 'G';
			array[0][3] = 'A';
			array[0][4] = 'G';
			array[0][5] = 'A';
			
			array[1][0] = 'C';
			array[1][1] = 'T';
			array[1][2] = 'A';
			array[1][3] = 'T';
			array[1][4] = 'G';
			array[1][5] = 'C';
			
			array[2][0] = 'T';
			array[2][1] = 'A';
			array[2][2] = 'T';
			array[2][3] = 'T';
			array[2][4] = 'G';
			array[2][5] = 'T';
			
			
			array[3][0] = 'A';
			array[3][1] = 'G';
			array[3][2] = 'A';
			array[3][3] = 'G';
			array[3][4] = 'G';
			array[3][5] = 'G';//
			
			array[4][0] = 'T';
			array[4][1] = 'C';
			array[4][2] = 'C';
			array[4][3] = 'C';
			array[4][4] = 'C';//
			array[4][5] = 'A';//2
			
			array[5][0] = 'T';
			array[5][1] = 'C';
			array[5][2] = 'A';
			array[5][3] = 'C';
			array[5][4] = 'T';
			array[5][5] = 'G';//1
			

			return array;
		}
}
