package com.aspose.cells.cloud.examples.workbook;

import com.aspose.cells.cloud.examples.Common;
import com.aspose.cells.model.ResponseMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ConvertToAnotherFormat {

    public static void main(String... args) throws IOException {
        Path inputFile = Common.getPath(ConvertToAnotherFormat.class, "Workbook1.xlsx");
        Path outputFile = Common.getPath(ConvertToAnotherFormat.class, "Workbook1.pdf");

        com.aspose.storage.model.ResponseMessage sr = Common.getStorageSdk().PutCreate(
                inputFile.getFileName().toString(),
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        ResponseMessage cr = Common.getCellsSdk().GetWorkBookWithFormat(
                inputFile.getFileName().toString(),
                "pdf",
                null,
                true,
                null,
                Common.STORAGE,
                null
        );

        Files.copy(cr.getInputStream(), outputFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
