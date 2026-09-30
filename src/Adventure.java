import java.util.ArrayList;

public class Adventure {
    private Player player;
    private Map map;

    public void look(){
        Room room = player.getCurrentRoom();

        System.out.println(player.getCurrentRoom().getName());
        System.out.println(player.getCurrentRoom().getDescription());
            if (room.getItems().isEmpty()) {
                System.out.println("There are no items here.");
            } else {
                System.out.println("Items:");
                for (Item item : room.getItems()) {
                    System.out.println("- " + item.getShortName());
                }
        }
    }

    public void start() {
        map = new Map();
        player = new Player(map);

        UserInterface ui = new UserInterface(this);
        ui.startProgram();
    }

    public boolean movePlayer(String direction) {
        return player.move(direction);
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }
    public Item takeItem(String shortName){
        return player.takeItem(shortName);
    }
    public Item dropItem(String shortName){
        return player.dropItem(shortName);
    }
    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public int getHealth() {
        return player.getHealth();
    }
    public EatOutcome eat(String shortName)
    {
        return player.eat(shortName);
    }
}