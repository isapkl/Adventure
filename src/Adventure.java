public class Adventure {
    private Player player;
    private Map map;

    public String look(){
        return player.getCurrentRoom().getDescription();
    }

    public static void main(String[] args) {
        Map map = new Map();
        Player player = new Player(map);

        UserInterface ui = new UserInterface(player);
        ui.startProgram();


    }
}