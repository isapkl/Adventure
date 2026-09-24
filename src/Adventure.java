public class Adventure {
    private Player player;
    private Map map;

//    public void look(){
//        player.printRoomInfo();
//    }

    public static void start() {
        Map map = new Map();
        Player player = new Player(map);

        UserInterface ui = new UserInterface(player);
        ui.startProgram();


    }
}