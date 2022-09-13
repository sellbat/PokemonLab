public class Effect {
    private enum Effects {Paralyzed, Poisoned, Burned, Frozen, Flinch};

    private Effects name;
    private  int roundsLeft;
    private double scalingDamage;
    private int damage;
    private double incapacitateChance;

    Effect(Effects effect, int roundsLeft) {
        this.name = effect;
        this.roundsLeft = roundsLeft;

        switch(effect) {
            case Paralyzed:
                this.scalingDamage = 0.0;
                this.damage = 0;
                this.incapacitateChance = 0.25;
                break;

            case Poisoned:
                this.scalingDamage = 0.0625;
                this.damage = 0;
                this.incapacitateChance = 0.0;
                break;

            case Burned:
                this.scalingDamage = 0.125;
                this.damage = 0;
                this.incapacitateChance = 0.0;
                break;

            case Frozen:
                this.scalingDamage = 0.0;
                this.damage = 0;
                this.incapacitateChance = 1.0;
                break;

            case Flinch:
                this.scalingDamage = 0.0;
                this.damage = 0;
                this.incapacitateChance = 1.0;
                break;

            default:
                this.scalingDamage = 0.0;
                this.damage = 0;
                this.incapacitateChance = 0.0;
        }
    }
}
