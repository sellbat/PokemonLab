public class Pokemon {
    public String nickName;

    public PokemonStats stats;
    public PokemonSpecies species;

    public Attack[] attacks;

    public int currentHp;

    public int maxHp;
    public int attackPower;
    public int defensePower;

    public Effect effect;

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
    public void useAttack(Game game, Attack attack, ComputerTeam compTeam, PlayerTeam team){
        if(this.paralyzedRoundsLeft==0){
            compTeam.pokemons[0].currentHp -= game.calculateAttackDamage(attack, team.pokemons[0], compTeam.pokemons[0]);
            poisonedRoundsLeft += attack.effect.roundsLeft;
            paralyzedRoundsLeft += attack.effect.roundsLeft;
        }

    }
    public void useItem(BagItem item){
        this.currentHp+=item.itemType.healthIncrease;
        this.stats.level+=item.itemType.levelIncrease;
        if (currentHp>maxHp){
            currentHp = maxHp;
        }
        if(stats.level> 100){
            stats.level = 100;
        }
        if(item.itemType.revive && this.currentHp==0){
            this.currentHp = maxHp/2;
        }
        if(item.itemType.maxRevive && this.currentHp==0){
            this.currentHp = this.maxHp;
        }
        item.numOfItems = item.numOfItems-1;
    }
}
