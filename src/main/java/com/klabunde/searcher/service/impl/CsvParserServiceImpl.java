package com.klabunde.searcher.service.impl;

import com.klabunde.searcher.model.Cuisine;
import com.klabunde.searcher.model.Restaurant;
import com.klabunde.searcher.service.CsvParserService;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CsvParserServiceImpl implements CsvParserService {

    private static final Logger logger = LoggerFactory.getLogger(CsvParserServiceImpl.class);

    @Override
    public <T> List<T> parseToList(InputStream fileStream, Class<T> clazz) {
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileStream));
            return new CSVReaderBuilder(fileReader)
                    .withSkipLines(1)
                    .build()
                    .readAll()
                    .stream()
                    .map(line -> parseLine(line, clazz))
                    .toList();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        return new ArrayList<>();
    }

    private <T> T parseLine(String[] line, Class<T> clazz) {
        if (Restaurant.class.equals(clazz)) {
            return (T) parseLineToRestaurant(line);
        } else if (Cuisine.class.equals(clazz)) {
            return (T) parseLineToCuisine(line);
        }
        return null;
    }

    private Restaurant parseLineToRestaurant(String[] line) {
        return new Restaurant(line[0],
                Long.parseLong(line[1]),
                Long.parseLong(line[2]),
                Long.parseLong(line[3]),
                new Cuisine(Long.parseLong(line[4])));
    }

    private Cuisine parseLineToCuisine(String[] line) {
        return new Cuisine(Long.parseLong(line[0]), line[1]);
    }
}
