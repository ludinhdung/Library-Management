package view;

import controller.DocumentManagement;
import fileIO.ReadFile;
import fileIO.WriteFile;
import model.Book;
import model.Document;
import model.Journal;
import model.Newspaper;
import validation.Validation;

import java.util.List;

public class ConsoleForm {
    DocumentManagement documentManagement = new DocumentManagement();
    List<String> menu = List.of("======== Library Management=======\n" +
            "1. Add document\n" +
            "2. Delete document\n" +
            "3. View document information\n" +
            "4. Write to file\n" +
            "5. Read from file\n" +
            "4. Exit");

    public int getChoice() {
        for (String s : menu) {
            System.out.println(s);
        }
        System.out.print("Enter your choice: ");
        int choice = Validation.inputLimit(1, 5);
        return choice;
    }

    public void createDocument() {
        System.out.println("--------- Add document --------");
        System.out.print("Enter your choice (Please enter 1 to create Books, 2 to create Journal, 3 to create Newspapers): ");
        int type = Validation.inputLimit(1, 3);
        System.out.print("Enter Document ID: ");
        String id = Validation.inputID(documentManagement);
        System.out.print("Enter Publisher Name: ");
        String publisherName = Validation.inputString();
        System.out.print("Enter Issue Number: ");
        String issueNumber = Validation.inputString();
        switch (type) {
            case 1 -> {
                System.out.print("Enter Author Name: ");
                String authorName = Validation.inputString();
                System.out.print("Enter Page Number: ");
                int pageNumber = Validation.inputPositiveNumber();
                Book book = new Book(id, publisherName, issueNumber, authorName, pageNumber);
                documentManagement.add(book);
            }
            case 2 -> {
                System.out.print("Enter issue month: ");
                String issueMonth = Validation.inputMonth();
                Journal journal = new Journal(id, publisherName, issueNumber, issueMonth);
                documentManagement.add(journal);
            }
            case 3 -> {
                System.out.print("Enter issue date: ");
                String issueDate = Validation.inputDate();
                Newspaper newspaper = new Newspaper(id, publisherName, issueNumber, issueDate);
                documentManagement.add(newspaper);
            }
        }
        System.out.println("Input successful");
    }

    public void deleteDocument() {
        System.out.println("------- Delete document --------");
        System.out.print("Enter Code: ");
        String id = Validation.inputString();
        if (documentManagement.delete(id)) System.out.println("Delete successful");
        else System.out.println("Not found");
    }

    public void listDocument() {
        System.out.println("------- View document information --------");
        for (Document document : documentManagement.getDocumentsList()) {
            System.out.println(document);
        }
    }

    public void writeFile() {
        WriteFile.writeDocumentsToFile(documentManagement.getDocumentsList());
        System.out.println("Done write to file ListDocument.csv");
    }

    public void readFile() {
        for (Document document : ReadFile.readDocumentList()) {
            System.out.println(document);
        }
    }


    public void execute() {
        while (true) {
            int choice = getChoice();
            switch (choice) {
                case 1 -> createDocument();
                case 2 -> deleteDocument();
                case 3 -> listDocument();
                case 4 -> writeFile();
                case 5 -> readFile();
                case 6 -> System.exit(0);
            }
        }
    }
}
