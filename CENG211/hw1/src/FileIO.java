import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

    // counts lines in the file
    private static int countNumberOfLines(String fileName) {
        int lineCount = 0;

        // reads file as lines and increments the count by one for each line
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    public static Product[] readProductFile(String fileName) {
        int numOfLines = countNumberOfLines(fileName); // gets the number of lines in the file
        String delimiter = ";";
        Product[] products = new Product[numOfLines]; // creates a new array for product objects in each line

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int counter = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                // while there more lines to read
                // splits each line for product id, name and price and creates a String array for each product
                String[] product = line.split(delimiter);
                //
                int id = Integer.parseInt(product[0]);
                String productName = product[1];
                double price = Double.parseDouble(product[2].replaceAll(",","."));
                products[counter] = new Product(id, price, productName);
                counter++;
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static ShopAssistant[] readAssistantFile(String fileName) {
        int numOfLines = countNumberOfLines(fileName);
        String delimiter = ";";
        ShopAssistant[] assistants = new ShopAssistant[numOfLines];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int counter = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] assistant = line.split(delimiter);
                int id = Integer.parseInt(assistant[0]);
                String name = assistant[1];
                String surname = assistant[2];
                String phoneNumber = assistant[3];
                assistants[counter] = new ShopAssistant(id, name, surname, phoneNumber);
                counter++;
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return assistants;
    }

    public void csvToArray(){

    }
}



