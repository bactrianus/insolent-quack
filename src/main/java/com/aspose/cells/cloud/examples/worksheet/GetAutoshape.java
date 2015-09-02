package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Path;

public class GetAutoshape {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        Path inputFile = Common.getPath(GetAutoshape.class, input);
        String sheet = "Sheet1";
        int autoshape = 0;

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.AutoShapeResponse ar
                = Common.getCellsSdk().GetWorksheetAutoshape(
                        inputFile.getFileName().toString(),
                        sheet,
                        autoshape,
                        Common.STORAGE,
                        null
                );

        System.out.println("Autoshape HTML: " + ar.getAutoShape().getHtmlText());
    }
}
