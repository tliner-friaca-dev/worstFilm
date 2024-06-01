package com.tliner.worstFilm.dto;

import java.util.Objects;
public class ProducerIntervalMinMaxDTO {
    
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    public ProducerIntervalMinMaxDTO() {
    }

    public ProducerIntervalMinMaxDTO(Integer interval, Integer previousWin, Integer followingWin) {
        this.interval = interval;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
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

    public ProducerIntervalMinMaxDTO interval(Integer interval) {
        setInterval(interval);
        return this;
    }

    public ProducerIntervalMinMaxDTO previousWin(Integer previousWin) {
        setPreviousWin(previousWin);
        return this;
    }

    public ProducerIntervalMinMaxDTO followingWin(Integer followingWin) {
        setFollowingWin(followingWin);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProducerIntervalMinMaxDTO)) {
            return false;
        }
        ProducerIntervalMinMaxDTO producerIntervalMinMaxDTO = (ProducerIntervalMinMaxDTO) o;
        return Objects.equals(interval, producerIntervalMinMaxDTO.interval) && Objects.equals(previousWin, producerIntervalMinMaxDTO.previousWin) && Objects.equals(followingWin, producerIntervalMinMaxDTO.followingWin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interval, previousWin, followingWin);
    }

    @Override
    public String toString() {
        return "{" +
            " interval='" + getInterval() + "'" +
            ", previousWin='" + getPreviousWin() + "'" +
            ", followingWin='" + getFollowingWin() + "'" +
            "}";
    }

}
