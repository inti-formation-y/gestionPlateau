package fr.formation.inti.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import fr.formation.inti.domain.enumeration.Section;

/**
 * A Categorie.
 */
@Entity
@Table(name = "categorie")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "section")
    private Section section;

    @Column(name = "descrition")
    private String descrition;

    @ManyToOne
    @JsonIgnoreProperties("categories")
    private Club club;

    @ManyToOne
    @JsonIgnoreProperties("categories")
    private Referent referent;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Section getSection() {
        return section;
    }

    public Categorie section(Section section) {
        this.section = section;
        return this;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getDescrition() {
        return descrition;
    }

    public Categorie descrition(String descrition) {
        this.descrition = descrition;
        return this;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public Club getClub() {
        return club;
    }

    public Categorie club(Club club) {
        this.club = club;
        return this;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Referent getReferent() {
        return referent;
    }

    public Categorie referent(Referent referent) {
        this.referent = referent;
        return this;
    }

    public void setReferent(Referent referent) {
        this.referent = referent;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Categorie)) {
            return false;
        }
        return id != null && id.equals(((Categorie) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Categorie{" +
            "id=" + getId() +
            ", section='" + getSection() + "'" +
            ", descrition='" + getDescrition() + "'" +
            "}";
    }
}
