import java.util.Scanner;

public class UserInterface {

    public void start() {
        Adventure a = new Adventure();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Where do you want to go?: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "go north", "north",
                     "go south", "south",
                     "go west", "west",
                     "go east", "east" -> {

                    if (a.moveToRoom(command)) {
                        System.out.println(a.getCurrentRoom().getName());
                        System.out.println(a.getCurrentRoom().getDescription());
                    } else {
                        System.out.println("You cannot go that way");
                    }
                }

                case "look" -> {
                    System.out.println(a.getCurrentRoom().getName());
                    System.out.println(a.getCurrentRoom().getDescription());
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
}
