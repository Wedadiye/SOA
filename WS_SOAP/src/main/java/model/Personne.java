package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Personne {
    @XmlElement
    private int id;
    @XmlElement
    private String nom;
	
	public Personne(int id, String nom) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.nom=nom;
	}
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String name) {
		this.nom= name;
	}
	

   
}
