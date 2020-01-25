import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Personaggio {
	public int Livello;
	public String nome;
	public String classe;
	public String razza;
	public int HP;
	public int Difesa;
	public int TxC;
	public Arma arma;
	public Armatura armatura;
	//statistiche
	public int Forza;
	public int Destrezza;
	public int Costituzione;
	public int Intelligenza;
	public int Saggezza;
	public int Carisma;
	//modificatori
	public int modFOR;
	public int modDES;
	public int modCOS;
	public int modINT;
	public int modSAG;
	public int modCAR;
	
	
	public Personaggio(String n) throws IOException{
		Livello=(int) (Math.random()*20+1);
		nome=n;
		classe="Guerrriero";
		razza="Umano";
		HP=(CalcoloHP()+modCOS)*Livello;
		Difesa=10+modDES+Armatura.CA;
		Forza=CalcolaStatistica();
		Destrezza=CalcolaStatistica();
		Costituzione=CalcolaStatistica();
		Intelligenza=CalcolaStatistica();
		Saggezza=CalcolaStatistica();
		Carisma=CalcolaStatistica();
		modFOR=(Forza-10)/2;
		modDES=(Destrezza-10)/2;
		modCOS=(Costituzione-10)/2;
		modINT=(Intelligenza-10)/2;
		modSAG=(Saggezza-10)/2;
		modCAR=(Carisma-10)/2;
		armatura=new Armatura(n);
		arma = new Arma();
	}
	public int CalcoloHP() {
		Dado d4=new Dado(10);
		d4.LanciaDado();
		int risultato=0;
		return risultato=d4.risultato;
	}
	public int CalcolaStatistica() {
		Dado d1 = new Dado(8);
		d1.LanciaDado();
		Dado d2 = new Dado(8);
		d2.LanciaDado();
		Dado d3 = new Dado(8);
		d3.LanciaDado();
		int risultato=0;
		return risultato=d1.risultato+d2.risultato+d3.risultato;
	}
	public void Txc() {
		Dado d7 = new Dado(20);
		d7.LanciaDado();
		TxC=d7.risultato+Livello+modFOR+arma.Magia;
	}
	public void attacca(Personaggio p) throws InterruptedException {
		this.Txc();
		System.out.println();
		System.out.println("TxC: "+this.TxC);
		System.out.println();
		System.out.println(this.nome + " attacca " + p.nome);
			if(this.TxC>=p.Difesa) {
				System.out.println(this.nome+" è pronto a sfoderare "+this.arma.nome+ ". . . . .");
				java.util.concurrent.TimeUnit.SECONDS.sleep(1);
				if(DaMischia.Tipo==1) {
					p.HP -=this.arma.DannoBase()+modFOR;
					System.out.println("E' efficace e rimane con " + p.HP + " HP");
				} else {
					p.HP -=this.arma.DannoBase()+modFOR*1.5;
					System.out.println("E' efficace e rimane con " + p.HP + " HP");
					System.out.println();
				}
			}else {
				System.out.println("\t\t\tMISS!!");
			}
		}
	public static void Combattimento(Personaggio p1, Personaggio p2) throws InterruptedException, IOException {
		int turni=0;
		do {
		turni++;
		System.out.println("Turno "+turni);
		p1.attacca(p2);
		java.util.concurrent.TimeUnit.SECONDS.sleep(3);
		if(p2.HP<=0) {
			break;
		}
		turni++;
		int r=0;
		System.out.println("Che fortuna, hai trovato una nuova arma in un forziere");
		 int sceltarma=(int) (Math.random()*3+1);
		r=(int) (Math.random()*3+1);
		if(r==2) {
			switch(sceltarma) {
			case 1:
				p1.arma=new Spada();
				break;
			case 2:
				p1.arma=new Lancia();
				break;
			case 3:
				p1.arma=new Ascia();
				break;
			}
			
		}
		System.out.println("Turno "+turni);
		p2.attacca(p1);	
		java.util.concurrent.TimeUnit.SECONDS.sleep(3);
		}while(p1.HP>0);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		InputStreamReader input =new InputStreamReader(System.in);
		BufferedReader tastiera =new BufferedReader(input);
		System.out.println("\t\t\tBenvenuto in Dungerous & Dragons!");
		String nome;
		System.out.println("Inserisci il nome del primo personaggio: ");
		nome=tastiera.readLine();
		Personaggio p1=new Personaggio(nome);
		System.out.println("\t\t\tStatistiche personaggio:");
		System.out.println("Livello: "+p1.Livello);
		System.out.println("Classe: "+p1.classe);
		System.out.println("Razza: "+p1.razza);
		System.out.println("Forza: "+p1.Forza);
		System.out.println("Destrezza: "+p1.Destrezza);
		System.out.println("Costituzione: "+p1.Costituzione);
		System.out.println("Intelligenza: "+p1.Intelligenza);
		System.out.println("Saggezza: "+p1.Saggezza);
		System.out.println("Carisma: "+p1.Carisma);
		System.out.println("HP: "+p1.HP+" Difesa: "+p1.Difesa);
		
		//SECONDO PERSONAGGIO
		String nome1;
		System.out.println("\nInserisci il nome del secondo personaggio: ");
		nome1=tastiera.readLine();
		Personaggio p2=new Personaggio(nome1);
		System.out.println("\t\t\tStatistiche personaggio:");
		System.out.println("Livello: "+p2.Livello);
		System.out.println("Classe: "+p2.classe);
		System.out.println("Razza: "+p2.razza);
		System.out.println("Forza: "+p2.Forza);
		System.out.println("Destrezza: "+p2.Destrezza);
		System.out.println("Costituzione: "+p2.Costituzione);
		System.out.println("Intelligenza: "+p2.Intelligenza);
		System.out.println("Saggezza: "+p2.Saggezza);
		System.out.println("Carisma: "+p2.Carisma);
		System.out.println("HP: "+p2.HP+" Difesa: "+p2.Difesa);
		System.out.println("\n\t\t\tINIZIO COMBATTIMENTO\n");
		Combattimento(p1,p2);
		if(p1.HP<=0) {
			System.out.println(p2.nome+" ha vinto il combattimento!");
		}else if(p2.HP<=0) {
			System.out.println(p1.nome+" ha vinto il combattimento!");
		}
	}
}
