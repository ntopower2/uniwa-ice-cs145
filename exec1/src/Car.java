public class Car extends Vehicle {
    private int horsepower;
    private boolean isDriving;

    public Car(String make, String model, int year, int weight,
               int hp, boolean isDriving) {
        super(make, model, year, weight);
        this.horsepower = hp;
        this.isDriving = isDriving;
    }

    public void drive() {
        this.isDriving = true;
    }

    public void stop() {
        this.isDriving = false;
        if (++this.tripsSinceMaintenance==101) {
            this.needsMaintenance=true;
        }
    }

    public void repair() {
        this.tripsSinceMaintenance = 0;
        this.needsMaintenance = false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCar{" +
                "horsepower=" + horsepower +
                ", isDriving=" + isDriving +
                '}';
    }
}
