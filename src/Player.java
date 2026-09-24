public class Player {

    private Map map;
    private Room currentRoom;


    public Player(Map map) {
        this.map = map;
        this.currentRoom = map.getStartRoom();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


    public boolean move(String direction) {
        Room desiredRoom = switch (direction) {
            case "go north", "north", "n" -> currentRoom.getNorth();
            case "go south", "south", "s" -> currentRoom.getSouth();
            case "go west", "west", "w" -> currentRoom.getWest();
            case "go east", "east", "e" -> currentRoom.getEast();
            default -> null;
        };
        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }
    }

}
