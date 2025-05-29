import java.io.*;
import java.util.*;

public class BazaKlientow {
    private List<Klient> klienci = new ArrayList<>();
    private final String plik = "klienci.dat";

    public BazaKlientow() {
        wczytaj();
    }

    public void dodajKlienta(Klient k) {
        klienci.add(k);
        zapisz();
    }

    public void usunKlienta(int id) {
        klienci.removeIf(k -> k.getId() == id);
        zapisz();
    }

    public Klient znajdzKlienta(int id) {
        for (Klient k : klienci) {
            if (k.getId() == id)
                return k;
        }
        return null;
    }

    public void zasilKonto(int id, double kwota) {
        Klient k = znajdzKlienta(id);
        if (k != null) {
            k.zasilenie(kwota);
            zapisz();
        }
    }

    public boolean wyplacZKonta(int id, double kwota) {
        Klient k = znajdzKlienta(id);
        if (k != null && k.wyplata(kwota)) {
            zapisz();
            return true;
        }
        return false;
    }

    public boolean przelew(int idOd, int idDo, double kwota) {
        Klient od = znajdzKlienta(idOd);
        Klient doK = znajdzKlienta(idDo);
        if (od != null && doK != null && od.wyplata(kwota)) {
            doK.zasilenie(kwota);
            zapisz();
            return true;
        }
        return false;
    }

    public void naliczOprocentowanie(int id) {
        Klient k = znajdzKlienta(id);
        if (k != null) {
            k.naliczOprocentowanie();
            zapisz();
        }
    }

    public void wyswietlWszystkich() {
        for (Klient k : klienci) {
            System.out.println(k);
        }
    }

    private void zapisz() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(plik))) {
            oos.writeObject(klienci);
        } catch (IOException e) {
            System.err.println("Błąd zapisu: " + e.getMessage());
        }
    }

    private void wczytaj() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(plik))) {
            klienci = (List<Klient>) ois.readObject();
        } catch (Exception e) {
            klienci = new ArrayList<>();
        }
    }
}
