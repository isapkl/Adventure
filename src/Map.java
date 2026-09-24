public class Map {

    private Room r1 = new Room("Room 1", "A white room with a red carpet");
    private Room r2 = new Room("Room 2", "A dark cave with water dripping from the ceiling");
    private Room r3 = new Room("Room 3", "A volcanic room filled with lava and a small path");
    private Room r4 = new Room("Room 4", "A tropical cave with foliage everywhere");
    private Room r5 = new Room("Room 5", "A mystical empty closet that leads to...?");
    private Room r6 = new Room("Room 6", "A room made of cobblestone");
    private Room r7 = new Room("Room 7", "A room with a suspicious waterfall");
    private Room r8 = new Room("Room 8", "A dark cave with wet yet sandy floor");
    private Room r9 = new Room("Room 9", "A suspicous waterfall made of sand");

    public Map(){
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
    public Room getStartRoom() {
        return r1;
    }
}
