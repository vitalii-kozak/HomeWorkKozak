package Taxi;

public class FamilyTariff implements TaxiTariff{
    @Override
    public long calculatePrice(TaxiRide ride) {
        return 50 + 20 * ride.getDistance() / ride.getPassengers();
    }
}
