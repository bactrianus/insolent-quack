package com.aspose.cells.cloud.examples.worksheet;

import com.aspose.cells.cloud.examples.Common;
import java.io.IOException;
import java.nio.file.Path;

public class GetComment {

    public static void main(String... args) throws IOException {
        String input = "Sample1.xlsx";
        Path inputFile = Common.getPath(GetComment.class, input);
        String sheet = "Sheet1";
        String cell = "A1";

        Common.getStorageSdk().PutCreate(
                input,
                null,
                Common.STORAGE,
                inputFile.toFile()
        );

        com.aspose.cells.model.CommentResponse r
                = Common.getCellsSdk().GetWorkSheetComment(
                        inputFile.getFileName().toString(),
                        sheet,
                        cell,
                        Common.STORAGE,
                        null
                );

        System.out.println("Comment: " + r.getComment().getNote());
    }
}
