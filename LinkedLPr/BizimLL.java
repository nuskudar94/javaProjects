public class BizimLL{
    
    Eleman head; //Listenin basina isaret ediyor.
    Eleman tail;

    public BizimLL(){
        head = null;  //Liste bos oldugu icin null'a esitliyor.
        tail = null; //cunku bos liste
    }

    public void bastanSil(){
        if(isFilled()){
            if(head == tail){
                //listede tek eleman
                head = null;
                tail = null;
            }else {
                 Eleman newHead = head.next;
                 head.next = null;
                 head = newHead;
                  
            }
        }
    }

    public void insertAtIndex(int data, int index){
        Eleman newEleman = new Eleman(data);
        if (isFilled()){
            //liste dolu ve biz en basa eklemek istiyoruz yani index=0
            if(index == 0){
                //basa eklemekle ayni
                newEleman.next = head;
                head = newEleman;
            }else {
                //ortada bir yere ekliyoruz ve pointer ile yapicaz bunu
                Eleman frontPointer = head;
                Eleman prePointer = null;
                int currentIndex = 0; 
                //Pointer biseye isaret ettigi surece taricaz 
                while( frontPointer != null  && currentIndex < index){
                    System.out.println(frontPointer.data + " ");
                    //Pointeri ilerletmek icin objenin icindeki nexti degistirmemiz gerekiyor.
                    prePointer = frontPointer;
                    frontPointer = frontPointer.next; //Eger isaretci sona geldiyse null i gostericek ve while dongusunden cikacak
                    currentIndex++;
                }
                if(frontPointer == null){
                    tail.next= newEleman; 
                     //Yeni son artik bizim yeni elemanimizi gostermeli
                    tail = newEleman;       
                }else{
                    //ortada bi yere ekliyoruz
                    newEleman.next = frontPointer;
                    prePointer.next = newEleman;
                }
            }
            

        }else {
            //liste bos
            head = newEleman;
            tail  = newEleman;
        }
    }

    public void insertAtStart(int data){
        Eleman newEleman = new Eleman(data);
        if (isFilled()){
            //liste dolu
            newEleman.next = head;
            head = newEleman;

        }else {
            //liste bos
            head = newEleman;
            tail  = newEleman;
        }
    }


    public void insertAtEnd(int data){
        Eleman newEleman = new Eleman(data);
        if (isFilled()){
            //liste dolu
            //Eski sonun siradakisi null idi ama simdi yeni sonu gostermesi gerekiyor
            tail.next= newEleman; 
            //Yeni son artik bizim yeni elemanimizi gostermeli
            tail = newEleman;
        }else {
            //liste bos
            head = newEleman;
            tail  = newEleman;
        }

    }

    public boolean isFilled(){
        if (head != null){
            return true;
        } else {
            return false;
        }
    }

    public void listeyiYazdir(){
        //Listeyi taramaya bastan baslicaz.Pointer yardimiyla listeyi taricaz.
        Eleman pointer = head;
        int elemanSayisi=0;
        //Pointer biseye isaret ettigi surece taricaz
        while( pointer != null){
            System.out.print(pointer.data + " ");
            //Pointeri ilerletmek icin objenin icindeki nexti degistirmemiz gerekiyor.
            pointer = pointer.next; //Eger isaretci sona geldiyse null i gostericek ve while dongusunden cikacak
            elemanSayisi++;

        }

        System.out.println();
        System.out.println("Eleman Sayisi: " + elemanSayisi);
        System.out.println();

    }

}
