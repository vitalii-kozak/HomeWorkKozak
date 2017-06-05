import java.util.Objects;

/**
 * Created by Tigra on 26.05.2017.
 */
public class Book {

    private static int id = 0;
    private String name;
    private String author;
    private  String publishing;
    private  int year;
    private  int numberOfPages;
    private  double price;
    private int typeOfBookCover;

    public Book(String name, String author, String publishing, int year, int numberOfPages, double price, int typeOfBookCover) {
        this.name = name;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.typeOfBookCover = typeOfBookCover;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publishing, year, numberOfPages, price, typeOfBookCover);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Book.id = id;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getPublishing() {
        return publishing;
    }

    public Book setPublishing(String publishing) {
        this.publishing = publishing;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Book setYear(int year) {
        this.year = year;
        return this;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Book setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Book setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getTypeOfBookCover() {
        return typeOfBookCover;
    }

    public Book setTypeOfBookCover(int typeOfBookCover) {
        this.typeOfBookCover = typeOfBookCover;
        return this;
    }

    @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year &&
               numberOfPages == book.numberOfPages &&
               price == book.price &&
               typeOfBookCover == book.typeOfBookCover &&
               Objects.equals(name, book.name) &&
               Objects.equals(author, book.author) &&
               Objects.equals(publishing, book.publishing);
    }
     @Override
     public String toString() {
         return "Book {" + "id=" + id +
                 ", name='" + name + '\'' +
                 ", author='" + author + '\'' +
                 ", publishing='" + publishing + '\'' +
                 ", year=" + year +
                 ", numberOfPages='" + numberOfPages + '\'' +
                 ", price='" + price + '\'' +
                 ", typeOfBookCover='" + typeOfBookCover + '\'' +
                 '}';
     }

}
