package com.tliner.worstFilm.dto;

import java.util.Objects;

public class ProducerDTO {

    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    public ProducerDTO() {
    }

    public ProducerDTO(String producer, Integer interval, Integer previousWin, Integer followingWin) {
        this.producer = producer;
        this.interval = interval;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
    }

    public String getProducer() {
        return this.producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getInterval() {
        return this.interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getPreviousWin() {
        return this.previousWin;
    }

    public void setPreviousWin(Integer previousWin) {
        this.previousWin = previousWin;
    }

    public Integer getFollowingWin() {
        return this.followingWin;
    }

    public void setFollowingWin(Integer followingWin) {
        this.followingWin = followingWin;
    }

    public ProducerDTO producer(String producer) {
        setProducer(producer);
        return this;
    }

    public ProducerDTO interval(Integer interval) {
        setInterval(interval);
        return this;
    }

    public ProducerDTO previousWin(Integer previousWin) {
        setPreviousWin(previousWin);
        return this;
    }

    public ProducerDTO followingWin(Integer followingWin) {
        setFollowingWin(followingWin);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProducerDTO)) {
            return false;
        }
        ProducerDTO producerDTO = (ProducerDTO) o;
        return Objects.equals(producer, producerDTO.producer) && Objects.equals(interval, producerDTO.interval) && Objects.equals(previousWin, producerDTO.previousWin) && Objects.equals(followingWin, producerDTO.followingWin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, interval, previousWin, followingWin);
    }

    @Override
    public String toString() {
        return "{" +
            " producer='" + getProducer() + "'" +
            ", interval='" + getInterval() + "'" +
            ", previousWin='" + getPreviousWin() + "'" +
            ", followingWin='" + getFollowingWin() + "'" +
            "}";
    }

}
