import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {

    // reads countries from the file
    // creates an array list of countries
    // returns the array list
    public static ArrayList<Country> readFileCountry(String fileName) {
        String delimiter = ", ";
        ArrayList<Country> countries= new ArrayList<>(); // creates a new array for country objects in each line

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                // while there more lines to read
                // splits each line for locations
                String[] locations = line.split(delimiter);
                // first String is a country, others are cities
                String countryName = locations[0];
                Country country = new Country(countryName);
                countries.add(country);
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    // reads cities from the file
    // creates an array list of cities
    // returns the array list
    public static ArrayList<City> readFileCity(String fileName) {
        String delimiter = ", ";
        ArrayList<City> cities= new ArrayList<>(); // creates a new array for city objects in each line

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                // while there more lines to read
                // splits each line for locations
                String[] locations = line.split(delimiter);
                // first String is a country, others are cities

                String city1Name = locations[1];
                String city2Name = locations[2];
                String city3Name = locations[3];
                City city1 = new City(city1Name);
                City city2 = new City(city2Name);
                City city3 = new City(city3Name);
                cities.add(city1);
                cities.add(city2);
                cities.add(city3);

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

}




