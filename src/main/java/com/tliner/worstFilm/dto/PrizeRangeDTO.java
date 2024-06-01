package com.tliner.worstFilm.dto;

import java.util.List;

import java.util.Objects;

public class PrizeRangeDTO {

    private List<ProducerDTO> min;
    private List<ProducerDTO> max;

    public PrizeRangeDTO() {
    }

    public PrizeRangeDTO(List<ProducerDTO> min, List<ProducerDTO> max) {
        this.min = min;
        this.max = max;
    }

    public List<ProducerDTO> getMin() {
        return this.min;
    }

    public void setMin(List<ProducerDTO> min) {
        this.min = min;
    }

    public List<ProducerDTO> getMax() {
        return this.max;
    }

    public void setMax(List<ProducerDTO> max) {
        this.max = max;
    }

    public PrizeRangeDTO min(List<ProducerDTO> min) {
        setMin(min);
        return this;
    }

    public PrizeRangeDTO max(List<ProducerDTO> max) {
        setMax(max);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PrizeRangeDTO)) {
            return false;
        }
        PrizeRangeDTO prizeRangeDTO = (PrizeRangeDTO) o;
        return Objects.equals(min, prizeRangeDTO.min) && Objects.equals(max, prizeRangeDTO.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        return "{" +
            " min='" + getMin() + "'" +
            ", max='" + getMax() + "'" +
            "}";
    }
    
}
