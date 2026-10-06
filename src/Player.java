import java.util.ArrayList;

public class Player {

    private Map map;
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health = 100;
    private Weapon equipped;

    public int getHealth() {
        return health;

    }
    public void hit(int damage) {
        health -= damage;
    }

        public EatOutcome eat(String shortName) {

            Item item = findItem(shortName);

            if (item == null) {
                item = currentRoom.findItem(shortName);
            }

            if (item == null) {
                return new EatOutcome(EatResult.NOT_FOUND, null, 0);
            }

            if (!(item instanceof Food)) {
                return new EatOutcome(
                        EatResult.NOT_FOOD,
                        item.getLongName(),
                        0
                );
            }

            Food food = (Food) item;

            health += food.getHealthPoints();

            inventory.remove(item);
            currentRoom.removeItem(item);

            return new EatOutcome(
                    EatResult.EATEN,
                    item.getShortName(),
                    food.getHealthPoints()
            );
        }

        public Weapon getEquipped(){
            return equipped;
        }

        public EquipResult equip(String shortName){
        Item item = findItem(shortName);

        if (item == null){
            return EquipResult.NOT_FOUND;
        }
        Weapon weapon = item.getWeapon();

        if(weapon == null){
            return EquipResult.NOT_WEAPON;
        }
        equipped = weapon;

        return EquipResult.EQUIPPED;
        }

    public AttackResult attack(String enemyName){

        if (equipped == null){
            return AttackResult.NO_WEAPON;
        }
        if(!equipped.canUse()){
            return AttackResult.CANNOT_USE;
        }
        Enemy enemy = currentRoom.findEnemy(enemyName);

        if (enemy == null) {
            return AttackResult.ENEMY_NOT_FOUND;
        }

        equipped.use();

        enemy.hit(equipped.getDamage());

        if (enemy.isDead()) {
            enemy.die();
            return AttackResult.ENEMY_DIED;
        }

        hit(enemy.getWeapon().getDamage());

        return AttackResult.ENEMY_HIT;
    }

    public Player(Map map) {
        this.map = map;
        this.currentRoom = map.getStartRoom();
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


    public boolean move(String direction) {
        Room desiredRoom = switch (direction) {
            case "north" -> currentRoom.getNorth();
            case "south" -> currentRoom.getSouth();
            case "west" -> currentRoom.getWest();
            case "east" -> currentRoom.getEast();
            default -> null;
        };
        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }
    }

    public void addItem(Item item){
        inventory.add(item);
    }
    public void removeItem(Item item){
        inventory.remove(item);
    }
    public Item takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);

        if (item != null) {
            currentRoom.removeItem(item);
            inventory.add(item);
            return item;
        }

        return null;
    }

    public Item dropItem(String shortName){
        Item item = findItem(shortName);

        if (item != null) {
            inventory.remove(item);
            currentRoom.addItem(item);

            if (item == equipped) {
                equipped = null;
            }

            return item;
        }
        return null;
    }
    public Item findItem(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }
    public ArrayList<Item> getInventory(){
        return inventory;
    }


}
