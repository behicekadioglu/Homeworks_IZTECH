import java.util.Random;

public class Temperature extends ClimateMeasurement{
    private double celciusMeasurement;
    private double fahrenheitMeasurement;
    private double kelvinMeasurement;

    // default constructor
    public Temperature(){
        super();
        this.celciusMeasurement = 0;
        this.fahrenheitMeasurement = 0;
        this.kelvinMeasurement = 0;
    }

    // constructor
    public Temperature(int year, int month) {
        super(year, month);
        initializeMeasurements();
    }

    // copy constructor
    public Temperature(Temperature otherTemperature) {
        super(otherTemperature);
        this.celciusMeasurement = otherTemperature.getCelciusMeasurement();
        this.fahrenheitMeasurement = otherTemperature.getFahrenheitMeasurement();
        this.kelvinMeasurement = otherTemperature.getKelvinMeasurement();
    }

    // randomly initializes attributes
    private void initializeMeasurements() {
        // Initialize temperature measurements within specified ranges
        Random rand = new Random();
        celciusMeasurement = -40.0 + (50.0 + 40.0) * rand.nextDouble();
        fahrenheitMeasurement = (celciusMeasurement * 9 / 5) + 32;
        kelvinMeasurement = celciusMeasurement + 273.15;
    }

    // getters and setters
    public double getCelciusMeasurement() {
        return celciusMeasurement;
    }

    public void setCelciusMeasurement(double celciusMeasurement) {
        this.celciusMeasurement = celciusMeasurement;
    }

    public double getFahrenheitMeasurement() {
        return fahrenheitMeasurement;
    }

    public void setFahrenheitMeasurement(double fahrenheitMeasurement) { this.fahrenheitMeasurement = fahrenheitMeasurement; }

    public double getKelvinMeasurement() { return kelvinMeasurement; }

    public void setKelvinMeasurement(double kelvinMeasurement) {
        this.kelvinMeasurement = kelvinMeasurement;
    }

    @Override
    public boolean equals(Object otherObj) {
        super.equals(otherObj);
        Temperature otherTemperature = (Temperature) otherObj;
        return this.celciusMeasurement == otherTemperature.celciusMeasurement;
    }

    public String toString(){
        return("Temperature of " + this.getMonth() + "th month of the year " +
                this.getYear() + " in Celcius is " + this.getCelciusMeasurement());
    }

}
