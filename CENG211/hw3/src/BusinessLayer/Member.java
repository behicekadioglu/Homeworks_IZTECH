package BusinessLayer;

public abstract class Member {
    private double discount;
    public Member( double discount){
        this.discount = discount;
    }
    public double getDiscount(){
        return discount;
    }
}
