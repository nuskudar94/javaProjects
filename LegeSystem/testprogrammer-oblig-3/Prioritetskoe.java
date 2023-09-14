public class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste <E> {
    

    @Override
    public void leggTil(E x){

        Node newNode = new Node(x);

        if(start==null){
            start=newNode;
        }else{

            if(start.verdi.compareTo( newNode.verdi)>=0){
                newNode.neste=start;
                start=newNode;
            }else{
                Node pointer = start;
                while(pointer.neste != null && pointer.neste.verdi.compareTo(newNode.verdi)<0){
                        pointer =pointer.neste;
                }
                newNode.neste=pointer.neste;
                pointer.neste=newNode;
            }

        }
        stoerrelse++;
    }

    @Override
    public E fjern(){
        if (start == null){

            throw new UgyldigListeindeks(-1);

        }else{
            Node noden =start;
            start= start.neste;
            stoerrelse--;
            return noden.verdi;
        }
     }

     @Override
     public E hent() throws UgyldigListeindeks{
         
         if (start == null){
             
             
             throw new UgyldigListeindeks(-1);
 
         }
 
         return start.verdi ;
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
