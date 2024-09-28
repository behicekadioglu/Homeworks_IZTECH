import java.util.Random;

public class WindSpeed extends ClimateMeasurement{
    private double metersPerSecond;
    private double kmPerHour;

    // default constructor
    public WindSpeed(){
        super();
        this.metersPerSecond = 0;
        this.kmPerHour = 0;
    }

    // constructor
    public WindSpeed(int year, int month) {
        super(year, month);
        initializeMeasurements();
    }

    // copy constructor
    public WindSpeed(WindSpeed otherWindSpeed) {
        super(otherWindSpeed);
        this.metersPerSecond = otherWindSpeed.getMetersPerSecond();
        this.kmPerHour = otherWindSpeed.getKmPerHour();
    }

    // randomly initializes attributes
    private void initializeMeasurements() {
        Random rand = new Random();
        metersPerSecond = rand.nextDouble() * 113.2;
        kmPerHour = metersPerSecond * 3.6;
    }

    // getters and setters
    public double getKmPerHour() {
        return kmPerHour;
    }

    public void setKmPerHour(double kmPerHour) {
        this.kmPerHour = kmPerHour;
    }

    public double getMetersPerSecond() {
        return metersPerSecond;
    }

    public void setMetersPerSecond(double metersPerSecond) {
        this.metersPerSecond = metersPerSecond;
    }

    public boolean equals(Object otherObj) {
        super.equals(otherObj);
        WindSpeed otherWindSpeed = (WindSpeed) otherObj;
        return this.metersPerSecond== otherWindSpeed.metersPerSecond;
    }

    public String toString(){
        return("Wind speed of " + this.getMonth() + "th month of the year " +
                this.getYear() + " in meters per second is " + this.getMetersPerSecond());
    }
}
