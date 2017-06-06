package Books;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by Tigra on 26.05.2017.
 */
public class Books {
    private final ArrayList<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
   }

    public Books findByYear(int year) {
        Books results = new Books();
            for (Book book : books) {
                if (book.getYear() >= year) {
                    results.add(book);
                }
            }
            return results;
    }

    public Books findByAuthor(String author) {
        Books results = new Books();
        for (Book book : books) {
            if (Objects.equals(book.getAuthor(), author)) {
                results.add(book);
            }
        }
        return results;
    }

    public Books findByPublishing(String publishing) {
        Books results = new Books();
        for (Book book : books) {
            if (Objects.equals(book.getPublishing(), publishing)) {
                results.add(book);
            }
        }
        return results;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Book book : books) {
            joiner.add(book.toString());
        }
        return "Books.Books:\n" + joiner.toString();
    }

}
