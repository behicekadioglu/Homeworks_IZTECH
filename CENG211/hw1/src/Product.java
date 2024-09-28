import java.util.Random;

public class
Product {

    private int id;
    private double price;
    private String productName;
    private int quantity;

    public Product(){
        this(0,0.0, "" );
    }
    public Product(int id, double price, String name){
        this.id = id;
        this.price = price;
        this.productName = name;
        this.quantity = determineQuantity();

    }
    public Product(Product product){
        this.id = product.id;
        this.price = product.price;
        this.productName = product.productName;
        this.quantity = product.quantity;
    }

    public String toString(){
        return(id + " " + price + " " + productName);
    }

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Product product = (Product) obj;
        return (id == product.id) && (price == product.price) && (productName.equals(product.productName));
    }

    private int determineQuantity(){
        Random random = new Random();
        int randomInt = random.nextInt(10) + 1;
        return randomInt;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getId() {
        return id;
    }

    public int getQuantity(){return quantity; }

    //, Getters & Setters
}
