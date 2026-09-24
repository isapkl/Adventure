public class Main {
    public static void main(String[] args) {
        Adventure adventure = new Adventure(new Player(new Map()));

        adventure.start();
    }
}
