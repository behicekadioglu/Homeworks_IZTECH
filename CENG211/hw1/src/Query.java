public class Query {
    private Transaction highestPriceTransaction;
    private Transaction lowestPriceTransaction;
    private Transaction highestFeeTransaction;
    private Transaction lowestFeeTransaction;
    private Product mostExpensiveProduct;
    private Product leastExpensiveProduct;
    private ShopAssistant highestSalaryAssistant;
    private ShopAssistant lowestSalaryAssistant;
    private double totalRevenue;
    private double totalProfit;

    public Query(Transaction[][] transactions, ShopAssistant[] assistants) {
        this.highestPriceTransaction = new Transaction(determineHighestPriceTransaction(transactions, assistants));
        this.lowestPriceTransaction = new Transaction(determineLowestPriceTransaction(transactions, assistants));
        this.highestFeeTransaction = new Transaction(determineHighestFeeTransaction(transactions, assistants));
        this.lowestFeeTransaction = new Transaction(determineLowestFeeTransaction(transactions, assistants));
        this.mostExpensiveProduct = new Product(determineMostExpensiveProduct(lowestPriceTransaction));
        this.highestSalaryAssistant = new ShopAssistant(determineHighestSalaryAssistant(assistants));
        this.totalProfit = determineTotalRevenue(transactions);
        this.totalRevenue =  determineTotalProfit(totalRevenue , assistants);
    }



    private Transaction determineHighestPriceTransaction(Transaction[][] transactions, ShopAssistant[] assistants) {
        Transaction maxTransaction = new Transaction(transactions[0][0]);
        for (int i = 0; i < transactions.length; i++) {
            for (int j = 0; j < assistants[i].NUMOFTRANSACTIONS; j++){
                if (transactions[i][j].getTotalPrice() > maxTransaction.getTotalPrice()) {
                maxTransaction = new Transaction(transactions[i][j]);
                }
            }
        }
        return maxTransaction;
    }

    private Transaction determineLowestPriceTransaction(Transaction[][] transactions, ShopAssistant[] assistants) {
        Transaction minTransaction = new Transaction(transactions[0][0]);
        for (int i = 0; i < transactions.length; i++) {
            for (int j = 0; j < assistants[i].NUMOFTRANSACTIONS; j++){
                if (transactions[i][j].getTotalPrice() < minTransaction.getTotalPrice()) {
                    minTransaction = new Transaction(transactions[i][j]);
                }
            }
        }
        return minTransaction;
    }

    private Transaction determineHighestFeeTransaction(Transaction[][] transactions, ShopAssistant[] assistants) {
        Transaction maxTransactionFee = new Transaction(transactions[0][0]);
        for (int i = 0; i < transactions.length; i++) {
            for (int j = 0; j < assistants[i].NUMOFTRANSACTIONS; j++){
                if (transactions[i][j].getTransactionFee() > maxTransactionFee.getTransactionFee()) {
                    maxTransactionFee = new Transaction(transactions[i][j]);
                }
            }
        }
        return maxTransactionFee;
    }

    private Transaction determineLowestFeeTransaction(Transaction[][] transactions, ShopAssistant[] assistants) {
        Transaction minTransactionFee = new Transaction(transactions[0][0]);
        for (int i = 0; i < transactions.length; i++) {
            for (int j = 0; j < assistants[i].NUMOFTRANSACTIONS; j++){
                if (transactions[i][j].getTransactionFee() < minTransactionFee.getTransactionFee()) {
                    minTransactionFee = new Transaction(transactions[i][j]);
                }
            }
        }
        return minTransactionFee;
    }
    //finds the most expensive product in the lowest-price transaction.
    private Product determineMostExpensiveProduct(Transaction transaction){
        Product mostExpensiveProduct = new Product();
        for (int i = 0; i < transaction.getProductsOfTransaction().length; i++) {
            if (transaction.getProductsOfTransaction()[i].getPrice() > mostExpensiveProduct.getPrice()) {
                mostExpensiveProduct = new Product(transaction.getProductsOfTransaction()[i]);
            }
        }
        return mostExpensiveProduct;
    }

    private ShopAssistant determineHighestSalaryAssistant(ShopAssistant[] assistants) {
        ShopAssistant highestSalaryAssistant = new ShopAssistant();
        for (int i = 0; i < assistants.length; i++) {
                if (assistants[i].getMonthlySalary() > highestSalaryAssistant.getMonthlySalary()) {
                    highestSalaryAssistant = new ShopAssistant(assistants[i]);
                }

        }
        return highestSalaryAssistant;
    }


    private double determineTotalRevenue(Transaction[][] transactions) {
        totalRevenue = 0;
        for (int i = 0; i < transactions.length; i++) {
            for (int j = 0; j < transactions[i].length; j++) {
                totalRevenue += transactions[i][j].getTotalPrice();
            }
        }
        return totalRevenue;
    }

    private double determineTotalProfit(double totalRevenue , ShopAssistant[] assistants){
        double totalAssistantSalary = 0;
        for(int i = 0; i < assistants.length; i++){
            totalAssistantSalary += assistants[i].getMonthlySalary();
        }

        return totalRevenue - totalAssistantSalary;
    }


    public void printData() {
        System.out.println("The highest value transaction's ID is " + highestPriceTransaction.getId());

        System.out.println("The most expensive product in the least expensive transaction is " + mostExpensiveProduct.getProductName());

        System.out.println("The lowest transaction fee is " + lowestFeeTransaction.getTransactionFee());

        System.out.println("The highest salary shop assistant's ID is " + highestSalaryAssistant.getId()
                + ", his/her name is " + highestSalaryAssistant.getName() + " " + highestSalaryAssistant.getSurname()
                + ", his/her seniority is " + highestSalaryAssistant.getSeniority()
                + ", his/her commission is " + highestSalaryAssistant.getCommission()
                + " and his/her total salary is " + highestSalaryAssistant.getMonthlySalary());

        System.out.println("Total revenue from these transactions is " + totalRevenue);

        System.out.println("Total profit from these transactions is " + totalProfit);
    }


}



























