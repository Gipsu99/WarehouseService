import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Osoba implements Serializable {
    private String imie;
    private String nazwisko;
    private String pesel;
    private String adres;
    private String dataUrodzenia;
    private String dataPierwszegoNajmu;
    private boolean wynajete;
    private String dataWynajecia;
    private int dzien;
    private int miesiac;
    private int rok;
    private int admin;
    private boolean remont;



    public Osoba(String imie, String nazwisko, String pesel, String adres, String dataUrodzenia, int dzien, int miesiac, int rok) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
    }
    public Osoba(String imie, String nazwisko, String pesel, String adres, String dataUrodzenia, int admin) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
        this.admin = admin;
    }

    public Osoba(String imie, String nazwisko, String pesel, String adres, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
    }

    public Osoba() {
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAdres() {
        return adres;
    }

    public String getDataPierwszegoNajmu() {
        return dataPierwszegoNajmu;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String toString() {
        return getImie() + " " + getNazwisko();
    }



    void infoOsoba() throws NeverRentException {
        try {
            if (dzien == 0 && miesiac == 0 && rok == 0) {
                throw new NeverRentException("Nie wynająłeś nigdy pomieszczenia.");
            }  else {
                System.out.print("Imie: " + getImie() + ", Nazwisko: " + getNazwisko() + ", PESEL: " + getPesel() + ", Adres: " + getAdres() + ", Data urodzenia: " + getDataUrodzenia() + ", Data pierwszego najmu: " + dzien + "-" + miesiac + "-" + rok);
            }
        } catch (NeverRentException e) {
            System.out.println("Imie: " + getImie() + ", Nazwisko: " + getNazwisko() + ", PESEL: " + getPesel() + ", Adres: " + getAdres() + ", Data urodzenia: " + getDataUrodzenia() + ", Data pierwszego najmu: " + dataPierwszegoNajmu);
            e.printStackTrace();
        }
        if (dzien == 0 && miesiac == 0 && rok == 0) {
            System.out.print("Lista pomieszczeń: ");
        } else {
            System.out.print("\nLista pomieszczeń: ");
        }
    }

    List<Pomieszczenia> listaPomieszczen = new ArrayList<>();


List<Osoba> listaOsob = new ArrayList<>();

    public List<Osoba> getListaOsob() {
        return listaOsob;
    }

    public void daneOsoby(Osoba osoba) {
        try {
            osoba.infoOsoba();
        } catch (NeverRentException e) {
            e.printStackTrace();
        }
    }

    public List<Pomieszczenia> getListaPomieszczen() {
        return listaPomieszczen;
    }


public void wynajmij(Pomieszczenia pomieszczenia) {

    if(pomieszczenia.isWynajete() == false) {
        if (dzien == 0 && miesiac == 0 && rok == 0) {
            boolean set = false;
            int a, b, c, d;
            do {
                try {
                    do {
                        System.out.print("Podaj datę wynajmu DDMMRRRR, pamiętaj, że mamy rok 2020: ");
                        Scanner sc = new Scanner(System.in);
                        a = sc.nextInt();
                        b = sc.nextInt();
                        c = sc.nextInt();
                        dzien = a;
                        miesiac = b;
                        rok = c;
                        if (a > 0 || b > 0 || c > 0) {
                            set = true;
                        }
                    } while (a <= 0 || a > 31 || b <= 0 || b > 12 || c != 2020);
                } catch (InputMismatchException e) {
                    System.err.println("to nie jest liczba");
                    set = false;
                }
            } while (set == false);
            listaPomieszczen.add(pomieszczenia);
            pomieszczenia.setWynajete(true);
        } else {
            pomieszczenia.setWynajete(true);
            listaPomieszczen.add(pomieszczenia);
        }
    } else {
        System.err.println("Te pomieszczenie jest zajęte.");
    }
}




    public int getAdmin() {
        return admin;
    }
    public void Remontwlacz(Pomieszczenia pomieszczenia) {
        if(listaPomieszczen.contains(pomieszczenia) == false) {
            listaPomieszczen.add(pomieszczenia);
        } else {
            System.out.println("Pomieszczenie najpierw musi być wyłączone.");
        }

    }
    public void Remontwylacz(Pomieszczenia pomieszczenia) {
            listaPomieszczen.remove(pomieszczenia);

    }

        public void wolnePomieszczenia (List<Pomieszczenia> pomieszczenia) {
            for (Pomieszczenia pomieszczenia1: listaPomieszczen) {
                if(pomieszczenia1.isWynajete() == false) {
                    System.out.println(pomieszczenia1);
                }
            }
            }

    public void zapisanie(List<Osoba> listaOsob, List<Pomieszczenia> listaPomieszczen) {
        try {

            Collections.sort(getListaPomieszczen());
            Collections.sort(listaPomieszczen);

            FileWriter zapis = new FileWriter("stanMagazynu.txt");

            zapis.write("Osoby i pomieszczenia ich: " + '\n');
            for(Osoba osoba : listaOsob) {
                    zapis.write(osoba + " " + osoba.listaPomieszczen.toString() + "\n");
            }
            zapis.write("\nLista pomieszczeń i przedmiotów w nich: ");
            for(Pomieszczenia pomieszczenia : listaPomieszczen) {
                Collections.sort(pomieszczenia.listaPrzedmiotow);
                zapis.write('\n' + pomieszczenia.toString() + " " + pomieszczenia.listaPrzedmiotow.toString());
            }
            zapis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
