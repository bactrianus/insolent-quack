package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Path;

public class CalculateFormula {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        Path inputFile = Common.getPath(CalculateFormula.class, input);
        String sheet = "Sheet1";
        String formula = "SUM(A1:A10)";

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.SingleValueResponse r
                = Common.getCellsSdk().GetWorkSheetCalculateFormula(
                        inputFile.getFileName().toString(),
                        sheet,
                        formula,
                        Common.STORAGE,
                        null
                );

        System.out.println("Result: " + r.getValue().getValue());
    }
}
