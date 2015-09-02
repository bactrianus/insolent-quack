package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Path;

public class GetWorksheetCount {

    public static void main(String... args) throws IOException {
        Path inputFile = Common.getPath(GetWorksheetCount.class, "Sample.xlsx");

        Common.getStorageSdk().PutCreate(
                inputFile.getFileName().toString(),
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.WorksheetsResponse wr
                = Common.getCellsSdk().GetWorkSheets(
                        inputFile.getFileName().toString(),
                        Common.STORAGE,
                        null
                );

        System.out.println("Count: " + wr.getWorksheets().getWorksheetList().size());
    }
}
