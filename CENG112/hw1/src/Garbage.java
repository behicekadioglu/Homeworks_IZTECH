public class Garbage {
    public String nameOfItem;
    public String typeOfItem;
    public Integer numberOfGarbage;

    // constructer of the garbage
    public Garbage(String name, String type, String stringNumber)
    {
        nameOfItem = name;
        typeOfItem = type;

        // converts string to int
        // trim() removes white spaces from the string
        numberOfGarbage = Integer.parseInt(stringNumber.trim());
    }

    // returns the name of the garbage
    public String toString()
    {
        return nameOfItem;
    }


    // returns true if the type of the garbage is the given type
    public boolean equals(String type)
    {
        if (type.equals(typeOfItem))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // returns the garbage's type
    public String getType()
    {
        return typeOfItem;
    }

    public String toFileString()
    {
        String numberOfGarb = Integer.toString(numberOfGarbage);
        String result = nameOfItem + ", " + typeOfItem + ", " + numberOfGarb;
        return result;
    }

}
