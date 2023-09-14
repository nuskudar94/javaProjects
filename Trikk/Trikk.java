abstract class Trikk implements Runnable {
    private  Trikkelinje trikkelinje;
    private Holdeplass gjeldenHoldeplass;
    protected int id;
    protected int hastighet;
    

    public Trikk(int id,Trikkelinje trikkelinje){
        this.id=id;
        this.trikkelinje=trikkelinje;
        gjeldenHoldeplass=trikkelinje.hentForste();
    }


    @Override
    public void run(){
        while(gjeldenHoldeplass != null){
            System.out.println("ankommer  " + gjeldenHoldeplass);
            gjeldenHoldeplass = gjeldenHoldeplass.neste;
            try{
            Thread.sleep(hastighet);//venter litt
            } catch(InterruptedException e){
                e.printStackTrace();

            }
        }

        System.out.println("Ferdig");
    }


}
