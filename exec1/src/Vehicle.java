public class Vehicle {
    private String make, model;
    private int year, weight;
    protected int tripsSinceMaintenance=0;
    protected boolean needsMaintenance=false;

    public Vehicle() {
        this.make = "";
        this.model= "";
        this.year = 1999;
        this.weight = 1500;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                ", tripsSinceMaintenance=" + tripsSinceMaintenance +
                ", needsMaintenance=" + needsMaintenance +
                '}';
    }

    public Vehicle(String make, String model, int year, int weight) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setNeedsMaintenance(boolean needsMaintenance) {
        this.needsMaintenance = needsMaintenance;
    }

    public void setTripsSinceMaintenance(int tripsSinceMaintenance) {
        this.tripsSinceMaintenance = tripsSinceMaintenance;
    }
};