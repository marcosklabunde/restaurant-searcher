package com.klabunde.searcher.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

@Service
public interface CsvParserService {

    <T> List<T> parseToList(InputStream fileStream, Class<T> clazz);
}
