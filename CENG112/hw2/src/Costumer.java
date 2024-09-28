public class Costumer
{
    private String nameOfCostumer;
    private double threshold;

    public Costumer()
    {
        this("unnamed");
    }

    public Costumer(String name)
    {
        nameOfCostumer = name;
        threshold = Math.random() * ((3 - 1) + 1);
        threshold = Double.parseDouble(String.valueOf(threshold));
    }

    public double getThreshold() {
        return threshold;
    }

    public String getNameOfCostumer() {
        return nameOfCostumer;
    }

    public void setThreshold() {
        this.threshold = threshold * 0.9;
    }
}
