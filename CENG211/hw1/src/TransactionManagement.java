public class TransactionManagement {

    private Transaction[][] transactions;
    private Product[] products;

    public TransactionManagement(String productsFileName){
        products = FileIO.readProductFile(productsFileName);
    }

    public Transaction[][] determineTransactions(ShopAssistant[] assistants){
        Transaction[][] transactions = new Transaction[assistants.length][assistants[0].NUMOFTRANSACTIONS];
        for (int i=0; i<assistants.length; i++){
            for (int j=0; j<assistants[i].NUMOFTRANSACTIONS; j++){
                transactions[i][j] = new Transaction((i*assistants[i].NUMOFTRANSACTIONS)+j, products);
                transactions[i][j].setAssistantOfTransaction(assistants[i]);
            }
        }

        return transactions;
    }

    public Product[] getProducts(){ return products; }
    // Constructors, Getters & Setters
}
