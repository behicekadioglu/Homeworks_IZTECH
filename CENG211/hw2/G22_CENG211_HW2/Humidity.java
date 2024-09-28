import java.util.Random;

public class Humidity extends ClimateMeasurement{
    private double humidityPercentage;

    //default constructor
    public Humidity(){
        super();
        this.humidityPercentage = 0;
    }

    // constructor
    public Humidity(int year, int month) {
        super(year, month);
        initializeMeasurements();
    }

    // copy constructor
    public Humidity(Humidity otherHumidity) {
        super(otherHumidity);
        this.humidityPercentage = otherHumidity.getHumidityPercentage();
    }

    // randomly initializes attributes
    private void initializeMeasurements() {
        // Initialize humidity measurements within specified ranges
        Random rand = new Random();
        humidityPercentage = rand.nextDouble() * 100.0; //nextDouble [0,1)
    }

    // getter and setter
    public double getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(double humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }

    public boolean equals(Object otherObj) {
        super.equals(otherObj);
        Humidity otherTemperature = (Humidity) otherObj;
        return this.humidityPercentage == otherTemperature.humidityPercentage;
    }

    public String toString(){
        return("Humidity of" + this.getMonth() +"th month of the year " + this.getYear() + "is " + this.humidityPercentage);
    }
}
