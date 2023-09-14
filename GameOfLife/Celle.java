//package oblig1;



class Celle {
    public boolean levende;
    public Celle[] naboer;
    public int antLevendeNaboer;
    public int antNaboer;


    public Celle(){
       levende=false;
       naboer= new Celle[8];
       antLevendeNaboer=0;
       antNaboer=0;

    }
    public void settDoed(){
        levende= false;
    }
    public void settLevende(){
        levende= true;
    }

    public boolean erLevende(){
        return levende;
    }

    public char hentStatusTegn(){
        if(levende){
            return 'O';
        }
        else{
            return '.';
        }
    }

    public void leggTilNabo(Celle nabo){
        
       naboer[antNaboer++]=nabo;

        }
    public void tellLevendeNaboer(){
         antLevendeNaboer=0;
        for(int i=0; i<antNaboer; i++){
            if(naboer[i].erLevende()){
                antLevendeNaboer++;
                
            }
            
            
        }}
    

    public void oppdaterStatus(){
        
        if(levende==false){
            if(antLevendeNaboer==3){
               settLevende();
            }
         }
        else{ 
            if ( antLevendeNaboer < 2 || antLevendeNaboer >3){
                settDoed();
        }
            
        }

    }
   


}


    

