package controller;

import model.Document;

import java.util.ArrayList;

public class DocumentManagement {
    ArrayList<Document> list = new ArrayList<>();

    public DocumentManagement() {
    }

    public DocumentManagement(ArrayList<Document> documentsList) {
        this.list = documentsList;
    }

    public ArrayList<Document> getDocumentsList() {
        return list;
    }

    public void setDocumentsList(ArrayList<Document> documentsList) {
        this.list = documentsList;
    }

    public boolean checkID(String id) {
        for (Document document : list) {
            if (document.getId().equals(id)) return false;
        }
        return true;
    }

    public void add(Document document) {
        list.add(document);
    }

    public boolean delete(String id) {
        for (Document document : list) {
            if (document.getId().equals(id)) {
                list.remove(document);
                return true;
            }
        }
        return false;
    }
}

