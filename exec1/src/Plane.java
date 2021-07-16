public class Plane extends Vehicle {
    private boolean isFlying;
    private float wingspan;
    
    public Plane(String make, String model, int year, int weight,
               boolean isF, float wingspan) {
        super(make, model, year, weight);
        this.isFlying = isF;
        this.wingspan = wingspan;
    }

    public void fly() {
        if (!this.needsMaintenance) this.isFlying = true;
        else System.out.println(this.toString()+" cannot fly!");
    }

    public void land() {
        if (this.isFlying) {
            this.isFlying = false;
            if (++this.tripsSinceMaintenance == 81) {
                this.needsMaintenance = true;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nPlane{" +
                "wingspan=" + wingspan +
                ", isFlying=" + isFlying +
                '}';
    }
}
