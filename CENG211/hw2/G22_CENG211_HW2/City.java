import java.util.ArrayList;

public class City extends Location{
    private ArrayList<Temperature> temperatureData;
    private ArrayList<Humidity> humidityData;
    private ArrayList<WindSpeed> windSpeedData;
    private ArrayList<RadiationAbsorption> radiationAbsorptionData;
    private ArrayList<Double> feltTemperatureData;

    // default constructor
    public City(){
        super();
        temperatureData = new ArrayList<>();
        humidityData = new ArrayList<>();
        windSpeedData = new ArrayList<>();
        radiationAbsorptionData = new ArrayList<>();
        feltTemperatureData = new ArrayList<>();
    }

    // constructor
    public City(String name){
        super(name);
        initializeArrayLists();
    }

    // copy constructor
    public City(City otherCity){
        super(otherCity);
        this.radiationAbsorptionData = otherCity.getRadiationAbsorptionData();
        this.feltTemperatureData = otherCity.getFeltTemperatureData();
        this.humidityData = otherCity.getHumidityData();
        this.temperatureData = otherCity.getTemperatureData();
        this.windSpeedData = otherCity.getWindSpeedData();
    }


    // creates array lists for all climate measurements
    // calculates feltTemperature and adds it its array list
    public void initializeArrayLists(){
        temperatureData = new ArrayList<>();
        humidityData = new ArrayList<>();
        windSpeedData = new ArrayList<>();
        radiationAbsorptionData = new ArrayList<>();
        feltTemperatureData = new ArrayList<>();

        for (int year = 2020; year <= 2022; year++){
            for (int month = 1; month <= 12; month++){

                Temperature tempTemperature = new Temperature(year, month);
                temperatureData.add(tempTemperature);

                Humidity tempHumidity = new Humidity(year, month);
                humidityData.add(tempHumidity);

                WindSpeed tempWindSpeed = new WindSpeed(year, month);
                windSpeedData.add(tempWindSpeed);

                RadiationAbsorption tempRadiationAbsorption = new RadiationAbsorption(year, month);
                radiationAbsorptionData.add(tempRadiationAbsorption);

                Double tempFeltTemperature = tempTemperature.getCelciusMeasurement()+
                        (0.3 * (tempHumidity.getHumidityPercentage()/100.00)) -
                        (0.7 * (tempRadiationAbsorption.getUnitAbsorptionValue() / (tempWindSpeed.getMetersPerSecond() + 10)));
                feltTemperatureData.add(tempFeltTemperature);
            }
        }
        temperatureData.trimToSize();
        humidityData.trimToSize();
        windSpeedData.trimToSize();
        radiationAbsorptionData.trimToSize();
        feltTemperatureData.trimToSize();
    }

    public ArrayList<Humidity> getHumidityData() {
        return humidityData;
    }

    public void setHumidityData(ArrayList<Humidity> humidityData) {
        this.humidityData = humidityData;
    }

    public ArrayList<RadiationAbsorption> getRadiationAbsorptionData() {
        return radiationAbsorptionData;
    }

    public void setRadiationAbsorptionData(ArrayList<RadiationAbsorption> radiationAbsorptionData) {
        this.radiationAbsorptionData = radiationAbsorptionData;
    }

    // setters and getters
    public ArrayList<Temperature> getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(ArrayList<Temperature> temperatureData) {
        this.temperatureData = temperatureData;
    }

    public ArrayList<WindSpeed> getWindSpeedData() {
        return windSpeedData;
    }

    public void setWindSpeedData(ArrayList<WindSpeed> windSpeedData) {
        this.windSpeedData = windSpeedData;
    }

    public ArrayList<Double> getFeltTemperatureData() {
        return feltTemperatureData;
    }

    public void setFeltTemperatureData(ArrayList<Double> feltTemperatureData) {
        this.feltTemperatureData = feltTemperatureData;
    }

    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        else if (getClass() != otherObject.getClass()){
            return false;
        }
        else{
            City otherCity = (City) otherObject;
            return(getName().equals(otherCity.getName()));
        }
    }

    public String toString(){
        return ("This city's name is " + this.getName());
    }

}
