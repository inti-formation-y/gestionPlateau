package fr.formation.inti.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import fr.formation.inti.domain.enumeration.Groupe;

/**
 * A Equipe.
 */
@Entity
@Table(name = "equipe")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nbr_joueurs")
    private Integer nbrJoueurs;

    @Enumerated(EnumType.STRING)
    @Column(name = "groupe")
    private Groupe groupe;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Equipe nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbrJoueurs() {
        return nbrJoueurs;
    }

    public Equipe nbrJoueurs(Integer nbrJoueurs) {
        this.nbrJoueurs = nbrJoueurs;
        return this;
    }

    public void setNbrJoueurs(Integer nbrJoueurs) {
        this.nbrJoueurs = nbrJoueurs;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public Equipe groupe(Groupe groupe) {
        this.groupe = groupe;
        return this;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Equipe)) {
            return false;
        }
        return id != null && id.equals(((Equipe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Equipe{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", nbrJoueurs=" + getNbrJoueurs() +
            ", groupe='" + getGroupe() + "'" +
            "}";
    }
}
