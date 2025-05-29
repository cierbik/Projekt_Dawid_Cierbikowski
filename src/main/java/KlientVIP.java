public class KlientVIP extends Klient {
    private double dodatkoweOprocentowanie;

    public KlientVIP(int id, String imie, String nazwisko, double saldo, double oprocentowanie, double dodatkoweOprocentowanie) {
        super(id, imie, nazwisko, saldo, oprocentowanie);
        this.dodatkoweOprocentowanie = dodatkoweOprocentowanie;
    }

    @Override
    public void naliczOprocentowanie() {
        saldo += saldo * ((oprocentowanie + dodatkoweOprocentowanie) / 100);
    }

    @Override
    public String toString() {
        return "KlientVIP{" +
                "ID=" + getId() +
                ", Imię='" + getImie() + '\'' +
                ", Nazwisko='" + getNazwisko() + '\'' +
                ", Saldo=" + saldo +
                ", Oprocentowanie=" + oprocentowanie +
                "%, Dodatkowe Oprocentowanie=" + dodatkoweOprocentowanie + "%}";
    }
}
