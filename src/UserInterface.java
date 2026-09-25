import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    private Scanner scanner;


    public UserInterface(Adventure adventure) {
        scanner = new Scanner(System.in);
        this.adventure = adventure;
    }

    public void startProgram() {

        while (true) {
            System.out.print("Where do you want to go?: ");
            String command = scanner.nextLine().trim().toLowerCase();
            String direction = parseInput(command);

            switch (command) {
                case "go north", "north", "n",
                     "go south", "south", "s",
                     "go west", "west", "w",
                     "go east", "east", "e" -> {
                    if (adventure.movePlayer(direction)) {
                        System.out.println(adventure.getCurrentRoom().getName());
                        System.out.println(adventure.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("You cannot go that way");
                    }
                }
                case "look" -> {
                    adventure.look();
                }
                case "help" -> {
                    showHelp();
                }
                case "exit" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Unknown command");
            }
        }
    }

    public void showHelp(){
            System.out.println("To move, type: go north, go south, go west, go east");
            System.out.println("Look: Description of your current room");
            System.out.println("Help: Show commands");
            System.out.println("Exit: Quit the game");
    }

    public String parseInput(String command) {
        return switch (command) {
            case "go north", "north", "n" -> "north";
            case "go south", "south", "s" -> "south";
            case "go west", "west", "w" -> "west";
            case "go east", "east", "e" -> "east";
            default -> command;
        };
    }

}
