import java.util.ArrayList;

public class Country extends Location {

    private ArrayList<Temperature> countryWideTemperatureData;

    // default constructor
    public Country(){
        super();
        countryWideTemperatureData = new ArrayList<>();
    }

    // constructor
    // also creates Temperature objects and adds them an array list
    public Country(String name) {
        super(name);
        countryWideTemperatureData = new ArrayList<>();
        for (int year = 2020; year <= 2022; year++) {
            for (int month = 1; month <= 12; month++) {
                Temperature tempTemperature = new Temperature(year, month);
                countryWideTemperatureData.add(tempTemperature);
            }
        }
        countryWideTemperatureData.trimToSize();
    }
    //copy constructor
    public Country(Country otherCountry){
        super(otherCountry);
        this.countryWideTemperatureData = otherCountry.getCountryWideTemperatureData();
    }

    // getters and setters
    public ArrayList<Temperature> getCountryWideTemperatureData(){
        return countryWideTemperatureData;
    }

    public void setCountryWideTemperatureData(ArrayList<Temperature> countryWideTemperatureData) {
        this.countryWideTemperatureData = countryWideTemperatureData;
    }

    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            Country otherCountry = (Country) otherObject;
            return (getName().equals(otherCountry.getName()));
        }
    }

    public String toString(){
        return ("This country's name is " + this.getName());
    }
}
