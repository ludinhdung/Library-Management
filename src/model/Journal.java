package model;

public class Journal extends Document {
    private String issueMonth;

    public Journal() {
    }

    public void setIssueMonth(String issueMonth) {
        this.issueMonth = issueMonth;
    }

    public String getIssueMonth() {
        return issueMonth;
    }

    public Journal(String id, String publisherName, String issueNumber, String issueMonth) {
        super(id, publisherName, issueNumber);
        this.issueMonth = issueMonth;
    }

    @Override
    public String toString() {
        return String.format("Journal ID: %s, Publisher Name: %s, Issue Number: %s, Issue Month: %s",
                getId(), getPublisherName(), getIssueNumber(), issueMonth);
    }

}
