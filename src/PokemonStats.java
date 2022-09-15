/*Andrew*/

public class PokemonStats {
    private int hpIV;
    private int attackIV;
    private int defenseIV;

    private int hpEV;
    private int attackEV;
    private int defenseEV;

    private Nature nature;

    private boolean shiny;

    private int level;

    //Generates random stats if none are passed in
    PokemonStats() {
        this.hpIV = StaticVars.RANDOM.nextInt(32);
        this.attackIV = StaticVars.RANDOM.nextInt(32);
        this.defenseIV = StaticVars.RANDOM.nextInt(32);

        int maxTotalEVs = 510;
        this.hpEV = StaticVars.RANDOM.nextInt(255);
        this.attackEV = StaticVars.RANDOM.nextInt(255);
        this.defenseEV = StaticVars.RANDOM.nextInt(255);

        //A pokemon can only have max EVs of 510 in total, and 255 per stat
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

    public int getHpIV() {
        return hpIV;
    }

    public void setHpIV(int hpIV) {
        this.hpIV = hpIV;
    }

    public int getAttackIV() {
        return attackIV;
    }

    public void setAttackIV(int attackIV) {
        this.attackIV = attackIV;
    }

    public int getDefenseIV() {
        return defenseIV;
    }

    public void setDefenseIV(int defenseIV) {
        this.defenseIV = defenseIV;
    }

    public int getHpEV() {
        return hpEV;
    }

    public void setHpEV(int hpEV) {
        this.hpEV = hpEV;
    }

    public int getAttackEV() {
        return attackEV;
    }

    public void setAttackEV(int attackEV) {
        this.attackEV = attackEV;
    }

    public int getDefenseEV() {
        return defenseEV;
    }

    public void setDefenseEV(int defenseEV) {
        this.defenseEV = defenseEV;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public boolean isShiny() {
        return shiny;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
