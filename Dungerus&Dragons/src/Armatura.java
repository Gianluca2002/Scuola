
public class Armatura {
	public String nome;
	public static int CA;
	
	
	public Armatura(String n) {
		CA=(int) (Math.random()*8+1);
		System.out.println("Armatura di classe: "+CA);
		nome=n;
	}
}
