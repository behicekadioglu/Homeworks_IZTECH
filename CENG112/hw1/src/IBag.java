public interface IBag<T> {

    // adds T to the bag
    // returns true if it adds
    boolean add(T newItem);


    // returns true if the bag is empty
    boolean isEmpty();

    
    // returns true if the bag is full
    boolean isFull();

    
    // removes the item in the index and returns it
    T removeByIndex(int index);

    
    // removes a random item and returns it
    T remove();

    
    // removes the item and returns it
    T remove(T item);

    
    // gets the number of the items in the bag
    int getItemCount();

    
    // gets the index of item
    int getIndexOf(T item);

    
    // returns true if the item is in the bag
    boolean contains(T item);

    
    // it prints items of the bag
    void displayItems();

    
    // removes all the items from the bag
    void dump();

    
    // transfers the item to the targetBag
    // returns true if it transfers
    boolean transferTo(IBag<T> targetBag, T item);

    // returns the item in the given index
    T showItemByIndex(int index);
}
