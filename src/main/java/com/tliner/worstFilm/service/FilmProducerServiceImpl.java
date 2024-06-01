package com.tliner.worstFilm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tliner.worstFilm.dto.PrizeRangeDTO;
import com.tliner.worstFilm.dto.ProducerDTO;
import com.tliner.worstFilm.dto.ProducerIntervalMinMaxDTO;
import com.tliner.worstFilm.dto.ProducerYearsDTO;
import com.tliner.worstFilm.entity.Film;
import com.tliner.worstFilm.repository.FilmRepository;

@Service
public class FilmProducerServiceImpl implements FilmProducerService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public PrizeRangeDTO findPrizeRangeMinAndMax() {

        List<Film> filmList = filmRepository.findByIsWinner(Film.PRODUCER_IS_WINNER);
        Map<String, List<Integer>> multipleProducersMap = getFilmsFromMultipleProducers(filmList);

        List<ProducerYearsDTO> producerYearsDTOList = new ArrayList<>();
        multipleProducersMap.forEach((producer, years) -> producerYearsDTOList.add(new ProducerYearsDTO(producer, years, new ArrayList<>(), new ArrayList<>(),new ArrayList<>())));

        producerYearsDTOList.removeIf(p -> p.getYears().size() <= 1);

        List<ProducerYearsDTO> producerYearsMinAndMaxIntervalDTOList = calculateMinAndMaxIntervalPerProducer(producerYearsDTOList);
        PrizeRangeDTO prizeRangeDTO = getResponsePrizeRange(producerYearsMinAndMaxIntervalDTOList);

        return prizeRangeDTO;
    }

    private List<ProducerYearsDTO> calculateMinAndMaxIntervalPerProducer(List<ProducerYearsDTO> producerYearsDTOList) {

        for (ProducerYearsDTO producerYearsDTO : producerYearsDTOList) {
            
            List<Integer> years = producerYearsDTO.getYears();
            years.sort(Integer::compareTo);

            for (int i = 0; i < years.size() -1; i++) {
                
                int yearCurrent = years.get(i);
                int yearNext = years.get(i + 1);
                int internal = yearNext - yearCurrent;

                producerYearsDTO.getInterval().add(new ProducerIntervalMinMaxDTO(internal, yearCurrent, yearNext));

            }

            producerYearsDTO.setIntervalMin(getMinInterval(producerYearsDTO.getInterval()));
            producerYearsDTO.setIntervalMax(getMaxInterval(producerYearsDTO.getInterval()));
        }
        return producerYearsDTOList;
    }

    private List<ProducerIntervalMinMaxDTO> getMinInterval(List<ProducerIntervalMinMaxDTO> producers) {
        return calculateInterval(producers, Comparator.naturalOrder());
    }
    private List<ProducerIntervalMinMaxDTO> getMaxInterval(List<ProducerIntervalMinMaxDTO> producers) {
        return calculateInterval(producers, Comparator.reverseOrder());
    }
    
    private List<ProducerIntervalMinMaxDTO> calculateInterval (List<ProducerIntervalMinMaxDTO> producers, Comparator<Integer> comparator) {

        Optional<Integer> extremeInterval = producers.stream()
                .map(ProducerIntervalMinMaxDTO::getInterval)
                .min(comparator);

        if (!extremeInterval.isPresent()) {
            return Collections.emptyList();
        }

        final Integer extremeValue = extremeInterval.get();

        return producers.stream()
                .filter(p -> p.getInterval().equals(extremeValue))
                .collect(Collectors.toList());
    }

    private Map<String, List<Integer>> getFilmsFromMultipleProducers(List<Film> filmList) {

        Map<String, List<Integer>> multipleProducersMap = new HashMap<>();
        
        filmList.forEach(film -> {
            String[] producers = film.getProducers().split(", | and |, and ");
            for (String producer : producers) {
                String producerName = producer.trim().replace("and", "").trim();
                multipleProducersMap.computeIfAbsent(producerName, k -> new ArrayList<>()).add(film.getYear());
            }
        });

        return multipleProducersMap;

    }
    
    private PrizeRangeDTO getResponsePrizeRange(List<ProducerYearsDTO> producerYearsMinAndMaxIntervalDTOList) {
        
        List<ProducerDTO> producerDTOMinList = new ArrayList<>();
        List<ProducerDTO> producerDTOMaxList = new ArrayList<>();

        producerYearsMinAndMaxIntervalDTOList.forEach( producerYears -> {
            producerYears.getIntervalMin().forEach( min -> {
                producerDTOMinList.add(new ProducerDTO(producerYears.getProducers(), min.getInterval(), min.getPreviousWin(), min.getFollowingWin()));
            });
        });

        producerYearsMinAndMaxIntervalDTOList.forEach( producerYears -> {
            producerYears.getIntervalMin().forEach( max -> {
                producerDTOMaxList.add(new ProducerDTO(producerYears.getProducers(), max.getInterval(), max.getPreviousWin(), max.getFollowingWin()));
            });
        });

        return new PrizeRangeDTO(getProducerMinInterval(producerDTOMinList), getProducerMaxInterval(producerDTOMaxList));

    }

    private List<ProducerDTO> getProducerMinInterval(List<ProducerDTO> producerDTOList) {
        
        Optional<Integer> min = producerDTOList.stream()
                                .map(ProducerDTO::getInterval)
                                .min(Comparator.naturalOrder());

        if (!min.isPresent()) {
            return new ArrayList<>();
        }

        return producersByInterval(producerDTOList, min.get());

    }
    
    private List<ProducerDTO> getProducerMaxInterval(List<ProducerDTO> producerDTOList) {

        Optional<Integer> max = producerDTOList.stream()
                                .map(ProducerDTO::getInterval)
                                .max(Comparator.naturalOrder());
                                
        if (!max.isPresent()) {
            return new ArrayList<>();
        }

        return producersByInterval(producerDTOList, max.get());

    }

    private  List<ProducerDTO> producersByInterval(List<ProducerDTO> producersList, int interval) {

        List<ProducerDTO> producersByInterval = new ArrayList<>();

        for (ProducerDTO producerDTO : producersList) {
            if (producerDTO.getInterval() == interval) {
                producersByInterval.add(producerDTO);
            }
        }

        return producersByInterval;

    }

}
