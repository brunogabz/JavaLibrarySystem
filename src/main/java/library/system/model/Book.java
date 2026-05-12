package library.system.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String title, String author, String isbn, int publicationYear){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setId(int id) {
        this.id = id;
    }
}
