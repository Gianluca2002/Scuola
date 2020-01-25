
public class Dado {
	public int nfacce;
	public int risultato;
	
	public Dado(int nf) {
		 nfacce=nf;
		 risultato=0;
	}
	public void LanciaDado() {
		risultato=(int) (Math.random()*nfacce+1);
	}
}