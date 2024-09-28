package BusinessLayer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public abstract class BorrowedItem implements Searchable, Borrowable {

    private String itemNumber;
    private String title;
    private int priority;
    private String itemType;
    private Member customerType;
    private LocalDate startBorrow;
    private LocalDate endBorrow;



    public BorrowedItem(String[] itemAttributes){
        this.itemNumber = itemAttributes[0];
        this.title = itemAttributes[1];
        this.priority = decidePriority(itemAttributes[2]);
        this.itemType = itemAttributes[3];
        this.customerType = createCustomer(itemAttributes[6]);


        String[] startTime = itemAttributes[7].split("/");
        String[] endTime = itemAttributes[8].split("/");

        int startDay = Integer.parseInt(startTime[0]);
        int startMonth = Integer.parseInt(startTime[1]);
        int startYear = Integer.parseInt(startTime[2]);

        int endDay = Integer.parseInt(endTime[0]);
        int endMonth = Integer.parseInt(endTime[1]);
        int endYear = Integer.parseInt(endTime[2]);

        this.startBorrow = LocalDate.of(startYear, startMonth, startDay);
        this.endBorrow = LocalDate.of(endYear, endMonth, endDay);
    }

    private int decidePriority(String priorityString){

        Priority itemPriority = Priority.valueOf(priorityString.replace(" ", "_").toUpperCase());
        priority = itemPriority.ordinal()+1;
        return priority;
    }

    private Member createCustomer(String customer){
        switch (customer) {
            case "general" -> customerType = new General();
            case "studentWScholar" -> customerType = new StudentWScholar();
            case "studentWOScholar" -> customerType = new StudentWoScholar();
        }
        return customerType;
    }

    public void searchByTitle(String title, ArrayList<BorrowedItem> itemArrayList ){
        boolean contains = false;
        for (int i = 0; i < itemArrayList.size(); i++) {
            if (itemArrayList.get(i).title.equals(title)) {
                contains = true;
                System.out.println("Exists " + itemArrayList.get(i));
            }
        }
        if(!contains){
            System.out.println("Does not exist." );
        }
    }

    public void searchByTitleAndType(String title, String itemType, ArrayList<BorrowedItem> itemArrayList ){
        boolean contains = false;
        for (int i = 0; i < itemArrayList.size(); i++) {
            if (itemArrayList.get(i).title.equals(title) && itemArrayList.get(i).itemType.equals(itemType)) {
                contains = true;
                System.out.println("Exists " + itemArrayList.get(i));
            }
        }
        if(!contains){
            System.out.println("Does not exist." );
        }

    }

    public int calculateBorrowedTime(){
        long borrowedTime = ChronoUnit.DAYS.between(startBorrow, endBorrow);
        int time = (int) borrowedTime;
        return time;
    }
    public abstract int getDailyPrice();

    @Override
    public double calculateBorrowingCharge() {
        return this.getDailyPrice() * calculateBorrowedTime() * priority;
    }

    @Override
    public double calculateDiscount() {
        return this.customerType.getDiscount();
    }

    @Override
    public abstract double calculateLateCharge();

    @Override
    public double calculateTotalCharge() {
        double totalCharge = this.calculateBorrowingCharge() -
                this.calculateDiscount()*this.calculateBorrowingCharge() +
                this.calculateLateCharge();
        return totalCharge;
    }
    public abstract String decideExceed();

    public String getItemNumber(){
        return this.itemNumber;}

    public int getPriority(){
        return this.priority;
    }
    public String getItemType(){
        return this.itemType;
    }
    public String getTitle(){
        return this.title;
    }
    public String toString(){
        return "Item Number: "  + this.getItemNumber() + " Title: " + this.getTitle() +
                " Item Type: " + this.getItemType() + " Borrowing Days: " + calculateBorrowedTime() + " days Exceed: " +
                this.decideExceed() + " Total Price: " + this.calculateTotalCharge()  + "$";

    }

}

