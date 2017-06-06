package First;

/**
 * Created by Tigra on 26.05.2017.
 */
public class Month {
    public static void main(String[] args) {

        int monthNumber = readNumberFromConsole();
        System.out.println(chooseMonth(monthNumber));

    }

    private static int readNumberFromConsole() {
        ConsoleReader consoleReader = new ConsoleReader();

        int n = consoleReader.readInt();
        while (!(n >= 1 && n <=12)) {
            System.out.println("Wrong!!! Type again");
            n = consoleReader.readInt();
        }
        return n;
    }

    private static String chooseMonth(int monthNumber){
        String month = "";
        switch (monthNumber) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                break;
        }
        return month;
    }
}
