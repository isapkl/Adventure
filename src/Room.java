public class Room {
    private String name;
    private String description;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public void setNorth(Room room){

    }
    public Room getNorth(){
    }
}
