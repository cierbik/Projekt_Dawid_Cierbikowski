import java.io.Serializable;

public class Klient implements Serializable {
    private int id;
    private String imie;
    private String nazwisko;
    protected double saldo;
    protected double oprocentowanie;

    public Klient(int id, String imie, String nazwisko, double saldo, double oprocentowanie) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.saldo = saldo;
        this.oprocentowanie = oprocentowanie;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getSaldo() {
        return saldo;
    }

    public void zasilenie(double kwota) {
        saldo += kwota;
    }

    public boolean wyplata(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
            return true;
        }
        return false;
    }

    public void naliczOprocentowanie() {
        saldo += saldo * (oprocentowanie / 100);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "ID=" + id +
                ", Imię='" + imie + '\'' +
                ", Nazwisko='" + nazwisko + '\'' +
                ", Saldo=" + saldo +
                ", Oprocentowanie=" + oprocentowanie + "%}";
    }
}
