public class Adventure {
    private Player player;
    private Map map;

    public void look(){
        System.out.println(player.getCurrentRoom().getName());
        System.out.println(player.getCurrentRoom().getDescription());
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
}