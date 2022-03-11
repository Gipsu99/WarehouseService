public class Przedmiot implements Comparable<Przedmiot> {


    private String nazwa;
    private int powierzchnia;


    public Przedmiot(String nazwa, int powierzchnia) {
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
    }

    public Przedmiot(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return "Nazwa: " + getNazwa() + ", powierzchnia: " + getPowierzchnia() + " m^3.";
    }

    public int getPowierzchnia() {
        return powierzchnia ;
    }


    @Override
    public int compareTo(Przedmiot przedmiot) {
        if(this.powierzchnia - przedmiot.powierzchnia == 0) {
            return nazwa.compareTo(przedmiot.nazwa);
    }
        return przedmiot.powierzchnia - this.powierzchnia;
    }

}
