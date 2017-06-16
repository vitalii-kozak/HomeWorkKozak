package Cashier;///123
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cashier {
    public static void main(String[] args) {

        MenuCashier menuCashier = new MenuCashier();
        menuCashier.showMenu();
    }
}

abstract class MenuEntry {
    private String title;

    public MenuEntry(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void run();
}

class MenuCashier {
    private static final String MENU_PATTERN = "%s - %s\n";
    private List<MenuEntry> entries = new ArrayList<MenuEntry>();
    private boolean isExit = false;
    private boolean allowPurchase = false;
    private boolean allowAdd = false;

    Autorizator az = new Autorizator();
    GoodsTable gt = new GoodsTable();
    LinkedList<Bill> bill = new LinkedList<>();



    public MenuCashier() {

        az.addUser("User1", "1");
        az.addUser("User2", "2");
        az.addUser("User3", "3");

        gt.addGood("Milk", "1", 14.45);
        gt.addGood("Bread","2", 6.15);
        gt.addGood("Checken", "3", 50.85);

        entries.add(new MenuEntry("Authorization") {
            @Override
            public void run() {
                System.out.println("Authorization run");
                System.out.println("Enter login");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String CurrentLogin = reader.readLine();
                    System.out.println("Enter password");
                    String CurrentPassword = reader.readLine();
                    System.out.println(CurrentLogin + " " + CurrentPassword);
                    if (isAutorized(CurrentLogin, CurrentPassword)) {
                        allowPurchase = true;
                        System.out.println("Authorization OK now you can sell");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        entries.add(new MenuEntry("Create Purchase") {
            @Override
            public void run() {
                if(!allowPurchase) {
                    System.out.println("ERROR! AUTHORIZE FIRST ");
                }else {
                    System.out.println("Create Purchase");
                    allowAdd = true;
                }
            }
        });

        entries.add(new MenuEntry("Add Cashier.Good") {
            @Override
            public void run() {
                if(!allowPurchase) {
                    System.out.println("ERROR! AUTHORIZE FIRST ");
                }else if(!allowAdd) {
                    System.out.println("ERROR! CREATE PURCHASE FIRST ");
                }else {
                    System.out.println("Add Cashier.Good");
                    System.out.println("Enter BarCode");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String CurrentBarCode = reader.readLine();
                        if(gt.returnGood(CurrentBarCode) != null) {
                            System.out.println("Enter amount");
                            String CurrentAmount = reader.readLine();
                            double amount = Double.parseDouble(CurrentAmount);
                            System.out.println(gt.returnGood(CurrentBarCode) + " " + amount);
                            bill.add(new Bill(gt.returnGood(CurrentBarCode),amount));
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        entries.add(new MenuEntry("Remove Cashier.Good") {
            @Override
            public void run() {
                if(!allowPurchase) {
                    System.out.println("ERROR! AUTHORIZE FIRST ");
                }else if(!allowAdd) {
                    System.out.println("ERROR! CREATE PURCHASE FIRST ");
                }else {
                    System.out.println("Remove Cashier.Good");
                    System.out.println("Enter BarCode");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String CurrentBarCode = reader.readLine();
                        if(gt.returnGood(CurrentBarCode) != null) {
                            System.out.println("Enter amount");
                            String CurrentAmount = reader.readLine();
                            double amount = Double.parseDouble(CurrentAmount);
                            System.out.println(gt.returnGood(CurrentBarCode) + " " + amount);
                            boolean foundBill = false;

                            for(Bill bl:bill){
                                if(bl.getGood().equals(gt.returnGood(CurrentBarCode)) &&(bl.getAmount() == amount)){
                                    bill.remove(bl);
                                    System.out.println(gt.returnGood(CurrentBarCode) + " " + amount + " is removed");
                                    foundBill = true;
                                    break;
                                }
                            }

                            if(foundBill == false) {
                                System.out.println("ERROR! GOOD NOT FOUND OR NOT CORRECT AMOUNT!");
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        entries.add(new MenuEntry("Cancel Purchase") {
            @Override
            public void run() {
                if(!allowPurchase) {
                    System.out.println("ERROR! AUTHORIZE FIRST ");
                }else if(!allowAdd) {
                    System.out.println("ERROR! CREATE PURCHASE FIRST");
                }else {
                    allowAdd = false;
                    bill.clear();
                    System.out.println("Cancel Purchase");
                }
            }
        });

        entries.add(new MenuEntry("Close Purchase") {
            @Override
            public void run() {
                if(!allowPurchase) {
                    System.out.println("ERROR! AUTHORIZE FIRST ");
                }else if(!allowAdd) {
                    System.out.println("ERROR! CREATE PURCHASE FIRST");
                }else {
                    System.out.println("Close Purchase");
                    double summ = 0.0;
                    for(Bill bl:bill){
                        summ +=bl.getPrice()*bl.getAmount();
                    }
                    System.out.println("Your whole price: "+ summ);
                }
                bill.clear();
            }
        });

        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    public boolean isAutorized(String login, String password){
        if(az.isEmpty()) {
            System.out.println("ERROR NO USERS IN MEMORY: ");
            return false;
        }else {
            if(az.autorize(login,password)){
                allowPurchase = true;
                return true;
            }else{
                System.out.println("Authorization failed: ");
                return false;
            }
        }
    }

    public void showMenu() {
        while (!isExit) {
            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                if ((choice <=0) || (choice-1 >= entries.size())){
                    System.out.println("ERROR WRONG MENU INDEX: ");
                }else {
                    MenuEntry entry = entries.get(choice - 1);
                    entry.run();
                }
            }catch (NumberFormatException e) {
                System.out.println("ERROR NOT a NUMBER: " + e.getMessage());
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public MenuCashier addEntry(MenuEntry entry) {
        int index = entries.size() - 1;
        entries.add(index, entry);
        return this;
    }

    private void printMenu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\nMenu:\n");
        for (int i = 0; i < entries.size(); i++) {
            MenuEntry entry = entries.get(i);
            String entryFormatted = String.format(MENU_PATTERN, (i + 1), entry.getTitle());
            buffer.append(entryFormatted);
        }
        System.out.print(buffer.toString());
    }
}

class Bill {
    private Good good;
    private double amount;

    public Bill(Good good, double amount){
        this.good = good;
        this.amount = amount;
    }

    public double getPrice(){
        return good.getPrice();
    }

    public double getAmount(){
        return amount;
    }

    public Good getGood(){
        return good;
    }
}

class GoodsTable{
    private  HashSet<Good> goods;

    public GoodsTable(){
        goods = new HashSet<>();
    }

    public void addGood(String descriptionGood, String barCode, double price){
        goods.add(new Good(descriptionGood, barCode, price));
    }

    public Good returnGood(String barCode){
        for(Good gd:goods){
            if(barCode.equals(gd.getBarCode())){
                return gd;
            }
        }
        return null;
    }
}

class Good{
    private String descriptionGood;
    private String barCode;
    private double price;

    public Good(String descriptionGood, String barCode, double price){
        this.descriptionGood = descriptionGood;
        this.barCode = barCode;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getBarCode(){
        return barCode;
    }

    @Override
    public String toString(){
        return "Cashier.Good: "+descriptionGood+" price: "+price;
    }

    @Override
    public int hashCode() {
        return  barCode.hashCode();
    }
}

class Autorizator{
    private  HashSet<User> users;

    public Autorizator(){
        users = new HashSet<>();
    }

    public boolean autorize(String login, String password){
        return users.contains(new User(login,password));
    }

    public void addUser(String login, String password){
        users.add(new User(login,password));
    }

    public void printAutorizator(){
        Set usersTree = new TreeSet<>();
        usersTree.addAll(users);
        System.out.println(usersTree);
    }

    public boolean isEmpty() {
        return users.size() == 0;
    }
}

class User implements Comparable<User>{
    private String login;
    private String password;

    @Override
    public String toString(){
        return "Login: "+login+" Pass: "+password;
    }

    @Override
    public int compareTo(User user){
        if(login.compareToIgnoreCase(user.login) > 0){
            return -1;
        }else if (login.compareToIgnoreCase(user.login) ==0) {
            return 0;
        }else {
            return 1;
        }
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this){
            return true;
        }
        if (this.getClass() != obj.getClass()){
            return false;
        }
        User user = (User) obj;
        if(login.compareToIgnoreCase(user.login) == 0 && password.compareToIgnoreCase(user.password) ==0){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode()+ password.hashCode();
    }
}