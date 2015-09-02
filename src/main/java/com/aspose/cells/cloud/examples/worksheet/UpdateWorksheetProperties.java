package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class UpdateWorksheetProperties {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        String output = "Sample2.xlsx";
        Path inputFile = Common.getPath(UpdateWorksheetProperties.class, input);
        Path outputFile = Common.getPath(UpdateWorksheetProperties.class, output);
        String sheet = "Sheet1";

        com.aspose.cells.model.Worksheet properties = new com.aspose.cells.model.Worksheet();
        properties.setType("Worksheet");
        properties.setName("Sheet1");
        properties.setIsGridlinesVisible(true);
        properties.setIsPageBreakPreview(true);
        properties.setIsRulerVisible(true);

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        Common.getCellsSdk().PostUpdateWorksheetProperty(
                input,
                sheet,
                null,
                Common.STORAGE,
                properties
        );

        com.aspose.storage.model.ResponseMessage sr
                = Common.getStorageSdk().GetDownload(
                        input,
                        null,
                        Common.STORAGE
                );

        Files.copy(sr.getInputStream(), outputFile, StandardCopyOption.REPLACE_EXISTING);

    }
}
