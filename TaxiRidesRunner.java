public class TaxiRidesRunner {
    public static void main(String[] args) {
        TaxiTariff tariff1 = new StandardTariff();
        TaxiTariff tariff2 = new FamilyTariff();

        TaxiRide taxiRide1 = new TaxiRide(1,1,tariff1);
        TaxiRide taxiRide2 = new TaxiRide(2,1,1,tariff2);
        TaxiRide taxiRide3 = new TaxiRide(1,10,1,tariff1);

        TaxiRides rides = new TaxiRides();
        rides.add(taxiRide1);
        System.out.println("1 trip costs "+ taxiRide1.getPrice());
        rides.add(taxiRide2);
        System.out.println("2 trip costs "+ taxiRide2.getPrice());
        rides.add(taxiRide3);
        System.out.println("3 trip costs "+ taxiRide3.getPrice());

        System.out.println(rides);
        System.out.println("Total costs " + rides.getPrice());

    }
}
