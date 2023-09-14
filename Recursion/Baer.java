public class Baer extends Frukt{

	protected int surhetsgrad;

	public Baer(String navn,boolean spiselig,int surhetsgrad){
		super(navn,spiselig); //after constructor you have to write super from super constructor
		this.surhetsgrad= surhetsgrad;
	}
}