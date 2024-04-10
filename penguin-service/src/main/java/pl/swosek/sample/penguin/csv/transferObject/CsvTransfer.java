package pl.swosek.sample.penguin.csv.transferObject;

import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.swosek.sample.penguin.csv.bean.PenguinCsvBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Transfer object.
 */
@Setter
@NoArgsConstructor
public class CsvTransfer {

    /**
     * List of csv beans.
     */
    private List<PenguinCsvBean> csvList;

    public List<PenguinCsvBean> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<>();
    }

}
