package com.aspose.cells.cloud.examples.workbook;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DecryptWorkbook {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        String output = "Sample2.xlsx";
        Path inputFile = Common.getPath(DecryptWorkbook.class, input);
        Path outputFile = Common.getPath(DecryptWorkbook.class, output);

        com.aspose.cells.model.WorkbookEncryptionRequest properties = new com.aspose.cells.model.WorkbookEncryptionRequest();
        properties.setEncryptionType("XOR");
        properties.setPassword("12345678");
        properties.setKeyLength(128);

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        Common.getCellsSdk().DeleteDecryptDocument(
                input,
                Common.STORAGE,
                null,
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
