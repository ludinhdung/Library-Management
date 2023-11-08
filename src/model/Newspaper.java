package model;

public class Newspaper extends Document {
    private String issueDate;

    public Newspaper() {
    }

    public Newspaper(String id, String publisherName, String issueNumber, String issueDate) {
        super(id, publisherName, issueNumber);
        this.issueDate = issueDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return String.format("Newspaper ID: %s, Publisher Name: %s, Issue Number: %s, Issue Date: %s",
                getId(), getPublisherName(), getIssueNumber(), issueDate);
    }

}
