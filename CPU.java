import java.util.Random;

public class CPU{
	
	static int random;
	static String endereco = "", bin = "01";
	static Random rand = new Random();
	
	//esse metodo gera um endereço virtual aleatorio
	public static String generateEV(){
		
		endereco = "";
		for(int i=0; i<32; i++){		
			random = rand.nextInt(2);
			endereco = endereco + bin.charAt(random);				
		}
		
		return endereco;
		
	}
	
	//esse metodo retorna o offset do endereço virtual
	public static String getOffset(String a, int b){
		
		return new String(a.substring(a.length()-b, a.length()));
		
		
	}
	
	//esse metodo retorna a parte do endereco sem offset
	public static String getAddress(String a, int b){
		
		return new String(a.substring(0, a.length()-b));
		
	}
	
}