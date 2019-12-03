import java.lang.Math;

public class TLB{
	
	static int[][] tabela;
	static int cont = 0;
	
	public static int[][] preencherTLB(int[][] t1, int[][] t2, int[][] t3, int[][] t4, int[][] t5, int a, int num){
		int aux = (int) ((Math.pow(2,a))*0.01);
		int aux2 = (int) (Math.pow(2,a));
		cont = 0;
		tabela = new int[aux][4];
		int k = 1;
		int i = 0;
		
		switch (num) {
			case (1):
				while (cont < aux) {
					while (t1[i][2] != k) {
						if (i == aux2-1) {
							k++;
							i = 0;
						}
						i++;
					}
					tabela[cont][0] = t1[i][0];
					tabela[cont][1] = t1[i][1];
					tabela[cont][2] = t1[i][2];
					tabela[cont][3] = 1;
					cont++;
					i++;
				}
			break;
			case (2):
				while (cont < aux) {
					while (t1[i][2] != k && t2[i][2] != k) {
						if (i == aux2-1) {
							k++;
							i = 0;
						}
						i++;
					}
					if (t1[i][2] == k) {
						tabela[cont][0] = t1[i][0];
						tabela[cont][1] = t1[i][1];
						tabela[cont][2] = t1[i][2];
						tabela[cont][3] = 1;
					}
					if (t2[i][2] == k) {
						tabela[cont][0] = t2[i][0];
						tabela[cont][1] = t2[i][1];
						tabela[cont][2] = t2[i][2];
						tabela[cont][3] = 2;
					}
					cont++;
					i++;
				}
			break;
			case (3):
				while (cont < aux) {
					while (t1[i][2] != k && t2[i][2] != k && t3[i][2] != k) {
						if (i == aux2-1) {
							k++;
							i = 0;
						}
						i++;
					}
					if (t1[i][2] == k) {
						tabela[cont][0] = t1[i][0];
						tabela[cont][1] = t1[i][1];
						tabela[cont][2] = t1[i][2];
						tabela[cont][3] = 1;
					}
					if (t2[i][2] == k) {
						tabela[cont][0] = t2[i][0];
						tabela[cont][1] = t2[i][1];
						tabela[cont][2] = t2[i][2];
						tabela[cont][3] = 2;
					}
					if (t3[i][2] == k) {
						tabela[cont][0] = t3[i][0];
						tabela[cont][1] = t3[i][1];
						tabela[cont][2] = t3[i][2];
						tabela[cont][3] = 3;
					}
					cont++;
					i++;
				}
			break;
			case (4):
				while (cont < aux) {
					while (t1[i][2] != k && t2[i][2] != k && t3[i][2] != k && t4[i][2] != k) {
						if (i == aux2-1) {
							k++;
							i = 0;
						}
						i++;
					}
					if (t1[i][2] == k) {
						tabela[cont][0] = t1[i][0];
						tabela[cont][1] = t1[i][1];
						tabela[cont][2] = t1[i][2];
						tabela[cont][3] = 1;
					}
					if (t2[i][2] == k) {
						tabela[cont][0] = t2[i][0];
						tabela[cont][1] = t2[i][1];
						tabela[cont][2] = t2[i][2];
						tabela[cont][3] = 2;
					}
					if (t3[i][2] == k) {
						tabela[cont][0] = t3[i][0];
						tabela[cont][1] = t3[i][1];
						tabela[cont][2] = t3[i][2];
						tabela[cont][3] = 3;
					}
					if (t4[i][2] == k) {
						tabela[cont][0] = t4[i][0];
						tabela[cont][1] = t4[i][1];
						tabela[cont][2] = t4[i][2];
						tabela[cont][3] = 4;
					}
					cont++;
					i++;
				}
			break;
			case (5):
				while (cont < aux) {
					while (t1[i][2] != k && t2[i][2] != k && t3[i][2] != k && t4[i][2] != k && t5[i][2] != k) {
						if (i == aux2-1) {
							k++;
							i = 0;
						}
						i++;
					}
					if (t1[i][2] == k) {
						tabela[cont][0] = t1[i][0];
						tabela[cont][1] = t1[i][1];
						tabela[cont][2] = t1[i][2];
						tabela[cont][3] = 1;
					}
					if (t2[i][2] == k) {
						tabela[cont][0] = t2[i][0];
						tabela[cont][1] = t2[i][1];
						tabela[cont][2] = t2[i][2];
						tabela[cont][3] = 2;
					}
					if (t3[i][2] == k) {
						tabela[cont][0] = t3[i][0];
						tabela[cont][1] = t3[i][1];
						tabela[cont][2] = t3[i][2];
						tabela[cont][3] = 3;
					}
					if (t4[i][2] == k) {
						tabela[cont][0] = t4[i][0];
						tabela[cont][1] = t4[i][1];
						tabela[cont][2] = t4[i][2];
						tabela[cont][3] = 4;
					}
					if (t5[i][2] == k) {
						tabela[cont][0] = t5[i][0];
						tabela[cont][1] = t5[i][1];
						tabela[cont][2] = t5[i][2];
						tabela[cont][3] = 5;
					}
					cont++;
					i++;
				}
			break;
		}
		
		return tabela;
	}
	
	public static void mostraLocalizado(int [][] tabela, int num){
		System.out.println("");
		for(int i=num-3; i<num+3; i++){
			try{
				System.out.println("\t" + (String.format("%04x", tabela[i][0])).toUpperCase() + " " + (String.format("%04x", tabela[i][1])).toUpperCase() + " " + tabela[i][2] + " " + tabela[i][3]);
			} catch( ArrayIndexOutOfBoundsException exc ){
			}
		}
		
	}
	
	public static void mostraTabela(int[][] tabela, int a){
		
		int aux = (int) ((Math.pow(2,a))*0.01); 
		String ajuda1 = "", ajuda2 = "";
		System.out.printf("\n\n\t           TLB");
		System.out.printf("\n\t ___________________________________");
		System.out.printf("\n\t| Virtual| Fisico |  Prio  |  Prog  |");
		
		for(int i=0; i<5; i++){
			
			System.out.println("\t");
			
			for(int j=0; j<4; j++){
				
				if(tabela[i][j] == -1){
					System.out.printf("\t  DISCO");
				} else {
					if(j == 0){
						System.out.printf("\t|");
					}
					if(j == 2){
						System.out.printf("   %04d |", tabela[i][j]);
					} else {
						ajuda1 = (Integer.toHexString(tabela[i][j])).toUpperCase();
						ajuda2 = (Integer.toHexString(tabela[i][j])).toUpperCase();
						int maior = ajuda2.length();
						for(int k=0; k<aux; k++){
							ajuda2 = (Integer.toHexString(tabela[k][j])).toUpperCase();
							if(ajuda2.length() > maior){
								maior = ajuda2.length();
							}
						}
						if(j == 0){
							while(ajuda1.length() < maior){
								ajuda1 = "0" + ajuda1;
							}
						}
						System.out.printf("%7s |", ajuda1);
					}
				}
				
			}
			
		}
		
		System.out.printf("\n\t|   ...  |  ...   |   ...  |   ...  |");
		
		for(int i=aux-6; i<aux; i++){
			
			System.out.println();
			
			for(int j=0; j<4; j++){
				
				if(tabela[i][j] == -1){
					System.out.printf("  DISCO |");
				} else {
					if(j == 0){
						System.out.printf("\t|");
					}
					if(j == 2){
						System.out.printf("   %04d |", tabela[i][j]);
					} else {
						ajuda1 = (Integer.toHexString(tabela[i][j])).toUpperCase();
						ajuda2 = (Integer.toHexString(tabela[aux-1][j])).toUpperCase();
						if(j == 0){
							while(ajuda1.length() < ajuda2.length()){
								ajuda1 = "0" + ajuda1;
							}
						}
						System.out.printf("%7s |", ajuda1);
					}					
				}
				
			}
			
		}
		System.out.printf("\n\t|________|________|________|________|");
		
	}
	
}