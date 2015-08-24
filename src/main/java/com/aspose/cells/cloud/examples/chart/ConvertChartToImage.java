package com.aspose.cells.cloud.examples.chart;

import com.aspose.cells.cloud.examples.Common;
import com.aspose.cells.model.ResponseMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ConvertChartToImage {

    public static void main(String... args) throws IOException {
        Path inputFile = Common.getPath(ConvertChartToImage.class, "Sample.xlsx");
        Path outputFile = Common.getPath(ConvertChartToImage.class, "Chart.png");

        Common.getStorageSdk().PutCreate(
                inputFile.getFileName().toString(),
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        ResponseMessage cr = Common.getCellsSdk().GetWorksheetChartWithFormat(
                inputFile.getFileName().toString(),
                "Sheet1",
                0,
                "png",
                Common.STORAGE,
                null
        );

        Files.copy(cr.getInputStream(), outputFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
