public class KaninOreTeller {
    public static void main(String[] args) {
        System.out.println(tellKaninOrer(0)); //Forventet resultat 0
        System.out.println(tellKaninOrer(1)); //Forventet resultat 1
        System.out.println(tellKaninOrer(2)); //Forventet resultat 3
        System.out.println(tellKaninOrer(12)); //Forventet resultat 18
        System.out.println(tellKaninOrer(234)); //Forventet resultat 351
        }
        
        
        public static int tellKaninOrer(int antallKaniner){
        //kode inn her
        if(antallKaniner == 0) return 0;
        
        if(antallKaniner%2 !=0) return tellKaninOrer(antallKaniner - 1) + 1;
        
        return tellKaninOrer(antallKaniner - 1) + 2;
        }


    }

    class StringOprasjoner {
        public static void main(String[] args) {
        String str = "kattkukatt";
        System.out.println(antallSubStringer(str, "katt")); //Forventet resultat 2
        System.out.println(antallSubStringer(str, "ku")); //Forventet resultat 1
        System.out.println(antallSubStringer(str, "hund")); //Forventet resultat 0
        }
        public static int antallSubStringer(String str, String sub){
        //kode inn her
        if(str.length()<sub.length()) return 0;
        
        if(str.substring(0, sub.length()).equals(sub)){
            return 1 + antallSubStringer(str.substring(1,str.length()), sub);
        }
        return antallSubStringer(str.substring(1, str.length()), sub);
        }
        }
