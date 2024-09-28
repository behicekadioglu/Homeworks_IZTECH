public class Main{

    public static void main(String[] args){
        ClimateRecord climateRecordObject = new ClimateRecord("countries_and_cities.csv");
        UserInput userInputObject = new UserInput();
        userInputObject.printTheMenu();
    }
}