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

}
