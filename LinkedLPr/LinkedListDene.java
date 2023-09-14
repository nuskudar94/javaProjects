public class LinkedListDene {
    
    
    public static void main(String[] args){
    
    
    BizimLL list = new BizimLL();

    list.insertAtStart(2);
    list.insertAtStart(5);
    list.insertAtStart(6);

    list.listeyiYazdir();

    list.insertAtEnd(8);
    list.insertAtEnd(10);
    list.listeyiYazdir();


    list.insertAtIndex(8,0);
    list.insertAtIndex(10,33);
    list.listeyiYazdir();

        
    list.insertAtIndex(10,3);
    list.listeyiYazdir();

 
}
}