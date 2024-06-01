package com.tliner.worstFilm.dto;

import java.util.List;
import java.util.Objects;

public class ProducerYearsDTO {
    private String producers;
    private List<Integer> years;

    private List<ProducerIntervalMinMaxDTO> interval;
    private List<ProducerIntervalMinMaxDTO> intervalMin;
    private List<ProducerIntervalMinMaxDTO> intervalMax;

    public ProducerYearsDTO() {
    }

    public ProducerYearsDTO(String producers, List<Integer> years, List<ProducerIntervalMinMaxDTO> interval, List<ProducerIntervalMinMaxDTO> intervalMin, List<ProducerIntervalMinMaxDTO> intervalMax) {
        this.producers = producers;
        this.years = years;
        this.interval = interval;
        this.intervalMin = intervalMin;
        this.intervalMax = intervalMax;
    }

    public String getProducers() {
        return this.producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public List<Integer> getYears() {
        return this.years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<ProducerIntervalMinMaxDTO> getInterval() {
        return this.interval;
    }

    public void setInterval(List<ProducerIntervalMinMaxDTO> interval) {
        this.interval = interval;
    }

    public List<ProducerIntervalMinMaxDTO> getIntervalMin() {
        return this.intervalMin;
    }

    public void setIntervalMin(List<ProducerIntervalMinMaxDTO> intervalMin) {
        this.intervalMin = intervalMin;
    }

    public List<ProducerIntervalMinMaxDTO> getIntervalMax() {
        return this.intervalMax;
    }

    public void setIntervalMax(List<ProducerIntervalMinMaxDTO> intervalMax) {
        this.intervalMax = intervalMax;
    }

    public ProducerYearsDTO producers(String producers) {
        setProducers(producers);
        return this;
    }

    public ProducerYearsDTO years(List<Integer> years) {
        setYears(years);
        return this;
    }

    public ProducerYearsDTO interval(List<ProducerIntervalMinMaxDTO> interval) {
        setInterval(interval);
        return this;
    }

    public ProducerYearsDTO intervalMin(List<ProducerIntervalMinMaxDTO> intervalMin) {
        setIntervalMin(intervalMin);
        return this;
    }

    public ProducerYearsDTO intervalMax(List<ProducerIntervalMinMaxDTO> intervalMax) {
        setIntervalMax(intervalMax);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProducerYearsDTO)) {
            return false;
        }
        ProducerYearsDTO producerYearsDTO = (ProducerYearsDTO) o;
        return Objects.equals(producers, producerYearsDTO.producers) && Objects.equals(years, producerYearsDTO.years) && Objects.equals(interval, producerYearsDTO.interval) && Objects.equals(intervalMin, producerYearsDTO.intervalMin) && Objects.equals(intervalMax, producerYearsDTO.intervalMax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producers, years, interval, intervalMin, intervalMax);
    }

    @Override
    public String toString() {
        return "{" +
            " producers='" + getProducers() + "'" +
            ", years='" + getYears() + "'" +
            ", interval='" + getInterval() + "'" +
            ", intervalMin='" + getIntervalMin() + "'" +
            ", intervalMax='" + getIntervalMax() + "'" +
            "}";
    }
    
}
