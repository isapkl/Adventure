public class Map {

    private Room r1 = new Room("Room 1", "A white room with a red carpet");
    private Room r2 = new Room("Room 2", "A dark cave with water dripping from the ceiling");
    private Room r3 = new Room("Room 3", "A volcanic room filled with lava and a small path");
    private Room r4 = new Room("Room 4", "A tropical cave with foliage everywhere");
    private Room r5 = new Room("Room 5", "A mystical empty closet that leads to...?");
    private Room r6 = new Room("Room 6", "A room made of cobblestone");
    private Room r7 = new Room("Room 7", "A room with a suspicious waterfall");
    private Room r8 = new Room("Room 8", "A dark cave with wet yet sandy floor");
    private Room r9 = new Room("Room 9", "A suspicous waterfall made of sand");


    Weapon sword = new MeleeWeapon("sword", "a long sword", 10);
    Weapon pistol = new RangedWeapon("pistol", "an old muzzle-loading pistol", 25, 1);
    Weapon knives = new RangedWeapon("knives", "a set of throwing knives", 15, 3);
    Weapon halberd = new MeleeWeapon("halberd", "a heavy halberd", 20);
    Weapon wand = new MagicWand("wand", "a glowing magic wand", 30, 5);

    Enemy troll = new Enemy("troll", "a dangerous troll", "with sharp teeth", 40, sword, r4);

    Item aRedKey = new Item("red key", "a red key with an ominous aura");
    Item aBlueKey = new Item("blue key", "a blue key with an ominous aura");
    Item aBucket = new Item("bucket", "an empty copper bucket");
    Item aCoin = new Item("coin", "a gold coin");
    Item aLamp = new Item("lamp", "a shiny brass lamp");

    public Map(){
        setConnectionWestEast(r1, r2);
        setConnectionWestEast(r2, r3);
        setConnectionNorthSouth(r3, r6);
        setConnectionNorthSouth(r6, r9);
        setConnectionWestEast(r8, r9);
        setConnectionWestEast(r7, r8);
        setConnectionNorthSouth(r4, r7);
        setConnectionNorthSouth(r1, r4);
        setConnectionNorthSouth(r5, r8);

        r1.addItem(sword);
        r1.addItem(aRedKey);
        r2.addItem(aLamp);
        r6.addItem(aCoin);
        r7.addItem(aBucket);
        r8.addItem(aBlueKey);
        r1.addItem(unHealthyMushroom);
        r4.addItem(watermelon);
        r3.addItem(cookedChicken);
        r2.addItem(deadAnimal);
        r5.addItem(chicken);
        r6.addItem(healthyMushroom);
        r7.addItem(bread);
        r2.addItem(pistol);
        r4.addItem(knives);
        r6.addItem(halberd);
        r9.addItem(wand);
        r4.addEnemy(troll);


    }


    private void setConnectionWestEast(Room w, Room e) {
        w.setEast(e);
        e.setWest(w);
    }
    private void setConnectionNorthSouth(Room n, Room s){
        n.setSouth(s);
        s.setNorth(n);
    }
    public Room getStartRoom() {
        return r1;
    }

    Food bread = new Food("bread", "a loaf of stale bread", 10);
    Food unHealthyMushroom = new Food ("mushy", "a very unhealthy mushroom", -2);
    Food healthyMushroom = new Food ("mushroom", "a very healthy mushroom", 30);
    Food watermelon = new Food ("watermelon", "a juicy tasty watermelon", 25);
    Food chicken = new Food ("chicken", "a raw chicken", -15);
    Food cookedChicken = new Food ("cooked Chicken", "a tasty cooked Chicken", 50);
    Food deadAnimal = new Food ("Bob", "an abandon dead animal", -40);


}
