package com.atmspring.atmspring.Service;

import java.io.IOException;
import java.util.List;

public interface CsvService {
    void writer(String[] header, List<String[]> data, String name) throws IOException;
}
