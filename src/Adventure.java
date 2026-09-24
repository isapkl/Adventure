public class Adventure {
    private Player player;
    private Map map;

    public void look(){
        System.out.println(player.getCurrentRoom().getName());
        System.out.println(player.getCurrentRoom().getDescription());
    }
    public Adventure(Player player) {
        this.player = player;
    }

    public void start() {
        map = new Map();
        player = new Player(map);
        Adventure adventure = new Adventure(player);

        UserInterface ui = new UserInterface(player, adventure);
        ui.startProgram();
    }
}