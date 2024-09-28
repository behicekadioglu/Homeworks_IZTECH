package BusinessLayer;

public class Book extends BorrowedItem {
    private String author;
    private String publisher;

    private final int dailyPrice = 5;

    private final int penaltyDay = 10;

    public Book(String[] bookAttributes) {
        super(bookAttributes);
        this.author = bookAttributes[4];
        this.publisher = bookAttributes[5];
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public double calculateLateCharge() {
        double lateCharge = 0;
        if (this.calculateBorrowedTime() > penaltyDay) {
            lateCharge = 5;
        }
        return lateCharge;


    }
    public String decideExceed(){
        if (this.calculateBorrowedTime() > penaltyDay) {
            return "Exceed";
        }
        else{
            return "Not Exceed";
        }
    }

}
