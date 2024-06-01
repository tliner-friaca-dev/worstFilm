package com.tliner.worstFilm.service;

import com.tliner.worstFilm.dto.PrizeRangeDTO;

public interface FilmProducerService {

    PrizeRangeDTO findPrizeRangeMinAndMax();

}
