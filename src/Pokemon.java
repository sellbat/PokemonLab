public class Pokemon {
    public String nickName;

    public PokemonStats stats;
    public PokemonSpecies species;

    public Attack[] attacks;

    public int currentHp;

    public int maxHp;
    public int attackPower;
    public int defensePower;

    public boolean fainted;

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

    private void updateFinalStats() {
        this.maxHp =  (int) ((0.01 * (2 * this.species.baseHp + this.stats.hpIV + (int)(0.25 * this.stats.hpEV)) * this.stats.level) + this.stats.level + 10);
        this.attackPower = (int) (((0.01 * (2 * this.species.baseAttack + this.stats.defenseIV + (int)(0.25 * this.stats.attackEV)) * this.stats.level) + 5) * this.stats.nature.attackMultiplier);
        this.defensePower = (int) (((0.01 * (2 * this.species.baseDefense + this.stats.defenseIV + (int)(0.25 * this.stats.defenseEV)) * this.stats.level) + 5) * this.stats.nature.defenseMultiplier);
    }
}
