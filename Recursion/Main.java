public class Main{

	public static void main(String[] args){

		Frukt frukt = new Baer("Blåbaer",true,1);

		System.out.println(frukt.navn);
		System.out.println(frukt.spiselig);
		
		System.out.println(frukt.surhetsgrad);
		Baer baer;

		if( frukt instanceof Baer){

			baer= (Baer) frukt;

			System.out.println(baer.navn);
		System.out.println(baer.spiselig);
		System.out.println(baer.surhetsgrad);


		}

		// System.out.println(baer.navn);
		// System.out.println(baer.spiselig);
		// System.out.println(baer.surhetsgrad);
		


	}
}
