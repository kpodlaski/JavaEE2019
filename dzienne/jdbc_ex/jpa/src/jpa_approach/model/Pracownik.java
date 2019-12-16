package jpa_approach.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Pracownik {
    private Integer id;
    private String imie;
    private String nazwisko;
    private Stanowisko stanowisko;
    private List<Jednostka> jednostki;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pracownik pracownik = (Pracownik) o;
        return Objects.equals(id, pracownik.id) &&
                Objects.equals(imie, pracownik.imie) &&
                Objects.equals(nazwisko, pracownik.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imie, nazwisko);
    }

    @OneToOne
    @JoinColumn(name = "stanowisko", referencedColumnName = "id")
    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    @ManyToMany(mappedBy = "pracownicy")
    public List<Jednostka> getJednostki() {
        return jednostki;
    }

    public void setJednostki(List<Jednostka> jednostki) {
        this.jednostki = jednostki;
    }
}
