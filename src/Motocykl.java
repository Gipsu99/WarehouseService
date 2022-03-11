public class Motocykl extends Przedmiot {
    private String nazwa;
    private int powierzchnia;
    private boolean homologacja;


    public Motocykl(String nazwa, int powierzchnia, boolean homologacja) {
        super(nazwa, powierzchnia);
        this.nazwa = nazwa;
        this.powierzchnia = powierzchnia;
        this.homologacja = homologacja;
    }

    public String toString() {
        return "nazwa: " + nazwa + ", powierzchnia: " + getPowierzchnia() + ", homologacja: " + homologacja;
    }
}
