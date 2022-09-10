public class PokemonStats {
    public int hpIV;
    public int attackIV;
    public int defenseIV;

    public int hpEV;
    public int attackEV;
    public int defenseEV;

    public Nature nature;

    public boolean shiny;

    public int level;



    PokemonStats() {
        this.hpIV = StaticVars.RANDOM.nextInt(32);
        this.attackIV = StaticVars.RANDOM.nextInt(32);
        this.defenseIV = StaticVars.RANDOM.nextInt(32);

        int maxTotalEVs = 510;
        this.hpEV = StaticVars.RANDOM.nextInt(255);
        this.attackEV = StaticVars.RANDOM.nextInt(255);
        this.defenseEV = StaticVars.RANDOM.nextInt(255);

        while((this.hpEV + this.attackEV + this.defenseEV) > maxTotalEVs) {
            this.hpEV -= 1;
            this.attackEV -= 1;
            this.defenseEV -= 1;
        }

        this.nature = new Nature();

        this.shiny = (StaticVars.RANDOM.nextInt(4096) == 0);

        this.level = StaticVars.RANDOM.nextInt(100) + 1;
    }

    PokemonStats(int hpIV, int attackIV, int defenseIV, int hpEV, int attackEV, int defenseEV, Nature nature, boolean shiny, int level) {
        this.hpIV = hpIV;
        this.attackIV = attackIV;
        this.defenseIV = defenseIV;

        this.hpEV = hpEV;
        this.attackEV = attackEV;
        this.defenseEV = defenseEV;

        this.nature = nature;

        this.shiny = shiny;

        this.level = level;
    }
}
