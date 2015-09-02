package com.aspose.cells.cloud.examples.workbook;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class CreateEmptyWorkbook {

    public static void main(String... args) throws IOException {
        String output = "Sample-" + UUID.randomUUID().toString() + ".xlsx";
        Path outputFile = Common.getPath(CreateEmptyWorkbook.class, output);

        Common.getCellsSdk().PutWorkbookCreate(
                output,
                null,
                null,
                Common.STORAGE,
                null,
                null
        );

        com.aspose.storage.model.ResponseMessage sr
                = Common.getStorageSdk().GetDownload(
                        output,
                        null,
                        Common.STORAGE
                );

        Files.copy(sr.getInputStream(), outputFile, StandardCopyOption.REPLACE_EXISTING);

    }
}
