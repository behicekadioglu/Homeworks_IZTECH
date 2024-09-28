public class SalesManagementApp {
    public static void main(String[] args) {
    	
        SalaryManagement salaryManagementObject= new SalaryManagement("shopAssistants.csv");
        ShopAssistant[] assistants = salaryManagementObject.getShopAssistants();

        TransactionManagement transactionManagementObject = new TransactionManagement("products.csv");
        Product[] products = transactionManagementObject.getProducts();

        Transaction[][] transactions = transactionManagementObject.determineTransactions(assistants);
        salaryManagementObject.calculateCommissionsAndMonthlySalaries(transactions);


        Query query = new Query(transactions, assistants);
        query.printData();
    }

}