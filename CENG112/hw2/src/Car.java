public class Car
{
    private String nameOfCar;
    private double quality;
    private int occupancy;
    private Costumer occupant = null;

    public Car()
    {
        this("unnamed");
    }

    public Car(String name)
    {
        nameOfCar = name;
        quality = Math.random() * ((3 - 1) + 1);
        String stringQuality = Double.toString(quality);
        quality = Double.parseDouble(stringQuality);
        occupancy = 0;
    }

    public double getQuality()
    {
        return quality;
    }

    public int getOccupancy()
    {
        return occupancy;
    }

    public String getNameOfCar()
    {
        return nameOfCar;
    }

    public void setOccupancy(int occupancy)
    {
        this.occupancy = occupancy;
    }

    public void setOccupant(Costumer occupant)
    {
        this.occupant = occupant;
    }

    public String getOccupant()
    {
        return occupant.getNameOfCostumer();
    }

}
