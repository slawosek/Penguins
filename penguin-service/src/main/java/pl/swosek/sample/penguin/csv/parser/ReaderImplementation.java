package pl.swosek.sample.penguin.csv.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;
import pl.swosek.sample.penguin.csv.transferObject.CsvTransfer;

import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * Csv bean reader implementation.
 */
@Service
public class ReaderImplementation {

    /**
     * Path to data.
     */
    public static final String PATH_TO_DATA_SOURCE = "data/Data.csv";

    /**
     *
     * @return instance of csv bean
     * @throws Exception exceptions from parsing csv file
     */
    public List<PenguinCsvBean> readDataFromCsv() throws Exception {
        CsvTransfer csvTransfer = new CsvTransfer();
        URI res = Objects.requireNonNull(getClass().getClassLoader().getResource(PATH_TO_DATA_SOURCE)).toURI();
        try (Reader reader = Files.newBufferedReader(Path.of(res))) {
            CsvToBean<PenguinCsvBean> csvToBean = new CsvToBeanBuilder<PenguinCsvBean>(reader)
                    .withType(PenguinCsvBean.class)
                    .build();
            csvTransfer.setCsvList(csvToBean.parse());
        }
        return csvTransfer.getCsvList();
    }

}
