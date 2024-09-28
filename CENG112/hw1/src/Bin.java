public class Bin<T> implements IBag<T>{
    // these class implements bag with array
    T[] bag;
    int numberOfItems;


    // adds T to the bag, returns true if it adds
    public boolean add(T newItem)
    {
        if (isFull())
        {
            return false;
        }
        else
        {
            bag[numberOfItems] = newItem;
            numberOfItems++;
            return true;
        }
    }

    // returns true if the bag is empty
    public boolean isEmpty()
    {
        return numberOfItems == 0;
    }

    // returns true if the bag is full
    public boolean isFull()
    {
        return numberOfItems >= bag.length;
    }

    // removes the item in the index and returns it
    public T removeByIndex(int index)
    {
        T result = null;
        if (!isEmpty() && (index >= 0)) {
            result = bag[index];  // gives the wanted item
            bag[index] = bag[numberOfItems-1];
            bag[numberOfItems-1] = null;
            numberOfItems -= 1;
        }
        return result;
    }

    // removes a random item and returns it
    public T remove()
    {
        T result = null;
        if (numberOfItems > 0)
        {
            result = bag[numberOfItems - 1]; // removes the last item in the bag
            bag[numberOfItems - 1] = null;
            numberOfItems--;
        }
        return result; // returns the removed item
    }

    // removes the item and returns it
    public T remove(T item)
    {
        int index = getIndexOf(item); // finds the item in the bag
        T result = removeByIndex(index);  // removes the item in the index
        return result; // returns the removed item
    }

    // gets the number of the items in the bag
    public int getItemCount()
    {
        return numberOfItems;
    }

    // gets the index of item
    public int getIndexOf(T item)
    {
        int counter = 0;
        for (int index = 0; index < numberOfItems; index++) {
            if (item.equals(bag[index])) {
                counter++;
            }
        }
        return counter;
    }

    // returns true if the item is in the bag
    public boolean contains(T item)
    {
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfItems))
        {
            if (item.equals(bag[index]))
            {
                found = true;
            }
            index++;
        }
        return found;
    }

    // it prints items of the bag
    public void displayItems()
    {
        for (int i=0; i<numberOfItems; i++)
        {
            System.out.print(" " + bag[i]);
        }
        System.out.println();
    }



    // removes all the items from the bag
    public void dump()
    {
        while (!isEmpty()){
            remove();
        }
    }

    // transfers the item to the targetBag, returns true if it transfers
    public boolean transferTo(IBag<T> targetBag, T item)
    {
        if (!targetBag.isFull())
        {
            targetBag.add(item);
            return true;
        }
        else
        {
            return false;
        }
    }

    // returns the item in the given index
    public T showItemByIndex(int index)
    {
        return bag[index];
    }

}
