package DataAccessLayer;

import BusinessLayer.Book;
import BusinessLayer.BorrowedItem;
import BusinessLayer.Magazine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {

    public static ArrayList<BorrowedItem> readFile(String fileName) {

        String delimiter = ";";
        ArrayList<BorrowedItem> borrowedItems = new ArrayList<>(); // creates a new array for book objects in each line

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                // while there more lines to read
                // splits each line for books

                String[] temp = line.split(delimiter);
                if(temp[3].equals("book")) {

                    Book book = new Book(temp);
                    borrowedItems.add(book);
                }
                else if(temp[3].equals("magazine")) {
                        Magazine magazine = new Magazine(temp);
                        borrowedItems.add(magazine);
                    }

            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return borrowedItems;
    }
}
