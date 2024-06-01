package com.tliner.worstFilm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tliner.worstFilm.dto.PrizeRangeDTO;
import com.tliner.worstFilm.service.FilmProducerService;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmProducerService filmProducerService;
    
    @GetMapping(path = "/findWinningProducersWithMinAndMaxRange")
    public ResponseEntity<PrizeRangeDTO> getWinningProducersWithMinAndMaxRange(){
        return ResponseEntity.ok().body(filmProducerService.findPrizeRangeMinAndMax())  ;
    }

}
