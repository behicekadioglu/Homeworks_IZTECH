import java.util.Random;

public class ShopAssistant {
    private int id;
    private String name;
    private String surname;
    private String phoneNum;
    private int seniority;
    private double monthlySalaryBasis;
    public final int NUMOFTRANSACTIONS = 15;
    private double monthlySalary;
    private double commission;

    // Constructors, Getters & Setters
    public ShopAssistant() {
        this(0, "", "", "");
    }

    public ShopAssistant(int id, String name, String surname, String phoneNum) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNum = phoneNum;
        this.seniority = determineSeniority();
        this.monthlySalaryBasis = determineWeeklySalaryBasis()*4;
        this.monthlySalary = 0;
        this.commission = 0.0;
    }

    public ShopAssistant(ShopAssistant shopAssistant) {
        if (shopAssistant == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        this.id = shopAssistant.id;
        this.name = shopAssistant.name;
        this.surname = shopAssistant.surname;
        this.phoneNum = shopAssistant.phoneNum;
        this.seniority = shopAssistant.seniority;
        this.monthlySalaryBasis = shopAssistant.monthlySalaryBasis;
        this.monthlySalary = shopAssistant.monthlySalary;
        this.commission = shopAssistant.commission;
    }

    private int determineSeniority() {
        Random random = new Random();
        int randomInt = random.nextInt(6);
        return randomInt;
    }

    private int determineWeeklySalaryBasis() {
        if (seniority < 1) {
            return 1500;
        }
        else if (seniority < 3) {
            return 2000;
        }
        else if (seniority < 5) {
            return 2500;
        }
        else {
            return 3000;
        }
    }

    public String toString() {
        return (id + " " + name + " " + surname + " " + phoneNum);
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        ShopAssistant shopAssistant = (ShopAssistant) obj;
        return (id == shopAssistant.id && name.equals(shopAssistant.name) &&
                surname.equals(shopAssistant.surname) && phoneNum.equals(shopAssistant.phoneNum) &&
                seniority == shopAssistant.seniority);

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCommission(double commission) { this.commission = commission; }

    public void setMonthlySalary(double monthlySalary) { this.monthlySalary = monthlySalary; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public int getSeniority() { return seniority; }

    public double getMonthlySalaryBasis() { return monthlySalaryBasis; }

    public double getCommission() { return commission; }

    public double getMonthlySalary() { return monthlySalary; }
}


