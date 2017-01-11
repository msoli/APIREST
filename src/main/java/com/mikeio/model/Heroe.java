package com.mikeio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

/**
 * Created by SISTEMAS03-PC on 04/01/2017.
 */
@Entity
@Data
@Table(name = "heroe")
public class Heroe {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hero", nullable = false)
    private Integer idHero;

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Basic
    @Column(name = "estatus", nullable = false)
    private Boolean estatus;

    @Basic
    @Column(name = "super_power", nullable = false, length = 100)
    private String superPower;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Heroe heroe = (Heroe) o;

        if (idHero != null ? !idHero.equals(heroe.idHero) : heroe.idHero != null) return false;
        if (name != null ? !name.equals(heroe.name) : heroe.name != null) return false;
        if (estatus != null ? !estatus.equals(heroe.estatus) : heroe.estatus != null) return false;
        if (superPower != null ? !superPower.equals(heroe.superPower) : heroe.superPower != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHero != null ? idHero.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (estatus != null ? estatus.hashCode() : 0);
        result = 31 * result + (superPower != null ? superPower.hashCode() : 0);
        return result;
    }
}
