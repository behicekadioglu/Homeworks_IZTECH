package BusinessLayer;

public interface Borrowable {

    public double calculateBorrowingCharge();

    public double calculateLateCharge();

    public double calculateDiscount();

    public double calculateTotalCharge();
}

