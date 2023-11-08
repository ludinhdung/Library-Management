package fileIO;

import model.Book;
import model.Document;
import model.Journal;
import model.Newspaper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    private static final String FILE_PATH = "src\\ListDocument.csv";

    public static void writeDocumentsToFile(List<Document> documents) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(FILE_PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(documents);

        } catch (Exception e) {
            System.err.println("Error writing the document file: " + e.getMessage());
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing output streams: " + e.getMessage());
            }
        }
    }
}
