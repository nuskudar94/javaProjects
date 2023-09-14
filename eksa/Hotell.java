class Hotell implements Iterable<Rom>{
	int antEtasjer;
	Rom [] forsteRomEtasje;

	public Hotell(int antEtasjer){
		this.antEtasjer = antEtasjer;
		forsteRomEtasje = new Rom[antEtasjer + 1];

	}

	class HotellIterator<Rom> implements Iterator<Rom>{
		Rom denne;
		int etasje;

		boolean hasNext(){
			return denne != null;
		}

		Rom next(){

			

		}

	}

	public Iterator iterator(){
		return HotellIterator();
	}
}