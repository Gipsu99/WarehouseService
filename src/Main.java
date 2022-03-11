import java.util.*;

public class Main {
    public static void main(String[] args) {

        Pomieszczenia pomieszczenie1 = new Pomieszczenia(28);
        Pomieszczenia pomieszczenie2 = new Pomieszczenia(22);
        Pomieszczenia pomieszczenie3 = new Pomieszczenia(23);
        Pomieszczenia pomieszczenie4 = new Pomieszczenia(16);
        Pomieszczenia pomieszczenie5 = new Pomieszczenia(40);
        Pomieszczenia pomieszczenie6 = new Pomieszczenia(15);
        Pomieszczenia pomieszczenie7 = new Pomieszczenia(23);
        Pomieszczenia pomieszczenie8 = new Pomieszczenia(27);
        Pomieszczenia pomieszczenie9 = new Pomieszczenia(32);
        Pomieszczenia pomieszczenie10 = new Pomieszczenia(18);
        infoDlaSkanera info = new infoDlaSkanera();

        Osoba kowalski = new Osoba("Jan", "Kowalski", "90050411001", "Warszawa", "04-05-90", 0);
        Osoba skonieczny = new Osoba("Tomasz", "Skonieczny", "87021222222", "Warszawa", "12-02-87", 0);
        Osoba zawada = new Osoba("Andrzej", "Zawada", "85031711581", "Warszawa", "17-03-85", 0);
        Osoba nowak = new Osoba("Krzysztof", "Nowak", "80050167987", "Warszawa", "01-05-80", 0);
        Osoba zielinski = new Osoba("Piotr", "Zieliński", "90071843213", "Warszawa", "18-07-90", 0);
        Osoba admin = new Osoba("Piotr", "Grzelczak", "86071843210", "Poznań", "18-07-86", 1);

        Osoba osoba1 = new Osoba();

        osoba1.getListaPomieszczen().add(pomieszczenie1);
        osoba1.getListaPomieszczen().add(pomieszczenie2);
        osoba1.getListaPomieszczen().add(pomieszczenie3);
        osoba1.getListaPomieszczen().add(pomieszczenie4);
        osoba1.getListaPomieszczen().add(pomieszczenie5);
        osoba1.getListaPomieszczen().add(pomieszczenie6);
        osoba1.getListaPomieszczen().add(pomieszczenie7);
        osoba1.getListaPomieszczen().add(pomieszczenie8);
        osoba1.getListaPomieszczen().add(pomieszczenie9);
        osoba1.getListaPomieszczen().add(pomieszczenie10);

        osoba1.getListaOsob().add(kowalski);
        osoba1.getListaOsob().add(skonieczny);
        osoba1.getListaOsob().add(zawada);
        osoba1.getListaOsob().add(nowak);
        osoba1.getListaOsob().add(zielinski);
        osoba1.getListaOsob().add(admin);


        Osoba osoba[] = {kowalski, skonieczny, zawada, nowak, zielinski, admin};



        Pomieszczenia pomieszczenia[] = {pomieszczenie1, pomieszczenie2, pomieszczenie3, pomieszczenie4, pomieszczenie5, pomieszczenie6, pomieszczenie7,
                pomieszczenie8, pomieszczenie9, pomieszczenie10};



        int scannerA;
        int scannerB, scannerC, scannerD;
        int scannerE;
        boolean a = false;
        boolean remont = false;
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        int k = 0;
        for (Osoba o : osoba) {
            k++;
            System.out.println(k + ". " + o);
        }

        System.out.println("Naciśnij 0 aby zakończyć program");
        int u, f;

        try {
            do {
                u = sc.nextInt();
                if (u == 0) {
                    System.exit(0);
                }
do {
    for (int i = 0; i < osoba.length; i++) {
        if (u == i + 1) {
            info.wybor();
        }
    }
}while(u < 0 || u > osoba.length);
                do {
                    f = sc.nextInt();
                    for(int i = 0; i < osoba.length; i++) {
                        if(u == i+1) {
                            switch(f) {
                                case 1:
                                    if(u == i+1) {
                                        osoba1.daneOsoby(osoba[u - 1]);
                                        Collections.sort(osoba[u-1].listaPomieszczen);
                                            System.out.println(osoba[u - 1].listaPomieszczen);
                                                do {
                                                System.out.println("Naciśnij 1, aby kontynuować.");
                                                 scannerA = sc.nextInt();
                                                    if (scannerA == 1) {
                                                 info.wybor();
                                                  }
                                                    } while(scannerA != 1);

                                                    }
                                                  break;
                                                case 2:
                                                        try {
                                                            if (u == i + 1 && a == true) {
                                                                System.out.println("Podaj numer, którego pomieszczenia wyświetlić zawartość.");
                                                                Collections.sort(osoba[u-1].listaPomieszczen);
                                                                System.out.println(osoba[u - 1].listaPomieszczen);
                                                                int tmp;
                                                                tmp = sc.nextInt();
                                                                if (u == i + 1) {
                                                                    Collections.sort(pomieszczenia[tmp-1].listaPrzedmiotow);
                                                                    System.out.println(pomieszczenia[tmp - 1].listaPrzedmiotow);
                                                                }
                                                                do {
                                                                    System.out.println("Naciśnij 1, aby kontynuować.");
                                                                    scannerA = sc.nextInt();
                                                                    if (scannerA == 1) {
                                                                        info.wybor();
                                                                    }
                                                                } while(scannerA != 1);
                                                            } else {
                                                                System.out.println("Nie masz wynajętego pomieszczenia.");
                                                                do {
                                                                    System.out.println("Naciśnij 1, aby kontynuować.");
                                                                    scannerA = sc.nextInt();
                                                                    if (scannerA == 1) {
                                                                        info.wybor();
                                                                    }
                                                                } while(scannerA != 1);
                                                            }
                                                        } catch (ArrayIndexOutOfBoundsException e) {
                                                            System.out.println("Niepoprawna liczba");
                                                        }
                                    break;
                                        case 3:
                                            boolean s = true;
                                            if(a == true  && osoba[u-1].listaPomieszczen.size() != 0 && osoba[u-1].listaPomieszczen.contains(osoba[u-1]) == false) {
                                                do {

                                                    System.out.println("Wybierz pomieszczenie scannerA listy do ktorego chcesz wlozyc przedmiot:");
                                                    if(u == i+1) {
                                                        Collections.sort(osoba[u-1].listaPomieszczen);
                                                        System.out.println(osoba[u-1].listaPomieszczen);
                                                    }

                                                        scannerE = sc.nextInt();
                                                            if (u == i + 1 && osoba[u-1].listaPomieszczen.size() != 0 && osoba[u-1].listaPomieszczen.contains(pomieszczenia[scannerE - 1]) == true) {
                                                                info.wybor2();
                                                                pomieszczenia[scannerE - 1].dodajPrzedmiotu();
                                                                s = false;
                                                                do {
                                                                    System.out.println("Naciśnij 1, aby kontynuować.");
                                                                    scannerA = sc.nextInt();
                                                                    if (scannerA == 1) {
                                                                        info.wybor();
                                                                    }
                                                                } while(scannerA != 1);

                                                            } else {
                                                                System.out.println("Te pomieszczenie nie jest twoją własnością.");

                                                                    s = false;
                                                                    do {
                                                                        System.out.println("Naciśnij 1, aby kontynuować.");
                                                                        scannerA = sc.nextInt();
                                                                        if (scannerA == 1) {
                                                                            info.wybor();
                                                                        }
                                                                    } while(scannerA != 1);
                                                               // }
                                                            }
                                                } while (s == true);
                            } else {
                                System.err.println("nie masz wynajętego pomieszczenia.");
                                                do {
                                                    System.out.println("Naciśnij 1, aby kontynuować.");
                                                    scannerA = sc.nextInt();
                                                    if (scannerA == 1) {
                                                        info.wybor();
                                                    }
                                                } while(scannerA != 1);
                            }
                                            break;
                                case 4:
                                    s = true;
                                    if(a == true && osoba[u-1].listaPomieszczen.size() != 0 && osoba[u-1].listaPomieszczen.contains(osoba[u-1]) == false) {
                                        do {
                                            info.wybor3();

                                            System.out.println("Wybierz pomieszczenie scannerA którego chcesz wyjąć przedmiot:");
                                            if(u == i+1) {
                                                Collections.sort(osoba[u-1].listaPomieszczen);
                                                System.out.println(osoba[u-1].listaPomieszczen);
                                            }

                                            try {
                                                scannerE = sc.nextInt();
                                                if (u == i + 1 && osoba[u-1].listaPomieszczen.size() != 0 && osoba[u-1].listaPomieszczen.contains(pomieszczenia[scannerE - 1]) == true) {
                                                    pomieszczenia[scannerE -1].wyjmijPrzedmiot();

                                                        s = false;
                                                        do {
                                                            System.out.println("Naciśnij 1, aby kontynuować.");
                                                            scannerA = sc.nextInt();
                                                            if (scannerA == 1) {
                                                                info.wybor();
                                                            }
                                                        } while(scannerA != 1);
                                                }
                                            } catch (ArrayIndexOutOfBoundsException e) {
                                                System.err.println("Niepoprawna liczba");
                                            }
                                        } while (s == true);
                                    } else {
                                        System.err.println("nie masz wynajętego pomieszczenia.");
                                        do {
                                            System.out.println("Naciśnij 1, aby kontynuować.");
                                            scannerA = sc.nextInt();
                                            if (scannerA == 1) {
                                                info.wybor();
                                            }
                                        } while(scannerA != 1);
                                    }
                                    break;
                                case 5:
                                    try {
                                    if(u == i+1) {
                                        System.out.println("wyswietl wolne pomieszczenia");
                                        Collections.sort(osoba1.listaPomieszczen);
                                        osoba1.wolnePomieszczenia(osoba1.listaPomieszczen);
                                        do {
                                            System.out.println("Naciśnij 1, aby kontynuować.");
                                            scannerA = sc.nextInt();
                                            if (scannerA == 1) {
                                                info.wybor();
                                            }
                                        } while(scannerA != 1);
                                    }
                                    }catch (ArrayIndexOutOfBoundsException e) {
                                        System.err.println("Niepoprawna liczba");
                                    }
                                    break;
                                case 6:
                                    try{
                                    if(u == i+1) {
                                    System.out.println("Podaj numer pomieszczenia które chcesz wynająć");
                                        Collections.sort(osoba1.listaPomieszczen);
                                    osoba1.wolnePomieszczenia(osoba1.listaPomieszczen);
                                    scannerB = sc.nextInt();
                                            if(u == i+1 ) {
                                                osoba[u-1].wynajmij(pomieszczenia[scannerB -1]);
                                                a = true;
                                            }
                                        a = true;
                                        do {
                                            System.out.println("Naciśnij 1, aby kontynuować.");
                                            scannerA = sc.nextInt();
                                            if (scannerA == 1) {
                                                info.wybor();
                                            }
                                        } while(scannerA != 1);
                                        }
                                    }catch (ArrayIndexOutOfBoundsException e) {
                                        System.err.println("Niepoprawna liczba");
                                    }
                                    break;
                                case 7:
                                        osoba[u-1].zapisanie(osoba1.listaOsob, osoba1.listaPomieszczen);
                                        System.exit(0);
                                    break;
                                case 8:
                                    do {
                                        k = 0;
                                        for (Osoba o : osoba) {
                                            k++;
                                            System.out.println(k + ". " + o);
                                        }
                                        System.out.println("Naciśnij 0, aby zakończyć program.");
                                        u = sc.nextInt();
                                        for (i = 0; i < osoba.length; i++) {
                                            if (i + 1 == u) {
                                                info.wybor();
                                            }
                                        }
                                    } while( u < 0||u >6);
                                    if (u == 0) {
                                        System.exit(0);
                                    }
                                    break;
                                case 9:
                                    System.out.println("1.Włącz pomieszczenie.");
                                    System.out.println("2.Wyłącz pomieszczenie.");
                                    scannerD = sc.nextInt();
                                    if(osoba[u - 1].getAdmin() == 1) {
                                        if (scannerD == 1 && remont == true) {
                                            System.out.println("Wybierz pomieszczenie do włączenia");
                                            scannerC = sc.nextInt();
                                            osoba1.Remontwlacz(pomieszczenia[scannerC - 1]);
                                            System.out.println("Pomyślnie włączono pomieszczenie [" + pomieszczenia[scannerC - 1] + "] do użytku.");
                                            do {
                                                System.out.println("Naciśnij 1, aby kontynuować.");
                                                scannerA = sc.nextInt();
                                                if (scannerA == 1) {
                                                    info.wybor();
                                                }
                                            } while(scannerA != 1);
                                        }
                                        if(remont == false) {
                                            System.out.println("Żadne pomieszczenie nie jest remontowane");
                                        }
                                        if (scannerD == 2) {
                                            System.out.println("Wybierz pomieszczenie do wyłączenia.");
                                            Collections.sort(osoba1.listaPomieszczen);
                                            System.out.println(osoba1.listaPomieszczen);
                                            scannerC = sc.nextInt();
                                            osoba1.Remontwylacz(pomieszczenia[scannerC - 1]);
                                            remont = true;
                                            do {
                                                System.out.println("Naciśnij 1, aby kontynuować.");
                                                scannerA = sc.nextInt();
                                                if (scannerA == 1) {
                                                    info.wybor();
                                                }
                                            } while(scannerA != 1);
                                        }
                                    } else {
                                        System.err.println("Nie masz dostępu");
                                        do {
                                            System.out.println("Naciśnij 1, aby kontynuować.");
                                            scannerA = sc.nextInt();
                                            if (scannerA == 1) {
                                                info.wybor();
                                            }
                                        } while(scannerA != 1);
                                    }
                                    break;
                                default:
                                    if (f != 0) {
                                        System.err.println("Niepoprawna liczba");
                                        do {
                                            System.out.println("Naciśnij 1, aby kontynuować.");
                                            scannerA = sc.nextInt();
                                            if (scannerA == 1) {
                                                info.wybor();
                                            }
                                        } while(scannerA != 1);
                                    } else {
                                        System.out.println("Zakończono program.");
                                    }
                            }
                        }
                        if(f == 0) {
                            System.exit(0);
                        }
                    }
                } while (exit == true);
            } while (exit == true);
        } catch (InputMismatchException e) {
            System.err.println("Niepodano numeru. Wyłączanie programu.");
        }
    }
}