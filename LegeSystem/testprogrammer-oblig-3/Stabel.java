class Stabel<E> extends Lenkeliste<E> {
    
   


     
    

  

    @Override
    public void leggTil(E x) throws UgyldigListeindeks  {
        Node nyNode = new Node(x);
        if (start == null){
            
            start = nyNode;
            
            
        }else{
             Node temp = start;
             start = nyNode;
             start.neste=temp;
        }

        stoerrelse++;
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
