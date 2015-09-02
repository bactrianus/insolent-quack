package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Path;

public class GetColumn {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        Path inputFile = Common.getPath(GetColumn.class, input);
        String sheet = "Sheet1";
        int index = 0;

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.ColumnResponse r
                = Common.getCellsSdk().GetWorksheetColumn(
                        inputFile.getFileName().toString(),
                        sheet,
                        index,
                        Common.STORAGE,
                        null
                );

        System.out.println("Column: " + r.getColumn().getLink().getHref());
    }
}
