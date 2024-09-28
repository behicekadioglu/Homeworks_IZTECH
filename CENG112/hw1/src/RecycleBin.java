import java.util.Random;

public class RecycleBin<T> extends Bin<T>{
    // capacity of the recycle bins will be randomized from 5, 10 and 15.
    Random random = new Random();
    int randomCap = random.nextInt(3);
    int capacity = (randomCap + 1) * 5;

    // constructor of the recycle bins
    public RecycleBin()
    {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity]; // Unchecked cast
        bag = tempBag;
        numberOfItems = 0;
    }

    // returns the capacity of the recycle bin
    public int getCapacity()
    {
        return capacity;
    }
}
