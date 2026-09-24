import java.util.Scanner;

public class UserInterface {
//    private Scanner scanner;
//    private Adventure adventure;
    private Player player;


    public UserInterface(Player player) {
        this.player = player;
    }

    public void startProgram() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Where do you want to go?: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "go north", "north",
                     "go south", "south",
                     "go west", "west",
                     "go east", "east" -> {
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
                    System.out.println("Move: go north, go south, go west, go east");
                    System.out.println("Look: Description of your current room");
                    System.out.println("Help: Show commands");
                    System.out.println("Exit: Quit the game");
                }
                case "exit" -> {
                    System.out.println("Exiting game");
                    return;
                }
                default -> System.out.println("Unknown command");
            }
        }
    }
//    public String parseInput(String command) {
//        return command;
//    }
//
//    public void showHelp(){
//
//    }

}
