package Threads;
public abstract class Bil{
	protected final String bilNummer;
	protected final int prisPerDag;

	public Bil neste;
	public Bil forrige;

	public Bil(String bilNummer,int prisPerDag){
		this.bilNummer = bilNummer;
		this.prisPerDag = prisPerDag;
	}

	public String hentBilNum(){
		return bilNummer;
	}

	public String toString(){
		return "Bilnummer: " + bilNummer + " Pris Per Dag: " + prisPerDag;
	}


	public Bil finnBilR(Dialog dialog, boolean kunElektrisk){
		
	}
}

public class Personbiler extends Bil{
	int final antPassasjer;

	public Personbiler(String bilNummer,int prisPerDag,int antPassasjer){
		super(bilNummer,prisPerDag);
		this.antPassasjer = antPassasjer;
	}

	public String toString(){
		return super.toString() + " Antall passasjerer: " + antPassasjer;
	}

}

public class Varebiler extends Bil{
	int final lasteVolum;

	public Varebiler(String bilNummer,int prisPerDag, int lasteVolum){
		super(bilNummer,prisPerDag);
		this.lasteVolum = lasteVolum;
	}

	public String toString(){
		return super.toString() + " Lastevolum: " + lasteVolum;
	}


}

interface ELektrisk{
	public int hentBatteri();
}

public class ElektriskPersonbil extends Personbiler implements Elektrisk{
	int final batteri;

	public ElektriskPersonbil(String bilNummer,int prisPerDag,int antPassasjer,int batteri){
		super(bilNummer,prisPerDag,antPassasjer);
		this.batteri = batteri;
	}

	public int hentBatteri(){
		return batteri;
	}

	public String toString(){
		return super.toString() + " Batteriet: " + batteri;
	}
}


public class ElektriskVarebil extends Varebiler implements Elektrisk{
	int final batteri;

	public ElektriskVarebil(String bilNummer,int prisPerDag,int antPassasjer,int batteri){
		super(bilNummer,prisPerDag,antPassasjer);
		this.batteri = batteri;
	}

	public int hentBatteri(){
		return batteri;
	}

	public String toString(){
		return super.toString() + " Batteriet: " + batteri;
	}

}

interface Dialog{
	public boolean svarJaEllerNei(String sporsmal);
}

import java.util.Scanner;
public class TastaturDialog implements Dialog{
	
	Scanner scan = new Scanner(System.in);


	public boolean svarJaEllerNei(String sporsmal){
		System.out.println(sporsmal);
		boolean bool = true;
		String input = scan.nextLine();

		if(input.equals("j")){
			bool = bool;
		}else{
			bool = false;
		}

		return bool;
	}
}

public class GUIDialog implements Dialog{

}

public class Bilkollektiv{
	public final int AB;

	private Bil forste;
	private Bil siste;
	Bil[] alleBilene;
	public Bilkollektiv(int AB){
		this.AB = AB;

		Bil alleBilene[] = new Bil[AB];


	}

	public void lagBilPris(){
		//ArrayList<Bil> LinkedListen = new ArrayList<>();

		int minPris = -1;


		for(int i = 0 ; i < AB ; i++){
			Bil billigst = null;

			for(int j = 0 ; j < AB ; j++){
				Bil b = alleBilene[j];

				if(b.prisPerDag>minPris && (billigst == null || b.prisPerDag < billigst.prisPerDag)){
					billigst = b;
				}

				if (forste == null){
					forste = billigst;
					siste = billigst;
				}else{
					billigst.neste = start;
					start.forrige = billigst;
					start = billigst;
				}
				minPris = billigst.prisPerDag;
			}
		}



}
	
	public void taUtBil(Bil b){
		Bil peker = start;
		
		while(peker.neste != null){
			if(peker == b){
				peker.forrige.neste = peker.neste;
				peker.neste.forrige = peker.forrige;
			}
			peker = peker.neste;
		}
	}

	public Bil velgBil(Dialog d){
		Scanner sc = new Scanner(System.in);
		System.out.println("Vil du ha elbil ? ");

		String input = sc.nextLine();
				Bil peker = start;
		while(peker =! null){
			if(input.equals("ja") && (peker instanceof ElektriskPersonbil || peker instanceof ElektriskVarebil)){
				System.out.println(peker.toString());
				System.out.println("Vil du ha denne bilen ?");
				String svaret = sc.nextLine();
				if(svaret.equals("ja")){
					taUtBil(peker);
				}else{
					peker= peker.neste;
				}


			}else if(input.equals("nei") && !(peker instanceof ElektriskPersonbil || peker instanceof ElektriskVarebil)){
				System.out.println(peker.toString());
				System.out.println("Vil du ha denne bilen ?");
				String svaret = sc.nextLine();
				if(svaret.equals("ja")){
					taUtBil(peker);
				}else{
					peker= peker.neste;
				}

		}
	}
}
