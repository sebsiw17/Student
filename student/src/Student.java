import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String imie;
    private String nazwisko;
    private double ocena;
    private char plec;
    private String kierunek;
    private List<Double> oceny = new ArrayList<>();

    // Mapa ocen przedmiotów (nazwa przedmiotu -> lista ocen)
    private Map<String, List<Double>> ocenyPrzedmiotow = new HashMap<>();

    public Student(String imie, String nazwisko, double ocena, char plec, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.plec = plec;
        this.kierunek = kierunek;
        oceny.add(ocena);

        // Dodaj ocenę do przedmiotu "Ogólny"
        if (!ocenyPrzedmiotow.containsKey("Ogólny")) {
            ocenyPrzedmiotow.put("Ogólny", new ArrayList<>());
        }
        ocenyPrzedmiotow.get("Ogólny").add(ocena);

        WyswietlInformacje();
    }

    public void WyswietlInformacje() {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Ocena: " + ocena);
        System.out.println("Płeć: " + plec);
        System.out.println("Kierunek: " + kierunek);
    }

    public void ZmienKierunek(String nowyKierunek) {
        this.kierunek = nowyKierunek;
        System.out.println("Zmieniono kierunek na: " + nowyKierunek);
        WyswietlInformacje();
    }

    public void ZmienOcene(double nowaOcena) {
        oceny.add(nowaOcena);
        this.ocena = nowaOcena;
        System.out.println("Zmieniono ocenę na: " + nowaOcena);
        WyswietlInformacje();
    }

    public void ZmienImie(String noweImie) {
        this.imie = noweImie;
        System.out.println("Zmieniono imię na: " + noweImie);
        WyswietlInformacje();
    }

    public void ZmienNazwisko(String noweNazwisko) {
        this.nazwisko = noweNazwisko;
        System.out.println("Zmieniono nazwisko na: " + noweNazwisko);
        WyswietlInformacje();
    }

    public boolean SprawdzZaliczenie() {
        // Przyjmujemy, że zaliczenie jest możliwe, jeśli średnia ocen jest większa lub równa 2.0
        double sumaOcen = 0;
        for (Double ocena : oceny) {
            sumaOcen += ocena;
        }
        double srednia = sumaOcen / oceny.size();
        return srednia >= 2.0;
    }

    public void UstawPlec(char nowaPlec) {
        this.plec = nowaPlec;
        System.out.println("Zmieniono płeć na: " + nowaPlec);
        WyswietlInformacje();
    }

    public double ObliczSredniaOcen() {
        double sumaOcen = 0;
        for (Double ocena : oceny) {
            sumaOcen += ocena;
        }
        return sumaOcen / oceny.size();
    }

    public double WyswietlSredniaOcenaKierunku(String kierunek) {
        if (!ocenyPrzedmiotow.containsKey(kierunek)) {
            return 0.0;
        }
        List<Double> ocenyKierunku = ocenyPrzedmiotow.get(kierunek);
        double sumaOcen = 0;
        for (Double ocena : ocenyKierunku) {
            sumaOcen += ocena;
        }
        return sumaOcen / ocenyKierunku.size();
    }

    public static void main(String[] args) {
        // Przykład użycia klasy Student
        Student student1 = new Student("Jan", "Kowalski", 4.5, 'M', "Informatyka");
        Student student2 = new Student("Anna", "Nowak", 3.0, 'K', "Medycyna");
        Student student3 = new Student("Mateusz", "Kierowca", 2.9, 'M', "Mechanika samochodowa");
        Student student4 = new Student("Eugeniusz", "Gwiazdeczka", 1.8, 'M', "Mechanika samochodowa");

        student1.ZmienOcene(3.8);
        student2.ZmienKierunek("Psychologia");
        student3.ZmienImie("Natalia");
        student3.ZmienNazwisko("Stópka");
        student3.UstawPlec('K');

        System.out.println("Średnia ocena studenta 1: " + student1.ObliczSredniaOcen());
        System.out.println("Średnia ocena studenta 2: " + student2.ObliczSredniaOcen());
        System.out.println("Średnia ocena studenta 3: " + student3.ObliczSredniaOcen());
        System.out.println("Średnia ocena studenta 4: " + student4.ObliczSredniaOcen());

        System.out.println("Czy student 1 zaliczył przedmiot? " + student1.SprawdzZaliczenie());
        System.out.println("Czy student 2 zaliczył przedmiot? " + student2.SprawdzZaliczenie());
        System.out.println("Czy student 3 zaliczył przedmiot? " + student3.SprawdzZaliczenie());
        System.out.println("Czy student 4 zaliczył przedmiot? " + student4.SprawdzZaliczenie());

        System.out.println("Średnia ocena studentów na kierunku Informatyka: " + student1.WyswietlSredniaOcenaKierunku("Informatyka"));
    }
}
