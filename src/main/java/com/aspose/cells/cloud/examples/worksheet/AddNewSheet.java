package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class AddNewSheet {

    public static void main(String... args) throws IOException {
        Path inputFile = Common.getPath(AddNewSheet.class, "Sample.xlsx");
        Path outputFile = Common.getPath(AddNewSheet.class, "Sample2.xlsx");

        Common.getStorageSdk().PutCreate(
                inputFile.getFileName().toString(),
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        Common.getCellsSdk().PutAddNewWorksheet(
                inputFile.getFileName().toString(),
                "NewSheet",
                Common.STORAGE,
                null
        );

        com.aspose.storage.model.ResponseMessage sr
                = Common.getStorageSdk().GetDownload(
                        inputFile.getFileName().toString(),
                        null,
                        Common.STORAGE
                );

        Files.copy(sr.getInputStream(), outputFile, StandardCopyOption.REPLACE_EXISTING);

    }
}
