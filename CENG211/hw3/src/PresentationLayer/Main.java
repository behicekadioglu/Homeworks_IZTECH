package PresentationLayer;

import DataAccessLayer.FileIO;
import BusinessLayer.BorrowedItem;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<BorrowedItem> borrowedItemArrayList = FileIO.readFile("items.csv"); //
        for (BorrowedItem item: borrowedItemArrayList) {
            System.out.println(item);
        }
        //using one borroweditem object to call methods
        borrowedItemArrayList.get(0).searchByTitleAndType("History of Art" , "book", borrowedItemArrayList);
        borrowedItemArrayList.get(0).searchByTitle("Animal Farm", borrowedItemArrayList);
    }
}