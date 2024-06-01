package com.tliner.worstFilm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tliner.worstFilm.dto.PrizeRangeDTO;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmProducerService filmProducerService;

    @Override
    public PrizeRangeDTO XXXfindWinningProducersWithMinAndMaxRange() {

        return filmProducerService.findPrizeRangeMinAndMax();

    }

}
