

public class uke14 {
    
    Node start;
    //int size;
    protected class Node(){
        Node neste;
        String data;

        public Node(String d){
            data = d;
        }
        
    }

    
    public void skrivUt(Node peker){
        if(peker == null)return;  //basis tilfelle

        System.out.println(peker.data);
        skrivUt(peker.neste); //recursive kall
    }

    public void hentStr(){

    }
}
