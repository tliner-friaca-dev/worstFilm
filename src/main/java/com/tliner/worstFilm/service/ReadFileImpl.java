package com.tliner.worstFilm.service;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.tliner.worstFilm.entity.Film;
import com.tliner.worstFilm.repository.FilmRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ReadFileImpl implements ReadFile {

    private String[] expectedHeader = {"YEAR", "TITLE", "STUDIOS", "PRODUCERS", "WINNER"};

    @Value("${file.name}")
    private String fileName;

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void databaseLoading() {

        log.info("File reading started");

        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
       
        CSVParser cSVParserBuilder = new CSVParserBuilder()
            .withSeparator(';')
            .build();

        CSVReader reader = new CSVReaderBuilder(fileReader)
            .withCSVParser(cSVParserBuilder)
            .build();

        String[] header = reader.readNext();
        validateHeader(header);

        String[] record = null;

            while ((record = reader.readNext()) != null) {

                Film film = new Film(Integer.parseInt(record[0]), record[1], record[2], record[3], "yes".equals(record[4]));

                filmRepository.save(film);
            }

            reader.close();

        } catch (CsvValidationException e) {
            log.error("Error in the structure of the file to be read: " + fileName);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.error("Error reading the file: " + fileName);
            throw new RuntimeException(e);
        }

    }

    private void validateHeader(String[] header) {
        if (header.length == 0) {
            log.error("File cannot be read, empty header");
            throw new RuntimeException();
        }else{
            int iterable = 0;
            for (String headerSelect : header) {
                if (headerSelect.toUpperCase().equalsIgnoreCase(expectedHeader[iterable].toUpperCase())) {
                    iterable ++;
                }else{
                    log.error("File cannot be read, header error");
                    throw new RuntimeException();
                }
            }
        }
    }

}
