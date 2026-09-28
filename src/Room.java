import java.util.ArrayList;

public class Room {
    private String name;
    private String description;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private ArrayList<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setNorth(Room north){
        this.north = north;
    }
    public Room getNorth(){
        return north;
    }

    public void setEast(Room east){
        this.east = east;
    }
    public Room getEast(){
        return east;
    }

    public void setSouth(Room south){
        this.south = south;
    }
    public Room getSouth(){
        return south;
    }

    public void setWest(Room west){
        this.west = west;
    }
    public Room getWest(){
        return west;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public ArrayList<Item> getItems() {
        for (int i = 0; i < items.size(); i++) {
            items.get(i);
        }
        return items;
    }
    public Item findItem(String shortname){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getShortName().equals(shortname)){
                return items.get(i);
            }
        }
        return null;
    }
}
