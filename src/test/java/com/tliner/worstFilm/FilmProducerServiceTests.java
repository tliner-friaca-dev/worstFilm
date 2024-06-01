package com.tliner.worstFilm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tliner.worstFilm.dto.PrizeRangeDTO;
import com.tliner.worstFilm.dto.ProducerDTO;
import com.tliner.worstFilm.service.FilmProducerService;

@SpringBootTest
class FilmProducerServiceTests {

	@Autowired
	private FilmProducerService filmProducerService;

	@Test
	public void test_findPrizeRangeMinAndMax_successfully() {

		ProducerDTO producerDTOMin = new ProducerDTO("Joel Silver", 1, 1990, 1991);
        ProducerDTO producerDTOMax = new ProducerDTO("Matthew Vaughn", 13, 2002, 2015);

        List<ProducerDTO> producerDTOMinList = Collections.singletonList(producerDTOMin);
        List<ProducerDTO> producerDTOMaxList = Collections.singletonList(producerDTOMax);

        PrizeRangeDTO expectedProducerDTO = new PrizeRangeDTO(producerDTOMinList, producerDTOMaxList);
        PrizeRangeDTO returnProducerDTO = filmProducerService.findPrizeRangeMinAndMax();

        assertEquals(expectedProducerDTO.getMin().get(0).getProducer(), returnProducerDTO.getMin().get(0).getProducer());
        assertEquals(expectedProducerDTO.getMin().get(0).getInterval(), returnProducerDTO.getMin().get(0).getInterval());
        assertEquals(expectedProducerDTO.getMin().get(0).getPreviousWin(), returnProducerDTO.getMin().get(0).getPreviousWin());
        assertEquals(expectedProducerDTO.getMin().get(0).getFollowingWin(), returnProducerDTO.getMin().get(0).getFollowingWin());

        assertEquals(expectedProducerDTO.getMax().get(0).getProducer(), returnProducerDTO.getMax().get(0).getProducer());
        assertEquals(expectedProducerDTO.getMax().get(0).getInterval(), returnProducerDTO.getMax().get(0).getInterval());
        assertEquals(expectedProducerDTO.getMax().get(0).getPreviousWin(), returnProducerDTO.getMax().get(0).getPreviousWin());
        assertEquals(expectedProducerDTO.getMax().get(0).getFollowingWin(), returnProducerDTO.getMax().get(0).getFollowingWin());
	}
}
