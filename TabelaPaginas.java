import java.util.Random;
import java.lang.Math;

public class TabelaPaginas{
	
	int[][] tabela;
	int num;

	public void criaTabela(int bV, int bF, int numProg, int[][] t1, int[][] t2, int[][] t3, int[][] t4, int[][] t5, int RAM){
		
		int x = 9999;
		int k = -1;
		int aux3 = (int) Math.pow(2, bV);
		int aux4 = (int) Math.pow(2, bF);
		int[] s = new int[aux4];
		num = aux3;
		Random rand = new Random();
		int aux = 0, aux2 = 0;
		tabela = new int[aux3][3];
		
		for(int i=0; i<aux4; i++){
			
			s[i] = i;
			
		}

		switch(numProg){

			case (0):
				for(int i=0; i<2; i++){
					for(int j=0; j<aux3; j++){
						if(i == 0){
							tabela[j][i] = aux;
							aux++;
						} else {
							do{
								aux2 = rand.nextInt(aux4);
								if(j >= aux4){
									aux2 = -1;
									break;
								}
							} while(s[aux2] == -1);
							if (aux2 == -1){
								tabela[j][i] = -1;
								tabela[j][2] = 0;
							} else {
								tabela[j][i] = s[aux2];
								s[aux2] = -1;
								tabela[j][2] = rand.nextInt(9999)+1;
							}
						}
					
					}
				}
			break;

			case (1):
				for(int i=0; i<2; i++){				
					for(int j=0; j<aux3 ; j++){
						if (RAM > 4) {
							if (i == 0) {
								tabela[j][i] = aux;
								aux++;
							} else {
								do {
									k = -1;
									aux2 = rand.nextInt(aux4);
									for (int p = 0; p < aux3 ; p++) {
										if (t1[p][1] == aux2)
											k = 0;
									}
								} while (k == 0);
								tabela[j][1] = aux2;
								tabela[j][2] = rand.nextInt(9999)+1;
							}
						}
						else {
							if (j < (aux4/2)) {		
								if(i == 0){
									tabela[j][i] = aux;
									aux++;
								} else {
									do{									
										k++;
										if (k == aux3-1) {
											k = 0;
											x--;
										}
									} while(t1[k][2] != x);
									tabela[j][1] = t1[k][1];
									tabela[j][2] = rand.nextInt(9999)+1;
									t1[k][1] = -1;
									t1[k][2] = 0;
								}
							}
							else {
								if(i == 0){
									tabela[j][i] = aux;
									aux++;
								} else {
									tabela[j][1] = -1;
									tabela[j][2] = 0; 
								}
							}
						}
					}	
				}
			break;

			case (2):
				for(int i=0; i<2; i++){				
					for(int j=0; j<aux3 ; j++){
						if (RAM > 8) {
							if (i == 0) {
								tabela[j][i] = aux;
								aux++;
							} else {
								do {
									k = -1;
									aux2 = rand.nextInt(aux4);
									for (int p = 0; p < aux3 ; p++) {
										if (t1[p][1] == aux2 || t2[p][i] == aux2)
											k = 0;
									}
								} while (k == 0);
								tabela[j][1] = aux2;
								tabela[j][2] = rand.nextInt(9999)+1;
							}
						} else {
							if (j < (aux4/3)) {		
								if(i == 0){
									tabela[j][i] = aux;
									aux++;
								} else {
									do{
										k++;
										if (k == aux3-1) {
											k = 0;
											x--;
										}
									} while(t1[k][2] != x && t2[k][2] != x);
									if (t1[k][2] == x) {
										tabela[j][i] = t1[k][1];
										tabela[j][2] = rand.nextInt(9999)+1;
										t1[k][1] = -1;
										t1[k][2] = 0;
									}
									if (t2[k][2] == x) {
										tabela[j][i] = t2[k][1];
										tabela[j][2] = rand.nextInt(9999)+1;
										t2[k][1] = -1;
										t2[k][2] = 0;
									}
								}
							}
							else {
								if(i == 0){
									tabela[j][i] = aux;
									aux++;
								} else {
									tabela[j][1] = -1;
									tabela[j][2] = 0;
								}
							}
						}
					}	
				}
			break;

			case (3):
				for(int i=0; i<2; i++){				
					for(int j=0; j<aux3 ; j++){
						if (RAM > 8) {
							if (i == 0) {
								tabela[j][i] = aux;
								aux++;
							} else {
								do {
									k = -1;
									aux2 = rand.nextInt(aux4);
									for (int p = 0; p < aux3 ; p++) {
										if (t1[p][1] == aux2 || t2[p][i] == aux2 || t3[p][i] == aux2)
											k = 0;
									}
								} while (k == 0);
								tabela[j][1] = aux2;
								tabela[j][2] = rand.nextInt(9999)+1;
							}
						} else {
							if (j < (aux4/3)) {		
								if(i == 0){
									tabela[j][i] = aux;
									aux++;
								} else {
									do{
										k++;
										if (k == aux3-1) {
											k = 0;
											x--;
										}
									} while(t1[k][2] != x && t2[k][2] != x && t3[k][2] != x);
									if (t1[k][2] == x) {
										tabela[j][i] = t1[k][1];
										tabela[j][2] = rand.nextInt(9999)+1;
										t1[k][1] = -1;
										t1[k][2] = 0;
									}
									if (t2[k][2] == x) {
										tabela[j][i] = t2[k][1];
										tabela[j][2] = rand.nextInt(9999)+1;
										t2[k][1] = -1;
										t2[k][2] = 0;
									}
									if (t3[k][2] == x) {
										tabela[j][i] = t3[k][1];
										tabela[j][2] = rand.nextInt(9999)+1;
										t3[k][1] = -1;
										t3[k][2] = 0;
									}
								}
							}
							else {
								if(i == 0){
									tabela[j][i] = aux;
									aux++;
								} else {
									tabela[j][1] = -1;
									tabela[j][2] = 0;
								}
							}
						}
					}	
				}

			break;

			case (4):
				for(int i=0; i<2; i++){				
					for(int j=0; j<aux3 ; j++){
						if (j < (aux4/3)) {		
							if(i == 0){
								tabela[j][i] = aux;
								aux++;
							} else {
								do{
									k++;
									if (k == aux3-1) {
										k = 0;
										x--;
									}
								} while(t1[k][2] != x && t2[k][2] != x && t3[k][2] != x && t4[k][2] != x);
								if (t1[k][2] == x) {
									tabela[j][i] = t1[k][1];
									tabela[j][2] = rand.nextInt(9999)+1;
									t1[k][1] = -1;
									t1[k][2] = 0;
								}
								if (t2[k][2] == x) {
									tabela[j][i] = t2[k][1];
									tabela[j][2] = rand.nextInt(9999)+1;
									t2[k][1] = -1;
									t2[k][2] = 0;
								}
								if (t3[k][2] == x) {
									tabela[j][i] = t3[k][1];
									tabela[j][2] = rand.nextInt(9999)+1;
									t3[k][1] = -1;
									t3[k][2] = 0;
								}
								if (t4[k][2] == x) {
									tabela[j][i] = t4[k][1];
									tabela[j][2] = rand.nextInt(9999)+1;
									t4[k][1] = -1;
									t4[k][2] = 0;
								}
							}
						}
						else {
							if(i == 0){
								tabela[j][i] = aux;
								aux++;
							} else {
								tabela[j][1] = -1;
								tabela[j][2] = 0;
							}
						}
					}	
				}

			break;
		}
	}
	
	public void mostraTabela(){
		
		String ajuda1 = "", ajuda2 = "";
		System.out.printf("\n\n\t           RAM");
		System.out.printf("\n\t __________________________");
		System.out.printf("\n\t|Virtual | Fisico |  Prio  |");
		for(int i=0; i<5; i++){
			
			System.out.println("\t");
			
			for(int j=0; j<3; j++){
				
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
						ajuda2 = (Integer.toHexString(tabela[num-1][j])).toUpperCase();
						if(j == 0){
							do{
								ajuda1 = "0" + ajuda1;
							}while(ajuda1.length() < ajuda2.length());
						}
						System.out.printf("%7s |", ajuda1);
					}
				}
				
			}
			
		}
		
		System.out.printf("\n\t|   ...  |   ...  |   ...  |");
		
		for(int i=num-5; i<num; i++){
			
			System.out.println();
			
			for(int j=0; j<3; j++){
				
				if(tabela[i][j] == -1){
					System.out.printf("  DISCO |");
				} else {
					if(j == 0){
						System.out.printf("\t|");
					}
					if(j == 2){
						System.out.printf("   %04d |", tabela[i][j]);
					} else {
						System.out.printf("%7s |", (Integer.toHexString(tabela[i][j])).toUpperCase());
					}					
				}
				
			}
			
		}
		System.out.printf("\n\t|________|________|________|");
		
	}
	
	public void mostraTabelaCompleta(){
		
		String ajuda1 = "", ajuda2 = "";
		System.out.printf("\n\n\t           RAM");
		System.out.printf("\n\t __________________________");
		System.out.printf("\n\t|Virtual | Fisico |  Prio  |");
		for(int i=0; i<tabela.length; i++){
			
			System.out.println("\t");
			
			for(int j=0; j<3; j++){
				
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
						ajuda2 = (Integer.toHexString(tabela[num-1][j])).toUpperCase();
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
		System.out.printf("\n\t|________|________|________|\n\n\n");
	}
	
	public void mostraLocalizado(int x){
		System.out.println("");
		for(int i=x-3; i<x+3; i++){
			try{
				System.out.println("\t" + (String.format("%04x", tabela[i][0])).toUpperCase() + " " + (String.format("%04x", tabela[i][1])).toUpperCase());
			} catch( ArrayIndexOutOfBoundsException exc ){
			}
		}
	}
	
	public void compartilhaMemoria(int[][] t1) {
		Random rand = new Random();
		int tam = num / 10;
		int aux1, aux2;
		int j = 0;
		System.out.println("\n\n");
		for (int i=0 ; i < tam ; i++) {
			do {
				aux1 = rand.nextInt(num);
			} while (tabela[aux1][1] == -1);
			aux2 = rand.nextInt(num);
			t1[aux2][1] = tabela[aux1][1];
			t1[aux2][2] = tabela[aux1][2];
			if (j < 10){
				System.out.println("\t" + (Integer.toHexString(tabela[aux1][0])).toUpperCase() + " " + (Integer.toHexString(t1[aux2][1])).toUpperCase() + " " + (Integer.toHexString(t1[aux2][0])).toUpperCase() + " " + (Integer.toHexString(tabela[aux1][1])).toUpperCase());
				j++;
			}
		}
	}
	
}