package model;

public class Book extends Document {
    private String authorName;
    private int pageNumber;

    public Book() {
    }

    public Book(String id, String publisherName, String issueNumber, String authorName, int pageNumber) {
        super(id, publisherName, issueNumber);
        this.authorName = authorName;
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return String.format("Book ID: %s, Publisher Name: %s, Issue Number: %s, Author Name: %s, Page Number: %d",
                getId(), getPublisherName(), getIssueNumber(), authorName, pageNumber);
    }


}
