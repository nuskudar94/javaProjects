
class Main{
	public static void main(String[] args) {
		Monitor monitor = new Monitor();

		CountDownLatch teller = CountDownLatch(ANTALL_STEINHUGGER);

		final int ANTALL_STEINhUGGER = 2;

		Thread [] steinhuggere = new Thread[ANTALL_STEINHUGGER];

		for(int i = 0 ; i <= ANTALL_STEINHUGGER ; i++){
			steinhuggere[i] = new Thread(new Steinhugger(monitor));
			steinhuggere[i].start();	
		}

		Thread trad1 = new Thread(new Steinhugger(monitor));

		//trad1.start();
	for(int i = 0 ; i <= ANTALL_STEINHUGGER ; i++){
		try{
			steinhuggere[i].join();
		}catch(InterruptedException e){
			System.out.println(e);
		}	
	}

	try{
		teller.await();
	}

		

		System.out.println(monitor);
	}



}

class Steinhugger implements Runnable{
	Monitor monitor ;

	public Steinhugger(Monitor monitor){
		this.monitor = monitor;
	}
	@Override
	void run(){
		monitor.settInnStein(stein);
	}
}

class Monitor{
	//Beholder
	ArrayList<Stein> steiner = new ArrayList<>();


	//Lock
	Lock steinerLock = new ReentrantLock();
	//Condition
	
	//Metoder
	void settInnStein(Stein stein){
		steinerLock.lock();
		try{
			steiner.add(stein);
		}
		finally{
			steinerLock.unlock();
		}
		
	}

	@Override
	public String toString(){
		String string = "Monitor: \n";
		return Steiner.toString();
	}


}

class Stein{

	@Override
	public String toString(){
		return "stein";
	}
}
