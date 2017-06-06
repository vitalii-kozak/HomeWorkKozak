package Taxi;

public class TaxiRide  {
    private int passengers;
    private int distance;
    private int duration;
    private TaxiTariff tariff;

    public TaxiRide(int passengers, int distance, int duration, TaxiTariff tariff) {
        check(passengers);
        this.passengers = passengers;
        check(distance);
        this.distance = distance;
        check(duration);
        this.duration = duration;
        this.tariff = tariff;
    }

    public TaxiRide(int distance, int duration, TaxiTariff tariff) {
        this.passengers = 1;
        check(distance);
        this.distance = distance;
        check(duration);
        this.duration = duration;
        this.tariff = tariff;
    }

    private void check(int value){
        if(value <= 0){
            throw new IllegalArgumentException("Value should be more than 0");
        }
    }

    public long getPrice(){
        return tariff.calculatePrice(this);
    }


    public int getPassengers() {
        return passengers;
    }

    public int getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Taxi.TaxiRide{" +
                "passengers=" + passengers +
                ", distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}
