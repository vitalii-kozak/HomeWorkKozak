import java.util.Scanner;


public class ConsoleReader {

    private final Scanner scanner = new Scanner(System.in);

    public int readInt() {
        System.out.print(">> ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // idle

            System.out.println("Sorry, illegal number");
            System.out.print(">> ");
        }
        return scanner.nextInt();
    }

}
