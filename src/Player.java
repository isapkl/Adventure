import java.util.ArrayList;

public class Player {

    private Map map;
    private Room currentRoom;
    private ArrayList<Item> inventory;


    public Player(Map map) {
        this.map = map;
        this.currentRoom = map.getStartRoom();
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


    public boolean move(String direction) {
        Room desiredRoom = switch (direction) {
            case "north" -> currentRoom.getNorth();
            case "south" -> currentRoom.getSouth();
            case "west" -> currentRoom.getWest();
            case "east" -> currentRoom.getEast();
            default -> null;
        };
        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }
    }

    public void addItem(Item item){
        inventory.add(item);
    }
    public void removeItem(Item item){
        inventory.remove(item);
    }
//    public Item takeItem(String shortName){
//
//    }
//    public Item dropItem(String shortName){
//
//    }
//    public Item findItem(String shortName){
//
//    }
    public ArrayList<Item> getInventory(){
        return inventory;
    }

}
