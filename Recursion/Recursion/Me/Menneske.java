package Me;

public class Menneske {
    private Menneske mor,far;
    private int alder;
    private String navn;

    public Menneske(Menneske mor,Menneske far,int alder,String navn){
        this.mor=mor;
        this.far=far;
        this.alder=alder;
        this.navn=navn;
    }
    //overloading samme metode ulik signatur
    public Menneske(int alder,String navn){
        this.alder=alder;
        this.navn=navn;
    }

    public void settMor(Menneske mor){
        this.mor=mor;
    }

    public void settFar(Menneske far){
        this.far=far;
    }


    public String hentFamilieTre(){
        return familieTreRekursjon(""); //starter recursive call
    }

    public String familieTreRekursjon(String utskrift){
        String tekst="\n" + utskrift +  this;
        //basistilfelle
        if(mor==null && far==null) return tekst;

        //recursive call
        if(mor != null){
            tekst +=  mor.familieTreRekursjon(utskrift + "  ");
        }
        if(far != null){
            tekst +=  far.familieTreRekursjon(utskrift + "  ");
        }

        return tekst;
    }
    //overloading
    public void  finnRelasjon(Menneske leterEtter){
        finnRelasjon(leterEtter, "");
    }

    private void finnRelasjon(Menneske leterEtter, String relasjon){
        //basistilfelle
        if(this == leterEtter){
            System.out.println("Navn: " + this.navn + ", Relasjon: " + relasjon);
            return; 
        }
        //recursive call
        if(mor != null){
            mor.finnRelasjon(leterEtter, relasjon + "mor");
        }
        if(far != null){
            far.finnRelasjon(leterEtter, relasjon + "far");
        }
    }
    

    public Menneske finnEldsteIFamilieTre(){
        //basis tilfelle uten ref til mor og far obj
        if(mor == null && far ==null){
            return this;
        }

        Menneske eldsteFarSide = null;
        Menneske eldsteMorSide = null;

        if(mor != null){
            eldsteMorSide = mor.finnEldsteIFamilieTre();
        }
        if(far != null){
            eldsteFarSide = far.finnEldsteIFamilieTre();
        }

        Menneske eldste = this;
        if(eldsteMorSide != null){
            if(eldste.alder < eldsteMorSide.alder){
                eldste = eldsteMorSide;
            }
        }

        if(eldsteFarSide != null){
            if(eldste.alder < eldsteFarSide.alder){
                eldste = eldsteFarSide;
            }
        }

        return eldste;

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return navn + "(" + alder + ")" ;
    }
}
