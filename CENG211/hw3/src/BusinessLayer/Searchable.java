package BusinessLayer;

import java.util.ArrayList;

public interface Searchable {

    public void searchByTitle(String item, ArrayList<BorrowedItem> itemArrayList);

    public void searchByTitleAndType(String item, String type,  ArrayList<BorrowedItem> itemArrayList);
}
