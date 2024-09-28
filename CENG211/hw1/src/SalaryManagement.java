public class SalaryManagement {

    private ShopAssistant[] shopAssistants;

    public SalaryManagement(String fileName){
        this.shopAssistants = FileIO.readAssistantFile(fileName);
    }

    public ShopAssistant[] getShopAssistants() {
        return shopAssistants;
    }

    public void calculateCommissionsAndMonthlySalaries(Transaction[][] transactions){
        for (int i=0; i<transactions.length; i++){
            double counter = 0;
            for (int j=0; j<transactions[i].length; j++){
                counter = counter + transactions[i][j].getTotalPrice() + transactions[i][j].getTransactionFee();
            }
            if (counter < 7500){
                transactions[i][0].getAssistantOfTransaction().setCommission(0.01);
                double salary = counter*1.01;
                transactions[i][0].getAssistantOfTransaction().setMonthlySalary(salary);
            }
            else if (counter < 7500){
                transactions[i][0].getAssistantOfTransaction().setCommission(0.03);
                double salary = counter*1.03;
                transactions[i][0].getAssistantOfTransaction().setMonthlySalary(salary);
            }
        }
    }

}
