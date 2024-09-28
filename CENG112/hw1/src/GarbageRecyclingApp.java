import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GarbageRecyclingApp
{
    public static void main(String[] args) throws IOException
    {
        FileIO io = new FileIO();
        TrashCan<Garbage> trash = (TrashCan<Garbage>) io.readTrashCan("garbage.txt");

        // prints the current number of items and the contents of the trash can before separation
        System.out.print("Trash Can: " + "size = " + trash.numberOfItems + ", contents =");
        trash.displayItems();

        // creates recycle bins
        FabricRecycleBin<Garbage> fabricBin = new FabricRecycleBin<>();
        GlassRecycleBin<Garbage> glassBin = new GlassRecycleBin<>();
        MetalRecycleBin<Garbage> metalBin = new MetalRecycleBin<>();
        OrganicRecycleBin<Garbage> organicBin = new OrganicRecycleBin<>();
        PaperRecycleBin<Garbage> paperBin = new PaperRecycleBin<>();
        PlasticRecycleBin<Garbage> plasticBin = new PlasticRecycleBin<>();

        // separates garbages into recycling bins one by one
        for (int i=0; i< trash.getItemCount(); i++)
        {
            Garbage garbage = trash.showItemByIndex(i);
            trash.separate(garbage, fabricBin, glassBin, metalBin, organicBin, paperBin, plasticBin);
        }

        System.out.print("Fabric Recycle Bin: " + "size = " + fabricBin.numberOfItems + ", contents =");
        fabricBin.displayItems();

        System.out.print("Glass Recycle Bin: " + "size = " + glassBin.numberOfItems+ ", contents =");
        glassBin.displayItems();

        System.out.print("Metal Recycle Bin: " + "size = " + metalBin.numberOfItems + ", contents =");
        metalBin.displayItems();

        System.out.print("Organic Recycle Bin: " + "size = " + organicBin.numberOfItems + ", contents =");
        organicBin.displayItems();

        System.out.print("Paper Recycle Bin: " + "size = " + paperBin.numberOfItems + ", contents =");
        paperBin.displayItems();

        System.out.print("Plastic Recycle Bin: " + "size = " + plasticBin.numberOfItems + ", contents =");
        plasticBin.displayItems();


        TrashCan<Garbage> updatedTrash = io.updateTrashCan(trash, fabricBin, glassBin, metalBin, organicBin, paperBin, plasticBin);

        System.out.print("Updated Trash Can: " + "size = " + updatedTrash.numberOfItems + ", contents =");
        updatedTrash.displayItems();

        File updatedGarbageFile = new File("updatedGarbage.txt");

        FileWriter writer = new FileWriter("updatedGarbage.txt");

        for (int i=0; i<updatedTrash.numberOfItems;)
        {
            String updatedGarbage = updatedTrash.showItemByIndex(i).toFileString();
            writer.write(updatedGarbage+ "\n");
            i += updatedTrash.showItemByIndex(i).numberOfGarbage;
        }

        writer.close();

















    }


}
