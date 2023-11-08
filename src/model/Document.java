package model;

import java.io.Serializable;

public class Document implements Serializable {
    private String id;
    private String publisherName;
    private String issueNumber;

    public Document(String id, String publisherName, String issueNumber) {
        this.id = id;
        this.publisherName = publisherName;
        this.issueNumber = issueNumber;
    }

    public Document() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

}
