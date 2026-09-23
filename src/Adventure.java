import java.util.Scanner;

public class Adventure {

    private Room r1 = new Room("Room 1", "A white room with a red carpet");
    private Room r2 = new Room("Room 2", "A dark cave with water dripping from the ceiling");
    private Room r3 = new Room("Room 3", "A volcanic room filled with lava and a small path");
    private Room r4 = new Room("Room 4", "A tropical cave with foliage everywhere");
    private Room r5 = new Room("Room 5", "A mystical empty closet that leads to...?");
    private Room r6 = new Room("Room 6", "A room made of cobblestone");
    private Room r7 = new Room("Room 7", "A room with a suspicious waterfall");
    private Room r8 = new Room("Room 8", "A dark cave with wet yet sandy floor");
    private Room r9 = new Room("Room 9", "A suspicous waterfall made of sand");

    public Adventure(){
        setConnectionWestEast(r1, r2);
        setConnectionWestEast(r2, r3);
        setConnectionNorthSouth(r3, r6);
        setConnectionNorthSouth(r6, r9);
        setConnectionWestEast(r8, r9);
        setConnectionWestEast(r7, r8);
        setConnectionNorthSouth(r4, r7);
        setConnectionNorthSouth(r1, r4);
        setConnectionNorthSouth(r5, r8);
    }
    private void setConnectionWestEast(Room w, Room e) {
        w.setEast(e);
        e.setWest(w);
    }
    private void setConnectionNorthSouth(Room n, Room s){
        n.setSouth(s);
        s.setNorth(n);
    }


    static void main(String[] args) {
        Adventure a = new Adventure();
      a.r1.setName("Room 1");
      a.r2.setName("Room 2");
      a.r3.setName("Room 3");
      a.r4.setName("Room 4");
      a.r5.setName("Room 5");
      a.r6.setName("Room 6");
      a.r7.setName("Room 7");
      a.r8.setName("Room 8");
      a.r9.setName("Room 9");

      Room currentRoom = a.r1;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Where do you want to go?: ");

            public boolean moveToRoom(String direction) {
            Room desiredRoom = switch (moveToRoom) {
                case "go north", "north" -> {
                    System.out.println("going north");
                    currentRoom.getNorth();
                }
                case "go south", "south" -> {
                    System.out.println("going south");
                    currentRoom.getSouth();
                }
                case "go west", "west" -> {
                    System.out.println("going west");
                    currentRoom.getWest();
                }
                case "go east", "east" -> {
                    System.out.println("going east");
                    currentRoom.setEast();
                }
                case "look" -> {
                    System.out.println("looking around");
                    System.out.println(currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                }
                case "exit" -> {
                    System.out.println("Exiting game");
                    return;
                }
                default -> {
                    null;
                    System.out.println("You cannot go that way");
                };
                if (desiredRoom != null) {
                    currentRoom = desiredRoom;
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        }
    }
}
