package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class UnhideWorksheet {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        String output = "Sample2.xlsx";
        Path inputFile = Common.getPath(UnhideWorksheet.class, input);
        Path outputFile = Common.getPath(UnhideWorksheet.class, output);
        String sheet = "Sheet1";
        boolean isVisible = true;

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.WorksheetResponse wr
                = Common.getCellsSdk().PutChangeVisibilityWorksheet(
                        input,
                        sheet,
                        isVisible,
                        Common.STORAGE,
                        null
                );

        System.out.println("Visibility Type: " + wr.getWorksheet().getVisibilityType());

        com.aspose.storage.model.ResponseMessage sr
                = Common.getStorageSdk().GetDownload(
                        input,
                        null,
                        Common.STORAGE
                );

        Files.copy(sr.getInputStream(), outputFile, StandardCopyOption.REPLACE_EXISTING);

    }
}
