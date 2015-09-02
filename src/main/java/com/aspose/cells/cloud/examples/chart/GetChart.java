package com.aspose.cells.cloud.examples.chart;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Path;

public class GetChart {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        Path inputFile = Common.getPath(GetChart.class, input);
        String sheet = "Sheet1";
        int chart = 0;

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.ChartResponse r
                = Common.getCellsSdk().GetWorksheetChart(
                        input,
                        sheet,
                        chart,
                        Common.STORAGE,
                        null
                );

        System.out.println("Name: " + r.getChart().getName());
        System.out.println("Type: " + r.getChart().getType());
    }
}
