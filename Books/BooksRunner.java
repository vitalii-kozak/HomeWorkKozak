package Books;

/**
 * Created by Tigra on 26.05.2017.
 */
public class BooksRunner {
    public static void main(String[] args) {
        Book book = new Book("Wizard of Oz", "Frank Baum","Mahaon", 1939,198, 128.00, 1);

        System.out.println(book.toString());

        Books books = new Books();
        books.add(new Book("Wizard of Oz", "Frank Baum","Mahaon", 1939,198, 128.00, 1));
        books.add(new Book("Queen", "Frank Baum","Mahaon", 1958,118, 133.00, 1));
        books.add(new Book("Tantra", "Volkov","Mahaon", 1966,255, 228.00, 1));
        books.add(new Book("Warlock", "Tolstoi","Kiev", 1975,198, 175.00, 1));

        System.out.println("All Books.Books ***************************************************");
        System.out.println(books);
        System.out.println("By Author ****************************************************");
        System.out.println(books.findByAuthor("Frank Baum"));
        System.out.println("By Year *****************************************************");
        System.out.println(books.findByYear(1960));

    }
}
