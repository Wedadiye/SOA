package models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty
    private int nni;
    @JsonProperty
    private String nom;

    public Person() {}

    public Person(int nni, String nom) {
        this.nni = nni;
        this.nom = nom;
    }

    public int getNni() {
        return nni;
    }

    public void setNni(int nni) {
        this.nni = nni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return "Personne [nni=" + nni + ", nom=" + nom + "]";
    }
}
