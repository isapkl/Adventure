public class RangedWeapon extends Weapon{

    private int ammunition;

    public RangedWeapon(String shortName, String longName, int damage) {
        super(shortName, longName, damage);
    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public void use() {
        ammunition--;
    }
    public String getAttackVerb(){
        return "fire";
    }

    public String getUsesLeftText(){
        return "You have " + ammunition + " uses left";
    }
}
