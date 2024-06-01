package com.tliner.worstFilm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="film")
public class Film {

    public static final Boolean PRODUCER_IS_WINNER = Boolean.TRUE;

    @Id
    @Column(name = "id_film", length = 23, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "year_film")
    private Integer year;
    
    @Column
    private String title;
    
    @Column
    private String studios;
    
    @Column
    private String producers;
    
    @Column
    private Boolean isWinner;

    public Film() {
    }

    public Film(Long id, Integer year, String title, String studios, String producers, Boolean isWinner) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.studios = studios;
        this.producers = producers;
        this.isWinner = isWinner;
    }

    public Film(Integer year, String title, String studios, String producers, Boolean isWinner) {
        this.year = year;
        this.title = title;
        this.studios = studios;
        this.producers = producers;
        this.isWinner = isWinner;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudios() {
        return this.studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getProducers() {
        return this.producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public Boolean isIsWinner() {
        return this.isWinner;
    }

    public Boolean getIsWinner() {
        return this.isWinner;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    public Film id(Long id) {
        setId(id);
        return this;
    }

    public Film year(Integer year) {
        setYear(year);
        return this;
    }

    public Film title(String title) {
        setTitle(title);
        return this;
    }

    public Film studios(String studios) {
        setStudios(studios);
        return this;
    }

    public Film producers(String producers) {
        setProducers(producers);
        return this;
    }

    public Film isWinner(Boolean isWinner) {
        setIsWinner(isWinner);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Film)) {
            return false;
        }
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(year, film.year) && Objects.equals(title, film.title) && Objects.equals(studios, film.studios) && Objects.equals(producers, film.producers) && Objects.equals(isWinner, film.isWinner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, title, studios, producers, isWinner);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", year='" + getYear() + "'" +
            ", title='" + getTitle() + "'" +
            ", studios='" + getStudios() + "'" +
            ", producers='" + getProducers() + "'" +
            ", isWinner='" + isIsWinner() + "'" +
            "}";
    }

}
