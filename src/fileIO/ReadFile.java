package fileIO;

import model.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private static final String PATH = "src\\ListDocument.csv";

    public static List<Document> readDocumentList() {
        List<Document> documentList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            File file = new File(PATH);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                documentList = (List<Document>) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading the document file: " + e.getMessage());
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing input streams: " + e.getMessage());
            }
        }
        return documentList;
    }
}
