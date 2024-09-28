import java.util.ArrayList;

public class ClimateRecord {

    private static ArrayList<Country> countries;
    private static ArrayList<City> cities;

    // default constructor
    public ClimateRecord(){
        countries = new ArrayList<>();
        cities = new ArrayList<>();
    }

    // constructor
    public ClimateRecord(String fileName){
        countries = new ArrayList<Country>();
        cities = new ArrayList<City>();
        this.countries = FileIO.readFileCountry(fileName);
        this.cities = FileIO.readFileCity(fileName);
    }

    // copy constructor
    public ClimateRecord(ClimateRecord otherClimateRecord){
        this.countries = otherClimateRecord.getCountries();
        this.cities = otherClimateRecord.getCities();
    }

    // getters and setters
    public ArrayList<City> getCities() {
        return cities;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    // finds a city according to its name from cities array list and returns the found city
    public static City getACityAccordingToName(String name){
        for (int i = 0; i<cities.size(); i++){
            if (cities.get(i).getName().equalsIgnoreCase(name)){
                return cities.get(i);
            }
        }
        return null;
    }

    // finds a country according to its name from countries array list and returns the found country
    public static Country getACountryAccordingToName(String name){
        for (int i = 0; i<countries.size(); i++){
            if (countries.get(i).getName().equalsIgnoreCase(name)){
                return countries.get(i);
            }
        }
        return null;
    }

    // finds temperature objects according to their year for a city,
    // adds them to a new array list,
    // returns the new array list
    public static ArrayList<Temperature> getTemperatureDataAccordingToYear(City city, int year){
        ArrayList<Temperature> temperatureArrayList = new ArrayList<>();
        for (int i = 0; i < city.getTemperatureData().size(); i++){
            if(city.getTemperatureData().get(i).getYear() == year){
                temperatureArrayList.add(city.getTemperatureData().get(i));
            }
        }
        return temperatureArrayList;
    }

    // finds Temperature objects according to their year for a country,
    // adds them to a new array list,
    // returns the new array list
    public static ArrayList<Temperature> getTemperatureDataAccordingToYear(Country country, int year){
        ArrayList<Temperature> temperatureArrayList = new ArrayList<>();
        for (int i = 0; i < country.getCountryWideTemperatureData().size(); i++){
            if(country.getCountryWideTemperatureData().get(i).getYear() == year){
                temperatureArrayList.add(country.getCountryWideTemperatureData().get(i));
            }
        }
        return temperatureArrayList;
    }

    // finds windSpeed objects according to their month for a city,
    // adds them to a new array list,
    // returns the new array list
    public static ArrayList<WindSpeed> getWindSpeedDataAccordingToMonth(City city, String month){
        ArrayList<WindSpeed> windSpeedArrayList = new ArrayList<>();
        for (int i = 0; i < city.getWindSpeedData().size(); i++){
            if (city.getWindSpeedData().get(i).getStringMonth().equalsIgnoreCase(month)){
                windSpeedArrayList.add(city.getWindSpeedData().get(i));
            }
        }
        return windSpeedArrayList;
    }

    // finds RadiationAbsorption objects according to their year for a city,
    // adds them to a new array list,
    // returns the new array list
    public static ArrayList<RadiationAbsorption> getRadiationAbsorptionDataAccordingToYear(City city, int year){
        ArrayList<RadiationAbsorption> radiationAbsorbtionArrayList = new ArrayList<>();
        for (int i = 0; i < city.getRadiationAbsorptionData().size(); i++){
            if(city.getRadiationAbsorptionData().get(i).getYear() == year){
                radiationAbsorbtionArrayList.add(city.getRadiationAbsorptionData().get(i));
            }
        }
        return radiationAbsorbtionArrayList;
    }


     // calculates the “felt temperature” value for a specific month of a specific year using theformula provided
     // returns the feltTemperature
    public static Double getFeltTemperatureAccordingToYearAndMonth(City city, int year, String month){
        Double feltTemperature = 0.0;
        for (int i=0 ; i < city.getFeltTemperatureData().size(); i++){
            if (city.getTemperatureData().get(i).getYear() == year &&
                    city.getTemperatureData().get(i).getStringMonth().equalsIgnoreCase(month)){
                feltTemperature = city.getFeltTemperatureData().get(i);
            }
        }
        return feltTemperature;
    }


}
