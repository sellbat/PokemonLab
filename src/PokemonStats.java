import java.util.Random;

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

    private static final Random rand = new Random();

    PokemonStats() {
        this.hpIV = rand.nextInt(32);
        this.attackIV = rand.nextInt(32);
        this.defenseIV = rand.nextInt(32);

        int maxTotalEVs = 510;
        this.hpEV = rand.nextInt(255);
        this.attackEV = rand.nextInt(255);
        this.defenseEV = rand.nextInt(255);

        while((this.hpEV + this.attackEV + this.defenseEV) > maxTotalEVs) {
            this.hpEV -= 1;
            this.attackEV -= 1;
            this.defenseEV -= 1;
        }

        this.nature = new Nature();

        this.shiny = (rand.nextInt(4096) == 0);

        this.level = rand.nextInt(100) + 1;
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
