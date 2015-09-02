package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Path;

public class GetValidation {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        Path inputFile = Common.getPath(GetValidation.class, input);
        String sheet = "Sheet1";
        int index = 0;

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.ValidationResponse r
                = Common.getCellsSdk().GetWorkSheetValidation(
                        inputFile.getFileName().toString(),
                        sheet,
                        index,
                        Common.STORAGE,
                        null
                );

        System.out.println("Validation Type: " + r.getValidation().getType());
    }
}
