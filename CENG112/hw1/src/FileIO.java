import java.io.*;

public class FileIO {

    // reads the file and returns all the lines as a String array
    public static String[] readFileIntoArray(String fileName) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try
        {
            // reads file and converts all file to a single string
            StringBuilder sb = new StringBuilder();
            String line = br.readLine(); // reads lines from the file
            while (line != null)
            {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString(); // creates a string from the file's contents

            // splits the string according to lines and creates a new array of them
            String[] allLines = everything.split("\n");
            return allLines;
        }
        finally
        {
            br.close();
        }
    }
    public static IBag<Garbage> readTrashCan(String fileName) throws IOException {
        // reads file and create a String array from it
        String[] garbageLines = readFileIntoArray("garbage.txt");

        // creates a trash object which is our trash can
        TrashCan<Garbage> trash = new TrashCan<>();

        // create garbage objects and adds them to the trash
        for (int i=0; i<garbageLines.length; i++) {
            // creates arrays from the string array, according to ","s inside the strings
            // does this for all lines in the file
            String[] garb = garbageLines[i].split(",");

            // creates garbage objects for all lines in the file
            Garbage garbage = new Garbage(garb[0], garb[1], garb[2]);


            // looks at the number of items for each garbage and adds this much to the trash
            for (int j = 0; j < garbage.numberOfGarbage; j++) {
                trash.add(garbage);
            }
        }
        return trash;
    }

    // updates contents of the trash can according to recycle bins
    public TrashCan<Garbage> updateTrashCan(TrashCan<Garbage> trashCan, FabricRecycleBin<Garbage> fabricBin,
                                            GlassRecycleBin<Garbage> glassBin, MetalRecycleBin<Garbage> metalBin,
                                            OrganicRecycleBin<Garbage> organicBin, PaperRecycleBin<Garbage> paperBin,
                                            PlasticRecycleBin<Garbage> plasticBin)
    {
        for (int i=0; i<fabricBin.getCapacity(); i++)
        {
            Garbage item = fabricBin.showItemByIndex(i);
            trashCan.remove(item);
        }

        for (int i=0; i<glassBin.getCapacity(); i++)
        {
            Garbage item = glassBin.showItemByIndex(i);
            trashCan.remove(item);
        }

        for (int i=0; i<metalBin.getCapacity(); i++)
        {
            Garbage item = metalBin.showItemByIndex(i);
            trashCan.remove(item);
        }

        for (int i=0; i<organicBin.getCapacity(); i++)
        {
            Garbage item = organicBin.showItemByIndex(i);
            trashCan.remove(item);
        }

        for (int i=0; i<paperBin.getCapacity(); i++)
        {
            Garbage item = paperBin.showItemByIndex(i);
            trashCan.remove(item);
        }

        for (int i=0; i<plasticBin.getCapacity(); i++)
        {
            Garbage item = plasticBin.showItemByIndex(i);
            trashCan.remove(item);
        }
        return trashCan;
    }


}

