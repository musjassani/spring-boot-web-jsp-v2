package com.proto.beans;

import javax.persistence.*;

@Entity
public class Film {

    public Film() { }

    public Film(String titre, Integer annee, Pays pays) {
        this.titre = titre;
        this.annee = annee;
        this.pays = pays;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public void setId(Integer i) { id = i; }

    @Column(nullable = false)
    String titre;
    public void setTitre(String t) { titre = t; }
    public String getTitre() { return titre; }

    @Column(nullable = false)
    Integer annee;
    public void setAnnee(Integer a) { annee = a; }
    public Integer getAnnee() { return annee; }

    @ManyToOne
    @JoinColumn(name = "CodePays")
    private Pays pays;
    public void setPays(Pays p) { pays = p; }
    public Pays getPays() { return pays; }

    /*@ManyToOne
    @JoinColumn(name = "idRealisateur")
    private Artiste realisateur;
    public void setRealisateur(Artiste a) {realisateur = a;}
    public Artiste getRealisateur() {return realisateur;}*/

    @ManyToOne
    @JoinColumn(name = "CodeGenre")
    private Genre genre;
    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }
}