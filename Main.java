class Book {
    protected String title;
    protected String author;
    protected int publishedYear;

    public Book (String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }


    public String getBookInfo () {
        return "Author " + author + ". Title: " + title + ". Year published: " + publishedYear + ".";
    }

    public void printBookDetails () {
        System.out.println(getBookInfo());
    }


}

class PrintedBook extends Book {

    protected int numOfPages;
    protected String publisher;

    public PrintedBook(String title, String author, int publishedYear, int numOfPages, String publisher) {
        super(title, author, publishedYear);
        this.numOfPages = numOfPages;
        this.publisher = publisher;
    }

    @Override
    public String getBookInfo () {
        return super.getBookInfo() + ". Pages" + numOfPages + ". Publisher: " + publisher;
    }

    @Override
    public void printBookDetails () {
        System.out.println(getBookInfo());
    }

    public void BookType () {
        System.out.println("This is a printed book");
    }

}

class EBook extends Book {
    protected double fileSizeMB;
    protected String fileFormat;

    public EBook (String title, String author, int publishedYear, double fileSizeMB, String fileFormat) {
        super(title, author, publishedYear);
        this.fileSizeMB = fileSizeMB;
        this.fileFormat = fileFormat;
    }

    @Override
    public String getBookInfo() {
        return super.getBookInfo() + ". File size: " + fileSizeMB + ". File Format: " + fileFormat;
    }

    @Override
    public void printBookDetails (){
        System.out.println(getBookInfo());
    }

    public void BookType () {
        System.out.println("This is an ebook");
    }
}





public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Jamilya", "Aitmatov", 2024);
        System.out.println(b1.getBookInfo());
        b1.printBookDetails();

        PrintedBook b2 = new PrintedBook("Plaha", "Aitmatov", 2023, 2000, "Baistan");
        b2.getBookInfo();
        b2.printBookDetails();
        b2.BookType();

        EBook b3 = new EBook("Gory", "Aitmatov", 2020, 8.0, "pdf");
        b3.printBookDetails();
        b3.BookType();
    }
}