import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Teste{
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		int memBits = 0, aux, aux2, numPaginasMem, HDbits, tamRam = 0, cho, numPaginasHD, emptyPages, processoPag, esc, choose = 0, addressDec = 0, offsetDec, cont = 0, pagina = 0, bits, bitOffset = 0, tamEndV, tamEndF;
		TabelaPaginas[] t = new TabelaPaginas[5];
		int[][] tlb = new int[0][0];
		for(int i=0; i<5; i++)
			t[i] = new TabelaPaginas();
		String EF, EV = "", memoria, HD, offset = "", address, enderecoFisico = "", ajuda = "";
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		bits = 32;
		
		system.clear();
		System.out.println("\n\n\tEscolha o tamanho da pagina: ");
		System.out.println("\n\n\t1. 4K");
		System.out.println("\t2. 8K");
		System.out.println("\t3. 16K");
		System.out.println("\t4. 32K");
		System.out.println("\t5. 64K");
		System.out.printf("\n\tEscolha: ");
		esc = scan.nextInt();
		switch(esc){
			case 1:
				bitOffset = 12;
			break;
			case 2:
				bitOffset = 13;
			break;
			case 3:
				bitOffset = 14;
			break;
			case 4:
				bitOffset = 15;
			break;
			case 5:
				bitOffset = 16;
			break;
		}
		
		system.clear();
		System.out.println("\n\n\tEscolha o tamanho da sua memoria RAM: ");
		System.out.println("\n\n\t1. 1GB");
		System.out.println("\t2. 2GB");
		System.out.println("\t3. 4GB");
		System.out.println("\t4. 8GB");
		System.out.println("\t5. 16GB");
		System.out.printf("\n\tEscolha: ");
		esc = scan.nextInt();
		switch(esc){
			case 1:
				memBits = 30;
				tamRam = 1;
			break;
			case 2:
				memBits = 31;
				tamRam = 2;
			break;
			case 3:
				memBits = 32;
				tamRam = 4;
			break;
			case 4:
				memBits = 33;
				tamRam = 8;
			break;
			case 5:
				memBits = 34;
				tamRam = 16;
			break;
		}
		
		tamEndV = bits - bitOffset;
		tamEndF = memBits - bitOffset;
		
		do{
			system.clear();
			System.out.println("\n\n\tO que deseja fazer?");
			System.out.println("\n\n\t1. Iniciar um programa");
			System.out.println("\t2. Fechar um programa");
			System.out.println("\t3. Escrever na memoria");
			System.out.println("\t4. Iniciar e mostrar TLB");
			System.out.println("\t5. Compartilhar memoria");
			System.out.println("\t6. Sair");
			System.out.printf("\n\tEscolha: ");
			esc = scan.nextInt();
			switch(esc){
				case 1:
					system.clear();
					if(cont > 0 && cont <= 4){
						System.out.println("\n\n\tProcessando...");
					}
					if(cont > 4){
						System.out.println("\n\n\tNumero maximo de programas simultaneos alcancado");
					} else {
						t[cont].criaTabela(tamEndV, tamEndF, cont, t[0].tabela, t[1].tabela, t[2].tabela, t[3].tabela, t[4].tabela, tamRam);
						system.clear();
						System.out.println("\n\n\tPrograma iniciado com sucesso!");
						System.out.println("\n\tComo voce deseja ver a tabela de paginas? ");
						System.out.printf("\n\t1. Completa");
						System.out.println("\n\t2. Resumida");
						System.out.printf("\tEscolha: ");
						aux = scan.nextInt();
						if(aux == 2){
							System.out.println("\n\tTabela de paginas: ");
							t[cont].mostraTabela();
						} else {
							System.out.println("\n\tTabela de paginas: ");
							t[cont].mostraTabelaCompleta();
						}
						
						cont++;
					}
					tlb = TLB.preencherTLB(t[0].tabela, t[1].tabela, t[2].tabela, t[3].tabela, t[4].tabela, tamEndV,cont);
					System.in.read();
				break;
				case 2:
					system.clear();
					if(cont == 0){
						System.out.println("\n\n\tNao ha programas abertos!");
						System.in.read();
					}else{
						System.out.printf("\n\n\tDigite o numero do programa que voce deseja fechar (0 / %d): ", cont-1);
						choose = scan.nextInt();
						cho = choose;
						for(int i=0; i<(cont - (choose+1)); i++){
							t[cho].tabela = t[cho+1].tabela;
							cho++;
						}
						cont--;
						t[cont].tabela = null;
						System.out.println("\n\n\tPrograma " + choose + " foi fechado com sucesso!");
						System.in.read();						
					}
				break;
				case 3:
					do{
						system.clear();
						System.out.printf("\n\n\tDigite o numero do programa que voce deseja alterar: ");
						choose = scan.nextInt();
						if(choose>4){
							System.out.println("\n\tO numero maximo de programas e 5!");
							System.in.read();
						}
					}while(choose>4);
					system.clear();
					System.out.println("\n\n\tVoce deseja digitar o endereco ou gerar aleatoriamente?");
					System.out.println("\n\t1. Digitar\n\t2. Gerar aleatoriamente");
					System.out.printf("\tEscolha: ");
					aux = scan.nextInt();
					if(aux == 1){
						system.clear();
						scan.nextLine();
						System.out.printf("\n\n\tDigite o endereco em hexadecimal: ");
						EV = scan.nextLine();
						EV = Long.toBinaryString(Long.parseLong(EV, 16));
						while(EV.length() < 32){
							EV = "0" + EV;
						}
					}else{
						EV = CPU.generateEV();
					}
					offset = CPU.getOffset(EV, bitOffset);
					address = CPU.getAddress(EV, bitOffset);
					system.clear();
					if(cont == 0){
						System.out.println("\n\n\tNao ha programas sendo executados");
					} else {
						addressDec = Integer.parseInt(address,2);
						offsetDec = Integer.parseInt(offset,2);
						System.out.printf("\n\n\tEndereco virtual: " + Long.toHexString(Long.parseLong(EV,2)).toUpperCase());
						System.out.println("\n\tOffset em hexadecimal: " + (Integer.toHexString(Integer.parseInt(offset,2))).toUpperCase());
						System.out.println("\tEndereco em hexadecimal: " + (Integer.toHexString(Integer.parseInt(address,2))).toUpperCase());
						try{
							int check = -1;
							for(int i = 0; i<tlb.length; i++){
								if(addressDec == tlb[i][0] && tlb[i][3] == (choose+1)){
									System.out.printf("\n\tO endereco foi encontrado na TLB! (HIT)");
									TLB.mostraLocalizado(tlb, i);
									check = i;
								}
							}
							if(check == -1){
								System.out.printf("\n\tO endereco nao foi encontrado na TLB! (MISS)");
								enderecoFisico = Integer.toBinaryString(t[choose].tabela[addressDec][1]);
							}else{
								enderecoFisico = Integer.toBinaryString(tlb[check][1]);
							}
							if(t[choose].tabela[addressDec][1] == -1){
								System.out.printf("\n\tO endereco nao foi encontrado na RAM (MISS)");
								t[choose].tabela = RAM.trataLRU(t[choose].tabela, addressDec, tamEndV);
								System.out.println("\n\tApos tratamento de excecao");
								offset = CPU.getOffset(EV, bitOffset);
								address = CPU.getAddress(EV, bitOffset);
								enderecoFisico = Integer.toBinaryString(t[choose].tabela[addressDec][1]);
							}else{
								System.out.println("\n\tO endereco foi encontrado na RAM (HIT)");
								t[choose].mostraLocalizado(addressDec);
							}
							if(check == -1){
								int maior = 0, j = -1;
								for(int i = 0; i<tlb.length; i++){
									if(tlb[i][2] > maior){
										maior = tlb[i][2];
										j = i;
									}
								}
								tlb[j][0] = t[choose].tabela[addressDec][0];
								tlb[j][1] = t[choose].tabela[addressDec][1];
								tlb[j][2] = 1;
								tlb[j][3] = choose+1;
							}
							System.out.println("\n\tEndereco fisico em hexadecimal: " + Integer.toHexString(Integer.parseInt(enderecoFisico,2)).toUpperCase());
							System.out.println("\tEndereco traduzido: " + Integer.toHexString(Integer.parseInt(enderecoFisico,2)).toUpperCase() + Integer.toHexString(Integer.parseInt(offset,2)).toUpperCase());
						} catch( NullPointerException exc ){
							System.out.println("\n\n\tO programa escolhido nao esta sendo executado");
						} catch( NumberFormatException exc ){
							System.out.println("\n\n\tNumberFormatException");
						} catch( ArrayIndexOutOfBoundsException exc){
							System.out.println("\n\n\tArrayIndexOutOfBoundsException");
						}
						
					}
					System.in.read();
				break;
				case 4:
					try{
						if(cont == 0){
							system.clear();
							System.out.println("\n\n\tNao ha programas abertos para iniciar a TLB");
							System.in.read();
						}else{
							tlb = TLB.preencherTLB(t[0].tabela, t[1].tabela, t[2].tabela, t[3].tabela, t[4].tabela, tamEndV,cont);
							system.clear();
							TLB.mostraTabela(tlb, tamEndV);
							System.in.read();							
						}
					} catch( NullPointerException exc){
						System.out.println("Não ha programas abertos");
					}
				break;
				case 5:
					system.clear();
					if(cont < 2){
						System.out.println("\n\n\tNao ha programas suficientes para compartilhamento de memoria");
					} else {
						System.out.println("\n\n\tEscolha os programas que voce deseja compartilhar");
						System.out.printf("\tDigite o numero do primeiro programa: ");
						aux = scan.nextInt();
						System.out.printf("\n\tDigite o numero do segundo programa: ");
						aux2 = scan.nextInt();
						system.clear();
						t[aux].compartilhaMemoria(t[aux2].tabela);
					}
					System.in.read();
				break;
			}
		}while(esc != 6);
	}
}