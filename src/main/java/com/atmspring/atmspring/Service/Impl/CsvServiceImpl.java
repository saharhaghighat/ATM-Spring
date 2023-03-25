package com.atmspring.atmspring.Service.Impl;

import com.atmspring.atmspring.Service.CsvService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvServiceImpl implements CsvService {
    @Override
    public void writer(String[] header, List<String[]> data, String name) throws IOException {

        Writer writer = Files.newBufferedWriter(Path.of("C://Users//Dell//IdeaProjects//ATM-System" + name + ".csv"));


        ICSVWriter csvWriter = new CSVWriterBuilder(writer)
                .build();

        // write header record
        csvWriter.writeNext(header);

        csvWriter.writeAll(data);

        // close writers
        csvWriter.close();
        writer.close();
    }


    public void reader(Path path) {

    }
}
