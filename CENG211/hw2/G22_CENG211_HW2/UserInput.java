import java.util.Scanner;

public class UserInput {

    // prints the menu and handle user input according to querry options
    public void printTheMenu(){
        System.out.println("[1] Calculate average temperature for a country according to temperature unit and year.\n" +
                "[2] Calculate average temperature for a city according to temperature unit and year.\n" +
                "[3] Calculate average wind speed for a city according to speed unit and year.\n" +
                "[4] Calculate average humidity of a city for every year.\n" +
                "[5] Count how many times a year a specific radiation intensity value appears.\n" +
                "[6] Calculate the felt temperature value for a specific month.\n" +
                "[7] Exit the application.");
        System.out.print("Please select an option: ");

        Scanner scannerObj = new Scanner(System.in);
        int tempOption = scannerObj.nextInt();

        while (! ((tempOption == 1) ||
                (tempOption == 2) ||
                (tempOption == 3) ||
                (tempOption == 4) ||
                (tempOption == 5) ||
                (tempOption == 6) ||
                (tempOption == 7))){
            System.out.println("Incorrect option input!");
            System.out.print("Please reenter another option input: ");
            tempOption = scannerObj.nextInt();
        }

        // actions for querry option 1
        if (tempOption == 1){
            String countryName = askForCountryName();
            String temperatureUnit = askForTemperatureUnit();
            int year = askForYear();
            Double average = ClimateApp.calculateAverageTemperature(ClimateRecord.getACountryAccordingToName(countryName), year, temperatureUnit);
            System.out.println("==> Average temperature of " + countryName.toUpperCase() + " in " +
                    temperatureUnit + " in " + year + " " + String.format("%.2f", average));
            System.out.println("****************************************************************************");
            System.out.println();
            printTheMenu();
        }

        // actions for querry option 2
        else if (tempOption == 2){
            String cityName = askForCityName();
            String temperatureUnit = askForTemperatureUnit();
            int year = askForYear();
            Double average = ClimateApp.calculateAverageTemperature(ClimateRecord.getACityAccordingToName(cityName), year, temperatureUnit);
            System.out.println("==> Average temperature of " + cityName.toUpperCase() + " in " +
                    temperatureUnit + " in " + year + " " + String.format("%.2f", average));
            System.out.println("****************************************************************************");
            System.out.println();
            printTheMenu();
        }

        // actions for querry option 3
        else if (tempOption == 3){
            String cityName = askForCityName();
            String windSpeedUnit = askForWindSpeedUnit();
            String month = askForMonth();
            Double average = ClimateApp.calculateAverageWindSpeed(ClimateRecord.getACityAccordingToName(cityName), month, windSpeedUnit);
            System.out.println("==> Average wind speed of " + cityName.toUpperCase() + " in " +
                            windSpeedUnit + " in " + month + " " + String.format("%.2f", average));
            System.out.println("****************************************************************************");
            System.out.println();
            printTheMenu();
        }

        // actions for querry option 4
        else if (tempOption == 4){
            String cityName = askForCityName();
            Double average = ClimateApp.calculateAverageHumidity(ClimateRecord.getACityAccordingToName(cityName));
            System.out.println("==> Average humidity of " + cityName.toUpperCase() +
                    " for 3 years is " + String.format("%.2f", average));
            System.out.println("****************************************************************************");
            System.out.println();
            printTheMenu();
        }

        // actions for querry option 5
        else if (tempOption == 5){
            String cityName = askForCityName();
            int year = askForYear();
            String stringIntensity;
            RadiationAbsorption.RadiationIntensity intensity = askForRadiationIntensity();
                if(intensity == RadiationAbsorption.RadiationIntensity.LOW){
                    stringIntensity = "low";
                } else if (intensity == RadiationAbsorption.RadiationIntensity.MEDIUM) {
                    stringIntensity = "medium";
                } else {
                    stringIntensity = "high";
                }
            int count = ClimateApp.calculateFrequencyOfIntensity(ClimateRecord.getACityAccordingToName(cityName), year, intensity);
            System.out.println("==> Total count of " + stringIntensity + " radiation intensity " + " in " +
                    cityName.toUpperCase() + " in " + year + ": " + count);
            System.out.println("****************************************************************************");
            System.out.println();
            printTheMenu();
        }

        // actions for querry option 6
        else if (tempOption == 6){
            String cityName = askForCityName();
            int year = askForYear();
            String month = askForMonth();
            Double feltTemp =ClimateRecord.getFeltTemperatureAccordingToYearAndMonth(ClimateRecord.getACityAccordingToName(cityName),year,month);
            System.out.println("==> Average felt temperature value of " + month + " " + year +
                    " for " + cityName.toUpperCase() + " in Celsius is " + String.format("%.2f", feltTemp));
            System.out.println("****************************************************************************");
            System.out.println();
            printTheMenu();
        }

        // actions for querry option 7
        else if (tempOption == 7){
            System.out.println("==> Closing the application…");
            return;
        }

    }

    // asks for a city name and gets the user input
    private static String askForCityName(){
        System.out.print("Enter city name: ");

        Scanner scannerObj = new Scanner(System.in);
        String name = scannerObj.nextLine().trim();

        while (ClimateRecord.getACityAccordingToName(name) == null){
            System.out.println("This city's data is not avaliable!");
            System.out.print("Please re-enter city name: ");
            name = scannerObj.nextLine().trim();
        }

        return name;
    }

    // asks for a country name and gets user input
    private String askForCountryName(){
        System.out.print("Enter country name: ");

        Scanner scannerObj = new Scanner(System.in);
        String name = scannerObj.nextLine().trim();

        while (ClimateRecord.getACountryAccordingToName(name) == null){
            System.out.println("This country's data is not avaliable!");
            System.out.print("Please reenter country name: ");
            name = scannerObj.nextLine().trim();
        }

        return name;
    }

    // asks for a year and gets user input
    private int askForYear(){
        System.out.println("[1] 2020 [2] 2021 [3] 2022");
        System.out.print("Please select a year value: ");

        Scanner scannerObj = new Scanner(System.in);
        try {
            int tempYear = scannerObj.nextInt();
            int year;

            while (!(tempYear == 1 || tempYear == 2 || tempYear == 3)) {
                System.out.println("Incorrect option input!");
                System.out.print("Please reenter another option input: ");
                tempYear = scannerObj.nextInt();
            }

            if (tempYear == 1) {
                year = 2020;
            } else if (tempYear == 2) {
                year = 2021;
            } else {
                year = 2022;
            }

            return year;
        }
        catch (java.util.InputMismatchException e){
            System.out.println("Your input is not in the correct form!");
            return askForYear();
        }
    }

    // asks for a month and gets user input
    private static String askForMonth(){
        System.out.print("Please enter a month name: ");

        Scanner scannerObj = new Scanner(System.in);
        String month = scannerObj.nextLine().trim();

        while (!(month.equalsIgnoreCase("January") ||
                month.equalsIgnoreCase("February") ||
                month.equalsIgnoreCase("March") ||
                month.equalsIgnoreCase("April") ||
                month.equalsIgnoreCase("May") ||
                month.equalsIgnoreCase("June") ||
                month.equalsIgnoreCase("July") ||
                month.equalsIgnoreCase("August") ||
                month.equalsIgnoreCase("September") ||
                month.equalsIgnoreCase("October") ||
                month.equalsIgnoreCase("November") ||
                month.equalsIgnoreCase("December") ) ){
            System.out.println("Incorrect option input!");
            System.out.print("Please reenter a month name: ");
            month = scannerObj.nextLine().trim();
        }

        return month;
    }

    // asks for an absorption intensity value and gets user input
    private RadiationAbsorption.RadiationIntensity askForRadiationIntensity(){
        System.out.println("[1] Low [2] Medium [3] High");
        System.out.print("Please select a radiation intensity value: ");

        Scanner scannerObj = new Scanner(System.in);
        try {
            int tempIntensity = scannerObj.nextInt();

            RadiationAbsorption.RadiationIntensity intensity;

            while (!(tempIntensity == 1 || tempIntensity == 2 || tempIntensity == 3)) {
                System.out.println("Incorrect option input!");
                System.out.print("Please reenter another option input: ");
                tempIntensity = scannerObj.nextInt();
            }

            if (tempIntensity == 1) {
                intensity = RadiationAbsorption.RadiationIntensity.LOW;
            } else if (tempIntensity == 2) {
                intensity = RadiationAbsorption.RadiationIntensity.MEDIUM;
            } else {
                intensity = RadiationAbsorption.RadiationIntensity.HIGH;
            }

            return intensity;
        }
        catch (java.util.InputMismatchException e){
            System.out.println("Your input is not in the correct form!");
            return askForRadiationIntensity();
        }
    }

    // asks for a temperature unit and gets user input
    private String askForTemperatureUnit(){
        System.out.println("[1] Celsius [2] Fahrenheit [3] Kelvin");
        System.out.print("Please select the temperature unit: ");

        Scanner scannerObj = new Scanner(System.in);

        try {
            int temperatureType = scannerObj.nextInt();

            String type;

            while (!(temperatureType == 1 || temperatureType == 2 || temperatureType == 3)) {
                System.out.println("Incorrect option input!");
                System.out.print("Please reenter another option input: ");
                temperatureType = scannerObj.nextInt();
            }

            if (temperatureType == 1) {
                type = "Celsius";
            } else if (temperatureType == 2) {
                type = "Fahrenheit";
            } else {
                type = "Kelvin";
            }

            return type;
        }
        catch (java.util.InputMismatchException e){
            System.out.println("Your input is not in the correct form!");
            return askForTemperatureUnit();
        }
    }

    // asks for a wind speed unit and gets user input
    private String askForWindSpeedUnit(){
        System.out.println("[1] Meters per second [2] Kilometers per hour");
        System.out.print("Please select the wind speed unit: ");

        Scanner scannerObj = new Scanner(System.in);

        try {
            int tempUnit = scannerObj.nextInt();

            String unit;

            while (!(tempUnit == 1 || tempUnit == 2)) {
                System.out.println("Incorrect option input!");
                System.out.print("Please reenter another option input: ");
                tempUnit = scannerObj.nextInt();
            }

            if (tempUnit == 1) {
                unit = "Meters per second";
            } else {
                unit = "Kilometers per hour";
            }

            return unit;
        }
        catch (java.util.InputMismatchException e){
            System.out.println("Your input is not in the correct form!");
            return askForWindSpeedUnit();
        }
    }

}
