public class IndeksertListe <E> extends Lenkeliste<E> {
    
    
    public void leggTil (int pos, E x)  {
        Node nyNode = new Node(x);
        //int counter=0;
        
        if(pos < 0 || pos > stoerrelse()){
            throw new UgyldigListeindeks(pos);
    
    }
        if(pos == stoerrelse()){
            leggTil(x);
        }else{
            if (pos==0){
                if(start==null){
                    start =nyNode;

                }else{
                    nyNode.neste=start;
                    start = nyNode;
                }
            }else{
                Node pointer = findNode(pos -1);
                nyNode.neste=pointer.neste;
                pointer.neste=nyNode;
            }
            stoerrelse++;
        }
     }
    
    public Node findNode(int pos){
        Node temp = start;
        for(int counter=0; counter<pos; counter++){
            temp=temp.neste;

        }
        return temp;
     }

     public void sett (int pos, E x) {
        Node newNode = new Node(x);
        if(pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeindeks(pos);
    
    }
        if(pos==0 ){
           
            newNode.neste=start;
            start=newNode;
        }
        

        Node settNode= findNode(pos);
        settNode.verdi = newNode.verdi;
    }   
      
    
      public E hent (int pos) { 
        if(pos < 0 || pos > stoerrelse()){
            throw new UgyldigListeindeks(pos);
    
    }  
        Node newNode = findNode(pos);


            return newNode.verdi;

      }
    
    public E fjern (int pos) { 
        //Node newNode = hent(pos); 
         
        if(pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeindeks(pos);
    
    }
    
        if (pos==0){
            return fjern();
        }
        else{
            Node pointer = findNode(pos -1);
            Node nodeToDelete = pointer.neste ;
            pointer.neste = nodeToDelete.neste;
            stoerrelse--;
            return nodeToDelete.verdi;
        }
        
 }
    

       
       @Override
     public String toString(){
        Node pointer = start;
        String elements ="";
        while( pointer != null){
            elements += pointer.verdi + ", " ;
            pointer = pointer.neste;
        }
        
        return "List: " + elements;

     }


}
