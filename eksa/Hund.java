class Hund implements Comparable<Hund> {
String navn;
Kull mittKull;
Tidspunkt minFodselstid;
Hund neste = null;
Hund (Kull k, String n, Tidspunkt fodt) {
navn = n; mittKull = k; minFodselstid = fodt;


}
public Hund mor () {
	return mittKull.mor;

// Oppgave 2a
}
public Hund far () {
	return mittKull.far;

// Oppgave 2a
}
@Override
public int compareTo (Hund h) {
	return this.minFodselstid.compareTo(h.minFodselstid); 
	
// Oppgave 2b
}
public boolean erHelsosken (Hund h) {
	if(this.mor() == h.mor() && this.far() == h.mor() && )
// Oppgave 2c
}
public boolean erHalvsosken (Hund h) {
	this.mor() 
// Oppgave 2c
}
public Hund finnEldsteKjenteOpphav () {
	if(this.mor()==null && this.far() == null){
		return this;
	}
	Hund eldsteFar=this.far();
	HUnd eldsteMor=this.mor();
	if(eldsteFar == null){
		eldsteMor.finnEldsteKjenteOpphav();
	}else if(eldsteMor == null){
		eldsteFar.finnEldsteKjenteOpphav();
	}
// Oppgave 2d
}
}

abstract class Kull implements Iterable<Hund> {
Hund mor, far;

Kull (Hund mor, Hund far) {

this.mor = mor; this.far = far;

}
public void skrivUtAlle () {

for (Hund h: this)
System.out.println(" " + h);

}
public abstract void settInn (Hund h);
public abstract Iterator<Hund> iterator ();
}

class KullListe extends Kull{
	Hund start = null;

	public KullListe(Hund mor, Hund far){
		super(mor,far);
	}

	public void settInn(Hund h){
		//listen er tomm
		if(start == null){
			start = h;
		}else{
			if(h.compareTo(start) > 0){

			}
		}
	}


	public Iterator<Hund> iterator(){
		return new HundeIterator();


	}

	class HundeIterator implements Iterator<Hund> {
		private Hund pointer = start;

		@Override
		public boolean hasNext(){
			return pointer != null;
		}

		@Override
		public Hund next(){
			Hund svar = pointer;
			pointer = pointer.neste;

			return svar;
		}
	}
}

class KullArray extends Kull{

	Hund[] hundene = new Hund[60];

	KullArray(Hund mor,Hund mor){
		super(mor,far);
	}


	void settInn (Hund h){


	}

	@Override
	public Iterator<Hund> iterator(){
		return new HundeIterator();


	}

	class HundeIterator implements Iterator<Hund> {
		private Hund pointer = start;

		@Override
		public boolean hasNext(){
			return pointer != null;
		}

		@Override
		public Hund next(){
			Hund svar = pointer;
			pointer = pointer.neste;

			return svar;
		}
	}



}