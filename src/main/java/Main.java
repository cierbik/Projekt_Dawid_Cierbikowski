import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BazaKlientow baza = new BazaKlientow();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dodaj klienta");
            System.out.println("2. Zasil konto");
            System.out.println("3. Wypłać z konta");
            System.out.println("4. Przelew");
            System.out.println("5. Nalicz oprocentowanie");
            System.out.println("6. Wyświetl wszystkich");
            System.out.println("7. Szukaj klienta po ID");
            System.out.println("8. Usuń klienta");
            System.out.println("0. Wyjście");

            int wybor = sc.nextInt();
            switch (wybor) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Imię: ");
                    String imie = sc.next();
                    System.out.print("Nazwisko: ");
                    String nazwisko = sc.next();
                    System.out.print("Saldo: ");
                    double saldo = sc.nextDouble();
                    System.out.print("Oprocentowanie: ");
                    double oprocentowanie = sc.nextDouble();
                    System.out.print("Czy VIP? (t/n): ");
                    String vip = sc.next();

                    if (vip.equalsIgnoreCase("t")) {
                        System.out.print("Dodatkowe oprocentowanie: ");
                        double dop = sc.nextDouble();
                        baza.dodajKlienta(new KlientVIP(id, imie, nazwisko, saldo, oprocentowanie, dop));
                    } else {
                        baza.dodajKlienta(new Klient(id, imie, nazwisko, saldo, oprocentowanie));
                    }
                }
                case 2 -> {
                    System.out.print("ID klienta: ");
                    int id = sc.nextInt();
                    System.out.print("Kwota: ");
                    double kwota = sc.nextDouble();
                    baza.zasilKonto(id, kwota);
                }
                case 3 -> {
                    System.out.print("ID klienta: ");
                    int id = sc.nextInt();
                    System.out.print("Kwota: ");
                    double kwota = sc.nextDouble();
                    if (!baza.wyplacZKonta(id, kwota)) {
                        System.out.println("Nie udało się wypłacić!");
                    }
                }
                case 4 -> {
                    System.out.print("ID nadawcy: ");
                    int idOd = sc.nextInt();
                    System.out.print("ID odbiorcy: ");
                    int idDo = sc.nextInt();
                    System.out.print("Kwota: ");
                    double kwota = sc.nextDouble();
                    if (!baza.przelew(idOd, idDo, kwota)) {
                        System.out.println("Nie udało się wykonać przelewu.");
                    }
                }
                case 5 -> {
                    System.out.print("ID klienta: ");
                    int id = sc.nextInt();
                    baza.naliczOprocentowanie(id);
                }
                case 6 -> baza.wyswietlWszystkich();
                case 7 -> {
                    System.out.print("ID klienta: ");
                    int id = sc.nextInt();
                    Klient k = baza.znajdzKlienta(id);
                    if (k != null)
                        System.out.println(k);
                    else
                        System.out.println("Nie znaleziono klienta.");
                }
                case 8 -> {
                    System.out.print("ID do usunięcia: ");
                    int id = sc.nextInt();
                    baza.usunKlienta(id);
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
