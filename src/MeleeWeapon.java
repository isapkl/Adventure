public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String shortName, String longName, int damage){
        super(shortName, longName, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {
        // ingenting – sværdet slides ikke
    }

    public String getAttackVerb(){
        return "You swing the " + getShortName() + " at the empty air";
    }

    public String getUsesLeftText(){
        return null;
    }
}
