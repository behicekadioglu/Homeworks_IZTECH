import java.util.Random;


public class RadiationAbsorption extends ClimateMeasurement{
    enum RadiationIntensity{LOW, MEDIUM, HIGH};
    private RadiationIntensity radiationIntensity;
    private double unitAbsorptionValue;

    // default constructor
    public RadiationAbsorption(){
        super();
        radiationIntensity = null;
        unitAbsorptionValue = 0;
    }

    // constructor
    public RadiationAbsorption(int year, int month ) {
        super(year, month);
        initializeMeasurements();
    }

    // copy constructor
    public RadiationAbsorption(RadiationAbsorption otherRadiationAbsorption) {
        super(otherRadiationAbsorption);
        this.unitAbsorptionValue = otherRadiationAbsorption.getUnitAbsorptionValue();
        this.radiationIntensity = otherRadiationAbsorption.getRadiationIntensity();
    }

    // randomly initializes attribute
    private void initializeMeasurements() {
        Random rand = new Random();
        unitAbsorptionValue = 5.0 + (20.0 - 5.0) * rand.nextDouble();
        radiationIntensity = determineIntensity();
    }

    // randomly initializes attribute
    private RadiationIntensity determineIntensity() {
        RadiationIntensity[] intensityArray = RadiationIntensity.values();
        Random rand = new Random();
        int index = rand.nextInt(3);
        RadiationIntensity intensity = intensityArray[index];
        return intensity;
    }

    // getters and setters
    public double getUnitAbsorptionValue() {
        return unitAbsorptionValue;
    }

    public void setUnitAbsorptionValue(double unitAbsorptionValue) {
        this.unitAbsorptionValue = unitAbsorptionValue;
    }

    public RadiationIntensity getRadiationIntensity() {
        return radiationIntensity;
    }

    public void setRadiationIntensity(RadiationIntensity radiationIntensity) { this.radiationIntensity = radiationIntensity; }

    public boolean equals(Object otherObj) {
        super.equals(otherObj);
        RadiationAbsorption otherAbsorption = (RadiationAbsorption) otherObj;
        return (this.radiationIntensity == otherAbsorption.radiationIntensity
                && this.unitAbsorptionValue == otherAbsorption.unitAbsorptionValue);
    }

    public String toString(){
        return("Unit absorption of " + this.getMonth() + "th month of the year " +
                this.getYear() + " is " + this.getUnitAbsorptionValue() + " and radiation intensity is "+ this.getRadiationIntensity() );
    }


}
