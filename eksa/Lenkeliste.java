class Lenkeliste implements Iterable <Integer>{
	class Node{
		int element;
		Node neste;
		Node forrige;

		public Node(int e){
			element = e;
		}
	}


	Node forste;
	Node siste;
	public void settInn(int e){
		//setter i tom liste
		if(forste == null){
			forste = new Node(e);
			siste = forste;
		}else{
			//setter i slutten
			Node nyNode = new Node(e);
			siste.neste = nyNode;
			nyNode.forrige = siste;
			siste = nyNode;

		}
	}

	
}