import java.util.ArrayList;

public abstract class Location {
    private String name;

    // default constructor
    public Location (){
        this("");
    }

    // constructor
    public Location(String name){
        this.name = name;
    }

    // copy constructor
    public Location(Location otherLocation){
        this.name = otherLocation.getName();
    }

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return ("The name of this location is" + name + ".");
    }
}
