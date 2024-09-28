public class TrashCan<T> extends Bin<T>{
    // capacity of the trash can 450
    int capacity = 450;

    // constructor of the trash can
    public TrashCan()
    {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity]; // Unchecked cast
        bag = tempBag;
        numberOfItems = 0;
    }


    // separates garbages into recycling bins
    public boolean separate(T item, FabricRecycleBin<T> fabricBin, GlassRecycleBin<T> glassBin,
                            MetalRecycleBin<T> metalBin, OrganicRecycleBin<T> organicBin,
                            PaperRecycleBin<T> paperBin, PlasticRecycleBin<T> plasticBin)
    {
        Garbage garbItem = (Garbage) item;
        String type = garbItem.getType();

        if (type.equals("fabric"))
        {
            return transferTo(fabricBin, item);
        }
        else if (type.equals("glass"))
        {
            return transferTo(glassBin, item);
        }
        else if (type.equals("metal"))
        {
            return transferTo(metalBin, item);
        }
        else if (type.equals("organic"))
        {
            return transferTo(organicBin, item);
        }
        else if (type.equals("paper"))
        {
            return transferTo(paperBin, item);
        }
        else if (type.equals("plastic"))
        {
            return transferTo(plasticBin, item);
        }
        else
        {
            System.out.println("there is a problem");
            return false;
        }
    }
    // returns the contents of the bag as an array
    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfItems]; // Unchecked cast
        for (int index = 0; index < numberOfItems; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }
}