package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MoveWorksheet {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        String output = "Sample2.xlsx";
        Path inputFile = Common.getPath(MoveWorksheet.class, input);
        Path outputFile = Common.getPath(MoveWorksheet.class, output);
        String sheet = "Sheet2";
        com.aspose.cells.model.WorksheetMovingRequest move = new com.aspose.cells.model.WorksheetMovingRequest();
        move.setDestinationWorksheet("Sheet5");
        move.setPosition("after");

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.WorksheetsResponse wr
                = Common.getCellsSdk().PostMoveWorksheet(
                        input,
                        sheet,
                        Common.STORAGE,
                        null,
                        move
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
