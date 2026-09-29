import java.util.Scanner;

public class UserInterface {
    private Adventure adventure;
    private Scanner scanner;

    boolean running = true;


    public UserInterface(Adventure adventure) {
        scanner = new Scanner(System.in);
        this.adventure = adventure;
    }

    public void startProgram() {

        while (running) {
            System.out.print("Where do you want to go?: ");
            String command = scanner.nextLine().trim().toLowerCase();
            String direction = parseInput(command);

            if (command.startsWith("take ")) {

                String itemTake = command.substring(5).trim();
                Item takeItem = adventure.takeItem(itemTake);

                if (takeItem != null) {
                    System.out.println("You took " + takeItem.getLongName());
                } else {
                    System.out.println("There is no item here called " + takeItem);
                }
            } else if (command.startsWith("drop ")) {

                String itemDrop = command.substring(5).trim();
                Item dropItem = adventure.dropItem(itemDrop);

                if (dropItem != null) {
                    System.out.println("You dropped " + dropItem.getLongName());
                } else {
                    System.out.println("You don't have an item called " + itemDrop + " in your inventory");
                }

            } else {

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

                    case "take" -> {
                        System.out.println("Write the name of the item you wish to take e.g. take sword");
                    }

                    case "drop" -> {
                        System.out.println("Write the name of the item you wish to drop e.g. drop sword");
                    }

                    case "inventory" -> {
                        if (adventure.getInventory().isEmpty()) {
                            System.out.println("Inventory is empty.");
                        } else {
                            System.out.println("Your inventory: ");
                            for (Item item : adventure.getInventory()) {
                                System.out.println("- " + item.getLongName());
                            }
                        }
                    }

                    case "exit" -> {
                        System.out.println("Goodbye!");
                        running = false;
                    }

                    default -> {
                        System.out.println("Unknown command");
                    }
                }
            }
        }
    }

    public void showHelp(){
            System.out.println("To move, type: go north, go south, go west, go east");
            System.out.println("Look: Description of your current room");
            System.out.println("Take: Take an item from the room");
            System.out.println("Drop: Drop an item from your inventory");
            System.out.println("Inventory: Show your items");
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
