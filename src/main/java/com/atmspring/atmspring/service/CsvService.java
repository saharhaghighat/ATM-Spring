package com.atmspring.atmspring.service;

import java.io.IOException;
import java.util.List;

public interface CsvService {
    void writer(String[] header, List<String[]> data, String name) throws IOException;
}
