public class MagicWand extends Weapon {
        private int charges;

        public MagicWand(String shortName, String longName,
                         int damage, int charges) {
            super(shortName, longName, damage);
            this.charges = charges;
        }

        @Override
        public boolean canUse() {
            return charges > 0;
        }

        @Override
        public void use() {
            if (canUse()) {
                charges--;
            }
        }

        @Override
        public String getAttackVerb() {
            return "wave";
        }

        @Override
        public String getUsesLeftText() {
            return "You have " + charges + " magic charges left.";
        }
    }
