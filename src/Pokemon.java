/*Andrew*/

public class Pokemon {
    private String nickName;

    private PokemonStats stats;
    private PokemonSpecies species;

    private Attack[] attacks;

    private int currentHp;

    private int maxHp;
    private int attackPower;
    private int defensePower;

    private Effect effect;

    private boolean fainted;

    Pokemon(String nickName, PokemonSpecies species, PokemonStats stats, Attack[] attacks, int currentHp) {
        this.nickName = nickName;

        this.species = species;
        this.stats = stats;

        this.attacks = attacks;

        this.updateFinalStats();

        if (currentHp == -1) {
            this.currentHp = this.maxHp;
        }
        else {
            this.currentHp = currentHp;
        }

        this.fainted = !(this.currentHp > 0);
    }

    //Calculates the final stats of the pokemon based on base stats and level and EVs and other factors (using the official Pokemon stat formula)
    private void updateFinalStats() {
        this.maxHp =  (int) ((0.01 * (2 * this.species.getBaseHp() + this.stats.getHpIV() + (int)(0.25 * this.stats.getHpEV())) * this.stats.getLevel()) + this.stats.getLevel() + 10);
        this.attackPower = (int) (((0.01 * (2 * this.species.getBaseAttack() + this.stats.getAttackIV() + (int)(0.25 * this.stats.getAttackEV())) * this.stats.getLevel()) + 5) * this.stats.getNature().getAttackMultiplier());
        this.defensePower = (int) (((0.01 * (2 * this.species.getBaseDefense() + this.stats.getDefenseIV() + (int)(0.25 * this.stats.getDefenseEV())) * this.stats.getLevel()) + 5) * this.stats.getNature().getDefenseMultiplier());
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PokemonStats getStats() {
        return stats;
    }

    public void setStats(PokemonStats stats) {
        this.stats = stats;
    }

    public PokemonSpecies getSpecies() {
        return species;
    }

    public void setSpecies(PokemonSpecies species) {
        this.species = species;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public boolean getFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }
}
