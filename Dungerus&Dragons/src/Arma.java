import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arma {
	public String nome;
	public int Danno_Base;
	public static int Magia;
	public String Elemento;
	
	public Arma() {
		Danno_Base=DannoBase();
		Magia=0;
		Elemento="Nessun Elemento";
		nome="Arma iniziale";
		System.out.println("Danni Base "+nome+": "+Danno_Base);
		System.out.println("Magia: "+Magia);
	}
	
	
	public Arma(int num) {
		
		switch(num) {
		case 1:
			nome="Spada";
			Danno_Base=Spada.DannoSpada;
			break;
		case 2:
			nome="Lancia";
			Danno_Base=Lancia.DannoLancia;
			break;
		case 3:
			nome="Ascia";
			Danno_Base=Ascia.DannoAscia;
			break;
		}
		
		Magia=(int) (Math.random()*6+1);
		int r=0;
		r=(int) (Math.random()*6+1);
		switch (r) {
		case 1 :
			Elemento="Fuoco";
			break;
		case 2:
			Elemento="Acqua";
			break;
		case 3:
			Elemento="Elettro";
			break;
		case 4:
			Elemento="Terra";
			break;
		case 5:
			Elemento="Aria";
			break;
		case 6:
			Elemento="Nessun_Elemento";
			break;
		}
	}
	
	public int DannoBase() {
		Dado d5=new Dado(8);
		d5.LanciaDado();
		int risultato = 0;
		return risultato=d5.risultato;
	}
	public int DannoElementare() {
		Dado d6=new Dado(6);
		d6.LanciaDado();
		int risultato=0;
		return risultato=d6.risultato;
	}
	public int DannoSpada() {
		int Dannototale = 0;
		if(Elemento=="Nessun_Elemento") {
			Dannototale=DannoBase()+Magia;
		}else {
			Dannototale=DannoBase()+Magia+DannoElementare();
		}
		return Dannototale;
		
	}
}
