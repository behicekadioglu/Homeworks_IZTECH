import java.util.ArrayList;

public class ClimateApp {

    //calculates average temperature for a country depending on the selected options
    public static double calculateAverageTemperature(Country country, int year, String type) {
        ArrayList<Temperature> tempArrayList = ClimateRecord.getTemperatureDataAccordingToYear(country, year);
        if (type.equals("Celcius")) {
            double sumOfTemp = 0;
            for (Temperature temp : tempArrayList) {
                double celciusTemp = temp.getCelciusMeasurement();
                sumOfTemp += celciusTemp;
            }
            return sumOfTemp / tempArrayList.size();
        } else if (type.equals("Kelvin")) {
            double sumOfTemp = 0;
            for (Temperature temp : tempArrayList) {
                double kelvinTemp = temp.getKelvinMeasurement();
                sumOfTemp += kelvinTemp;
            }
            return sumOfTemp / tempArrayList.size();
        } else {
            double sumOfTemp = 0;
            for (Temperature temp : tempArrayList) {
                double fahrenheitTemp = temp.getFahrenheitMeasurement();
                sumOfTemp += fahrenheitTemp;
            }
            return sumOfTemp / tempArrayList.size();
        }

    }

    //calculates average temperature for a city depending on the selected options
    public static double calculateAverageTemperature(City city, int year, String type) {
        ArrayList<Temperature> tempArrayList = ClimateRecord.getTemperatureDataAccordingToYear(city, year);

        if (type.equals("Celcius")) {
            double sumOfTemp = 0;
            for (Temperature temp : tempArrayList) {
                double celciusTemp = temp.getCelciusMeasurement();
                sumOfTemp += celciusTemp;
            }
            return sumOfTemp / tempArrayList.size();
        } else if (type.equals("Kelvin")) {
            double sumOfTemp = 0;
            for (Temperature temp : tempArrayList) {
                double kelvinTemp = temp.getKelvinMeasurement();
                sumOfTemp += kelvinTemp;
            }
            return sumOfTemp / tempArrayList.size();
        } else {
            double sumOfTemp = 0;
            for (Temperature temp : tempArrayList) {
                double fahrenheitTemp = temp.getFahrenheitMeasurement();
                sumOfTemp += fahrenheitTemp;
            }
            return sumOfTemp / tempArrayList.size();
        }

    }

    //calculates average wind speed for a city depending on the selected options.
    public static double calculateAverageWindSpeed(City city, String month, String unit) {
        ArrayList<WindSpeed> tempArrayList = ClimateRecord.getWindSpeedDataAccordingToMonth(city, month);
        if (unit.equals("Meters per second")) {
            double sumOfTemp = 0;
            for (WindSpeed temp : tempArrayList) {
                double metersPerSecondTemp = temp.getMetersPerSecond();
                sumOfTemp += metersPerSecondTemp;
            }
            return sumOfTemp / tempArrayList.size();
        } else {
            double sumOfTemp = 0;
            for (WindSpeed temp : tempArrayList) {
                double kmPerHourTemp = temp.getKmPerHour();
                sumOfTemp += kmPerHourTemp;
            }
            return sumOfTemp / tempArrayList.size();
        }

    }

    //calculates average humidity of a city across the 3-year period.
    public static double calculateAverageHumidity(City city) {
        ArrayList<Humidity> tempArrayList = city.getHumidityData();
        double sumOfTemp = 0;

        for (Humidity temp : tempArrayList) {
            double fahrenheitTemp = temp.getHumidityPercentage();
            sumOfTemp += fahrenheitTemp;
        }
        return sumOfTemp / tempArrayList.size();
    }

    //Find out how many times throughout a certain year radiation intensity has been one of the three possible enum values
    public static int calculateFrequencyOfIntensity(City city, int year, RadiationAbsorption.RadiationIntensity intensity) {
        ArrayList<RadiationAbsorption> radiationAbsorbtionArrayList = ClimateRecord.getRadiationAbsorptionDataAccordingToYear(city, year);
        int frequency = 0;
        switch (intensity) {
            case LOW:
                for (RadiationAbsorption radiationAbsorption : radiationAbsorbtionArrayList) {
                    if (radiationAbsorption.getRadiationIntensity() == intensity) {
                        frequency++;
                    }
                }
                return frequency;

            case MEDIUM:
                for (RadiationAbsorption radiationAbsorption : radiationAbsorbtionArrayList) {
                    if (radiationAbsorption.getRadiationIntensity() == intensity) {
                        frequency++;
                    }
                }
                return frequency;

            case HIGH:
                for (RadiationAbsorption radiationAbsorption : radiationAbsorbtionArrayList) {
                    if (radiationAbsorption.getRadiationIntensity() == intensity) {
                        frequency++;
                    }
                }
                return frequency;

            default:
                return -1;
        }
    }

}