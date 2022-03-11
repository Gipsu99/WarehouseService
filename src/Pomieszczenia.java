import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.sort;
import static java.util.Collections.synchronizedCollection;

public class Pomieszczenia implements Comparable<Pomieszczenia> {
    private int id;
    private static int counter = 1;
    private int powierzchnia;
    private boolean wynajete;
    private boolean osoba;
    private int dodawanie;
    private int rozmiarPrzedmiotu;

    Pomieszczenia(int powierzchnia) {
        this.powierzchnia = powierzchnia;
        id = counter++;

    }


    List<Przedmiot> listaPrzedmiotow = new ArrayList<Przedmiot>();

    public boolean isWynajete() {
        return wynajete;
    }

    public void setWynajete(boolean wynajete) {
        this.wynajete = wynajete;
    }

    public int getDodawanie() {
        return dodawanie;
    }

    public String toString() {
        return "id: " + id + ", rozmiar: " + powierzchnia + " metrów sześciennych.";
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }


    public void dodajPrzedmiotu() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Collections.sort(listaPrzedmiotow);
        int nr = sc.nextInt();

        System.out.println("Podaj rozmiar przedmiotu");
         rozmiarPrzedmiotu = sc.nextInt();
        if (dodawanie + rozmiarPrzedmiotu >= powierzchnia) {
            try {
                throw new TooManyThingsException("Przedmiot się nie zmieści.");
            } catch (TooManyThingsException eb) {
                eb.printStackTrace();
            }
        } else {

            if (nr == 1) {
                System.out.println("Podaj nazwe przedmiotu");
                String nazwaPrzedmiotu;
                nazwaPrzedmiotu = sc1.nextLine();

                System.out.println("Gaz/Benzyna/Diesel");

                String cecha1;
                cecha1 = sc1.nextLine();

                Przedmiot samochod = new Samochod(nazwaPrzedmiotu, rozmiarPrzedmiotu, cecha1);
                listaPrzedmiotow.add(samochod);
            }
            if (nr == 2) {
                System.out.println("Podaj nazwe przedmiotu");
                String nazwaPrzedmiotu;
                nazwaPrzedmiotu = sc1.nextLine();
                System.out.println("Czy posiada homologacje?");
                System.out.println("1. Tak");
                System.out.println("2. Nie");
                int homologacja;
                homologacja = sc.nextInt();
                if (homologacja == 1) {
                    Przedmiot motocykl = new Motocykl(nazwaPrzedmiotu, rozmiarPrzedmiotu, true);
                    listaPrzedmiotow.add(motocykl);
                }
                if (homologacja == 2) {
                    Przedmiot motocykl = new Motocykl(nazwaPrzedmiotu, rozmiarPrzedmiotu, false);
                    listaPrzedmiotow.add(motocykl);
                }

            }
            if (nr == 3) {
                System.out.println("1. Rower (nie można składać)");
                System.out.println("2. Skladak (można składać)");
                int nr2;
                nr2 = sc.nextInt();
                if(nr2 == 1) {
                    System.out.println("Podaj nazwe przedmiotu");
                    String nazwaPrzedmiotu;
                    nazwaPrzedmiotu = sc1.nextLine();
                    System.out.println("liczba przerzutek?");
                    int przerzutki;
                    przerzutki = sc.nextInt();
                    Przedmiot rower = new Rower(nazwaPrzedmiotu, rozmiarPrzedmiotu, przerzutki);
                    listaPrzedmiotow.add(rower);
                }
                if(nr2 == 2) {
                    System.out.println("Podaj nazwe przedmiotu");
                    String nazwaPrzedmiotu;
                    nazwaPrzedmiotu = sc1.nextLine();
                    System.out.println("liczba przerzutek?");
                    int przerzutki;
                    przerzutki = sc.nextInt();
                    System.out.println("Złożyć przedmiot?");
                    System.out.println("1.Tak");
                    System.out.println("2.Nie");
                    int nr3;
                    nr3 = sc.nextInt();
                    if(nr3 == 1) {
                        Przedmiot rower = new Rower(nazwaPrzedmiotu, rozmiarPrzedmiotu/2, przerzutki);
                        listaPrzedmiotow.add(rower);
                    }
                    if (nr3 == 2) {
                        Przedmiot rower = new Rower(nazwaPrzedmiotu, rozmiarPrzedmiotu, przerzutki);
                        listaPrzedmiotow.add(rower);
                    }
                }

            }
            if (nr == 4) {
                System.out.println("Podaj nazwe przedmiotu");
                String nazwaPrzedmiotu = sc.nextLine();
                System.out.println("Podaj rozmiar przedmiotu");
                rozmiarPrzedmiotu = sc.nextInt();
                Przedmiot przedmiot1 = new Przedmiot(nazwaPrzedmiotu, rozmiarPrzedmiotu);
                listaPrzedmiotow.add(przedmiot1);
            }

            dodawanie = dodawanie + rozmiarPrzedmiotu;
        }
    }





        void wyjmijPrzedmiot (){
            Scanner sc = new Scanner(System.in);

            if (listaPrzedmiotow.isEmpty() == true) {

                System.out.println("nie masz przedmiotów na liście");

            } else {
                System.out.println("Podaj numer przedmiotu na liscie");
                System.out.println(listaPrzedmiotow);
                int miejsce;
                miejsce = sc.nextInt();

                    listaPrzedmiotow.remove(listaPrzedmiotow.get(miejsce - 1));
                    dodawanie = dodawanie - rozmiarPrzedmiotu;


            }
        }



        @Override
        public int compareTo (Pomieszczenia pomieszczenia){
            return this.powierzchnia - pomieszczenia.powierzchnia;
        }




}