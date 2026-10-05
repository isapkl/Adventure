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
        return "You fire the " + getShortName() + " at the empty air";
    }

    public String getUsesLeftText(){
        return "You have " + ammunition + " uses left";
    }
}
