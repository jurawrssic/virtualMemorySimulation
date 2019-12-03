import java.io.IOException;

public class system{
	
	public static void clear() throws IOException, InterruptedException{
		
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		
	}
	
}