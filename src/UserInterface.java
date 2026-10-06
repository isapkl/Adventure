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
                    System.out.println("There is no item here called " + itemTake);
                }

            } else if (command.startsWith("drop ")) {

                String itemDrop = command.substring(5).trim();
                Item dropItem = adventure.dropItem(itemDrop);

                if (dropItem != null) {
                    System.out.println("You dropped " + dropItem.getLongName());
                } else {
                    System.out.println("You don't have an item called " + itemDrop + " in your inventory");
                }

            } else if (command.startsWith("equip ")) {

                String itemEquip = command.substring(6).trim();
                EquipResult result = adventure.equip(itemEquip);

                switch (result) {
                    case NOT_FOUND ->
                            System.out.println("You don't have that item.");

                    case NOT_WEAPON ->
                            System.out.println("That item is not a weapon.");

                    case EQUIPPED ->
                            System.out.println("You equipped the " + itemEquip + ".");
                }

            } else if (command.startsWith("eat ")) {

                String itemEat = command.substring(4).trim();
                EatOutcome outcome = adventure.eat(itemEat);

                switch (outcome.getResult()) {

                    case NOT_FOUND -> {
                        System.out.println(
                                "There is nothing like " + itemEat + " to eat around here"
                        );
                    }

                    case NOT_FOOD -> {
                        System.out.println(
                                "You cannot eat the " + outcome.getItemName()
                        );
                    }

                    case EATEN -> {
                        System.out.print(
                                "You eat the " + outcome.getItemName() + ". "
                        );

                        if (outcome.getHealthChange() > 0) {
                            System.out.println(
                                    "You feel a little better. You gain "
                                            + outcome.getHealthChange()
                                            + " health"
                            );
                        } else {
                            System.out.println(
                                    "That was a mistake. "
                                            + outcome.getHealthChange()
                                            + " health"
                            );
                        }
                    }
                }

            } else if (command.startsWith("attack ")) {

                String enemyName = command.substring(7).trim();

                AttackResult result = adventure.attack(enemyName);

                switch (result) {

                    case NO_WEAPON ->
                            System.out.println("You have no weapon equipped.");

                    case CANNOT_USE ->
                            System.out.println("You cannot use that weapon.");

                    case ENEMY_NOT_FOUND ->
                            System.out.println(
                                    "There is no enemy here called " + enemyName
                            );

                    case ENEMY_HIT -> {
                        Weapon weapon = adventure.getEquipped();

                        System.out.println(
                                "You hit " + enemyName
                                        + " with " + weapon.getLongName()
                                        + " for " + weapon.getDamage()
                                        + " damage."
                        );


                    }

                    case ENEMY_DIED ->
                            System.out.println(enemyName + " died.");
                }

            } else {

                switch (command) {

                    case "go north", "north", "n",
                         "go south", "south", "s",
                         "go west", "west", "w",
                         "go east", "east", "e" -> {

                        if (adventure.movePlayer(direction)) {
                            System.out.println(
                                    adventure.getCurrentRoom().getName()
                            );
                            System.out.println(
                                    adventure.getCurrentRoom().getDescription()
                            );
                            if (adventure.getCurrentRoom().getEnemies().isEmpty()) {
                                System.out.println("There are no enemies here.");
                            } else {
                                System.out.println("Enemies:");

                                for (Enemy enemy : adventure.getCurrentRoom().getEnemies()) {
                                    System.out.println("- " + enemy.getShortName());
                                }
                            }
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

                    case "health" -> {

                        int health = adventure.getHealth();

                        System.out.print("health: " + health + " - ");

                        if (health >= 100) {

                            System.out.println(
                                    "you are in perfect health"
                            );

                        } else if (health >= 50) {

                            System.out.println(
                                    "you are in good health, but avoid fighting right now"
                            );

                        } else if (health >= 25) {

                            System.out.println(
                                    "you are wounded - find something healthy to eat"
                            );

                        } else if (health >= 1) {

                            System.out.println(
                                    "you are barely alive"
                            );

                        } else {
                            System.out.println("dead");
                        }
                    }

                    case "take" -> {
                        System.out.println(
                                "Write the name of the item you wish to take e.g. take sword"
                        );
                    }

                    case "drop" -> {
                        System.out.println(
                                "Write the name of the item you wish to drop e.g. drop sword"
                        );
                    }

                    case "inventory" -> {

                        if (adventure.getInventory().isEmpty()) {
                            System.out.println("Inventory is empty.");
                        } else {

                            System.out.println("Your inventory: ");

                            for (Item item : adventure.getInventory()) {
                                System.out.println(
                                        "- " + item.getLongName()
                                );
                            }
                        }
                    }

                    case "eat" -> {
                        System.out.println(
                                "Write the name of the item you wish to eat e.g. eat watermelon"
                        );
                    }

                    case "attack" -> {
                        AttackResult result = adventure.attack("");

                        switch (result) {

                            case NO_WEAPON ->
                                    System.out.println("You have no weapon equipped.");

                            case CANNOT_USE ->
                                    System.out.println("You cannot use that weapon.");

                            case ATTACK -> {
                                Weapon weapon = adventure.getEquipped();

                                System.out.println(
                                        "You " + weapon.getAttackVerb() + " "
                                                + weapon.getLongName()
                                                + " at the empty air. "
                                                + weapon.getUsesLeftText()
                                );
                            }

                            case ENEMY_NOT_FOUND ->
                                    System.out.println("There is no enemy here.");

                            case ENEMY_HIT ->{
                                    Enemy enemy = adventure.getCurrentRoom().getEnemies().get(0);

                            System.out.println(
                                    "You hit the " + enemy.getShortName() +
                                            ". It has " + enemy.getHealth() + " health left."
                            );

                        }

                            case ENEMY_DIED ->
                                    System.out.println("The enemy died.");
                        }
                    }

                    case "equip" -> {
                        System.out.println(
                                "Write the name of the weapon you wish to equip e.g. equip sword"
                        );
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


    public void showHelp() {
        System.out.println("To move, type: go north, go south, go west, go east");
        System.out.println("Look: Description of your current room");
        System.out.println("Take: Take an item from the room");
        System.out.println("Drop: Drop an item from your inventory");
        System.out.println("Inventory: Show your items");
        System.out.println("Health: Show current health");
        System.out.println("Equip: Equip a weapon");
        System.out.println("Attack: Use a weapon to attack");
        System.out.println("Eat: Eat an item");
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
