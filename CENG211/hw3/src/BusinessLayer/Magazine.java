package BusinessLayer;

public class Magazine extends BorrowedItem {
    private String genre;
    private String producer;
    private final int dailyPrice = 10;
    private final int penaltyDay = 7;


    public Magazine(String[]  magazineAttributes){
        super(magazineAttributes);
        this.genre = magazineAttributes[4];
        this.producer = magazineAttributes[5];
    }
    public int getDailyPrice(){
        return dailyPrice;
    }

    public double calculateLateCharge() {
        double lateCharge = 0;
        if(calculateBorrowedTime() > penaltyDay){
            lateCharge = 2;
        }
        return lateCharge;
    }
    public String decideExceed(){
        if (this.calculateBorrowedTime() > penaltyDay) {
            return ("Exceed");
        }
        else{
            return ("Not Exceed");
        }
    }

}

