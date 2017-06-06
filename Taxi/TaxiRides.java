package Taxi;

import java.util.ArrayList;
import java.util.StringJoiner;

public class TaxiRides   {

    private final ArrayList<TaxiRide> rides = new ArrayList<>();

    public void add(TaxiRide ride) {
        rides.add(ride);
    }

    int getPrice(){
        int sum = 0;
        for (TaxiRide ride : rides) {
            sum += ride.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (TaxiRide ride : rides) {
            joiner.add(ride.toString());
        }
        return "Taxi.TaxiRides:\n" + joiner.toString();
    }
}
