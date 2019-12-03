import java.lang.Math;

public class RAM{
	
	//retorna o numero de bits usado na memoria RAM
	public static int getBitsMB(String r){
		
		int cont = 20, num;
		
		num = Integer.parseInt(r);
		
		do{
			
			num = num / 2;
			cont++;
			
		}while(num != 1);
		
		return cont;
		
	}
	
	public static int getBitsGB(String r){
		
		int cont = 30, num;
		
		num = Integer.parseInt(r);
		
		do{
			
			num = num / 2;
			cont++;
			
		}while(num != 1);
		
		return cont;
		
	}
	
	public static int[][] trataLRU(int[][] t, int a, int b){
		
		int maior = 0, lru = 0;
		
		for(int i=0; i<Math.pow(2, b); i++){
			
			if(t[i][2] > maior){
				
				maior = t[i][2];
				lru = i;
				
			}
			
		}
		
		t[a][1] = t[lru][1];
		t[a][2] = 1;
		t[lru][1] = -1;
		t[lru][2] = 0;
		
		return t;
		
	}
	
}