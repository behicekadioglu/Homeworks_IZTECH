import java.util.Random;

public class Transaction {
    private int id;
    private Product[] productsOfTransaction;
    private double totalPrice;
    private double transactionFee;
    private ShopAssistant assistantOfTransaction;

    public Transaction(int id, Product[] products) {
        this.id = id;
        this.productsOfTransaction = determineProducts(products,3);
        this.totalPrice = determineTotalPrice();
        this.transactionFee = determineTransactionFee();
        this.assistantOfTransaction = null;
    }

    public Transaction() {
        this.id = 0;
        this.productsOfTransaction = null;
        this.totalPrice = 0.0;
        this.transactionFee = 0.0;
        this.assistantOfTransaction = null;
    }

    public Transaction(Transaction transaction) {
        this.id = transaction.getId();
        setProductsOfTransaction(transaction.getProductsOfTransaction());
        this.totalPrice = transaction.getTotalPrice();
        this.transactionFee = transaction.getTransactionFee();
        setAssistantOfTransaction(transaction.getAssistantOfTransaction());
    }


    public Product[] determineProducts(Product[] products, int numberOfProducts){

        Random random = new Random();
        int randomId1 = random.nextInt(products.length);
        int randomId2 = random.nextInt(products.length);

        while(randomId2 == randomId1){
            randomId2 = random.nextInt(products.length);
        }

        int randomId3 = random.nextInt(products.length);
        while(randomId3 == randomId1 || randomId3 == randomId2){
            randomId3 = random.nextInt(products.length);
        }

        Product[] productsOfTransaction = {new Product(products[randomId1]), new Product(products[randomId2]), new Product(products[randomId3])};

        return productsOfTransaction;
    }

    private double determineTotalPrice(){
        double totalPrice = productsOfTransaction[0].getPrice()*productsOfTransaction[0].getQuantity() +
                productsOfTransaction[1].getPrice()*productsOfTransaction[1].getQuantity() +
                productsOfTransaction[2].getPrice()*productsOfTransaction[2].getQuantity();
        return totalPrice;
    }

    private double determineTransactionFee(){
        double transactionFee = 0.0;

        if (totalPrice <= 499){
            transactionFee = (1*totalPrice)/100;
        }
        else if (totalPrice <= 799 && totalPrice >= 500){
            transactionFee = (3*totalPrice)/100;
        }
        else if (totalPrice <= 999 && totalPrice >= 800){
            transactionFee = (5*totalPrice)/100;
        }
        else if (totalPrice >= 1000){
            transactionFee = (9*totalPrice)/100;
        }

        return transactionFee;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public ShopAssistant getAssistantOfTransaction(){
        return assistantOfTransaction;
    }

    public int getId() {
        return id;
    }

    public Product[] getProductsOfTransaction() {
        return productsOfTransaction;
    }


    public void setProductsOfTransaction(Product[] productsOfTransaction) {
        this.productsOfTransaction = productsOfTransaction;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssistantOfTransaction(ShopAssistant assistantOfTransaction) {
        this.assistantOfTransaction = assistantOfTransaction;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

