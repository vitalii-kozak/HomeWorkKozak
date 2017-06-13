package Books;

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
     public String toString() {
         return "Books.Book {" + "id=" + id +
                 ", name='" + name + '\'' +
                 ", author='" + author + '\'' +
                 ", publishing='" + publishing + '\'' +
                 ", year=" + year +
                 ", numberOfPages='" + numberOfPages + '\'' +
                 ", price='" + price + '\'' +
                 ", typeOfBookCover='" + typeOfBookCover + '\'' +
                 '}';
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (numberOfPages != book.numberOfPages) return false;
        if (Double.compare(book.price, price) != 0) return false;
        if (typeOfBookCover != book.typeOfBookCover) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return publishing != null ? publishing.equals(book.publishing) : book.publishing == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishing != null ? publishing.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + numberOfPages;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + typeOfBookCover;
        return result;
    }
}
