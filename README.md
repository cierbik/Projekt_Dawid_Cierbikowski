# Aplikacja Bankowa Java - Konta Klientów

## 📋 Opis

Prosta aplikacja konsolowa w języku Java do zarządzania kontami klientów banku. Dane klientów są przechowywane w pliku binarnym (`klienci.dat`), co umożliwia trwałość danych między uruchomieniami.

Aplikacja obsługuje:
- Dodawanie klientów (zwykłych i VIP)
- Zasilanie konta
- Wypłatę środków
- Przelewy między kontami
- Naliczanie oprocentowania
- Wyszukiwanie klientów po ID
- Wyświetlanie wszystkich klientów
- Usuwanie klientów

---

## 🧾 Klasy

### `Klient`
Reprezentuje zwykłego klienta z ID, imieniem, nazwiskiem, saldem i oprocentowaniem.

### `KlientVIP`
Dziedziczy po `Klient`. Zawiera dodatkowe oprocentowanie VIP.

### `BazaKlientow`
Zarządza listą klientów. Obsługuje zapisywanie/odczytywanie z pliku i operacje bankowe.

### `Main`
Interfejs tekstowy (menu konsolowe) do interakcji z użytkownikiem.

---

## 💾 Wymagania

- Java 8 lub nowsza

---

## 🚀 Uruchomienie

1. Skompiluj projekt:

```bash
javac Main.java Klient.java KlientVIP.java BazaKlientow.java
