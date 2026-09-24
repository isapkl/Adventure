import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Player player;


    public UserInterface(Player player) {
        scanner = new Scanner(System.in);
        this.player = player;
    }

    public void startProgram() {

        while (true) {
            System.out.print("Where do you want to go?: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "go north", "north", "n",
                     "go south", "south", "s",
                     "go west", "west", "w",
                     "go east", "east", "e" -> {
                    if (player.move(command)) {
                        System.out.println(player.getCurrentRoom().getName());
                        System.out.println(player.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("You cannot go that way");
                    }
                }
                case "look" -> {
                    System.out.println(player.getCurrentRoom().getName());
                    System.out.println(player.getCurrentRoom().getDescription());
                }
                case "help" -> {
                    showHelp();
                }
                case "exit" -> {
                    System.out.println("Exiting game");
                    return;
                }
                default -> System.out.println("Unknown command");
            }
        }
    }

    public void showHelp(){
            System.out.println("Move: go north, go south, go west, go east");
            System.out.println("Look: Description of your current room");
            System.out.println("Help: Show commands");
            System.out.println("Exit: Quit the game");
    }

}
